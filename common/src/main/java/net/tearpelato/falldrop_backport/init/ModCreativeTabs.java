package net.tearpelato.falldrop_backport.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

public class ModCreativeTabs {

    public static final ObjectRegistries<CreativeModeTab> FALL_DROP_TAB = ObjectRegistries.registerCreativeTab(Constants.vanilla("falldrop_backport"),
            ()->  CreativeModeTab.builder(CreativeModeTab.Row.TOP,1)
                    .title(Component.translatable(Constants.MOD_ID+ ".fall_drop_tab"))
                    .icon(()-> new ItemStack(Blocks.LEAF_LITTER))
                    .displayItems((provider, output)-> {
                        output.accept(ModBlocks.WHITE_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.WHITE_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.WHITE_WOOL_STAIRS.get());
                        output.accept(ModBlocks.WHITE_WOOL_SLAB.get());
                        output.accept(ModItems.WHITE_CUSHION.get());

                        output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get());
                        output.accept(ModItems.LIGHT_GRAY_CUSHION.get());

                        output.accept(ModBlocks.GRAY_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.GRAY_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.GRAY_WOOL_STAIRS.get());
                        output.accept(ModBlocks.GRAY_WOOL_SLAB.get());
                        output.accept(ModItems.GRAY_CUSHION.get());

                        output.accept(ModBlocks.BLACK_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.BLACK_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.BLACK_WOOL_STAIRS.get());
                        output.accept(ModBlocks.BLACK_WOOL_SLAB.get());
                        output.accept(ModItems.BLACK_CUSHION.get());

                        output.accept(ModBlocks.BROWN_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.BROWN_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.BROWN_WOOL_STAIRS.get());
                        output.accept(ModBlocks.BROWN_WOOL_SLAB.get());
                        output.accept(ModItems.BROWN_CUSHION.get());

                        output.accept(ModBlocks.RED_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.RED_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.RED_WOOL_STAIRS.get());
                        output.accept(ModBlocks.RED_WOOL_SLAB.get());
                        output.accept(ModItems.RED_CUSHION.get());

                        output.accept(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.ORANGE_WOOL_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_WOOL_SLAB.get());
                        output.accept(ModItems.ORANGE_CUSHION.get());

                        output.accept(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.YELLOW_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.YELLOW_WOOL_STAIRS.get());
                        output.accept(ModBlocks.YELLOW_WOOL_SLAB.get());
                        output.accept(ModItems.YELLOW_CUSHION.get());

                        output.accept(ModBlocks.LIME_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIME_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.LIME_WOOL_STAIRS.get());
                        output.accept(ModBlocks.LIME_WOOL_SLAB.get());
                        output.accept(ModItems.LIME_CUSHION.get());

                        output.accept(ModBlocks.GREEN_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.GREEN_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.GREEN_WOOL_STAIRS.get());
                        output.accept(ModBlocks.GREEN_WOOL_SLAB.get());
                        output.accept(ModItems.GREEN_CUSHION.get());

                        output.accept(ModBlocks.CYAN_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.CYAN_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.CYAN_WOOL_STAIRS.get());
                        output.accept(ModBlocks.CYAN_WOOL_SLAB.get());
                        output.accept(ModItems.CYAN_CUSHION.get());

                        output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get());
                        output.accept(ModItems.LIGHT_BLUE_CUSHION.get());

                        output.accept(ModBlocks.BLUE_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.BLUE_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.BLUE_WOOL_STAIRS.get());
                        output.accept(ModBlocks.BLUE_WOOL_SLAB.get());
                        output.accept(ModItems.BLUE_CUSHION.get());

                        output.accept(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.PURPLE_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.PURPLE_WOOL_STAIRS.get());
                        output.accept(ModBlocks.PURPLE_WOOL_SLAB.get());
                        output.accept(ModItems.PURPLE_CUSHION.get());

                        output.accept(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.MAGENTA_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.MAGENTA_WOOL_STAIRS.get());
                        output.accept(ModBlocks.MAGENTA_WOOL_SLAB.get());
                        output.accept(ModItems.MAGENTA_CUSHION.get());

                        output.accept(ModBlocks.PINK_CONCRETE_STAIRS.get());
                        output.accept(ModBlocks.PINK_CONCRETE_SLAB.get());
                        output.accept(ModBlocks.PINK_WOOL_STAIRS.get());
                        output.accept(ModBlocks.PINK_WOOL_SLAB.get());
                        output.accept(ModItems.PINK_CUSHION.get());


                        output.accept(ModBlocks.POPLAR_LOG.get());
                        output.accept(ModBlocks.POPLAR_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_POPLAR_LOG.get());
                        output.accept(ModBlocks.STRIPPED_POPLAR_WOOD.get());
                        output.accept(ModBlocks.POPLAR_PLANKS.get());
                        output.accept(ModBlocks.POPLAR_STAIRS.get());
                        output.accept(ModBlocks.POPLAR_SLAB.get());
                        output.accept(ModBlocks.POPLAR_FENCE.get());
                        output.accept(ModBlocks.POPLAR_FENCE_GATE.get());
                        output.accept(ModBlocks.POPLAR_DOOR.get());
                        output.accept(ModBlocks.POPLAR_TRAPDOOR.get());
                        output.accept(ModBlocks.POPLAR_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.POPLAR_BUTTON.get());
                        output.accept(ModItems.POPLAR_SIGN.get());
                        output.accept(ModItems.POPLAR_HANGING_SIGN.get());
                        output.accept(ModItems.POPLAR_BOAT.get());
                        output.accept(ModItems.POPLAR_CHEST_BOAT.get());
                        output.accept(ModBlocks.POPLAR_SHELF.get());
                        output.accept(ModBlocks.RED_POPLAR_LEAVES.get());
                        output.accept(ModBlocks.ORANGE_POPLAR_LEAVES.get());
                        output.accept(ModBlocks.YELLOW_POPLAR_LEAVES.get());
                        output.accept(ModBlocks.RED_SHRUB.get());
                        output.accept(ModBlocks.POPLAR_SAPLING.get());
                        output.accept(ModBlocks.SHELF_MUSHROOM.get());
                        output.accept(ModBlocks.STRAW_BED.get());

                        output.accept(ModItems.FLURRY_MUSIC_DISC.get());
                        output.accept(ModItems.FROSTBITE_SPAWN_EGG.get());

                        output.accept(ModItems.ICE_BALL.get());
                        output.accept(ModBlocks.ICE_CRYSTAL.get());
                        output.accept(ModBlocks.ICICLE.get());
                        output.accept(ModBlocks.BRITTLE_ICE.get());
                        output.accept(ModBlocks.PACKED_ICE_BRICKS.get());
                        output.accept(ModBlocks.PACKED_ICE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.PACKED_ICE_BRICK_SLAB.get());
                        output.accept(ModBlocks.PACKED_ICE_BRICK_WALL.get());
                        output.accept(ModBlocks.CHISELED_PACKED_ICE.get());

                        output.accept(ModBlocks.SNOW_BRICKS.get());
                        output.accept(ModBlocks.SNOW_BRICK_STAIRS.get());
                        output.accept(ModBlocks.SNOW_BRICK_SLAB.get());
                        output.accept(ModBlocks.SNOW_BRICK_WALL.get());

                        output.accept(Blocks.CALCITE);
                        output.accept(ModBlocks.CALCITE_STAIRS.get());
                        output.accept(ModBlocks.CALCITE_SLAB.get());
                        output.accept(ModBlocks.CALCITE_WALL.get());
                        output.accept(ModBlocks.CALCITE_PILLAR.get());

                        output.accept(ModBlocks.POLISHED_CALCITE.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_WALL.get());

                        output.accept(ModBlocks.POLISHED_CALCITE_BRICKS.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_BRICK_SLAB.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_BRICK_WALL.get());

                    }).build()
    );



    public static void init() {}
}