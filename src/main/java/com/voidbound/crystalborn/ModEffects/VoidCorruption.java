package com.voidbound.crystalborn.ModEffects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import java.util.function.Consumer;

public class VoidCorruption extends MobEffect {

    public VoidCorruption() {
        super(MobEffectCategory.HARMFUL, 0x9900CC); // purple color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.tickCount % 10 == 0 && !entity.hasEffect(ModEffects.CRYSTALSHIELDING.get())) {
            entity.hurt(entity.damageSources().magic(), 3.0F);
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
