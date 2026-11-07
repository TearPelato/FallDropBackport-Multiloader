package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.worldgen.placer.PoplarTrunkPlacer;

public class ModTrunkPlacerTypes {
     public static final ObjectRegistries<TrunkPlacerType<PoplarTrunkPlacer>> POPLAR_TRUNK_PLACER =
             ObjectRegistries.registerTrunkPlacer(Constants.vanilla("poplar_trunk_placer"), () -> new TrunkPlacerType<>(PoplarTrunkPlacer.CODEC));


    public static void init() {}
}
