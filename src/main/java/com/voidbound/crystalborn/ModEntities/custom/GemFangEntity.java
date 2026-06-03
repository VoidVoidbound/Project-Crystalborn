package com.voidbound.crystalborn.ModEntities.custom;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModEntities.ModEntities;
import com.voidbound.crystalborn.ModEntities.ai.GemFangAttackGoal;
import com.voidbound.crystalborn.ModEvent.BrokenBlockAgroEvent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class GemFangEntity extends TamableAnimal {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(GemFangEntity.class, EntityDataSerializers.BOOLEAN);

    public GemFangEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(GemFangEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState sitDownAnimationState = new AnimationState();
    public final AnimationState standUpAnimationState = new AnimationState();

    private boolean lastSitting = false;

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        if (damagesource.is(DamageTypes.FALL))
            return false;
        if (damagesource.is(DamageTypes.MAGIC))
            return false;
        if (damagesource.is(DamageTypes.DROWN))
            return false;
        if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
            return false;
        return super.hurt(damagesource, amount);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isBaby()) {
            return EntityDimensions.scalable(0.9f, 1f);
        }
        return super.getDimensions(pose);
    }


    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            boolean sitting = this.isSittingCustom();

            if (sitting && !lastSitting) {
                sitDownAnimationState.start(this.tickCount);
                standUpAnimationState.stop();
            }

            if (!sitting && lastSitting) {
                standUpAnimationState.start(this.tickCount);
                sitDownAnimationState.stop();
            }

            lastSitting = sitting;

            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 80;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(SITTING, false);
    }

    public boolean isSittingCustom() {
        // Use the vanilla ordered-to-sit state (this reads the synced data)
        return this.isOrderedToSit();
    }

    public void setSittingCustom(boolean sitting) {
        // Only change the authoritative state on the server
        if (!this.level().isClientSide) {
            this.setOrderedToSit(sitting);
        }
        // Do not directly set entityData on the client — the server will sync it.
    }




    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand != InteractionHand.MAIN_HAND) {
            return super.mobInteract(player, hand);
        }

        ItemStack item = player.getItemInHand(hand);

        // Taming / sit toggle logic (server-side)
        if (item.is(Items.CHICKEN)) {
            if (!this.level().isClientSide) {
                if (!this.isTame()) {
                    if (this.random.nextInt(3) == 0) {
                        this.tame(player);
                        this.getNavigation().stop();
                        this.setSittingCustom(true); // server-only wrapper that calls setOrderedToSit(...)
                        this.level().broadcastEntityEvent(this, (byte) 7);
                    } else {
                        this.level().broadcastEntityEvent(this, (byte) 6);
                    }
                } else if (this.isOwnedBy(player)) {
                    this.setSittingCustom(!this.isOrderedToSit());
                }
            } else {
                // Client-side: start predicted animation immediately so it doesn't feel like it "pops"
                boolean predictedSit;
                if (!this.isTame()) {
                    // If taming attempt, predict it will sit (only for the success case you already handle server-side)
                    predictedSit = true;
                } else if (this.isOwnedBy(player)) {
                    predictedSit = !this.isOrderedToSit();
                } else {
                    predictedSit = this.isOrderedToSit();
                }

                if (predictedSit && !this.lastSitting) {
                    this.sitDownAnimationState.start(this.tickCount);
                    this.standUpAnimationState.stop();
                } else if (!predictedSit && this.lastSitting) {
                    this.standUpAnimationState.start(this.tickCount);
                    this.sitDownAnimationState.stop();
                }
                this.lastSitting = predictedSit;
            }

            if (!player.getAbilities().instabuild) {
                item.shrink(1);
            }

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        // Toggle sit with empty hand / non-taming item
        if (this.isTame() && this.isOwnedBy(player) && !player.isShiftKeyDown()) {
            if (!this.level().isClientSide) {
                this.setSittingCustom(!this.isOrderedToSit());
            } else {
                // Client-side predicted toggle for immediate animation
                boolean predictedSit = !this.isOrderedToSit();
                if (predictedSit && !this.lastSitting) {
                    this.sitDownAnimationState.start(this.tickCount);
                    this.standUpAnimationState.stop();
                } else if (!predictedSit && this.lastSitting) {
                    this.standUpAnimationState.start(this.tickCount);
                    this.sitDownAnimationState.stop();
                }
                this.lastSitting = predictedSit;
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isOrderedToSit()) {
            this.getNavigation().stop();
            this.setDeltaMovement(0, 0, 0);
        }
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 0.5D, 10.0F, 2.0F, false));

        this.goalSelector.addGoal(3, new GemFangAttackGoal(this, 0.9D, true));

        this.goalSelector.addGoal(2, new BreedGoal(this, 0.9D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1D, Ingredient.of(Items.COOKED_BEEF, Items.CHICKEN), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 0.9F));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.9F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));


        this.targetSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new BrokenBlockAgroEvent(this, Set.of(ModBlocks.TERRA_CRYSTAL.get()), 15));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.ARMOR_TOUGHNESS, 2f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 5f);
    }




    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.GEMFANG.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COOKED_BEEF);
    }


    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.WOLF_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.WOLF_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }
}
