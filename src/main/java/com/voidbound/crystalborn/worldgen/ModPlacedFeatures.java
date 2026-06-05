package com.voidbound.crystalborn.worldgen;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.crystalborn;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> END_LIQUID_VOID_PLACED_KEY = registerKey("end_liquid_void_placed");

    public static final ResourceKey<PlacedFeature> TERRACRYSTAL_PLACED_KEY = registerKey("terracrystal_placed");

    public static final ResourceKey<PlacedFeature> INFERNALCRYSTAL_PLACED_KEY = registerKey("infernalcrystal_placed");

    public static final ResourceKey<PlacedFeature> VOIDCRYSTAL_PLACED_KEY = registerKey("voidcrystal_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
    register(context, END_LIQUID_VOID_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_LIQUID_VOID_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, TERRACRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TERRACRYSTAL_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.TERRACRYSTAL_SAPLING.get()));

        register(context, INFERNALCRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INFERNALCRYSTAL_SPIRE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.INFERNAL_CRYSTAL_SHARD.get()));

        register(context, VOIDCRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VOIDCRYSTAL_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.VOIDCRYSTAL_SAPLING.get()));
    }




    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(crystalborn.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
