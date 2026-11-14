package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.init.ModSounds;

public class NeoForgeSoundProvider extends SoundDefinitionsProvider {
    public NeoForgeSoundProvider(PackOutput output) {
        super(output, Constants.NAMESPACE);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.SHELF_MUSHROOM_BOUNCE.get(), definition()
                .subtitle("sounds.minecraft.shelf_mushroom.bounce")
                .with(sound(Constants.vanilla("block/shelf_mushroom/bounce1")),
                        sound(Constants.vanilla("block/shelf_mushroom/bounce2")),
                        sound(Constants.vanilla("block/shelf_mushroom/bounce3")),
                        sound(Constants.vanilla("block/shelf_mushroom/bounce4")),
                        sound(Constants.vanilla("block/shelf_mushroom/bounce5"))));

        add(ModSounds.SHELF_MUSHROOM_FALL.get(), definition().subtitle("sounds.minecraft.shelf_mushroom.bounce")
                .with(sound(Constants.vanilla("block/shelf_mushroom/fall"))));

        add(ModSounds.SHELF_MUSHROOM_BREAK.get(), definition().subtitle("sounds.minecraft.shelf_mushroom.break")
                .with(sound(Constants.vanilla("block/shelf_mushroom/break1")),
                        sound(Constants.vanilla("block/shelf_mushroom/break2")),
                        sound(Constants.vanilla("block/shelf_mushroom/break3")),
                        sound(Constants.vanilla("block/shelf_mushroom/break4")),
                        sound(Constants.vanilla("block/shelf_mushroom/break5")),
                        sound(Constants.vanilla("block/shelf_mushroom/break6"))));

        add(ModSounds.SHELF_MUSHROOM_PLACE.get(), definition().subtitle("sounds.minecraft.shelf_mushroom.place")
                .with(sound(Constants.vanilla("block/shelf_mushroom/place1")),
                        sound(Constants.vanilla("block/shelf_mushroom/place2")),
                        sound(Constants.vanilla("block/shelf_mushroom/place3")),
                        sound(Constants.vanilla("block/shelf_mushroom/place4")),
                        sound(Constants.vanilla("block/shelf_mushroom/place5")),
                        sound(Constants.vanilla("block/shelf_mushroom/place6"))));

        add(ModSounds.SHELF_MUSHROOM_STEP.get(), definition().subtitle("sounds.minecraft.shelf_mushroom.step")
                .with(sound(Constants.vanilla("block/shelf_mushroom/step1")),
                        sound(Constants.vanilla("block/shelf_mushroom/step2")),
                        sound(Constants.vanilla("block/shelf_mushroom/step3")),
                        sound(Constants.vanilla("block/shelf_mushroom/step4")),
                        sound(Constants.vanilla("block/shelf_mushroom/step5")),
                        sound(Constants.vanilla("block/shelf_mushroom/step6"))));

        add(ModSounds.RED_SHRUB_BREAK.get(), definition().subtitle("sounds.minecraft.red_shrub.break")
                .with(sound(Constants.vanilla("block/red_shrub/break1")),
                        sound(Constants.vanilla("block/red_shrub/break2")),
                        sound(Constants.vanilla("block/red_shrub/break3")),
                        sound(Constants.vanilla("block/red_shrub/break4"))));

        add(ModSounds.RED_SHRUB_PLACE.get(), definition().subtitle("sounds.minecraft.red_shrub.place")
                .with(sound(Constants.vanilla("block/red_shrub/place1")),
                        sound(Constants.vanilla("block/red_shrub/place2")),
                        sound(Constants.vanilla("block/red_shrub/place3")),
                        sound(Constants.vanilla("block/red_shrub/place4"))));

        add(ModSounds.STRAW_BED_BREAK.get(), definition().subtitle("sounds.minecraft.straw_bed.break")
                .with(sound(Constants.vanilla("block/straw_bed/break1")),
                        sound(Constants.vanilla("block/straw_bed/break2")),
                        sound(Constants.vanilla("block/straw_bed/break3")),
                        sound(Constants.vanilla("block/straw_bed/break4"))));

