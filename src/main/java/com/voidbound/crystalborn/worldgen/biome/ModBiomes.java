package com.voidbound.crystalborn.worldgen.biome;

import com.voidbound.crystalborn.crystalborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
    public static final ResourceKey<Biome> TERRACRYSTAL_HILLS = register("terracrystal_hills");
    public static final ResourceKey<Biome> VOIDCRYSTAL_FOREST = register("voidcrystal_forest");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(crystalborn.MOD_ID, name));
    }
}
