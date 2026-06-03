package com.voidbound.crystalborn.ModEvent;

import com.voidbound.crystalborn.ModEntities.client.*;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//import com.voidbound.crystalborn.ModBlocks.entity.ModBlockEntities;
//import com.voidbound.crystalborn.ModBlocks.entity.renderer.GemPolishingBlockEntityRenderer;

@Mod.EventBusSubscriber(modid = crystalborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.AETHERDRAKE_LAYER, AetherDrakeModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GEMFANG_LAYER, GemFangModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GEMGRAZER_LAYER, GemGrazerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PRISMELK_LAYER, PrismElkModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LUMIBLOOM_LAYER, LumibloomModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SHARDLING_LAYER, ShardlingModel::createBodyLayer);

//        event.registerLayerDefinition(ModModelLayers.PINE_BOAT_LAYER, BoatModel::createBodyModel);
//        event.registerLayerDefinition(ModModelLayers.PINE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

//    @SubscribeEvent
//    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(ModBlockEntities.GEM_POLISHING_BE.get(), GemPolishingBlockEntityRenderer::new);
//
//        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
//        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
//    }
}
