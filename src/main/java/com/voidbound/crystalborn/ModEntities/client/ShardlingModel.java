package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.voidbound.crystalborn.ModEntities.animations.LumibloomAnimationDefinitions;
import com.voidbound.crystalborn.ModEntities.animations.ShardlingAnimationDefinitions;
import com.voidbound.crystalborn.ModEntities.custom.LumibloomEntity;
import com.voidbound.crystalborn.ModEntities.custom.ShardlingEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ShardlingModel <T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart body;

    public ShardlingModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ShardlingAnimationDefinitions.SHARDLINGWALKING, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((ShardlingEntity) entity).idleAnimationState, ShardlingAnimationDefinitions.SHARDLINGIDLE, ageInTicks, 1f);
        this.animate(((ShardlingEntity) entity).attackAnimationState, ShardlingAnimationDefinitions.SHARDLINGWALKING, ageInTicks, 1f);

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);

        this.body.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
