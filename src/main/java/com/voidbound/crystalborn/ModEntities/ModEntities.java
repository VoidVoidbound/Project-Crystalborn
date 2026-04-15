package com.voidbound.crystalborn.ModEntities;

import com.voidbound.crystalborn.ModEntities.custom.AetherDrakeEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, crystalborn.MOD_ID);

    public static final RegistryObject<EntityType<AetherDrakeEntity>> AETHERDRAKE =
            ENTITY_TYPES.register("aetherdrake", () -> EntityType.Builder.of(AetherDrakeEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 1f).build("aetherdrake"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
