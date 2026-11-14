package net.tearpelato.falldrop_backport.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.init.ModSounds;

import java.util.concurrent.CompletableFuture;

public class FabricSoundProvider extends FabricSoundsProvider {

    public FabricSoundProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        exporter.add(ModSounds.SHELF_MUSHROOM_BOUNCE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.bounce")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/bounce1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/bounce2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/bounce3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/bounce4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/bounce5"))));

        exporter.add(ModSounds.SHELF_MUSHROOM_FALL.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.bounce")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/fall"))));

        exporter.add(ModSounds.SHELF_MUSHROOM_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/break6"))));

        exporter.add(ModSounds.SHELF_MUSHROOM_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/place6"))));

        exporter.add(ModSounds.SHELF_MUSHROOM_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.step")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/shelf_mushroom/step6"))));

        exporter.add(ModSounds.RED_SHRUB_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.red_shrub.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/break4"))));

        exporter.add(ModSounds.RED_SHRUB_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.red_shrub.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/red_shrub/place4"))));

        exporter.add(ModSounds.STRAW_BED_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.straw_bed.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/break4"))));

        exporter.add(ModSounds.STRAW_BED_BREAK_LEAVE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.straw_bed.leave")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/break_leave"))));

        exporter.add(ModSounds.STRAW_BED_HIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.straw_bed.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/hit6"))));

        exporter.add(ModSounds.STRAW_BED_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.straw_bed.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/place4"))));

        exporter.add(ModSounds.STRAW_BED_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.shelf_mushroom.step")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/straw_bed/step6"))));

        exporter.add(ModSounds.CUSHION_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.cushion.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/break3"))));

        exporter.add(ModSounds.CUSHION_GET_UP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.cushion.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/get_up1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/get_up2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/get_up3"))));

        exporter.add(ModSounds.CUSHION_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.cushion.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/place6"))));

        exporter.add(ModSounds.CUSHION_SIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.cushion.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/sit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/sit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/cushion/sit3"))));


        exporter.add(ModSounds.POPLAR_LEAVES_BREAK.get(), SoundTypeBuilder.of().subtitle("sounds.block.generic.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/break4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/break5"))));

        exporter.add(ModSounds.POPLAR_LEAVES_FALL.get(), SoundTypeBuilder.of().subtitle("sounds.block.generic.fall")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step6"))));

        exporter.add(ModSounds.POPLAR_LEAVES_HIT.get(), SoundTypeBuilder.of().subtitle("sounds.block.generic.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step6"))));

        exporter.add(ModSounds.POPLAR_LEAVES_PLACE.get(), SoundTypeBuilder.of().subtitle("sounds.block.generic.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/place4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/place5"))));

        exporter.add(ModSounds.POPLAR_LEAVES_STEP.get(), SoundTypeBuilder.of().subtitle("sounds.block.generic.footsteps")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step4")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step5")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/leaf_litter/step6"))));

        exporter.add(ModSounds.ICE_BLOCK_AMBIENT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.ice.ambient")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice/ambient1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice/ambient2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice/ambient3"))));

        exporter.add(ModSounds.FROSTBITE_AMBIENT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.frostbite.ambient")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/ambient1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/ambient2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/ambient3"))));

        exporter.add(ModSounds.FROSTBITE_DEATH.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.frostbite.death")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/death"))));

        exporter.add(ModSounds.FROSTBITE_HURT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.frostbite.hurt")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/hurt1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/hurt2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/hurt3"))));

        exporter.add(ModSounds.FROSTBITE_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.frostbite.step")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/step4"))));

        exporter.add(ModSounds.ICE_BALL_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.ice_ball.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/break3"))));

        exporter.add(ModSounds.ICE_BALL_THROW.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.ice_ball.throw")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/throw1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/throw2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/ice_ball/throw3"))));

        exporter.add(ModSounds.ZOMBIE_CONVERTED_TO_FROSTBITE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.zombie.converted_to_frostbite")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/zombie/converted_to_frostbite"))));

        exporter.add(ModSounds.FROSTBITE_CONVERTED_TO_ZOMBIE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.frostbite.converted_to_zombie")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("entity/frostbite/converted_to_zombie"))));

        exporter.add(ModSounds.APPLY_EFFECT_FREEZING.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.mob_effect.freezing")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("event/mob_effect/freezing"))));

        exporter.add(ModSounds.BRITTLE_ICE_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/break4"))));

        exporter.add(ModSounds.BRITTLE_ICE_HIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/hit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/hit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/hit3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/hit4"))));

        exporter.add(ModSounds.BRITTLE_ICE_CRACK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.brittle_ice.crack")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/crack1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/crack2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/crack3"))));

        exporter.add(ModSounds.BRITTLE_ICE_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/place4"))));

        exporter.add(ModSounds.BRITTLE_ICE_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.footsteps")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/brittle_ice/step4"))));

        exporter.add(ModSounds.ICICLE_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/break4"))));

        exporter.add(ModSounds.ICICLE_HIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/hit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/hit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/hit3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/hit4"))));

        exporter.add(ModSounds.ICICLE_LAND.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.icicle.land")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/land1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/land2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/land3"))));

        exporter.add(ModSounds.ICICLE_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/place4"))));

        exporter.add(ModSounds.ICICLE_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.footsteps")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/icicle/step4"))));

        exporter.add(ModSounds.ICE_CRYSTAL_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/break4"))));

        exporter.add(ModSounds.ICE_CRYSTAL_HIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/hit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/hit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/hit3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/hit4"))));

        exporter.add(ModSounds.ICE_CRYSTAL_AMBIENT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.minecraft.ice_crystal.ambient")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/ambient1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/ambient2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/ambient3"))));

        exporter.add(ModSounds.ICE_CRYSTAL_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/place4"))));

        exporter.add(ModSounds.ICE_CRYSTAL_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.footsteps")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/ice_crystal/step4"))));

        exporter.add(ModSounds.PACKED_ICE_BREAK.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.break")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/break1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/break2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/break3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/break4"))));

        exporter.add(ModSounds.PACKED_ICE_HIT.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.hit")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/hit1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/hit2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/hit3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/hit4"))));

        exporter.add(ModSounds.PACKED_ICE_PLACE.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.place")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/place1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/place2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/place3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/place4"))));

        exporter.add(ModSounds.PACKED_ICE_STEP.get(), SoundTypeBuilder.of()
                .subtitle("sounds.block.generic.footsteps")
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/step1")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/step2")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/step3")))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("block/packed_ice/step4"))));

        exporter.add(ModSounds.MUSIC_DISC_FLURRY.get(), SoundTypeBuilder.of()
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Constants.vanilla("records/flurry")).stream(true)));
    }

    @Override
    public String getName() {
        return "FallDrop Backport Sounds";
    }

}