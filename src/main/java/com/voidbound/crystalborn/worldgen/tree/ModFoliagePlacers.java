package com.voidbound.crystalborn.worldgen.tree;

import com.voidbound.crystalborn.crystalborn;
import com.voidbound.crystalborn.worldgen.tree.custom.TerraCrystalFoliagePlacer;
import com.voidbound.crystalborn.worldgen.tree.custom.VoidCrystalFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, crystalborn.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<TerraCrystalFoliagePlacer>> TERRACRYSTAL_TREE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("terracrystal_tree_foliage_placer", () -> new FoliagePlacerType<>(TerraCrystalFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<VoidCrystalFoliagePlacer>> VOIDCRYSTAL_TREE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("voidcrystal_tree_foliage_placer", () -> new FoliagePlacerType<>(VoidCrystalFoliagePlacer.CODEC));


    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}