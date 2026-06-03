package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.voidbound.crystalborn.ModEntities.client.ShardlingModel;
import com.voidbound.crystalborn.ModEntities.client.ModModelLayers;
import com.voidbound.crystalborn.ModEntities.custom.ShardlingEntity;
import com.voidbound.crystalborn.crystalborn;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShardlingRenderer extends MobRenderer<ShardlingEntity, ShardlingModel<ShardlingEntity>> {
    public ShardlingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShardlingModel<>(pContext.bakeLayer(ModModelLayers.SHARDLING_LAYER)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShardlingEntity ShardlingEntity) {
        return new ResourceLocation(crystalborn.MOD_ID, "textures/entity/shardling.png");
    }

    @Override
    public void render(ShardlingEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.7f, 0.7f, 0.7f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}