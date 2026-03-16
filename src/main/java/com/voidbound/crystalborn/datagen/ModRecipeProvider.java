package com.voidbound.crystalborn.datagen;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import com.voidbound.crystalborn.crystalborn;
//import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModItems.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
//            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(),
//            ModBlocks.END_STONE_SAPPHIRE_ORE.get());
    private static final List<ItemLike> OBSIDIANBLASTABLES = List.of(Blocks.OBSIDIAN.asItem()
    );
    private static final List<ItemLike> CRYSTALMIXTURES = List.of(ModItems.CRYSTAL_MIXTURE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, CRYSTALMIXTURES, RecipeCategory.MISC, ModItems.CRYSTAL_INGOT.get(), 0.25f, 200, "crystal_ingot");
        oreBlasting(pWriter, CRYSTALMIXTURES, RecipeCategory.MISC, ModItems.CRYSTAL_INGOT.get(), 0.25f, 100, "cracked_obsidian");

        oreBlasting(pWriter, OBSIDIANBLASTABLES, RecipeCategory.MISC, ModBlocks.CRACKED_OBSIDIAN.get(), 0.25f, 200, "cracked_obsidian");

        // Crystal Tools Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_PICKAXE.get())
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_HOE.get())
                .pattern("CC")
                .pattern(" S")
                .pattern(" S")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_SHOVEL.get())
                .pattern("C")
                .pattern("S")
                .pattern("S")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRYSTAL_AXE.get())
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);

        // CRACKED OBSIDIAN TOOLS RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRACKED_OBSIDIAN_PICKAXE.get())
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .define('C', ModBlocks.CRACKED_OBSIDIAN.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CRACKED_OBSIDIAN.get()), has(ModBlocks.CRACKED_OBSIDIAN.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRACKED_OBSIDIAN_HOE.get())
                .pattern("CC")
                .pattern(" S")
                .pattern(" S")
                .define('C', ModBlocks.CRACKED_OBSIDIAN.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CRACKED_OBSIDIAN.get()), has(ModBlocks.CRACKED_OBSIDIAN.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRACKED_OBSIDIAN_SHOVEL.get())
                .pattern("C")
                .pattern("S")
                .pattern("S")
                .define('C', ModBlocks.CRACKED_OBSIDIAN.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CRACKED_OBSIDIAN.get()), has(ModBlocks.CRACKED_OBSIDIAN.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRACKED_OBSIDIAN_AXE.get())
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .define('C', ModBlocks.CRACKED_OBSIDIAN.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CRACKED_OBSIDIAN.get()), has(ModBlocks.CRACKED_OBSIDIAN.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRACKED_OBSIDIAN_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("S")
                .define('C', ModBlocks.CRACKED_OBSIDIAN.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.CRACKED_OBSIDIAN.get()), has(ModBlocks.CRACKED_OBSIDIAN.get()))
                .save(pWriter);

        // Crystal Armor Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRYSTAL_BOOTS.get())
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);

        // CRYSTAL APPLE RECIPE
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CRYSTAL_APPLE.get())
                .pattern("CCC")
                .pattern("CAC")
                .pattern("CCC")
                .define('C', ModItems.CRYSTAL_INGOT.get())
                .define('A', Items.APPLE)
                .unlockedBy(getHasName(ModItems.CRYSTAL_INGOT.get()), has(ModItems.CRYSTAL_INGOT.get()))
                .save(pWriter);

        // CRYSTAL MIXTURE RECIPE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRYSTAL_MIXTURE.get(), 1)
                .requires(Items.BOWL)
                .requires(Items.QUARTZ)
                .requires(Items.FLINT)
                .requires(Items.AMETHYST_SHARD)
                .requires(ModBlocks.VOID_CRYSTAL.get())
                .requires(ModBlocks.TERRA_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.CRYSTAL_MIXTURE.get()), has(ModItems.CRYSTAL_MIXTURE.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  crystalborn.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}