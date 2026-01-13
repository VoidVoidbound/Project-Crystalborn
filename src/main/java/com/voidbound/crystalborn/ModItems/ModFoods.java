package com.voidbound.crystalborn.ModItems;

import com.voidbound.crystalborn.crystalborn;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // foods
    public static final FoodProperties CRYSTAL_APPLE = new FoodProperties.Builder().nutrition(8).saturationMod(0.3f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400), 1.0f)
            .build();
}