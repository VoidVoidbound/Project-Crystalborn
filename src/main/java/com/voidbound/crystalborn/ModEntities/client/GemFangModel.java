package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.voidbound.crystalborn.ModEntities.animations.GemFangAnimationDefinitions;
import com.voidbound.crystalborn.ModEntities.custom.GemFangEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;

public class GemFangModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart head2;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart upperBody;
    private final ModelPart leg0;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart tail;

    public GemFangModel(ModelPart root) {
        this.head2 = root.getChild("head2");
        this.head = this.head2.getChild("head");
        this.body = this.head2.getChild("body");
        this.upperBody = this.head2.getChild("upperBody");
        this.leg0 = this.head2.getChild("leg0");
        this.leg1 = this.head2.getChild("leg1");
        this.leg2 = this.head2.getChild("leg2");
        this.leg3 = this.head2.getChild("leg3");
        this.tail = this.head2.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(-1.0F, 11.5F, -7.0F));

        PartDefinition head = head2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 16).addBox(-3.0F, -2.0F, -1.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(42, 10).addBox(-2.5F, -5.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 43).addBox(1.5F, -5.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 37).addBox(-1.5F, 0.9844F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition body = head2.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -2.0F, -4.0F, 9.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 9.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition upperBody = head2.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -5.0F, 11.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 9.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition leg0 = head2.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(38, 37).addBox(-1.0F, 2.0F, 1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 2.5F, 14.0F));

        PartDefinition leg1 = head2.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(42, 0).addBox(0.0F, 2.0F, 1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.5F, 14.0F));

        PartDefinition leg2 = head2.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 36).addBox(-2.0F, 2.0F, 0.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 2.5F, 3.0F));

        PartDefinition leg3 = head2.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(12, 36).addBox(0.0F, 2.0F, 0.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.5F, 3.0F));

        PartDefinition tail = head2.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(34, 25).addBox(-1.5F, 3.2766F, 0.2943F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 15.0F, 0.9599F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
        GemFangEntity gf = (GemFangEntity) entity;

        this.animateWalk(GemFangAnimationDefinitions.GEMFANGWALKING, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((GemFangEntity) entity).idleAnimationState, GemFangAnimationDefinitions.GEMFANGIDLE, ageInTicks, 1f);

        if (gf.isSittingCustom() &&
                !gf.sitDownAnimationState.isStarted() &&
                !gf.standUpAnimationState.isStarted()) {

            // Clear any walk/idle transforms applied earlier this tick so sitting is not blended/overwritten
            this.root().getAllParts().forEach(ModelPart::resetPose);
            // Reapply head rotation so head orientation remains correct while sitting
            this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

            // Play the sitting animation and stop here so nothing later overwrites it
            this.animate(gf.idleAnimationState, GemFangAnimationDefinitions.GEMFANGSITTING, ageInTicks, 1f);
            return;
        } else {
            // Normal idle
            this.animate(gf.idleAnimationState, GemFangAnimationDefinitions.GEMFANGIDLE, ageInTicks, 1f);
        }

        this.animate(((GemFangEntity) entity).attackAnimationState, GemFangAnimationDefinitions.GEMFANGWALKING, ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return head2;
    }
}
