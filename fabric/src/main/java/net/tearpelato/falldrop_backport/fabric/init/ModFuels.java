package net.tearpelato.falldrop_backport.fabric.init;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.tearpelato.falldrop_backport.init.ModTags;

public class ModFuels {
    public static void init() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModTags.Items.WOOL_SET, 100);
        });
    }
}
