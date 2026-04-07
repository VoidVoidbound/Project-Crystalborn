
package com.voidbound.crystalborn.ModFluids;



import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModItems.ModItems;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class LiquidVoidFluid extends ForgeFlowingFluid {
	public static final Properties PROPERTIES = new Properties(() -> ModFluidTypes.LIQUIDVOID_TYPE.get(), () -> ModFluids.LIQUIDVOID.get(),
			() -> ModFluids.FLOWING_LIQUIDVOID.get()).explosionResistance(100f).bucket(() -> ModItems.LIQUIDVOID_BUCKET.get()).block(() -> (LiquidBlock) ModBlocks.LIQUIDVOID.get());

	private LiquidVoidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquidVoidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidVoidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

}
