package net.codywiebekehler.fracturedworldsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.codywiebekehler.fracturedworldsmod.FracturedWorldsMod;
import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AllSightRenderer extends MobRenderer<AllSightEntity, AllSightModel<AllSightEntity>> {
    public AllSightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AllSightModel<>(pContext.bakeLayer(ModModelLayers.ALL_SIGHT_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(AllSightEntity pEntity) {
        return new ResourceLocation(FracturedWorldsMod.MOD_ID, "textures/entity/all_sight.png");
    }

    @Override
    public void render(AllSightEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
//        pPoseStack.scale(0.75f,0.75f,0.75f);
//        pPoseStack.translate(0,1f,0);
//        pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
