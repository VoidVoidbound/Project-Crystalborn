package com.voidbound.crystalborn.ModEntities;

import com.mojang.datafixers.optics.Prism;
import com.voidbound.crystalborn.ModEntities.custom.*;
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

    public static final RegistryObject<EntityType<GemFangEntity>> GEMFANG =
            ENTITY_TYPES.register("gemfang", () -> EntityType.Builder.of(GemFangEntity::new, MobCategory.CREATURE)
                    .sized(1.2f, 1f).build("gemfang"));

    public static final RegistryObject<EntityType<AetherDrakeEntity>> AETHERDRAKE =
            ENTITY_TYPES.register("aetherdrake", () -> EntityType.Builder.of(AetherDrakeEntity::new, MobCategory.CREATURE)
                    .sized(2.2f, 0.5f).build("aetherdrake"));
    public static final RegistryObject<EntityType<GemGrazerEntity>> GEMGRAZER =
            ENTITY_TYPES.register("gemgrazer", () -> EntityType.Builder.of(GemGrazerEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.6f).build("gemgrazer"));
    public static final RegistryObject<EntityType<PrismElkEntity>> PRISMELK =
            ENTITY_TYPES.register("prismelk", () -> EntityType.Builder.of(PrismElkEntity::new, MobCategory.CREATURE)
                    .sized(1.2f, 1f).build("prismelk"));
    public static final RegistryObject<EntityType<LumibloomEntity>> LUMIBLOOM =
            ENTITY_TYPES.register("lumibloom", () -> EntityType.Builder.of(LumibloomEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.25f).build("lumibloom"));
    public static final RegistryObject<EntityType<ShardlingEntity>> SHARDLING =
            ENTITY_TYPES.register("shardling", () -> EntityType.Builder.of(ShardlingEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.3f).build("shardling"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
