package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.entity.client.custom.Cushion;
import net.tearpelato.falldrop_backport.entity.client.custom.Frostbite;
import net.tearpelato.falldrop_backport.item.projectile.IceBall;

import java.util.function.Supplier;

public class ModEntities {


    public static final ResourceKey<EntityType<?>> POPLAR_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Constants.vanilla("poplar_boat"));
    public static final ResourceKey<EntityType<?>> POPLAR_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Constants.vanilla("poplar_chest_boat"));
    public static final ResourceKey<EntityType<?>> CUSHION_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Constants.vanilla("cushion"));
    public static final ResourceKey<EntityType<?>> ICE_BALL_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Constants.vanilla("ice_ball"));
    public static final ResourceKey<EntityType<?>> FROSTBITE_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Constants.vanilla("frostbite"));


    public static final Supplier<EntityType<Boat>> POPLAR_BOAT = ObjectRegistries.registerEntity(Constants.vanilla("poplar_boat"),
            () -> EntityType.Builder.<Boat>of((entityType, level) -> new Boat(entityType, level, ModItems.POPLAR_BOAT),
                            MobCategory.MISC).eyeHeight(0.5625f).clientTrackingRange(10).noLootTable()
                    .sized(1.375f, 0.5625f).build(POPLAR_BOAT_KEY));
    public static final Supplier<EntityType<ChestBoat>> POPLAR_CHEST_BOAT = ObjectRegistries.registerEntity(Constants.vanilla("poplar_chest_boat"),
            () -> EntityType.Builder.<ChestBoat>of((entityType, level) -> new ChestBoat(entityType, level, ModItems.POPLAR_CHEST_BOAT),
                            MobCategory.MISC).eyeHeight(0.5625f).clientTrackingRange(10).noLootTable()
                    .sized(1.375f, 0.5625f).build(POPLAR_CHEST_BOAT_KEY));
    public static final Supplier<EntityType<Cushion>> CUSHION = ObjectRegistries.registerEntity(Constants.vanilla("cushion"),
            () -> EntityType.Builder.<Cushion>of(Cushion::new,
                            MobCategory.MISC).noLootTable().sized(1.0F, 0.25F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(CUSHION_KEY));

    public static final Supplier<EntityType<IceBall>> ICE_BALL = ObjectRegistries.registerEntity(Constants.vanilla("ice_ball"),
            ()-> EntityType.Builder.<IceBall>of(IceBall::new, MobCategory.MISC).noLootTable().sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(ICE_BALL_KEY));

    public static final Supplier<EntityType<Frostbite>> FROSTBITE = ObjectRegistries.registerEntity(Constants.vanilla("frostbite"),
            ()-> EntityType.Builder.<Frostbite>of(Frostbite::new, MobCategory.MONSTER).sized(0.6F, 1.95F).eyeHeight(1.74F).passengerAttachments(new float[]{2.0125F}).ridingOffset(-0.7F).clientTrackingRange(8).notInPeaceful().build(FROSTBITE_KEY));


    public static void init() {}

}

