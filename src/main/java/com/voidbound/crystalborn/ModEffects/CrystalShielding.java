package com.voidbound.crystalborn.ModEffects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import java.util.function.Consumer;

public class CrystalShielding extends MobEffect {

    public CrystalShielding() {
        super(MobEffectCategory.BENEFICIAL, 0x66CCFF); // light blue color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        entity.setAbsorptionAmount(10.0F);

        if (entity.tickCount % 50 == 0 && entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(1.0F);
        }

        entity.clearFire();
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
        consumer.accept(new IClientMobEffectExtensions() {
            public int getAbsorptionColor() {
                return 0x66CCFF; // light blue hearts
            }
        });
    }
}
