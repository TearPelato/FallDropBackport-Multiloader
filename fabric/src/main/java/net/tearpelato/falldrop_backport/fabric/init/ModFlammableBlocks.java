package net.tearpelato.falldrop_backport.fabric.init;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.tearpelato.falldrop_backport.init.ModBlocks;

public class ModFlammableBlocks {
    public static void init() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POPLAR_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POPLAR_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_POPLAR_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_POPLAR_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POPLAR_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_POPLAR_LEAVES.get(), 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORANGE_POPLAR_LEAVES.get(), 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.YELLOW_POPLAR_LEAVES.get(), 30, 60);
    }
}
