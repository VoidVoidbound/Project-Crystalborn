package com.voidbound.crystalborn.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import com.voidbound.crystalborn.crystalborn;
//import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModItems.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, crystalborn.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CRYSTAL_HELMET.get(),
                        ModItems.CRYSTAL_CHESTPLATE.get(),
                        ModItems.CRYSTAL_LEGGINGS.get(),
                        ModItems.CRYSTAL_BOOTS.get());

//        this.tag(ItemTags.MUSIC_DISCS)
//                .add(ModItems.BAR_BRAWL_MUSIC_DISC.get());

//        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
//                .add(ModItems.BAR_BRAWL_MUSIC_DISC.get());

//        this.tag(ItemTags.LOGS_THAT_BURN)
//                .add(ModBlocks.PINE_LOG.get().asItem())
//                .add(ModBlocks.PINE_WOOD.get().asItem())
//                .add(ModBlocks.STRIPPED_PINE_LOG.get().asItem())
//                .add(ModBlocks.STRIPPED_PINE_WOOD.get().asItem());
//
//        this.tag(ItemTags.PLANKS)
//                .add(ModBlocks.PINE_PLANKS.get().asItem());
    }
}
