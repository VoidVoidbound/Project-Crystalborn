package com.voidbound.crystalborn.ModItems;

import com.voidbound.crystalborn.ModEffects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties CRYSTAL_APPLE =
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.3f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(ModEffects.CRYSTALSHIELDING.get(), 6000), 1.0f) // 5 minutes
                    .build();
}
