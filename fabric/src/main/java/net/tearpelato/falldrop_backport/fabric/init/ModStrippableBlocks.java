package net.tearpelato.falldrop_backport.fabric.init;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.tearpelato.falldrop_backport.init.ModBlocks;

public class ModStrippableBlocks {
    public static void init() {
        StrippableBlockRegistry.register(ModBlocks.POPLAR_LOG.get(), ModBlocks.STRIPPED_POPLAR_LOG.get());
        StrippableBlockRegistry.register(ModBlocks.POPLAR_WOOD.get(), ModBlocks.STRIPPED_POPLAR_WOOD.get());
    }
}
