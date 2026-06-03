package com.voidbound.crystalborn.worldgen.tree;

import com.voidbound.crystalborn.worldgen.tree.custom.TerraCrystalTrunkPlacer;
import com.voidbound.crystalborn.crystalborn;

import com.voidbound.crystalborn.worldgen.tree.custom.VoidCrystalTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, crystalborn.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<TerraCrystalTrunkPlacer>> TERRA_CRYSTAL_TREE_TRUNK_PLACER =
            TRUNK_PLACER.register("terracrystal_tree_trunk_placer", () -> new TrunkPlacerType<>(TerraCrystalTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<VoidCrystalTrunkPlacer>> VOID_CRYSTAL_TREE_TRUNK_PLACER =
            TRUNK_PLACER.register("voidcrystal_tree_trunk_placer", () -> new TrunkPlacerType<>(VoidCrystalTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
