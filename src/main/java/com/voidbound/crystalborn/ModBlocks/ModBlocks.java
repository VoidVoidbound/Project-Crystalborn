package com.voidbound.crystalborn.ModBlocks;


import com.voidbound.crystalborn.ModBlocks.custom.LiquidVoidBlock;
import com.voidbound.crystalborn.ModBlocks.custom.VoidCrystalSaplingBlock;
import com.voidbound.crystalborn.ModItems.ModItems;
import com.voidbound.crystalborn.worldgen.tree.InfernalCrystalShardGrower;
import com.voidbound.crystalborn.worldgen.tree.TerraCrystalTreeGrower;
import com.voidbound.crystalborn.crystalborn;
import com.voidbound.crystalborn.worldgen.tree.VoidCrystalTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, crystalborn.MOD_ID);
//    misc blocks
public static final RegistryObject<Block> CRACKED_OBSIDIAN = registerBlock("cracked_obsidian",
        () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)) {
        });

//    crystals
    public static final RegistryObject<Block> VOID_CRYSTAL = registerBlock("void_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15)) {
            });
    public static final RegistryObject<Block> TERRA_CRYSTAL = registerBlock("terra_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15)) {
            });
    public static final RegistryObject<Block> INFERNAL_CRYSTAL = registerBlock("infernal_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(state -> 15)) {
            });

//    liquids
        public static final RegistryObject<Block> LIQUIDVOID = registerBlock("liquidvoid",
            () -> new LiquidVoidBlock());

//    saplings
    public static final RegistryObject<Block> TERRACRYSTAL_SAPLING = registerBlock("terracrystal_sapling",
            () -> new SaplingBlock(new TerraCrystalTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> VOIDCRYSTAL_SAPLING =
            registerBlock("voidcrystal_sapling",
                    () -> new VoidCrystalSaplingBlock(
                            new VoidCrystalTreeGrower(),
                            BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    ));
    public static final RegistryObject<Block> INFERNAL_CRYSTAL_SHARD = registerBlock("infernal_crystal_shard",
            () -> new SaplingBlock(new InfernalCrystalShardGrower(), BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    // Nested client-side class for render layers
//    @Mod.EventBusSubscriber(modid = crystalborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientSetup {
//        @SubscribeEvent
//        public static void clientSetup(FMLClientSetupEvent event) {
//             Set honey glass to translucent render layer
//            ItemBlockRenderTypes.setRenderLayer(HONEY_GLASS.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIQUIDHONEY.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(ModFluids.LIQUIDHONEY.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_LIQUIDHONEY.get(), RenderType.translucent());
//        }
//    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

