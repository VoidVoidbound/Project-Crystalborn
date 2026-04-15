package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import com.voidbound.crystalborn.crystalborn;
import com.voidbound.crystalborn.ModEntities.custom.AetherDrakeEntity;


public class AetherDrakeRenderer extends MobRenderer<AetherDrakeEntity, AetherDrakeModel<AetherDrakeEntity>> {
    public AetherDrakeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AetherDrakeModel<>(pContext.bakeLayer(ModModelLayers.AETHERDRAKE_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(AetherDrakeEntity rhinoEntity) {
        return new ResourceLocation(crystalborn.MOD_ID, "textures/entity/aetherdrake.png");
    }

    @Override
    public void render(AetherDrakeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
