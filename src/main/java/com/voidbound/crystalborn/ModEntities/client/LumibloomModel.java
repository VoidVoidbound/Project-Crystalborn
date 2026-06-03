package com.voidbound.crystalborn.ModEntities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.voidbound.crystalborn.ModEntities.animations.LumibloomAnimationDefinitions;
import com.voidbound.crystalborn.ModEntities.custom.LumibloomEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class LumibloomModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart Lumibloom;
    private final ModelPart body;
    private final ModelPart legs;
    private final ModelPart frontleft;
    private final ModelPart middleleft;
    private final ModelPart backleft;
    private final ModelPart frontright;
    private final ModelPart middleright;
    private final ModelPart backright;

    public LumibloomModel(ModelPart root) {
        this.Lumibloom = root.getChild("Lumibloom");
        this.body = this.Lumibloom.getChild("body");
        this.legs = this.Lumibloom.getChild("legs");
        this.frontleft = this.legs.getChild("frontleft");
        this.middleleft = this.legs.getChild("middleleft");
        this.backleft = this.legs.getChild("backleft");
        this.frontright = this.legs.getChild("frontright");
        this.middleright = this.legs.getChild("middleright");
        this.backright = this.legs.getChild("backright");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Lumibloom = partdefinition.addOrReplaceChild("Lumibloom", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = Lumibloom.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition legs = Lumibloom.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(0, 27).addBox(9.0F, -2.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 4.0F));

        PartDefinition frontleft = legs.addOrReplaceChild("frontleft", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, -8.0F));

        PartDefinition middleleft = legs.addOrReplaceChild("middleleft", CubeListBuilder.create().texOffs(16, 27).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 0.0F, -4.0F));

        PartDefinition backleft = legs.addOrReplaceChild("backleft", CubeListBuilder.create().texOffs(8, 27).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 0.0F, 0.0F));

        PartDefinition frontright = legs.addOrReplaceChild("frontright", CubeListBuilder.create().texOffs(8, 31).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition middleright = legs.addOrReplaceChild("middleright", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition backright = legs.addOrReplaceChild("backright", CubeListBuilder.create().texOffs(24, 27).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(LumibloomAnimationDefinitions.LUMIBLOOMWALKING, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(((LumibloomEntity) entity).idleAnimationState, LumibloomAnimationDefinitions.LUMIBLOOMIDLE, ageInTicks, 1f);
        this.animate(((LumibloomEntity) entity).attackAnimationState, LumibloomAnimationDefinitions.LUMIBLOOMWALKING, ageInTicks, 1f);

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);

        this.Lumibloom.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Lumibloom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return Lumibloom;
    }
}
