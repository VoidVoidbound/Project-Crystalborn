package com.voidbound.crystalborn;

//import com.voidbound.crystalborn.block.ModBlocks;
//import com.voidbound.crystalborn.entities.ModEntities;
//import com.voidbound.crystalborn.fluid.ModFluidTypes;
//import com.voidbound.crystalborn.fluid.ModFluids;
import com.mojang.logging.LogUtils;
//import com.voidbound.crystalborn.item.ModItems;
//import com.voidbound.crystalborn.item.ModCreativeModeTabs;
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


@Mod(crystalborn.MOD_ID)
public class crystalborn {
    public static final String MOD_ID = "crystalborn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public crystalborn(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

//        ModCreativeModeTabs.register(modEventBus);
//
//        ModEntities.ENTITIES.register(modEventBus);
//        ModItems.register(modEventBus);
//        ModBlocks.register(modEventBus);
//        ModFluidTypes.REGISTRY.register(modEventBus);
//        ModFluids.REGISTRY.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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
        }
    }
}
