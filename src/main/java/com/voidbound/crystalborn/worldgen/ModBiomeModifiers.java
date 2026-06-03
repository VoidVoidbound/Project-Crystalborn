package com.voidbound.crystalborn.worldgen;

import com.voidbound.crystalborn.crystalborn;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
//    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("add_sapphire_ore");
//    public static final ResourceKey<BiomeModifier> ADD_NETHER_SAPPHIRE_ORE = registerKey("add_nether_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_LIQUID_VOID = registerKey("add_liquid_void");

    public static final ResourceKey<BiomeModifier> ADD_TREE_TERRACRYSTAL = registerKey("add_tree_terracrystal");

    public static final ResourceKey<BiomeModifier> ADD_TREE_VOIDCRYSTAL = registerKey("add_tree_voidcrystal");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_LIQUID_VOID, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_LIQUID_VOID_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

//        context.register(ADD_TREE_TERRACRYSTAL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TERRACRYSTAL_PLACED_KEY)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_TREE_VOIDCRYSTAL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_END),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VOIDCRYSTAL_PLACED_KEY)),
//                GenerationStep.Decoration.TOP_LAYER_MODIFICATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(crystalborn.MOD_ID, name));
    }
}
