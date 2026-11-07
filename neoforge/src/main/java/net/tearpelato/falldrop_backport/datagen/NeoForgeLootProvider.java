package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.init.ModBlocks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class NeoForgeLootProvider extends CommonBlockLootableProvider{
    public NeoForgeLootProvider(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (Field field : ModBlocks.class.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())
                    || !ObjectRegistries.class.isAssignableFrom(field.getType())) {
                continue;
            }
            try {
                blocks.add((Block) ((ObjectRegistries<?>) field.get(null)).get());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return blocks;
    }
}
