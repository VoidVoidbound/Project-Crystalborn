package com.voidbound.crystalborn.ModFluids;


import com.voidbound.crystalborn.ModFluids.types.LiquidVoidFluidType;
import com.voidbound.crystalborn.crystalborn;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, crystalborn.MOD_ID);
	public static final RegistryObject<FluidType> LIQUIDVOID_TYPE = REGISTRY.register("liquidvoid", () -> new LiquidVoidFluidType());
}
