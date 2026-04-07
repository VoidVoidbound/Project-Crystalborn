package com.voidbound.crystalborn.ModFluids.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class LiquidVoidFluidType extends FluidType {
    public static final ResourceLocation STILL = new ResourceLocation("crystalborn:block/liquidvoid_still");
    public static final ResourceLocation FLOW = new ResourceLocation("crystalborn:block/liquidvoid_flow");

    public LiquidVoidFluidType() {
        super(Properties.create()
                .descriptionId("fluid.crystalborn.liquidvoid")
                .density(1500)
                .viscosity(2000)
                .canSwim(true)
                .canDrown(true)
                .supportsBoating(true)
                .canConvertToSource(true)
                .canDrown(true)
        );
    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOW;
            }

//            @Override
//            public ResourceLocation getOverlayTexture() {
//                return OVERLAY;
//            }

//            @Override
//            public int getTintColor() {
//                // ARGB format: Alpha, Red, Green, Blue
//                // Example: honey-like golden color
//                return 0xFFFFA500; // semi-transparent orange (like honey)
//            }

//            public net.minecraft.client.renderer.RenderType getRenderLayer() {
//                // Translucent is default, but you can force CUTOUT if you want your textures’ alpha only
//                return net.minecraft.client.renderer.RenderType.translucent();
//            }
        });
    }

}
