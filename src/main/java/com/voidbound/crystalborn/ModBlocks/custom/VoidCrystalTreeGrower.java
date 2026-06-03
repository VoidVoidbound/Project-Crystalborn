package com.voidbound.crystalborn.ModBlocks.custom;

import com.voidbound.crystalborn.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class VoidCrystalTreeGrower extends AbstractTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return ModConfiguredFeatures.VOIDCRYSTAL_TREE_KEY; // your tree feature key
    }
}
