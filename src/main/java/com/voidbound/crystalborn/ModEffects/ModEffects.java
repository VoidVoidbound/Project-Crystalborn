package com.voidbound.crystalborn.ModEffects;

import com.voidbound.crystalborn.crystalborn;
import com.voidbound.crystalborn.ModEffects.CrystalShielding;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, crystalborn.MOD_ID);

    public static final RegistryObject<MobEffect> CRYSTALSHIELDING =
            EFFECTS.register("crystalshielding", CrystalShielding::new);
    public static final RegistryObject<MobEffect> VOIDCORRUPTION =
            EFFECTS.register("voidcorruption", VoidCorruption::new);


    public static void register(IEventBus eventBus) {EFFECTS.register(eventBus);}
}
