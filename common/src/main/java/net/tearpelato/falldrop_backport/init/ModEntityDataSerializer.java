package net.tearpelato.falldrop_backport.init;

import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.world.item.DyeColor;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

public class ModEntityDataSerializer {

    public static final ObjectRegistries<EntityDataSerializer<DyeColor>> DYE_COLOR =
            ObjectRegistries.registerEntityDataSerializer(Constants.vanilla("dye_color"), ()-> EntityDataSerializer.forValueType(DyeColor.STREAM_CODEC));

    public static void init() {}


}
