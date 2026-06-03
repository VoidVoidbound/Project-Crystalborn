package com.voidbound.crystalborn.datagen;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.voidbound.crystalborn.crystalborn;
//import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModItems.ModItems;

import java.util.LinkedHashMap;

public class    ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, crystalborn.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CRYSTAL_INGOT);
        simpleItem(ModItems.CRYSTAL_MIXTURE);

        simpleItem(ModItems.CRYSTAL_APPLE);

        simpleItem(ModItems.CRYSTAL_HELMET);
        simpleItem(ModItems.CRYSTAL_CHESTPLATE);
        simpleItem(ModItems.CRYSTAL_LEGGINGS);
        simpleItem(ModItems.CRYSTAL_BOOTS);

        handheldItem(ModItems.CRYSTAL_PICKAXE);
        handheldItem(ModItems.CRYSTAL_SHOVEL);
        handheldItem(ModItems.CRYSTAL_AXE);
        handheldItem(ModItems.CRYSTAL_HOE);
        handheldItem(ModItems.CRYSTAL_SWORD);

        handheldItem(ModItems.CRACKED_OBSIDIAN_AXE);
        handheldItem(ModItems.CRACKED_OBSIDIAN_HOE);
        handheldItem(ModItems.CRACKED_OBSIDIAN_PICKAXE);
        handheldItem(ModItems.CRACKED_OBSIDIAN_SHOVEL);
        handheldItem(ModItems.CRACKED_OBSIDIAN_SWORD);

//        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);
//
//        fenceItem(ModBlocks.SAPPHIRE_FENCE, ModBlocks.SAPPHIRE_BLOCK);
//        buttonItem(ModBlocks.SAPPHIRE_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
//        wallItem(ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);
//
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_STAIRS);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);
//
//        trapdoorItem(ModBlocks.SAPPHIRE_TRAPDOOR);
//
//        handheldItem(ModItems.SAPPHIRE_SWORD);
//        handheldItem(ModItems.SAPPHIRE_PICKAXE);
//        handheldItem(ModItems.SAPPHIRE_AXE);
//        handheldItem(ModItems.SAPPHIRE_SHOVEL);
//        handheldItem(ModItems.SAPPHIRE_HOE);

        trimmedArmorItem(ModItems.CRYSTAL_HELMET);
        trimmedArmorItem(ModItems.CRYSTAL_CHESTPLATE);
        trimmedArmorItem(ModItems.CRYSTAL_LEGGINGS);
        trimmedArmorItem(ModItems.CRYSTAL_BOOTS);

//        simpleBlockItemBlockTexture(ModBlocks.CATMINT);
//
        withExistingParent(ModItems.AETHERDRAKE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GEMFANG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GEMGRAZER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.PRISMELK_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SHARDLING_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.LUMIBLOOM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));


//        simpleItem(ModItems.PINE_SIGN);
//        simpleItem(ModItems.PINE_HANGING_SIGN);
//
//        simpleItem(ModItems.PINE_BOAT);
//        simpleItem(ModItems.PINE_CHEST_BOAT);
//
//        simpleItem(ModItems.DICE);
        saplingItem(ModBlocks.TERRACRYSTAL_SAPLING);
        saplingItem(ModBlocks.VOIDCRYSTAL_SAPLING);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = crystalborn.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(crystalborn.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(crystalborn.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(crystalborn.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(crystalborn.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(crystalborn.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(crystalborn.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(crystalborn.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(crystalborn.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(crystalborn.MOD_ID,"block/" + item.getId().getPath()));
    }
}