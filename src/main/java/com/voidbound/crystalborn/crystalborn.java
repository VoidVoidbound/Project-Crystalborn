package com.voidbound.crystalborn;

import com.voidbound.crystalborn.ModEntities.ModEntities;
import com.voidbound.crystalborn.ModEntities.client.*;
import com.voidbound.crystalborn.ModFluids.ModFluids;
import com.voidbound.crystalborn.ModBlocks.ModBlocks;
//import com.voidbound.crystalborn.ModBlocks.ModEntity.ModBlockEntities;
//import com.voidbound.crystalborn.ModEntity.ModEntities;
//import com.voidbound.crystalborn.ModEntity.client.ModBoatRenderer;
import com.voidbound.crystalborn.ModItems.ModCreativeModeTabs;
import com.voidbound.crystalborn.ModItems.ModItems;
import com.voidbound.crystalborn.ModLoot.ModLootModifiers;
//import com.voidbound.crystalborn.ModRecipes.ModRecipes;
//import com.voidbound.crystalborn.ModScreens.GemPolishingStationScreen;
//import com.voidbound.crystalborn.ModScreens.ModMenuTypes;
import com.voidbound.crystalborn.ModSounds.ModSounds;
//import com.voidbound.crystalborn.util.ModWoodTypes;
//import com.voidbound.crystalborn.ModVillagers.ModVillagers;
import com.voidbound.crystalborn.worldgen.biome.*;
import com.voidbound.crystalborn.worldgen.tree.ModFoliagePlacers;
import com.voidbound.crystalborn.worldgen.tree.ModTrunkPlacerTypes;
import com.voidbound.crystalborn.ModEffects.ModEffects;
import com.voidbound.crystalborn.ModFluids.ModFluidTypes;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.Region;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;


@Mod(crystalborn.MOD_ID)
public class crystalborn {
    public static final String MOD_ID = "crystalborn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public crystalborn(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);
//        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

//        ModBlockEntities.register(modEventBus);
//        ModMenuTypes.register(modEventBus);

        ModEffects.register(modEventBus);
        ModFluidTypes.REGISTRY.register(modEventBus);
        ModFluids.REGISTRY.register(modEventBus);

//        ModRecipes.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);

        ModFoliagePlacers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new TerraCrystalHills(new ResourceLocation(MOD_ID, "overworld_1"), 2));

            Regions.register(new InfernalCrystalCaverns(new ResourceLocation(MOD_ID, "nether_1"), 2));
//
            EndBiomeRegistry.registerHighlandsBiome(ModBiomes.VOIDCRYSTAL_FOREST, 1);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
//            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, MOD_ID, ModSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.AETHERDRAKE.get(), AetherDrakeRenderer::new);
            EntityRenderers.register(ModEntities.GEMFANG.get(), GemFangRenderer::new);
            EntityRenderers.register(ModEntities.GEMGRAZER.get(), GemGrazerRenderer::new);
            EntityRenderers.register(ModEntities.PRISMELK.get(), PrismElkRenderer::new);
            EntityRenderers.register(ModEntities.LUMIBLOOM.get(), LumibloomRenderer::new);
            EntityRenderers.register(ModEntities.SHARDLING.get(), ShardlingRenderer::new);
        }
    }
}
