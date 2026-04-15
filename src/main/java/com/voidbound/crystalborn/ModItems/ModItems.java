package com.voidbound.crystalborn.ModItems;

import com.voidbound.crystalborn.ModEntities.ModEntities;
import com.voidbound.crystalborn.ModItems.custom.LiquidVoidItem;
import com.voidbound.crystalborn.ModItems.custom.ModArmorItem;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, crystalborn.MOD_ID);

    // Crystal Items
    public static final RegistryObject<Item> CRYSTAL_MIXTURE = ITEMS.register("crystal_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_INGOT = ITEMS.register("crystal_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_APPLE = ITEMS.register("crystal_apple",
            () -> new Item(new Item.Properties().food(ModFoods.CRYSTAL_APPLE)));

    // Armor
    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Tools
        // Crystal Tools
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword",
            () -> new SwordItem(ModTiers.CRYSTAL, 4, -1.9f, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe",
            () -> new PickaxeItem(ModTiers.CRYSTAL, 2, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe",
            () -> new AxeItem(ModTiers.CRYSTAL, 6f, -2.5f, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel",
            () -> new ShovelItem(ModTiers.CRYSTAL, 2.5f, -2.5f, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe",
            () -> new HoeItem(ModTiers.CRYSTAL, -3, 0.5f, new Item.Properties()));
    public static final RegistryObject<Item> LIQUIDVOID_BUCKET = ITEMS.register("liquidvoid_bucket",
            () -> new LiquidVoidItem());
        // Cracked Obsidian Tools
    public static final RegistryObject<Item> CRACKED_OBSIDIAN_SWORD = ITEMS.register("cracked_obsidian_sword",
                () -> new SwordItem(ModTiers.CRACKED_OBSIDIAN, 3, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_OBSIDIAN_PICKAXE = ITEMS.register("cracked_obsidian_pickaxe",
            () -> new PickaxeItem(ModTiers.CRACKED_OBSIDIAN, 1, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_OBSIDIAN_AXE = ITEMS.register("cracked_obsidian_axe",
            () -> new AxeItem(ModTiers.CRACKED_OBSIDIAN, 5f, -3.5f, new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_OBSIDIAN_SHOVEL = ITEMS.register("cracked_obsidian_shovel",
            () -> new ShovelItem(ModTiers.CRACKED_OBSIDIAN, 1.5f, -3.5f, new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_OBSIDIAN_HOE = ITEMS.register("cracked_obsidian_hoe",
            () -> new HoeItem(ModTiers.CRACKED_OBSIDIAN, -3, -0.5f, new Item.Properties()));

    public static final RegistryObject<Item> AETHERDRAKE_SPAWN_EGG = ITEMS.register("aetherdrake_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.AETHERDRAKE, 0x7e9680, 0xc5d1c5, new Item.Properties()));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}