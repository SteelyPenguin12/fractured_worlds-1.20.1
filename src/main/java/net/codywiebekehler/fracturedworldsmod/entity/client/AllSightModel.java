package net.codywiebekehler.fracturedworldsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.codywiebekehler.fracturedworldsmod.entity.animations.ModAnimationsDefinitions;
import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class AllSightModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart AllSightHost;
	private final ModelPart UpperBody;
	private final ModelPart Chest;
	private final ModelPart h_head;
	private final ModelPart h_helmet;
	private final ModelPart h_horns;
	private final ModelPart RibCage;
	private final ModelPart ChestArmour;
	private final ModelPart UpperRArm;
	private final ModelPart UpperRArmour;
	private final ModelPart MiddleRArm;
	private final ModelPart LowerRArm;
	private final ModelPart RHand;
	private final ModelPart Finger1;
	private final ModelPart Finger2;
	private final ModelPart Finger3;
	private final ModelPart Finger4;
	private final ModelPart Finger5;
	private final ModelPart Finger6;
	private final ModelPart Finger7;
	private final ModelPart Finger8;
	private final ModelPart Finger9;
	private final ModelPart UpperLArm;
	private final ModelPart UpperLArmour;
	private final ModelPart MiddleLArm;
	private final ModelPart MiddleLArmour;
	private final ModelPart LowerLArm;
	private final ModelPart LowerLArmour;
	private final ModelPart LHand;
	private final ModelPart Axe;
	private final ModelPart Blade;
	private final ModelPart Handle;
	private final ModelPart LowerBody;
	private final ModelPart UpperRLeg;
	private final ModelPart LowerRLeg;
	private final ModelPart RFoot;
	private final ModelPart UpperLLeg;
	private final ModelPart LowerLLeg;
	private final ModelPart LFoot;

	public AllSightModel(ModelPart root) {
		this.AllSightHost = root.getChild("AllSightHost");
		this.UpperBody = this.AllSightHost.getChild("UpperBody");
		this.Chest = this.UpperBody.getChild("Chest");
		this.h_head = this.Chest.getChild("h_head");
		this.h_helmet = this.h_head.getChild("h_helmet");
		this.h_horns = this.h_helmet.getChild("h_horns");
		this.RibCage = this.Chest.getChild("RibCage");
		this.ChestArmour = this.Chest.getChild("ChestArmour");
		this.UpperRArm = this.UpperBody.getChild("UpperRArm");
		this.UpperRArmour = this.UpperRArm.getChild("UpperRArmour");
		this.MiddleRArm = this.UpperRArm.getChild("MiddleRArm");
		this.LowerRArm = this.MiddleRArm.getChild("LowerRArm");
		this.RHand = this.LowerRArm.getChild("RHand");
		this.Finger1 = this.RHand.getChild("Finger1");
		this.Finger2 = this.Finger1.getChild("Finger2");
		this.Finger3 = this.Finger2.getChild("Finger3");
		this.Finger4 = this.RHand.getChild("Finger4");
		this.Finger5 = this.Finger4.getChild("Finger5");
		this.Finger6 = this.Finger5.getChild("Finger6");
		this.Finger7 = this.RHand.getChild("Finger7");
		this.Finger8 = this.Finger7.getChild("Finger8");
		this.Finger9 = this.Finger8.getChild("Finger9");
		this.UpperLArm = this.UpperBody.getChild("UpperLArm");
		this.UpperLArmour = this.UpperLArm.getChild("UpperLArmour");
		this.MiddleLArm = this.UpperLArm.getChild("MiddleLArm");
		this.MiddleLArmour = this.MiddleLArm.getChild("MiddleLArmour");
		this.LowerLArm = this.MiddleLArm.getChild("LowerLArm");
		this.LowerLArmour = this.LowerLArm.getChild("LowerLArmour");
		this.LHand = this.LowerLArm.getChild("LHand");
		this.Axe = this.LHand.getChild("Axe");
		this.Blade = this.Axe.getChild("Blade");
		this.Handle = this.Axe.getChild("Handle");
		this.LowerBody = this.AllSightHost.getChild("LowerBody");
		this.UpperRLeg = this.LowerBody.getChild("UpperRLeg");
		this.LowerRLeg = this.UpperRLeg.getChild("LowerRLeg");
		this.RFoot = this.LowerRLeg.getChild("RFoot");
		this.UpperLLeg = this.LowerBody.getChild("UpperLLeg");
		this.LowerLLeg = this.UpperLLeg.getChild("LowerLLeg");
		this.LFoot = this.LowerLLeg.getChild("LFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition AllSightHost = partdefinition.addOrReplaceChild("AllSightHost", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition UpperBody = AllSightHost.addOrReplaceChild("UpperBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Chest = UpperBody.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(226, 76).addBox(-5.0F, -24.0F, -6.0F, 11.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.25F, -22.0F, -28.0F, 13.0F, 11.0F, 54.0F, new CubeDeformation(0.0F))
				.texOffs(104, 100).addBox(-4.5F, 9.0F, -13.0F, 10.0F, 9.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(0, 129).addBox(-3.5F, 4.0F, -13.0F, 10.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(82, 247).addBox(-3.0F, -3.0F, -12.5F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(110, 248).addBox(-3.0F, -3.0F, 4.5F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(104, 193).addBox(2.75F, -11.0F, -10.25F, 2.0F, 16.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(18, 255).addBox(4.0F, -12.0F, -7.25F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(76, 260).addBox(4.0F, -12.0F, 3.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(84, 270).addBox(3.25F, -3.0F, 8.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 270).addBox(3.25F, -3.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(258, 48).addBox(-3.0F, -3.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -33.0F, 2.0F));

		PartDefinition cube_r1 = Chest.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 215).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -10.0F, 13.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Chest.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(194, 212).addBox(-5.0F, -11.0F, -5.0F, 10.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.0F, -11.75F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Chest.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(104, 65).addBox(-5.0F, -7.0F, -14.0F, 11.0F, 7.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.5F, -1.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition h_head = Chest.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(142, 133).addBox(-7.25F, -14.0F, -7.0F, 14.0F, 13.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(144, 212).addBox(-6.25F, -1.0F, -6.0F, 13.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, -1.0F));

		PartDefinition h_helmet = h_head.addOrReplaceChild("h_helmet", CubeListBuilder.create().texOffs(256, 101).addBox(-8.5F, 4.0F, -8.5F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(266, 132).addBox(-8.5F, -1.0F, -8.5F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(144, 193).addBox(-7.5F, -7.0F, -8.5F, 16.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(242, 0).addBox(-7.5F, -7.0F, 7.5F, 16.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(224, 91).addBox(7.5F, -7.0F, -7.5F, 1.0F, 15.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(228, 202).addBox(-8.5F, -7.0F, -8.5F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(76, 252).addBox(-8.5F, -7.0F, 6.5F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(58, 268).addBox(-8.5F, -1.0F, 4.5F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(258, 37).addBox(-8.5F, 4.0F, 1.5F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(82, 240).addBox(-8.5F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(222, 254).addBox(-8.5F, -7.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(134, 40).addBox(-8.5F, -9.0F, -8.5F, 17.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(68, 156).addBox(-8.0F, -9.25F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(46, 174).addBox(-7.5F, -9.5F, -7.5F, 15.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition h_horns = h_helmet.addOrReplaceChild("h_horns", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, 0.0F));

		PartDefinition cube_r4 = h_horns.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 266).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -17.75F, -16.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r5 = h_horns.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 266).addBox(-2.0F, -5.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 1.0F, -8.0F, 1.309F, 0.0F, 0.0F));

		PartDefinition cube_r6 = h_horns.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(200, 270).addBox(0.0F, -8.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -7.25F, 15.25F, 0.318F, 0.1699F, -0.1822F));

		PartDefinition cube_r7 = h_horns.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(196, 270).addBox(0.0F, -8.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -10.25F, -14.5F, -0.6904F, 0.5831F, -0.1729F));

		PartDefinition cube_r8 = h_horns.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(26, 255).addBox(0.0F, -8.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -7.25F, -15.75F, 0.0844F, 0.1965F, -0.2667F));

		PartDefinition cube_r9 = h_horns.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(128, 184).addBox(0.0F, -8.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -3.0F, -12.5F, 0.5442F, 0.2127F, -0.5783F));

		PartDefinition cube_r10 = h_horns.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(100, 260).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.0F, -11.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = h_horns.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(264, 165).addBox(-1.0F, -11.0F, -2.0F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -8.75F, -15.25F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r12 = h_horns.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(132, 261).addBox(0.0F, -11.0F, -1.0F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -17.75F, 16.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r13 = h_horns.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 264).addBox(-1.0F, -11.0F, -1.0F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -8.75F, 15.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r14 = h_horns.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(42, 225).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.0F, 11.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r15 = h_horns.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(234, 265).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 1.0F, 8.0F, -1.309F, 0.0F, 0.0F));

		PartDefinition cube_r16 = h_horns.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(246, 265).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 1.0F, 7.5F, -1.3835F, 0.1841F, -0.7681F));

		PartDefinition cube_r17 = h_horns.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(166, 263).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 11.0F, -0.9325F, 0.1919F, -0.7083F));

		PartDefinition cube_r18 = h_horns.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(264, 224).addBox(-1.0F, -10.0F, -1.0F, 1.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.75F, 18.0F, -0.3459F, 0.1986F, -0.7018F));

		PartDefinition cube_r19 = h_horns.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(264, 211).addBox(-1.0F, -10.0F, -2.0F, 1.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.75F, -18.0F, 0.3459F, -0.1986F, -0.7018F));

		PartDefinition cube_r20 = h_horns.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(122, 261).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -11.0F, 0.9325F, -0.1919F, -0.7083F));

		PartDefinition cube_r21 = h_horns.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(222, 265).addBox(-2.0F, -5.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 1.0F, -7.5F, 1.3835F, -0.1841F, -0.7681F));

		PartDefinition RibCage = Chest.addOrReplaceChild("RibCage", CubeListBuilder.create(), PartPose.offset(0.0F, 33.0F, -2.0F));

		PartDefinition cube_r22 = RibCage.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(50, 171).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(68, 129).addBox(-1.0F, -3.0F, -11.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -30.25F, 6.25F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r23 = RibCage.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(48, 171).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -30.25F, 7.25F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = RibCage.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(46, 171).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(72, 129).addBox(-1.0F, -3.0F, -11.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -32.25F, 6.25F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r25 = RibCage.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(140, 156).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -32.25F, 7.25F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r26 = RibCage.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(58, 171).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -36.25F, 7.25F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = RibCage.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(56, 171).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(54, 171).addBox(-1.0F, -3.0F, -11.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -36.25F, 6.25F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r28 = RibCage.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(138, 156).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -34.25F, 7.25F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r29 = RibCage.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(136, 156).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(134, 156).addBox(-1.0F, -3.0F, -11.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -34.25F, 6.25F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = RibCage.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(52, 171).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -36.25F, -5.25F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r31 = RibCage.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(132, 156).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -34.25F, -5.25F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = RibCage.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(74, 129).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -32.25F, -5.25F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = RibCage.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(70, 129).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -30.25F, -5.25F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition ChestArmour = Chest.addOrReplaceChild("ChestArmour", CubeListBuilder.create().texOffs(0, 65).addBox(-7.0F, -24.25F, -19.5F, 14.0F, 4.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r34 = ChestArmour.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 212).addBox(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -26.0F, -21.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r35 = ChestArmour.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(68, 133).addBox(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -25.0F, -24.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition UpperRArm = UpperBody.addOrReplaceChild("UpperRArm", CubeListBuilder.create(), PartPose.offset(0.25F, -50.0F, 24.0F));

		PartDefinition cube_r36 = UpperRArm.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(178, 160).addBox(-6.0F, -6.777F, -5.4406F, 13.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 8.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r37 = UpperRArm.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(54, 191).addBox(-7.0F, -5.777F, -5.4406F, 14.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition UpperRArmour = UpperRArm.addOrReplaceChild("UpperRArmour", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r38 = UpperRArmour.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(84, 260).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 260).addBox(8.75F, -5.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -7.5F, -5.25F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r39 = UpperRArmour.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(264, 179).addBox(-1.0F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(264, 179).addBox(9.75F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -9.5F, -1.25F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r40 = UpperRArmour.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(94, 215).addBox(0.0F, -9.0F, -1.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(94, 215).addBox(10.75F, -9.0F, -1.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -9.5F, 4.75F, -1.8326F, 0.0F, 0.0F));

		PartDefinition cube_r41 = UpperRArmour.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(146, 270).addBox(1.0F, -9.0F, 1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(146, 270).addBox(11.75F, -9.0F, 1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -9.25F, 12.75F, -2.0944F, 0.0F, 0.0F));

		PartDefinition cube_r42 = UpperRArmour.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(134, 20).addBox(-9.0F, -2.0F, -11.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 7.5F, 12.0F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r43 = UpperRArmour.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(134, 59).addBox(-8.0F, -2.0F, -3.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -1.25F, 9.5F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r44 = UpperRArmour.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(134, 0).addBox(-9.0F, -2.0F, -11.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -4.75F, 1.75F, -0.2618F, 0.0F, 0.0F));

		PartDefinition MiddleRArm = UpperRArm.addOrReplaceChild("MiddleRArm", CubeListBuilder.create().texOffs(182, 59).addBox(-5.25F, -4.027F, -5.6906F, 11.0F, 21.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(242, 254).addBox(-2.75F, -3.25F, -6.25F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.25F, 7.25F));

		PartDefinition LowerRArm = MiddleRArm.addOrReplaceChild("LowerRArm", CubeListBuilder.create().texOffs(206, 0).addBox(-4.5F, -6.777F, -4.4406F, 9.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 17.75F, -0.25F));

		PartDefinition cube_r45 = LowerRArm.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(264, 156).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, 6.5F, 0.0F, -1.0776F, 1.5529F, -1.1672F));

		PartDefinition cube_r46 = LowerRArm.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(36, 264).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.75F, 15.5F, 0.0F, -1.5841F, -1.5529F, 1.9744F));

		PartDefinition cube_r47 = LowerRArm.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 255).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r48 = LowerRArm.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(256, 90).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 4.5F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RHand = LowerRArm.addOrReplaceChild("RHand", CubeListBuilder.create(), PartPose.offset(-0.25F, 21.0F, 1.0F));

		PartDefinition Finger1 = RHand.addOrReplaceChild("Finger1", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, 3.0F));

		PartDefinition cube_r49 = Finger1.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(60, 252).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.25F, -0.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Finger2 = Finger1.addOrReplaceChild("Finger2", CubeListBuilder.create(), PartPose.offset(0.25F, 11.0F, 2.0F));

		PartDefinition cube_r50 = Finger2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(154, 260).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.25F, -0.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Finger3 = Finger2.addOrReplaceChild("Finger3", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.25F));

		PartDefinition cube_r51 = Finger3.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(258, 266).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.75F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Finger4 = RHand.addOrReplaceChild("Finger4", CubeListBuilder.create(), PartPose.offset(3.25F, -2.5F, 3.0F));

		PartDefinition cube_r52 = Finger4.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(190, 254).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, -0.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Finger5 = Finger4.addOrReplaceChild("Finger5", CubeListBuilder.create(), PartPose.offset(0.25F, 10.75F, 2.0F));

		PartDefinition cube_r53 = Finger5.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(260, 254).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 1.0F, -0.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Finger6 = Finger5.addOrReplaceChild("Finger6", CubeListBuilder.create(), PartPose.offset(-0.25F, 8.0F, 0.25F));

		PartDefinition cube_r54 = Finger6.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(266, 266).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.5F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Finger7 = RHand.addOrReplaceChild("Finger7", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -4.0F));

		PartDefinition cube_r55 = Finger7.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(206, 254).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.25F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Finger8 = Finger7.addOrReplaceChild("Finger8", CubeListBuilder.create(), PartPose.offset(0.25F, 10.25F, -2.5F));

		PartDefinition cube_r56 = Finger8.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(110, 261).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, 0.75F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Finger9 = Finger8.addOrReplaceChild("Finger9", CubeListBuilder.create(), PartPose.offset(0.0F, 8.75F, -0.25F));

		PartDefinition cube_r57 = Finger9.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(268, 56).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.25F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition UpperLArm = UpperBody.addOrReplaceChild("UpperLArm", CubeListBuilder.create(), PartPose.offset(0.0F, -50.0F, -24.0F));

		PartDefinition cube_r58 = UpperLArm.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(172, 100).addBox(-7.0F, -6.777F, -6.5594F, 14.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.75F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r59 = UpperLArm.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(178, 186).addBox(-6.0F, -6.777F, -6.5594F, 13.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -4.25F, -0.3491F, 0.0F, 0.0F));

		PartDefinition UpperLArmour = UpperLArm.addOrReplaceChild("UpperLArmour", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r60 = UpperLArmour.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(214, 237).addBox(-5.0F, -4.0F, -1.0F, 9.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, -13.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r61 = UpperLArmour.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(46, 158).addBox(-5.0F, -4.0F, -1.0F, 10.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -10.25F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r62 = UpperLArmour.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(76, 107).addBox(-6.0F, -4.0F, -1.0F, 12.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -9.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r63 = UpperLArmour.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 191).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, -4.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r64 = UpperLArmour.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 107).addBox(-9.0F, -2.0F, -1.0F, 18.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -9.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r65 = UpperLArmour.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(32, 245).addBox(-1.5F, -5.0F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -26.0F, -10.75F, -0.1585F, -1.0293F, -0.1583F));

		PartDefinition cube_r66 = UpperLArmour.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(138, 270).addBox(-1.5F, -7.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.75F, -26.25F, -9.5F, -0.2181F, -0.9597F, 0.2235F));

		PartDefinition cube_r67 = UpperLArmour.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(268, 68).addBox(-1.5F, -9.0F, -0.5F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, -25.25F, -10.25F, 0.7101F, -0.7968F, -0.1853F));

		PartDefinition cube_r68 = UpperLArmour.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(268, 79).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -9.25F, 1.75F, -0.1265F, -0.6404F, 0.2037F));

		PartDefinition cube_r69 = UpperLArmour.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(170, 248).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -9.5F, 1.5F, -1.716F, -1.2878F, 2.3319F));

		PartDefinition cube_r70 = UpperLArmour.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(166, 248).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -9.25F, 1.25F, 1.054F, -0.8391F, -0.6614F));

		PartDefinition cube_r71 = UpperLArmour.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(192, 270).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -17.75F, 2.5F, 0.1961F, -0.6499F, -0.3396F));

		PartDefinition cube_r72 = UpperLArmour.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(128, 174).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(2.0F)), PartPose.offsetAndRotation(5.0F, -17.25F, -7.0F, 0.3673F, -0.5553F, -0.3663F));

		PartDefinition cube_r73 = UpperLArmour.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 245).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -7.25F, -1.0F, 0.6414F, -0.5547F, -0.3542F));

		PartDefinition cube_r74 = UpperLArmour.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(68, 268).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(2.0F)), PartPose.offsetAndRotation(2.5F, -7.25F, -1.25F, 0.6602F, -0.6386F, -0.2326F));

		PartDefinition MiddleLArm = UpperLArm.addOrReplaceChild("MiddleLArm", CubeListBuilder.create().texOffs(198, 126).addBox(-5.5F, -6.777F, -5.8094F, 11.0F, 19.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 19.0F, -6.0F));

		PartDefinition MiddleLArmour = MiddleLArm.addOrReplaceChild("MiddleLArmour", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r75 = MiddleLArmour.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(178, 237).addBox(-8.0F, -2.0F, 5.0F, 3.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -7.75F, 1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r76 = MiddleLArmour.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(202, 40).addBox(-7.0F, -2.0F, 2.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, -9.25F, -0.3927F, 0.0F, 0.0F));

		PartDefinition LowerLArm = MiddleLArm.addOrReplaceChild("LowerLArm", CubeListBuilder.create().texOffs(228, 181).addBox(-4.5F, -1.777F, -4.3094F, 9.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -0.5F));

		PartDefinition LowerLArmour = LowerLArm.addOrReplaceChild("LowerLArmour", CubeListBuilder.create().texOffs(42, 240).addBox(-5.0F, 10.0F, -4.75F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r77 = LowerLArmour.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(178, 228).addBox(-8.0F, -2.0F, 13.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -10.0F, -5.25F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r78 = LowerLArmour.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(242, 142).addBox(-8.0F, -2.0F, 8.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -10.0F, 1.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition LHand = LowerLArm.addOrReplaceChild("LHand", CubeListBuilder.create().texOffs(228, 156).addBox(-4.75F, -3.027F, -4.5594F, 9.0F, 16.0F, 9.0F, new CubeDeformation(-1.0F))
				.texOffs(106, 174).addBox(-4.75F, -1.75F, -4.75F, 9.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 12.0F, 0.25F));

		PartDefinition Axe = LHand.addOrReplaceChild("Axe", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.0F, 0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Blade = Axe.addOrReplaceChild("Blade", CubeListBuilder.create().texOffs(444, 325).addBox(-0.35F, -3.95F, -1.226F, 11.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(475, 323).addBox(-1.64F, -8.37F, -0.692F, 13.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(409, 378).addBox(7.91F, -3.95F, -2.186F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -36.75F, 1.5708F, 0.0F, 1.5708F));

		PartDefinition cube_r79 = Blade.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(446, 362).addBox(0.97F, -16.792F, -0.852F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(412, 358).addBox(-4.124F, 3.26F, -0.284F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(419, 366).addBox(-9.84F, 2.55F, -0.284F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(475, 359).addBox(-14.55F, 1.84F, -0.284F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r80 = Blade.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(466, 367).addBox(-10.119F, -15.9688F, -1.136F, 17.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, 1.309F));

		PartDefinition cube_r81 = Blade.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(440, 381).addBox(-16.2912F, 11.3027F, -1.136F, 17.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, -3.38F, -0.09F, 0.0F, 0.0F, -1.309F));

		PartDefinition cube_r82 = Blade.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(398, 372).addBox(-17.882F, 3.8227F, -0.568F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, 1.7017F));

		PartDefinition cube_r83 = Blade.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(420, 360).addBox(3.94F, -1.0F, -0.284F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(477, 353).addBox(3.91F, -1.71F, -0.284F, 11.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r84 = Blade.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(475, 347).addBox(3.46F, -2.42F, -0.284F, 15.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.38F, -0.09F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r85 = Blade.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(474, 340).addBox(2.8054F, 0.303F, -0.568F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, -1.7017F));

		PartDefinition cube_r86 = Blade.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(414, 348).addBox(-11.0883F, -4.2505F, -0.852F, 11.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, 0.16F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r87 = Blade.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(415, 338).addBox(-7.3422F, -1.277F, -0.852F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.54F, 1.87F, 0.16F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r88 = Blade.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(426, 326).addBox(-26.8934F, -8.4234F, -0.852F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, -4.13F, 0.16F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r89 = Blade.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(444, 348).addBox(-22.2981F, -2.3771F, -1.136F, 11.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r90 = Blade.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(444, 337).addBox(-11.9969F, 1.155F, -1.136F, 11.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.71F, -3.63F, -0.09F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Handle = Axe.addOrReplaceChild("Handle", CubeListBuilder.create().texOffs(450, 442).addBox(-1.58F, 33.37F, -1.26F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 423).addBox(-1.58F, -39.97F, -1.26F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 417).addBox(-1.58F, -16.27F, -1.26F, 3.0F, 40.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(465, 420).addBox(-1.0F, 22.67F, 0.16F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(473, 420).addBox(-0.148F, 22.67F, -0.55F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(411, 421).addBox(-1.0F, -26.93F, 0.444F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(482, 420).addBox(0.136F, -26.93F, 0.16F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(490, 420).addBox(-1.284F, -26.93F, -0.55F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.0F, 0.5F, 1.5708F, 0.0F, 1.5708F));

		PartDefinition LowerBody = AllSightHost.addOrReplaceChild("LowerBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition UpperRLeg = LowerBody.addOrReplaceChild("UpperRLeg", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 11.0F));

		PartDefinition cube_r91 = UpperRLeg.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(136, 228).addBox(-5.0F, -19.0F, -2.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 11.5F, -0.75F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r92 = UpperRLeg.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(226, 56).addBox(-5.0F, -19.0F, -2.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 14.5F, -5.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r93 = UpperRLeg.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(132, 160).addBox(-5.0F, -19.0F, -7.0F, 11.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 14.0F, 0.75F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LowerRLeg = UpperRLeg.addOrReplaceChild("LowerRLeg", CubeListBuilder.create(), PartPose.offset(-1.0F, 17.0F, 1.0F));

		PartDefinition cube_r94 = LowerRLeg.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(266, 16).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, 0.0F, 0.9194F, -1.5551F, -1.6897F));

		PartDefinition cube_r95 = LowerRLeg.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(176, 263).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, 2.25F, -0.5F, 2.7042F, -1.5473F, 3.1063F));

		PartDefinition cube_r96 = LowerRLeg.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(204, 270).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.75F, 10.5F, 0.0F, -3.1376F, -1.5206F, 2.8755F));

		PartDefinition cube_r97 = LowerRLeg.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(242, 16).addBox(-7.0F, -23.0F, -3.0F, 8.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 29.0F, 0.75F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r98 = LowerRLeg.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(134, 63).addBox(-5.0F, -2.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.75F, 0.0F, 0.25F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r99 = LowerRLeg.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(198, 156).addBox(-5.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.75F, 5.5F, -0.25F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r100 = LowerRLeg.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(172, 126).addBox(-7.0F, -2.0F, -2.0F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, 10.75F, 0.25F, 0.0F, 0.0F, 0.7418F));

		PartDefinition cube_r101 = LowerRLeg.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(206, 91).addBox(-4.0F, -3.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 13.0F, -0.25F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r102 = LowerRLeg.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(234, 202).addBox(-7.0F, -19.0F, -1.0F, 8.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 14.0F, -2.75F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RFoot = LowerRLeg.addOrReplaceChild("RFoot", CubeListBuilder.create(), PartPose.offset(3.0F, 20.0F, 0.0F));

		PartDefinition cube_r103 = RFoot.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(138, 248).addBox(-8.0F, -28.0F, -4.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 26.0F, 1.25F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r104 = RFoot.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(264, 237).addBox(-5.0F, -26.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 24.25F, 0.75F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r105 = RFoot.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(266, 120).addBox(-1.0404F, -1.0209F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 3.5F, -0.25F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r106 = RFoot.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(170, 59).addBox(-0.0404F, -1.0209F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 2.5F, 0.25F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r107 = RFoot.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(182, 91).addBox(-4.955F, -3.1101F, -2.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.25F, 0.5F, 0.25F, 0.0F, 0.0F, -0.3491F));

		PartDefinition UpperLLeg = LowerBody.addOrReplaceChild("UpperLLeg", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -9.0F));

		PartDefinition cube_r108 = UpperLLeg.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(136, 228).addBox(-5.0F, -19.0F, -2.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 11.5F, -5.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r109 = UpperLLeg.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(226, 56).addBox(-5.0F, -19.0F, -2.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 14.5F, -0.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r110 = UpperLLeg.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(132, 160).addBox(-5.0F, -19.0F, -7.0F, 11.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 14.0F, 1.25F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LowerLLeg = UpperLLeg.addOrReplaceChild("LowerLLeg", CubeListBuilder.create(), PartPose.offset(-1.0F, 17.0F, 0.0F));

		PartDefinition cube_r111 = LowerLLeg.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(134, 63).addBox(-5.0F, -2.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.75F, 0.0F, -0.25F, 0.0F, 0.0F, 1.2654F));

		PartDefinition cube_r112 = LowerLLeg.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(198, 156).addBox(-5.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.75F, 5.5F, -0.75F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r113 = LowerLLeg.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(172, 126).addBox(-7.0F, -2.0F, -2.0F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, 10.75F, -0.25F, 0.0F, 0.0F, 0.7418F));

		PartDefinition cube_r114 = LowerLLeg.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(206, 91).addBox(-4.0F, -3.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 13.0F, -0.75F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r115 = LowerLLeg.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(266, 16).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, -0.5F, 0.9194F, -1.5551F, -1.6897F));

		PartDefinition cube_r116 = LowerLLeg.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(176, 263).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, 2.25F, -1.0F, 2.7042F, -1.5473F, 3.1063F));

		PartDefinition cube_r117 = LowerLLeg.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(204, 270).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.75F, 10.5F, -0.5F, -3.1376F, -1.5206F, 2.8755F));

		PartDefinition cube_r118 = LowerLLeg.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(234, 202).addBox(-7.0F, -19.0F, -1.0F, 8.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 14.0F, -3.25F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r119 = LowerLLeg.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(242, 16).addBox(-7.0F, -23.0F, -3.0F, 8.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 29.0F, 0.25F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LFoot = LowerLLeg.addOrReplaceChild("LFoot", CubeListBuilder.create(), PartPose.offset(2.75F, 19.75F, -0.5F));

		PartDefinition cube_r120 = LFoot.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(182, 91).addBox(-4.955F, -3.1101F, -2.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 0.75F, 0.25F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r121 = LFoot.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(170, 59).addBox(-0.0404F, -1.0209F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.25F, 2.75F, 0.25F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r122 = LFoot.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(266, 120).addBox(-1.0404F, -1.0209F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.25F, 3.75F, -0.25F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r123 = LFoot.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(264, 237).addBox(-5.0F, -26.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 24.5F, 0.75F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r124 = LFoot.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(138, 248).addBox(-8.0F, -28.0F, -4.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 26.25F, 1.25F, 0.0F, 0.0F, 0.0436F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose); //resets all limbs to t-pose before every animation
		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

		this.animateWalk(ModAnimationsDefinitions.ALL_SIGHT_WALK, limbSwing, limbSwingAmount, 10f, 20.5f); //defines animation for walk cycle
		this.animate(((AllSightEntity)entity).idleAnimationState, ModAnimationsDefinitions.ALL_SIGHT_IDLE, ageInTicks, 1f);
		this.animate(((AllSightEntity)entity).attackAnimationState, ModAnimationsDefinitions.ALL_SIGHT_ATTACK, ageInTicks, 1f);
	}
	//helper method for setting the heads rotation
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.h_head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.h_head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		AllSightHost.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return AllSightHost;
	}
}