        add(ModSounds.STRAW_BED_BREAK_LEAVE.get(), definition().subtitle("sounds.minecraft.straw_bed.leave")
                .with(sound(Constants.vanilla("block/straw_bed/break_leave"))));

        add(ModSounds.STRAW_BED_HIT.get(), definition().subtitle("sounds.minecraft.straw_bed.hit")
                .with(sound(Constants.vanilla("block/straw_bed/hit1")),
                        sound(Constants.vanilla("block/straw_bed/hit2")),
                        sound(Constants.vanilla("block/straw_bed/hit3")),
                        sound(Constants.vanilla("block/straw_bed/hit4")),
                        sound(Constants.vanilla("block/straw_bed/hit5")),
                        sound(Constants.vanilla("block/straw_bed/hit6"))));

        add(ModSounds.STRAW_BED_PLACE.get(), definition().subtitle("sounds.minecraft.straw_bed.place")
                .with(sound(Constants.vanilla("block/straw_bed/place1")),
                        sound(Constants.vanilla("block/straw_bed/place2")),
                        sound(Constants.vanilla("block/straw_bed/place3")),
                        sound(Constants.vanilla("block/straw_bed/place4"))));

        add(ModSounds.STRAW_BED_STEP.get(), definition().subtitle("sounds.minecraft.shelf_mushroom.step")
                .with(sound(Constants.vanilla("block/straw_bed/step1")),
                        sound(Constants.vanilla("block/straw_bed/step2")),
                        sound(Constants.vanilla("block/straw_bed/step3")),
                        sound(Constants.vanilla("block/straw_bed/step4")),
                        sound(Constants.vanilla("block/straw_bed/step5")),
                        sound(Constants.vanilla("block/straw_bed/step6"))));

        add(ModSounds.CUSHION_BREAK.get(), definition().subtitle("sounds.minecraft.cushion.break")
                .with(sound(Constants.vanilla("entity/cushion/break1")),
                        sound(Constants.vanilla("entity/cushion/break2")),
                        sound(Constants.vanilla("entity/cushion/break3"))));

        add(ModSounds.CUSHION_GET_UP.get(), definition().subtitle("sounds.minecraft.cushion.break")
                .with(sound(Constants.vanilla("entity/cushion/get_up1")),
                        sound(Constants.vanilla("entity/cushion/get_up2")),
                        sound(Constants.vanilla("entity/cushion/get_up3"))));

        add(ModSounds.CUSHION_PLACE.get(), definition().subtitle("sounds.minecraft.cushion.break")
                .with(sound(Constants.vanilla("entity/cushion/place1")),
                        sound(Constants.vanilla("entity/cushion/place2")),
                        sound(Constants.vanilla("entity/cushion/place3")),
                        sound(Constants.vanilla("entity/cushion/place4")),
                        sound(Constants.vanilla("entity/cushion/place5")),
                        sound(Constants.vanilla("entity/cushion/place6"))));

        add(ModSounds.CUSHION_SIT.get(), definition().subtitle("sounds.minecraft.cushion.break")
                .with(sound(Constants.vanilla("entity/cushion/sit1")),
                        sound(Constants.vanilla("entity/cushion/sit2")),
                        sound(Constants.vanilla("entity/cushion/sit3"))));

        add(ModSounds.POPLAR_LEAVES_BREAK.get(), definition().subtitle("sounds.block.generic.break")
                .with(sound(Constants.vanilla("block/leaf_litter/break1")),
                        sound(Constants.vanilla("block/leaf_litter/break2")),
                        sound(Constants.vanilla("block/leaf_litter/break3")),
                        sound(Constants.vanilla("block/leaf_litter/break4")),
                        sound(Constants.vanilla("block/leaf_litter/break5"))));

        add(ModSounds.POPLAR_LEAVES_FALL.get(), definition().subtitle("sounds.block.generic.fall")
                .with(sound(Constants.vanilla("block/leaf_litter/step1")),
                        sound(Constants.vanilla("block/leaf_litter/step2")),
                        sound(Constants.vanilla("block/leaf_litter/step3")),
                        sound(Constants.vanilla("block/leaf_litter/step4")),
                        sound(Constants.vanilla("block/leaf_litter/step5")),
                        sound(Constants.vanilla("block/leaf_litter/step6"))));

