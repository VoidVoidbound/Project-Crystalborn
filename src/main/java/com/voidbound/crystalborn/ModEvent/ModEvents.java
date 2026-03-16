package com.voidbound.crystalborn.ModEvent;

import com.voidbound.crystalborn.crystalborn;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModItems.ModItems;
//import com.voidbound.crystalborn.ModVillagers.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = crystalborn.MOD_ID)
public class ModEvents {

//    @SubscribeEvent
//    public static void addCustomTrades(VillagerTradesEvent event) {
//        if (event.getType() == VillagerProfession.FARMER) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//
//            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 2),
//                    new ItemStack(ModItems.STRAWBERRY.get(), 12),
//                    10, 8, 0.02f));
//
//            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 5),
//                    new ItemStack(ModItems.CORN.get(), 6),
//                    5, 8, 0.02f));
//
//            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 5),
//                    new ItemStack(ModItems.CORN_SEEDS.get(), 3),
//                    5, 8, 0.02f));
//
//            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 5),
//                    new ItemStack(ModItems.STRAWBERRY_SEEDS.get(), 3),
//                    5, 8, 0.02f));
//
//        }
//        if (event.getType() == VillagerProfession.LIBRARIAN) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 2));
//
//            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 32),
//                    enchantedBook,
//                    10, 8, 0.02f));
//        }
//        if (event.getType()== ModVillagers.SOUND_MASTER.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//
//            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 16),
//                    new ItemStack(ModBlocks.SOUND_BLOCK.get(), 1),
//                    10, 8, 0.02f));
//
//            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
//                    new ItemStack(Items.EMERALD, 6),
//                    new ItemStack(ModBlocks.SAPPHIRE_ORE.get(), 2),
//                    5, 8, 0.02f));
//        }
//    }
//
//    @SubscribeEvent
//    public static void addCustomWanderingTrades(WandererTradesEvent event) {
//        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
//        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
//
//        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
//                new ItemStack(Items.EMERALD, 12),
//                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(), 1),
//                10, 2, 0.2f
//        ));
//
//        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
//                new ItemStack(Items.EMERALD, 24),
//                new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
//                2, 2, 0.15f
//        ));
//    }
}
