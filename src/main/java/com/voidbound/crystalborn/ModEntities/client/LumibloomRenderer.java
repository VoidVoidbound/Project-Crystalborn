package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.voidbound.crystalborn.ModEntities.custom.LumibloomEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class LumibloomRenderer extends MobRenderer<LumibloomEntity, LumibloomModel<LumibloomEntity>> {
    public LumibloomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LumibloomModel<>(pContext.bakeLayer(ModModelLayers.LUMIBLOOM_LAYER)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(LumibloomEntity LumibloomEntity) {
        return new ResourceLocation(crystalborn.MOD_ID, "textures/entity/lumibloom.png");
    }

    @Override
    public void render(LumibloomEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.7f, 0.7f, 0.7f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}