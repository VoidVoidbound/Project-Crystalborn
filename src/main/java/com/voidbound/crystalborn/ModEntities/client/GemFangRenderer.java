package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;

import com.voidbound.crystalborn.ModEntities.custom.GemFangEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class GemFangRenderer extends MobRenderer<GemFangEntity, GemFangModel<GemFangEntity>> {
    public GemFangRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GemFangModel<>(pContext.bakeLayer(ModModelLayers.GEMFANG_LAYER)), 1.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(GemFangEntity rhinoEntity) {
        return new ResourceLocation(crystalborn.MOD_ID, "textures/entity/gemfang.png");
    }

    @Override
    public void render(GemFangEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.7f, 0.7f, 0.7f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