        add(ModSounds.POPLAR_LEAVES_HIT.get(), definition().subtitle("sounds.block.generic.hit")
                .with(sound(Constants.vanilla("block/leaf_litter/step1")),
                        sound(Constants.vanilla("block/leaf_litter/step2")),
                        sound(Constants.vanilla("block/leaf_litter/step3")),
                        sound(Constants.vanilla("block/leaf_litter/step4")),
                        sound(Constants.vanilla("block/leaf_litter/step5")),
                        sound(Constants.vanilla("block/leaf_litter/step6"))));

        add(ModSounds.POPLAR_LEAVES_PLACE.get(), definition().subtitle("sounds.block.generic.place")
                .with(sound(Constants.vanilla("block/leaf_litter/place1")),
                        sound(Constants.vanilla("block/leaf_litter/place2")),
                        sound(Constants.vanilla("block/leaf_litter/place3")),
                        sound(Constants.vanilla("block/leaf_litter/place4")),
                        sound(Constants.vanilla("block/leaf_litter/place5"))));

        add(ModSounds.POPLAR_LEAVES_STEP.get(), definition().subtitle("sounds.block.generic.footsteps")
                .with(sound(Constants.vanilla("block/leaf_litter/step1")),
                        sound(Constants.vanilla("block/leaf_litter/step2")),
                        sound(Constants.vanilla("block/leaf_litter/step3")),
                        sound(Constants.vanilla("block/leaf_litter/step4")),
                        sound(Constants.vanilla("block/leaf_litter/step5")),
                        sound(Constants.vanilla("block/leaf_litter/step6"))));

        add(ModSounds.ICE_BLOCK_AMBIENT.get(), definition().subtitle("sounds.minecraft.ice.ambient")
                .with(sound(Constants.vanilla("block/ice/ambient1")),
                        sound(Constants.vanilla("block/ice/ambient2")),
                        sound(Constants.vanilla("block/ice/ambient3"))));

        add(ModSounds.FROSTBITE_AMBIENT.get(), definition().subtitle("sounds.minecraft.frostbite.ambient")
                .with(sound(Constants.vanilla("entity/frostbite/ambient1")),
                        sound(Constants.vanilla("entity/frostbite/ambient2")),
                        sound(Constants.vanilla("entity/frostbite/ambient3"))));

        add(ModSounds.FROSTBITE_DEATH.get(), definition().subtitle("sounds.minecraft.frostbite.death")
                .with(sound(Constants.vanilla("entity/frostbite/death"))));

        add(ModSounds.FROSTBITE_HURT.get(), definition().subtitle("sounds.minecraft.frostbite.hurt")
                .with(sound(Constants.vanilla("entity/frostbite/hurt1")),
                        sound(Constants.vanilla("entity/frostbite/hurt2")),
                        sound(Constants.vanilla("entity/frostbite/hurt3"))));

        add(ModSounds.FROSTBITE_STEP.get(), definition().subtitle("sounds.minecraft.frostbite.step")
                .with(sound(Constants.vanilla("entity/frostbite/step1")),
                        sound(Constants.vanilla("entity/frostbite/step2")),
                        sound(Constants.vanilla("entity/frostbite/step3")),
                        sound(Constants.vanilla("entity/frostbite/step4"))));

        add(ModSounds.ICE_BALL_BREAK.get(), definition().subtitle("sounds.minecraft.ice_ball.break")
                .with(sound(Constants.vanilla("entity/ice_ball/break1")),
                        sound(Constants.vanilla("entity/ice_ball/break2")),
                        sound(Constants.vanilla("entity/ice_ball/break3"))));

        add(ModSounds.ICE_BALL_THROW.get(), definition().subtitle("sounds.minecraft.ice_ball.throw")
                .with(sound(Constants.vanilla("entity/ice_ball/throw1")),
                        sound(Constants.vanilla("entity/ice_ball/throw2")),
                        sound(Constants.vanilla("entity/ice_ball/throw3"))));

