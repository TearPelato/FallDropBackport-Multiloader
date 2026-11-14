package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import  net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.tearpelato.craftcorelib.api.registry.HolderRegistry;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

import java.util.function.Supplier;

public class ModSounds {

    public static final Supplier<SoundEvent> SHELF_MUSHROOM_BOUNCE = registerSoundEvent("block.shelf_mushroom.bounce");
    public static final Supplier<SoundEvent> SHELF_MUSHROOM_BREAK = registerSoundEvent("block.shelf_mushroom.break");
    public static final Supplier<SoundEvent> SHELF_MUSHROOM_FALL = registerSoundEvent("block.shelf_mushroom.fall");
    public static final Supplier<SoundEvent> SHELF_MUSHROOM_PLACE = registerSoundEvent("block.shelf_mushroom.place");
    public static final Supplier<SoundEvent> SHELF_MUSHROOM_STEP = registerSoundEvent("block.shelf_mushroom.step");
    public static final Supplier<SoundEvent> POPLAR_LEAVES_BREAK = registerSoundEvent("block.poplar_leaves.break");
    public static final Supplier<SoundEvent> POPLAR_LEAVES_HIT = registerSoundEvent("block.poplar_leaves.hit");
    public static final Supplier<SoundEvent> POPLAR_LEAVES_FALL = registerSoundEvent("block.poplar_leaves.fall");
    public static final Supplier<SoundEvent> POPLAR_LEAVES_PLACE = registerSoundEvent("block.poplar_leaves.place");
    public static final Supplier<SoundEvent> POPLAR_LEAVES_STEP = registerSoundEvent("block.poplar_leaves.step");
    public static final Supplier<SoundEvent> STRAW_BED_BREAK = registerSoundEvent("block.straw_bed.break");
    public static final Supplier<SoundEvent> STRAW_BED_BREAK_LEAVE = registerSoundEvent("block.straw_bed.break_leave");
    public static final Supplier<SoundEvent> STRAW_BED_STEP = registerSoundEvent("block.straw_bed.step");
    public static final Supplier<SoundEvent> STRAW_BED_PLACE = registerSoundEvent("block.straw_bed.place");
    public static final Supplier<SoundEvent> STRAW_BED_HIT = registerSoundEvent("block.straw_bed.hit");
    public static final Supplier<SoundEvent> STRAW_BED_FALL = registerSoundEvent("block.straw_bed.fall");
    public static final Supplier<SoundEvent> RED_SHRUB_BREAK = registerSoundEvent("block.red_shrub.break");
    public static final Supplier<SoundEvent> RED_SHRUB_PLACE = registerSoundEvent("block.red_shrub.place");

    public static final Supplier<SoundEvent> CUSHION_BREAK = registerSoundEvent("entity.cushion.break");
    public static final Supplier<SoundEvent> CUSHION_PLACE = registerSoundEvent("entity.cushion.place");
    public static final Supplier<SoundEvent> CUSHION_SIT = registerSoundEvent("entity.cushion.sit");
    public static final Supplier<SoundEvent> CUSHION_GET_UP = registerSoundEvent("entity.cushion.get_up");

    public static final Supplier<SoundEvent> ICE_BLOCK_AMBIENT = registerSoundEvent("block.ice.ambient");
    public static final Supplier<SoundEvent> FROSTBITE_AMBIENT = registerSoundEvent("entity.frostbite.ambient");
    public static final Supplier<SoundEvent> FROSTBITE_DEATH = registerSoundEvent("entity.frostbite.death");
    public static final Supplier<SoundEvent> FROSTBITE_HURT = registerSoundEvent("entity.frostbite.hurt");
    public static final Supplier<SoundEvent> FROSTBITE_STEP = registerSoundEvent("entity.frostbite.step");
    public static final Supplier<SoundEvent> ICE_BALL_BREAK = registerSoundEvent("entity.ice_ball.break");
    public static final Supplier<SoundEvent> ICE_BALL_THROW = registerSoundEvent("entity.ice_ball.throw");
    public static final Supplier<SoundEvent> ZOMBIE_CONVERTED_TO_FROSTBITE = registerSoundEvent("entity.zombie.converted_to_frostbite");
    public static final Supplier<SoundEvent> FROSTBITE_CONVERTED_TO_ZOMBIE = registerSoundEvent("entity.frostbite.converted_to_zombie");
    public static final Supplier<SoundEvent> APPLY_EFFECT_FREEZING = registerSoundEvent("event.mob_effect.freezing");

    public static final Supplier<SoundEvent> BRITTLE_ICE_BREAK = registerSoundEvent("block.brittle_ice.break");
    public static final Supplier<SoundEvent> BRITTLE_ICE_HIT = registerSoundEvent("block.brittle_ice.hit");
    public static final Supplier<SoundEvent> BRITTLE_ICE_CRACK = registerSoundEvent("block.brittle_ice.crack");
    public static final Supplier<SoundEvent> BRITTLE_ICE_PLACE = registerSoundEvent("block.brittle_ice.place");
    public static final Supplier<SoundEvent> BRITTLE_ICE_STEP = registerSoundEvent("block.brittle_ice.step");

