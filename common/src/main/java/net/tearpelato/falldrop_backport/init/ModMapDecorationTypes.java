package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

import java.util.function.Supplier;

public class ModMapDecorationTypes {

    public static final Supplier<Holder<MapDecorationType>> ANCIENT_CITY = register("ancient_city",  "ancient_city", true, MapColor.COLOR_LIGHT_GRAY.col, true, false);
    public static final Supplier<Holder<MapDecorationType>> ABANDONED_CAMP = register("abandoned_camp", "abandoned_camp",true,0,true, false);
    public static final Supplier<Holder<MapDecorationType>> DESERT_PYRAMID = register("desert_pyramid", "desert_pyramid", true,0, true,false);
    public static final Supplier<Holder<MapDecorationType>> MINESHAFT = register("mineshaft", "mineshaft",true,0,true,false);
    public static final Supplier<Holder<MapDecorationType>> OCEAN_RUIN_WARM = register("ocean_ruin_warm", "warm_ocean_ruins", true,0,true,false);


    public static void init() {}

    private static Supplier<Holder<MapDecorationType>> register(String name, String assetsName, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        ObjectRegistries<MapDecorationType> entry = ObjectRegistries.registerHolderMapDecoration(Constants.vanilla(name),
                () -> new MapDecorationType(Constants.vanilla(assetsName), showOnItemFrame, mapColor, explorationMapElement, trackCount));
        return () -> BuiltInRegistries.MAP_DECORATION_TYPE.wrapAsHolder(entry.get());
    }

}
