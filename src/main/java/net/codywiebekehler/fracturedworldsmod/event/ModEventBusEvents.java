package net.codywiebekehler.fracturedworldsmod.event;

import net.codywiebekehler.fracturedworldsmod.FracturedWorldsMod;
import net.codywiebekehler.fracturedworldsmod.entity.ModEntities;
import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FracturedWorldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.AllSight.get(), AllSightEntity.createAttributes().build());
    }
}
