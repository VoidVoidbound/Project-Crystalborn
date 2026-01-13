package com.voidbound.crystalborn.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.voidbound.crystalborn.crystalborn;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CRYSTAL_TOOL = tag("needs_crystal_tool");
        public static final TagKey<Block> NEEDS_CRACKED_OBSIDIAN_TOOL = tag("needs_cracked_obsidian_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(crystalborn.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(crystalborn.MOD_ID, name));
        }
    }
}
