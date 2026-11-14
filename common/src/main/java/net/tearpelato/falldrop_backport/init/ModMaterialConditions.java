package net.tearpelato.falldrop_backport.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.noise.SpatialNoiseThresholdConditionSource;

public class ModMaterialConditions {
    public static final ObjectRegistries<MapCodec<? extends SurfaceRules.ConditionSource>> SPATIAL_NOISE_THRESHOLD =
            ObjectRegistries.registerCustom(BuiltInRegistries.MATERIAL_CONDITION,
                    Constants.vanilla("spatial_noise_threshold"),
                    SpatialNoiseThresholdConditionSource.CODEC::codec);

    public static void init() {}
}
