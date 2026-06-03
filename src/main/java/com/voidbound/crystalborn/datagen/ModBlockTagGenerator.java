package com.voidbound.crystalborn.datagen;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import com.voidbound.crystalborn.crystalborn;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, crystalborn.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.SAPPHIRE_ORE.get()).addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VOID_CRYSTAL.get(),
                        ModBlocks.TERRA_CRYSTAL.get(),
                        ModBlocks.CRACKED_OBSIDIAN.get()
                        );

        this.tag(ModTags.Blocks.SAPLING_CAN_PLACE_ON)
                .add(Blocks.END_STONE);


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TERRA_CRYSTAL.get(),
                ModBlocks.VOID_CRYSTAL.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRACKED_OBSIDIAN.get());

        this.tag(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.VOID_CRYSTAL.get(), ModBlocks.LIQUIDVOID.get(), ModBlocks.VOIDCRYSTAL_SAPLING.get(), ModBlocks.CRACKED_OBSIDIAN.get());
//
//        this.tag(BlockTags.NEEDS_STONE_TOOL)
//                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());
//
//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
//                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
//
//        this.tag(ModTags.Blocks.NEEDS_CRYSTAL_TOOL)
//                .add(ModBlocks.SOUND_BLOCK.get());
//
//        this.tag(BlockTags.FENCES)
//                .add(ModBlocks.SAPPHIRE_FENCE.get());
//        this.tag(BlockTags.FENCE_GATES)
//                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
//        this.tag(BlockTags.WALLS)
//                .add(ModBlocks.SAPPHIRE_WALL.get());
//
//        this.tag(BlockTags.LOGS_THAT_BURN)
//                .add(ModBlocks.PINE_LOG.get())
//                .add(ModBlocks.PINE_WOOD.get())
//                .add(ModBlocks.STRIPPED_PINE_LOG.get())
//                .add(ModBlocks.STRIPPED_PINE_WOOD.get());
//
//        this.tag(BlockTags.PLANKS)
//                .add(ModBlocks.PINE_PLANKS.get());
    }
}
