package com.voidbound.crystalborn.ModItems;

import com.voidbound.crystalborn.crystalborn;
import com.voidbound.crystalborn.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier CRYSTAL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_CRYSTAL_TOOL, () -> Ingredient.of(ModItems.CRYSTAL_INGOT.get())),
            new ResourceLocation(crystalborn.MOD_ID, "crystal"), List.of(Tiers.NETHERITE), List.of());
    public static final Tier CRACKED_OBSIDIAN = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_CRACKED_OBSIDIAN_TOOL, () -> Ingredient.of(ModItems.CRYSTAL_INGOT.get())),
            new ResourceLocation(crystalborn.MOD_ID, "cracked_obsidian"), List.of(Tiers.NETHERITE), List.of());
}