        add(ModSounds.ZOMBIE_CONVERTED_TO_FROSTBITE.get(), definition().subtitle("sounds.minecraft.zombie.converted_to_frostbite")
                .with(sound(Constants.vanilla("entity/zombie/converted_to_frostbite"))));

        add(ModSounds.FROSTBITE_CONVERTED_TO_ZOMBIE.get(), definition().subtitle("sounds.minecraft.frostbite.converted_to_zombie")
                .with(sound(Constants.vanilla("entity/frostbite/converted_to_zombie"))));

        add(ModSounds.APPLY_EFFECT_FREEZING.get(), definition().subtitle("sounds.minecraft.mob_effect.freezing")
                .with(sound(Constants.vanilla("event/mob_effect/freezing"))));

        add(ModSounds.BRITTLE_ICE_BREAK.get(), definition().subtitle("sounds.block.generic.break")
                .with(sound(Constants.vanilla("block/brittle_ice/break1")),
                        sound(Constants.vanilla("block/brittle_ice/break2")),
                        sound(Constants.vanilla("block/brittle_ice/break3")),
                        sound(Constants.vanilla("block/brittle_ice/break4"))));

        add(ModSounds.BRITTLE_ICE_HIT.get(), definition().subtitle("sounds.block.generic.hit")
                .with(sound(Constants.vanilla("block/brittle_ice/hit1")),
                        sound(Constants.vanilla("block/brittle_ice/hit2")),
                        sound(Constants.vanilla("block/brittle_ice/hit3")),
                        sound(Constants.vanilla("block/brittle_ice/hit4"))));

        add(ModSounds.BRITTLE_ICE_CRACK.get(), definition().subtitle("sounds.minecraft.brittle_ice.crack")
                .with(sound(Constants.vanilla("block/brittle_ice/crack1")),
                        sound(Constants.vanilla("block/brittle_ice/crack2")),
                        sound(Constants.vanilla("block/brittle_ice/crack3"))));

        add(ModSounds.BRITTLE_ICE_PLACE.get(), definition().subtitle("sounds.block.generic.place")
                .with(sound(Constants.vanilla("block/brittle_ice/place1")),
                        sound(Constants.vanilla("block/brittle_ice/place2")),
                        sound(Constants.vanilla("block/brittle_ice/place3")),
                        sound(Constants.vanilla("block/brittle_ice/place4"))));

        add(ModSounds.BRITTLE_ICE_STEP.get(), definition().subtitle("sounds.block.generic.footsteps")
                .with(sound(Constants.vanilla("block/brittle_ice/step1")),
                        sound(Constants.vanilla("block/brittle_ice/step2")),
                        sound(Constants.vanilla("block/brittle_ice/step3")),
                        sound(Constants.vanilla("block/brittle_ice/step4"))));

        add(ModSounds.ICICLE_BREAK.get(), definition().subtitle("sounds.block.generic.break")
                .with(sound(Constants.vanilla("block/icicle/break1")),
                        sound(Constants.vanilla("block/icicle/break2")),
                        sound(Constants.vanilla("block/icicle/break3")),
                        sound(Constants.vanilla("block/icicle/break4"))));

        add(ModSounds.ICICLE_HIT.get(), definition().subtitle("sounds.block.generic.hit")
                .with(sound(Constants.vanilla("block/icicle/hit1")),
                        sound(Constants.vanilla("block/icicle/hit2")),
                        sound(Constants.vanilla("block/icicle/hit3")),
                        sound(Constants.vanilla("block/icicle/hit4"))));

        add(ModSounds.ICICLE_LAND.get(), definition().subtitle("sounds.minecraft.icicle.land")
                .with(sound(Constants.vanilla("block/icicle/land1")),
                        sound(Constants.vanilla("block/icicle/land2")),
                        sound(Constants.vanilla("block/icicle/land3"))));

        add(ModSounds.ICICLE_PLACE.get(), definition().subtitle("sounds.block.generic.place")
                .with(sound(Constants.vanilla("block/icicle/place1")),
                        sound(Constants.vanilla("block/icicle/place2")),
                        sound(Constants.vanilla("block/icicle/place3")),
                        sound(Constants.vanilla("block/icicle/place4"))));