    public static final Supplier<SoundEvent> ICICLE_BREAK = registerSoundEvent("block.icicle.break");
    public static final Supplier<SoundEvent> ICICLE_HIT = registerSoundEvent("block.icicle.hit");
    public static final Supplier<SoundEvent> ICICLE_LAND = registerSoundEvent("block.icicle.land");
    public static final Supplier<SoundEvent> ICICLE_PLACE = registerSoundEvent("block.icicle.place");
    public static final Supplier<SoundEvent> ICICLE_STEP = registerSoundEvent("block.icicle.step");

    public static final Supplier<SoundEvent> ICE_CRYSTAL_BREAK = registerSoundEvent("block.ice_crystal.break");
    public static final Supplier<SoundEvent> ICE_CRYSTAL_HIT = registerSoundEvent("block.ice_crystal.hit");
    public static final Supplier<SoundEvent> ICE_CRYSTAL_AMBIENT = registerSoundEvent("block.ice_crystal.ambient");
    public static final Supplier<SoundEvent> ICE_CRYSTAL_PLACE = registerSoundEvent("block.ice_crystal.place");
    public static final Supplier<SoundEvent> ICE_CRYSTAL_STEP = registerSoundEvent("block.ice_crystal.step");

    public static final Supplier<SoundEvent> PACKED_ICE_BREAK = registerSoundEvent("block.packed_ice.break");
    public static final Supplier<SoundEvent> PACKED_ICE_HIT = registerSoundEvent("block.packed_ice.hit");
    public static final Supplier<SoundEvent> PACKED_ICE_PLACE = registerSoundEvent("block.packed_ice.place");
    public static final Supplier<SoundEvent> PACKED_ICE_STEP = registerSoundEvent("block.packed_ice.step");



    public static final Supplier<SoundType> SHELF_MUSHROOM = ()-> new SoundType(1.0f, 1.0f,SHELF_MUSHROOM_BREAK.get(), SHELF_MUSHROOM_STEP.get(),SHELF_MUSHROOM_PLACE.get(), SoundEvents.EMPTY, SHELF_MUSHROOM_FALL.get());
    public static final Supplier<SoundType> STRAW_BED = ()-> new SoundType(1.0F,1.0F, STRAW_BED_BREAK.get(), STRAW_BED_STEP.get(), STRAW_BED_PLACE.get(), STRAW_BED_HIT.get(), STRAW_BED_FALL.get());
    public static final Supplier<SoundType> POPLAR_LEAVES = ()-> new SoundType(1.0F,1.0F, POPLAR_LEAVES_BREAK.get(), POPLAR_LEAVES_STEP.get(), POPLAR_LEAVES_PLACE.get(),POPLAR_LEAVES_HIT.get(), POPLAR_LEAVES_FALL.get());
    public static final Supplier<SoundType> RED_SHRUB = ()-> new SoundType(1.0F,1.0F,RED_SHRUB_BREAK.get(), SoundEvents.EMPTY, RED_SHRUB_PLACE.get(), SoundEvents.EMPTY, SoundEvents.EMPTY);

    public static final Supplier<SoundType> BRITTLE_ICE = ()-> new SoundType(1.0F,1.0F,BRITTLE_ICE_BREAK.get(), BRITTLE_ICE_STEP.get(), BRITTLE_ICE_PLACE.get(), BRITTLE_ICE_HIT.get(), SoundEvents.EMPTY);
    public static final Supplier<SoundType> ICICLE = ()-> new SoundType(1.0F,1.0F,ICICLE_BREAK.get(), ICICLE_STEP.get(), ICICLE_PLACE.get(), ICICLE_HIT.get(), SoundEvents.EMPTY);
    public static final Supplier<SoundType> ICE_CRYSTAL = ()-> new SoundType(1.0F,1.0F,ICE_CRYSTAL_BREAK.get(), ICE_CRYSTAL_STEP.get(), ICE_CRYSTAL_PLACE.get(), ICE_CRYSTAL_HIT.get(), SoundEvents.EMPTY);
    public static final Supplier<SoundType> PACKED_ICE = ()-> new SoundType(1.0F,1.0F,PACKED_ICE_BREAK.get(), PACKED_ICE_STEP.get(), PACKED_ICE_PLACE.get(), PACKED_ICE_HIT.get(), SoundEvents.EMPTY);




    public static final HolderRegistry<SoundEvent> MUSIC_DISC_FLURRY = registerHolderSoundEvent(Constants.vanilla("music_disc.flurry"));


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return ObjectRegistries.registerSound(Constants.vanilla(name),id-> () -> SoundEvent.createVariableRangeEvent(id));
    }

    private static HolderRegistry<SoundEvent> registerHolderSoundEvent(Identifier id) {
        return ObjectRegistries.registerHolder(BuiltInRegistries.SOUND_EVENT, id, ()-> SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {}

}
