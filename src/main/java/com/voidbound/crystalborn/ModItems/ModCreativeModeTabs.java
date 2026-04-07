package com.voidbound.crystalborn.ModItems;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, crystalborn.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CRYSTALBORN_TAB = CREATIVE_MODE_TABS.register("crystalborn",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYSTAL_INGOT.get()))
                    .title(Component.nullToEmpty("Crystalborn"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CRYSTAL_MIXTURE.get());
                        pOutput.accept(ModItems.CRYSTAL_INGOT.get());
                        pOutput.accept(ModItems.CRYSTAL_APPLE.get());

                        pOutput.accept(ModItems.CRYSTAL_HELMET.get());
                        pOutput.accept(ModItems.CRYSTAL_CHESTPLATE.get());
                        pOutput.accept(ModItems.CRYSTAL_LEGGINGS.get());
                        pOutput.accept(ModItems.CRYSTAL_BOOTS.get());

                        pOutput.accept(ModItems.CRYSTAL_SWORD.get());
                        pOutput.accept(ModItems.CRYSTAL_PICKAXE.get());
                        pOutput.accept(ModItems.CRYSTAL_AXE.get());
                        pOutput.accept(ModItems.CRYSTAL_SHOVEL.get());
                        pOutput.accept(ModItems.CRYSTAL_HOE.get());

                        pOutput.accept(ModItems.CRACKED_OBSIDIAN_SWORD.get());
                        pOutput.accept(ModItems.CRACKED_OBSIDIAN_PICKAXE.get());
                        pOutput.accept(ModItems.CRACKED_OBSIDIAN_AXE.get());
                        pOutput.accept(ModItems.CRACKED_OBSIDIAN_SHOVEL.get());
                        pOutput.accept(ModItems.CRACKED_OBSIDIAN_HOE.get());

                        pOutput.accept(ModBlocks.CRACKED_OBSIDIAN.get());
                        pOutput.accept(ModBlocks.VOID_CRYSTAL.get());
                        pOutput.accept(ModBlocks.TERRA_CRYSTAL.get());

                        pOutput.accept(ModItems.LIQUIDVOID_BUCKET.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}