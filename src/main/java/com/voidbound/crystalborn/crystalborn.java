package com.voidbound.crystalborn;

//import com.voidbound.crystalborn.block.ModBlocks;
//import com.voidbound.crystalborn.entities.ModEntities;
//import com.voidbound.crystalborn.fluid.ModFluidTypes;
//import com.voidbound.crystalborn.fluid.ModFluids;
import com.mojang.logging.LogUtils;
//import com.voidbound.crystalborn.ModItems.ModItems;
import com.voidbound.crystalborn.ModItems.ModCreativeModeTabs;
import com.voidbound.crystalborn.ModItems.ModItems;
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

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
//        ModBlocks.register(modEventBus);

//        ModLootModifiers.register(modEventBus);
//        ModVillagers.register(modEventBus);

//        ModSounds.register(modEventBus);
//        ModEntities.register(modEventBus);

//        ModBlockEntities.register(modEventBus);
//        ModMenuTypes.register(modEventBus);

//        ModRecipes.register(modEventBus);

//        ModTrunkPlacerTypes.register(modEventBus);
//        ModFoliagePlacers.register(modEventBus);

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
