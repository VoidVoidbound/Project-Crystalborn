package com.voidbound.crystalborn.ModFluids;

import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, crystalborn.MOD_ID);
	public static final RegistryObject<FlowingFluid> LIQUIDVOID = REGISTRY.register("liquidvoid_still", () -> new LiquidVoidFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LIQUIDVOID = REGISTRY.register("liquidvoid", () -> new LiquidVoidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
//			ItemBlockRenderTypes.setRenderLayer(LIQUIDVOID.get(), RenderType.translucent());
//			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUIDVOID.get(), RenderType.translucent());
		}
	}
}
