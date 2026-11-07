package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.worldgen.placer.PoplarFoliagePlacer;

public class ModFoliagePlacerTypes {

    public static final ObjectRegistries<FoliagePlacerType<PoplarFoliagePlacer>> POPLAR_FOLIAGE_PLACER =
           ObjectRegistries.registerFoliagePlacer(Constants.vanilla("poplar_foliage_placer"), () -> new FoliagePlacerType<>(PoplarFoliagePlacer.CODEC));


    public static void init() {}
}
