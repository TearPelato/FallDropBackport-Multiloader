package net.tearpelato.falldrop_backport.init;

import  net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
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


    public static final Supplier<SoundType> SHELF_MUSHROOM = ()-> new SoundType(1.0f, 1.0f,SHELF_MUSHROOM_BREAK.get(), SHELF_MUSHROOM_STEP.get(),SHELF_MUSHROOM_PLACE.get(), SoundEvents.EMPTY, SHELF_MUSHROOM_FALL.get());
    public static final Supplier<SoundType> STRAW_BED = ()-> new SoundType(1.0F,1.0F, STRAW_BED_BREAK.get(), STRAW_BED_STEP.get(), STRAW_BED_PLACE.get(), STRAW_BED_HIT.get(), STRAW_BED_FALL.get());
    public static final Supplier<SoundType> POPLAR_LEAVES = ()-> new SoundType(1.0F,1.0F, POPLAR_LEAVES_BREAK.get(), POPLAR_LEAVES_STEP.get(), POPLAR_LEAVES_PLACE.get(),POPLAR_LEAVES_HIT.get(), POPLAR_LEAVES_FALL.get());
    public static final Supplier<SoundType> RED_SHRUB = ()-> new SoundType(1.0F,1.0F,RED_SHRUB_BREAK.get(), SoundEvents.EMPTY, RED_SHRUB_PLACE.get(), SoundEvents.EMPTY, SoundEvents.EMPTY);

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return ObjectRegistries.registerSound(Constants.vanilla(name),id-> () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {}

}
