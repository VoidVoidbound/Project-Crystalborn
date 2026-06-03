package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.voidbound.crystalborn.ModEntities.custom.PrismElkEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class PrismElkRenderer extends MobRenderer<PrismElkEntity, PrismElkModel<PrismElkEntity>> {
    public PrismElkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PrismElkModel<>(pContext.bakeLayer(ModModelLayers.PRISMELK_LAYER)), 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PrismElkEntity prismelkEntity) {
        return new ResourceLocation(crystalborn.MOD_ID, "textures/entity/prismelk.png");
    }

    @Override
    public void render(PrismElkEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.7f, 0.7f, 0.7f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