        add(ModSounds.ICICLE_STEP.get(), definition().subtitle("sounds.block.generic.footsteps")
                .with(sound(Constants.vanilla("block/icicle/step1")),
                        sound(Constants.vanilla("block/icicle/step2")),
                        sound(Constants.vanilla("block/icicle/step3")),
                        sound(Constants.vanilla("block/icicle/step4"))));

        add(ModSounds.ICE_CRYSTAL_BREAK.get(), definition().subtitle("sounds.block.generic.break")
                .with(sound(Constants.vanilla("block/ice_crystal/break1")),
                        sound(Constants.vanilla("block/ice_crystal/break2")),
                        sound(Constants.vanilla("block/ice_crystal/break3")),
                        sound(Constants.vanilla("block/ice_crystal/break4"))));

        add(ModSounds.ICE_CRYSTAL_HIT.get(), definition().subtitle("sounds.block.generic.hit")
                .with(sound(Constants.vanilla("block/ice_crystal/hit1")),
                        sound(Constants.vanilla("block/ice_crystal/hit2")),
                        sound(Constants.vanilla("block/ice_crystal/hit3")),
                        sound(Constants.vanilla("block/ice_crystal/hit4"))));

        add(ModSounds.ICE_CRYSTAL_AMBIENT.get(), definition().subtitle("sounds.minecraft.ice_crystal.ambient")
                .with(sound(Constants.vanilla("block/ice_crystal/ambient1")),
                        sound(Constants.vanilla("block/ice_crystal/ambient2")),
                        sound(Constants.vanilla("block/ice_crystal/ambient3"))));

        add(ModSounds.ICE_CRYSTAL_PLACE.get(), definition().subtitle("sounds.block.generic.place")
                .with(sound(Constants.vanilla("block/ice_crystal/place1")),
                        sound(Constants.vanilla("block/ice_crystal/place2")),
                        sound(Constants.vanilla("block/ice_crystal/place3")),
                        sound(Constants.vanilla("block/ice_crystal/place4"))));

        add(ModSounds.ICE_CRYSTAL_STEP.get(), definition().subtitle("sounds.block.generic.footsteps")
                .with(sound(Constants.vanilla("block/ice_crystal/step1")),
                        sound(Constants.vanilla("block/ice_crystal/step2")),
                        sound(Constants.vanilla("block/ice_crystal/step3")),
                        sound(Constants.vanilla("block/ice_crystal/step4"))));

        add(ModSounds.PACKED_ICE_BREAK.get(), definition().subtitle("sounds.block.generic.break")
                .with(sound(Constants.vanilla("block/packed_ice/break1")),
                        sound(Constants.vanilla("block/packed_ice/break2")),
                        sound(Constants.vanilla("block/packed_ice/break3")),
                        sound(Constants.vanilla("block/packed_ice/break4"))));

        add(ModSounds.PACKED_ICE_HIT.get(), definition().subtitle("sounds.block.generic.hit")
                .with(sound(Constants.vanilla("block/packed_ice/hit1")),
                        sound(Constants.vanilla("block/packed_ice/hit2")),
                        sound(Constants.vanilla("block/packed_ice/hit3")),
                        sound(Constants.vanilla("block/packed_ice/hit4"))));

        add(ModSounds.PACKED_ICE_PLACE.get(), definition().subtitle("sounds.block.generic.place")
                .with(sound(Constants.vanilla("block/packed_ice/place1")),
                        sound(Constants.vanilla("block/packed_ice/place2")),
                        sound(Constants.vanilla("block/packed_ice/place3")),
                        sound(Constants.vanilla("block/packed_ice/place4"))));

        add(ModSounds.PACKED_ICE_STEP.get(), definition().subtitle("sounds.block.generic.footsteps")
                .with(sound(Constants.vanilla("block/packed_ice/step1")),
                        sound(Constants.vanilla("block/packed_ice/step2")),
                        sound(Constants.vanilla("block/packed_ice/step3")),
                        sound(Constants.vanilla("block/packed_ice/step4"))));

        add(ModSounds.MUSIC_DISC_FLURRY.get(), definition()
                .with(sound(Constants.vanilla("records/flurry")).stream()));
    }
}