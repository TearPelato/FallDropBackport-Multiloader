package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.tearpelato.craftcorelib.api.registry.HolderRegistry;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

public class ModMapDecorationTypes {

    public static final HolderRegistry<MapDecorationType> ANCIENT_CITY = register("ancient_city",  "ancient_city", true, MapColor.COLOR_LIGHT_GRAY.col, true, false);
    public static final HolderRegistry<MapDecorationType> ABANDONED_CAMP = register("abandoned_camp", "abandoned_camp",true,0,true, false);
    public static final HolderRegistry<MapDecorationType> DESERT_PYRAMID = register("desert_pyramid", "desert_pyramid", true,0, true,false);
    public static final HolderRegistry<MapDecorationType> MINESHAFT = register("mineshaft", "mineshaft",true,0,true,false);
    public static final HolderRegistry<MapDecorationType> OCEAN_RUIN_WARM = register("ocean_ruin_warm", "warm_ocean_ruins", true,0,true,false);


    public static void init() {}

    private static HolderRegistry<MapDecorationType> register(String name, String assetsName, boolean showOnItemFrame, int mapColor, boolean explorationMapElement, boolean trackCount) {
        return ObjectRegistries.registerHolderMapDecoration(Constants.vanilla(name),
                () -> new MapDecorationType(Constants.vanilla(assetsName), showOnItemFrame, mapColor, explorationMapElement, trackCount));
    }

}
