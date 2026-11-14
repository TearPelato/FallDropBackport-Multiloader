package net.tearpelato.falldrop_backport.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.tearpelato.falldrop_backport.Constants;

public class ModModelLayerLocations {

    public static final ModelLayerLocation POPLAR_BOAT =
            new ModelLayerLocation(Constants.vanilla("boat/poplar"), "main");
    public static final ModelLayerLocation POPLAR_CHEST_BOAT =
            new ModelLayerLocation(Constants.vanilla("chest_boat/poplar"), "main");
    public static final ModelLayerLocation CUSHION =
            new ModelLayerLocation(Constants.vanilla("cushion"), "main");
    public static final ModelLayerLocation FROSTBITE =
            new ModelLayerLocation(Constants.vanilla("frostbite"), "main");
    public static final ModelLayerLocation FROSTBITE_BABY =
            new ModelLayerLocation(Constants.vanilla("frostbite_baby"), "main");
    public static final ArmorModelSet<ModelLayerLocation> FROSTBITE_ARMOR =
            registerArmorSet("frostbite");
    public static final ArmorModelSet<ModelLayerLocation> FROSTBITE_BABY_ARMOR =
            registerArmorSet("frostbite_baby");
    public static final ModelLayerLocation FROSTBITE_OUTER_LAYER =
            new ModelLayerLocation(Constants.vanilla("frostbite"), "outer");



    private static ArmorModelSet<ModelLayerLocation> registerArmorSet(final String modelId) {
        return new ArmorModelSet(new ModelLayerLocation(Constants.vanilla(modelId), "helmet"), new ModelLayerLocation(Constants.vanilla(modelId), "chestplate"), new ModelLayerLocation(Constants.vanilla(modelId), "leggings"), new ModelLayerLocation(Constants.vanilla(modelId), "boots"));
    }
}
