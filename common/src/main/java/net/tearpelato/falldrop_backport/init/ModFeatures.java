package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.worldgen.feature.*;

public class ModFeatures {

    public static final ObjectRegistries<Feature<CrevasseConfiguration>> CREVASSE = ObjectRegistries.registerCustom(BuiltInRegistries.FEATURE, Constants.vanilla("crevasse"),
            ()-> new CrevasseFeature(CrevasseConfiguration.CODEC.codec()));

    public static final ObjectRegistries<Feature<SpeleothemConfiguration>> SPELEOTHEM =
            ObjectRegistries.registerCustom(BuiltInRegistries.FEATURE, Constants.vanilla("speleothem"),
                    () -> new SpeleothemFeature(SpeleothemConfiguration.CODEC));

    public static final ObjectRegistries<Feature<SpeleothemClusterConfiguration>> SPELEOTHEM_CLUSTER =
            ObjectRegistries.registerCustom(BuiltInRegistries.FEATURE, Constants.vanilla("speleothem_cluster"),
                    () -> new SpeleothemClusterFeature(SpeleothemClusterConfiguration.CODEC));

    public static final ObjectRegistries<Feature<LargeSpeleothemConfiguration>> LARGE_SPELEOTHEM =
            ObjectRegistries.registerCustom(BuiltInRegistries.FEATURE, Constants.vanilla("large_speleothem"),
                    () -> new LargeSpeleothemFeature(LargeSpeleothemConfiguration.CODEC));

    public static void init() {}
}
