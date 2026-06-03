package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.voidbound.crystalborn.ModEntities.animations.GemGrazerAnimationDefinitions;
import com.voidbound.crystalborn.ModEntities.custom.GemGrazerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GemGrazerModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart head2;
    private final ModelPart fullhead;
    private final ModelPart Head;
    private final ModelPart Ear1;
    private final ModelPart Ear2;
    private final ModelPart Neck;
    private final ModelPart Leg4A;
    private final ModelPart Leg3A;
    private final ModelPart Leg2A;
    private final ModelPart Leg1A;
    private final ModelPart TailA;
    private final ModelPart body;

    public GemGrazerModel(ModelPart root) {
        this.head2 = root.getChild("head2");
        this.fullhead = this.head2.getChild("fullhead");
        this.Head = this.fullhead.getChild("Head");
        this.Ear1 = this.fullhead.getChild("Ear1");
        this.Ear2 = this.fullhead.getChild("Ear2");
        this.Neck = this.fullhead.getChild("Neck");
        this.Leg4A = this.head2.getChild("Leg4A");
        this.Leg3A = this.head2.getChild("Leg3A");
        this.Leg2A = this.head2.getChild("Leg2A");
        this.Leg1A = this.head2.getChild("Leg1A");
        this.TailA = this.head2.getChild("TailA");
        this.body = this.head2.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition fullhead = head2.addOrReplaceChild("fullhead", CubeListBuilder.create(), PartPose.offset(0.0F, -28.0F, -11.0F));

        PartDefinition Head = fullhead.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 25).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition Ear1 = fullhead.addOrReplaceChild("Ear1", CubeListBuilder.create().texOffs(19, 16).mirror().addBox(-0.4913F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0044F, 11.0498F, 2.9134F, 0.5236F, 0.0F, 0.0873F));

        PartDefinition Ear2 = fullhead.addOrReplaceChild("Ear2", CubeListBuilder.create().texOffs(19, 16).addBox(-1.5F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0044F, 11.0498F, 2.9134F, 0.5236F, 0.0F, -0.0873F));

        PartDefinition Neck = fullhead.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(56, 36).addBox(-1.0F, -16.0F, 4.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 3.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition Leg4A = head2.addOrReplaceChild("Leg4A", CubeListBuilder.create().texOffs(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -11.0F, -9.0F));

        PartDefinition Leg3A = head2.addOrReplaceChild("Leg3A", CubeListBuilder.create().texOffs(48, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -11.0F, -9.0F));

        PartDefinition Leg2A = head2.addOrReplaceChild("Leg2A", CubeListBuilder.create().texOffs(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -11.0F, 9.0F));

        PartDefinition Leg1A = head2.addOrReplaceChild("Leg1A", CubeListBuilder.create().texOffs(48, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -11.0F, 9.0F));

        PartDefinition TailA = head2.addOrReplaceChild("TailA", CubeListBuilder.create().texOffs(42, 36).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 11.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition body = head2.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 9.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(GemGrazerAnimationDefinitions.GEMGRAZERWALKING, limbSwing, limbSwingAmount, 5f, 2.5f);
        this.animate(((GemGrazerEntity) entity).idleAnimationState, GemGrazerAnimationDefinitions.GEMGRAZERIDLE, ageInTicks, 1f);
        this.animate(((GemGrazerEntity) entity).attackAnimationState, GemGrazerAnimationDefinitions.GEMGRAZERWALKING, ageInTicks, 1f);

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.fullhead.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.fullhead.xRot = pHeadPitch * ((float) Math.PI / 180F);
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
