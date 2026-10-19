package net.codywiebekehler.fracturedworldsmod.entity;

import net.codywiebekehler.fracturedworldsmod.FracturedWorldsMod;
import net.codywiebekehler.fracturedworldsmod.entity.custom.AllSightEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FracturedWorldsMod.MOD_ID);

    public static final RegistryObject<EntityType<AllSightEntity>> AllSight =
            ENTITY_TYPES.register("all_sight", () -> EntityType.Builder.of(AllSightEntity::new, MobCategory.MONSTER)
                    .sized(2f, 3.5f).build("all_sight"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
