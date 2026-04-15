package com.voidbound.crystalborn.ModEvent;

import com.voidbound.crystalborn.ModEntities.ModEntities;
import com.voidbound.crystalborn.ModEntities.custom.AetherDrakeEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = crystalborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.AETHERDRAKE.get(), AetherDrakeEntity.createAttributes().build());
    }
}
