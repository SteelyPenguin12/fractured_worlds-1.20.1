package net.codywiebekehler.fracturedworldsmod.event;

import net.codywiebekehler.fracturedworldsmod.FracturedWorldsMod;
import net.codywiebekehler.fracturedworldsmod.entity.client.AllSightModel;
import net.codywiebekehler.fracturedworldsmod.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FracturedWorldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.ALL_SIGHT_LAYER, AllSightModel::createBodyLayer);
    }
}
