package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.MapDecorations;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.item.CushionItem;

public class ModItems {

    public static final ObjectRegistries<Item> POPLAR_SIGN = ObjectRegistries.registerBlockItem(Constants.vanilla("poplar_sign"), ModBlocks.POPLAR_SIGN,
            (block,properties) -> new SignItem(ModBlocks.POPLAR_SIGN.get(), ModBlocks.POPLAR_WALL_SIGN.get(), properties.stacksTo(16)));

    public static final ObjectRegistries<Item> POPLAR_HANGING_SIGN = ObjectRegistries.registerBlockItem(Constants.vanilla("poplar_hanging_sign"), ModBlocks.POPLAR_HANGING_SIGN,
           (block,properties) -> new HangingSignItem(ModBlocks.POPLAR_HANGING_SIGN.get(), ModBlocks.POPLAR_WALL_HANGING_SIGN.get(), properties.stacksTo(16)));

    public static final ObjectRegistries<Item> POPLAR_BOAT = ObjectRegistries.registerItem(Constants.vanilla("poplar_boat"),
            properties -> new BoatItem(ModEntities.POPLAR_BOAT.get(), properties.stacksTo(1)), Item.Properties::new);

    public static final ObjectRegistries<Item> POPLAR_CHEST_BOAT = ObjectRegistries.registerItem(Constants.vanilla("poplar_chest_boat"),
            properties -> new BoatItem(ModEntities.POPLAR_CHEST_BOAT.get(), properties.stacksTo(1)), Item.Properties::new);

    public static final ObjectRegistries<Item> WHITE_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("white_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.WHITE), Item.Properties::new);
    public static final ObjectRegistries<Item> LIGHT_GRAY_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("light_gray_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.LIGHT_GRAY), Item.Properties::new);
    public static final ObjectRegistries<Item> GRAY_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("gray_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.GRAY), Item.Properties::new);
    public static final ObjectRegistries<Item> BLACK_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("black_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.BLACK), Item.Properties::new);
    public static final ObjectRegistries<Item> BROWN_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("brown_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.BROWN), Item.Properties::new);
    public static final ObjectRegistries<Item> RED_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("red_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.RED), Item.Properties::new);
    public static final ObjectRegistries<Item> ORANGE_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("orange_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.ORANGE), Item.Properties::new);
    public static final ObjectRegistries<Item> YELLOW_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("yellow_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.YELLOW), Item.Properties::new);
    public static final ObjectRegistries<Item> LIME_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("lime_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.LIME), Item.Properties::new);
    public static final ObjectRegistries<Item> GREEN_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("green_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.GREEN), Item.Properties::new);
    public static final ObjectRegistries<Item> CYAN_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("cyan_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.CYAN), Item.Properties::new);
    public static final ObjectRegistries<Item> LIGHT_BLUE_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("light_blue_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.LIGHT_BLUE), Item.Properties::new);
    public static final ObjectRegistries<Item> BLUE_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("blue_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.BLUE), Item.Properties::new);
    public static final ObjectRegistries<Item> PURPLE_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("purple_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.PURPLE), Item.Properties::new);
    public static final ObjectRegistries<Item> MAGENTA_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("magenta_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.MAGENTA), Item.Properties::new);
    public static final ObjectRegistries<Item> PINK_CUSHION = ObjectRegistries.registerItem(Constants.vanilla("pink_cushion"),
            properties -> new CushionItem(properties.stacksTo(16), DyeColor.PINK), Item.Properties::new);

    public static final ObjectRegistries<Item> STRAW_BED = ObjectRegistries.registerBlockItem(Constants.vanilla("straw_bed"), ModBlocks.STRAW_BED,
            (block, properties) -> new BlockItem(block,properties.stacksTo(16)));

    public static final ObjectRegistries<MapItem> OCEAN_MONUMENT_MAP = ObjectRegistries.registerItem(Constants.vanilla("ocean_monument_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> WOODLAND_MANSION_MAP = ObjectRegistries.registerItem(Constants.vanilla("woodland_mansion_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> BURIED_TRIAL_MAP = ObjectRegistries.registerItem(Constants.vanilla("buried_trial_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> JUNGLE_PYRAMID_MAP = ObjectRegistries.registerItem(Constants.vanilla("jungle_pyramid_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> SWAMP_HUT_MAP = ObjectRegistries.registerItem(Constants.vanilla("swamp_hut_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> DESERT_VILLAGE_MAP = ObjectRegistries.registerItem(Constants.vanilla("desert_village_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> PLAINS_VILLAGE_MAP = ObjectRegistries.registerItem(Constants.vanilla("plains_village_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> SAVANNA_VILLAGE_MAP = ObjectRegistries.registerItem(Constants.vanilla("savanna_village_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> SNOWY_VILLAGE_MAP = ObjectRegistries.registerItem(Constants.vanilla("snowy_village_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> TAIGA_VILLAGE_MAP = ObjectRegistries.registerItem(Constants.vanilla("taiga_village_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> BURIED_TREASURE_MAP = ObjectRegistries.registerItem(Constants.vanilla("buried_treasure_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> BURIED_ANCIENT_CITY_MAP = ObjectRegistries.registerItem(Constants.vanilla("buried_ancient_city_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> BURIED_MINESHAFT_MAP = ObjectRegistries.registerItem(Constants.vanilla("buried_mineshaft_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> DESERT_PYRAMID_MAP = ObjectRegistries.registerItem(Constants.vanilla("desert_pyramid_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> ABANDONED_CAMP_MAP = ObjectRegistries.registerItem(Constants.vanilla("abandoned_camp_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);
    public static final ObjectRegistries<MapItem> WARM_OCEAN_RUINS_MAP = ObjectRegistries.registerItem(Constants.vanilla("warm_ocena_ruins_map"),
            properties -> new MapItem(properties.component(DataComponents.MAP_DECORATIONS, MapDecorations.EMPTY)), Item.Properties::new);




    public static Item getCushion(DyeColor color) {
        return switch (color) {
            case WHITE -> WHITE_CUSHION.get();
            case LIGHT_GRAY -> LIGHT_GRAY_CUSHION.get();
            case GRAY -> GRAY_CUSHION.get();
            case BLACK -> BLACK_CUSHION.get();
            case BROWN -> BROWN_CUSHION.get();
            case RED -> RED_CUSHION.get();
            case ORANGE -> ORANGE_CUSHION.get();
            case YELLOW -> YELLOW_CUSHION.get();
            case LIME -> LIME_CUSHION.get();
            case GREEN -> GREEN_CUSHION.get();
            case CYAN -> CYAN_CUSHION.get();
            case LIGHT_BLUE -> LIGHT_BLUE_CUSHION.get();
            case BLUE -> BLUE_CUSHION.get();
            case PURPLE -> PURPLE_CUSHION.get();
            case MAGENTA -> MAGENTA_CUSHION.get();
            case PINK -> PINK_CUSHION.get();
        };
    }




    public static void init() {}

}