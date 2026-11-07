package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.worldgen.placer.decorator.ShelfMushroomDecorator;

public class ModTreeDecoratorType {
    public static final ObjectRegistries<TreeDecoratorType<ShelfMushroomDecorator>> SHELF_MUSHROOM =
            ObjectRegistries.registerTreeDecoratorType(Constants.vanilla("shelf_mushroom_decorator"), () -> new TreeDecoratorType<>(ShelfMushroomDecorator.CODEC));


    public static void init() {}
}
