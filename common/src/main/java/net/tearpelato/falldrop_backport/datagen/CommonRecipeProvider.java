package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.tearpelato.falldrop_backport.init.ModBlocks;
import net.tearpelato.falldrop_backport.init.ModItems;
import net.tearpelato.falldrop_backport.init.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CommonRecipeProvider extends RecipeProvider {
    protected CommonRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    private static final List<Item> DYE_ITEMS = List.of(
            Items.WHITE_DYE, Items.LIGHT_GRAY_DYE, Items.GRAY_DYE, Items.BLACK_DYE,
            Items.BROWN_DYE, Items.RED_DYE, Items.ORANGE_DYE, Items.YELLOW_DYE,
            Items.LIME_DYE, Items.GREEN_DYE, Items.CYAN_DYE, Items.LIGHT_BLUE_DYE,
            Items.BLUE_DYE, Items.PURPLE_DYE, Items.MAGENTA_DYE, Items.PINK_DYE
    );


    @Override
    public void buildRecipes() {

        stairBuilder(ModBlocks.WHITE_WOOL_STAIRS.get(), Ingredient.of(Blocks.WHITE_WOOL))
                .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                .save(output);

        stairBuilder(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get(), Ingredient.of(Blocks.LIGHT_GRAY_WOOL))
                .unlockedBy(getHasName(Blocks.LIGHT_GRAY_WOOL), has(Blocks.LIGHT_GRAY_WOOL))
                .save(output);

        stairBuilder(ModBlocks.GRAY_WOOL_STAIRS.get(), Ingredient.of(Blocks.GRAY_WOOL))
                .unlockedBy(getHasName(Blocks.GRAY_WOOL), has(Blocks.GRAY_WOOL))
                .save(output);

        stairBuilder(ModBlocks.BLACK_WOOL_STAIRS.get(), Ingredient.of(Blocks.BLACK_WOOL))
                .unlockedBy(getHasName(Blocks.BLACK_WOOL), has(Blocks.BLACK_WOOL))
                .save(output);

        stairBuilder(ModBlocks.BROWN_WOOL_STAIRS.get(), Ingredient.of(Blocks.BROWN_WOOL))
                .unlockedBy(getHasName(Blocks.BROWN_WOOL), has(Blocks.BROWN_WOOL))
                .save(output);

        stairBuilder(ModBlocks.RED_WOOL_STAIRS.get(), Ingredient.of(Blocks.RED_WOOL))
                .unlockedBy(getHasName(Blocks.RED_WOOL), has(Blocks.RED_WOOL))
                .save(output);

        stairBuilder(ModBlocks.ORANGE_WOOL_STAIRS.get(), Ingredient.of(Blocks.ORANGE_WOOL))
                .unlockedBy(getHasName(Blocks.ORANGE_WOOL), has(Blocks.ORANGE_WOOL))
                .save(output);

        stairBuilder(ModBlocks.YELLOW_WOOL_STAIRS.get(), Ingredient.of(Blocks.YELLOW_WOOL))
                .unlockedBy(getHasName(Blocks.YELLOW_WOOL), has(Blocks.YELLOW_WOOL))
                .save(output);

        stairBuilder(ModBlocks.LIME_WOOL_STAIRS.get(), Ingredient.of(Blocks.LIME_WOOL))
                .unlockedBy(getHasName(Blocks.LIME_WOOL), has(Blocks.LIME_WOOL))
                .save(output);

        stairBuilder(ModBlocks.GREEN_WOOL_STAIRS.get(), Ingredient.of(Blocks.GREEN_WOOL))
                .unlockedBy(getHasName(Blocks.GREEN_WOOL), has(Blocks.GREEN_WOOL))
                .save(output);

        stairBuilder(ModBlocks.CYAN_WOOL_STAIRS.get(), Ingredient.of(Blocks.CYAN_WOOL))
                .unlockedBy(getHasName(Blocks.CYAN_WOOL), has(Blocks.CYAN_WOOL))
                .save(output);

        stairBuilder(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get(), Ingredient.of(Blocks.LIGHT_BLUE_WOOL))
                .unlockedBy(getHasName(Blocks.LIGHT_BLUE_WOOL), has(Blocks.LIGHT_BLUE_WOOL))
                .save(output);

        stairBuilder(ModBlocks.BLUE_WOOL_STAIRS.get(), Ingredient.of(Blocks.BLUE_WOOL))
                .unlockedBy(getHasName(Blocks.BLUE_WOOL), has(Blocks.BLUE_WOOL))
                .save(output);

        stairBuilder(ModBlocks.PURPLE_WOOL_STAIRS.get(), Ingredient.of(Blocks.PURPLE_WOOL))
                .unlockedBy(getHasName(Blocks.PURPLE_WOOL), has(Blocks.PURPLE_WOOL))
                .save(output);

        stairBuilder(ModBlocks.MAGENTA_WOOL_STAIRS.get(), Ingredient.of(Blocks.MAGENTA_WOOL))
                .unlockedBy(getHasName(Blocks.MAGENTA_WOOL), has(Blocks.MAGENTA_WOOL))
                .save(output);

        stairBuilder(ModBlocks.PINK_WOOL_STAIRS.get(), Ingredient.of(Blocks.PINK_WOOL))
                .unlockedBy(getHasName(Blocks.PINK_WOOL), has(Blocks.PINK_WOOL))
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_WOOL_SLAB.get(), Blocks.WHITE_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_WOOL_SLAB.get(), Blocks.LIGHT_GRAY_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_WOOL_SLAB.get(), Blocks.GRAY_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_WOOL_SLAB.get(), Blocks.BLACK_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_WOOL_SLAB.get(), Blocks.BROWN_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_WOOL_SLAB.get(), Blocks.RED_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_WOOL_SLAB.get(), Blocks.ORANGE_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_WOOL_SLAB.get(), Blocks.YELLOW_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_WOOL_SLAB.get(), Blocks.LIME_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_WOOL_SLAB.get(), Blocks.GREEN_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_WOOL_SLAB.get(), Blocks.CYAN_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_WOOL_SLAB.get(), Blocks.LIGHT_BLUE_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_WOOL_SLAB.get(), Blocks.BLUE_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_WOOL_SLAB.get(), Blocks.PURPLE_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_WOOL_SLAB.get(), Blocks.MAGENTA_WOOL);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_WOOL_SLAB.get(), Blocks.PINK_WOOL);


        stairBuilder(ModBlocks.WHITE_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.WHITE_CONCRETE))
                .unlockedBy(getHasName(Blocks.WHITE_CONCRETE), has(Blocks.WHITE_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.LIGHT_GRAY_CONCRETE))
                .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CONCRETE), has(Blocks.LIGHT_GRAY_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.GRAY_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.GRAY_CONCRETE))
                .unlockedBy(getHasName(Blocks.GRAY_CONCRETE), has(Blocks.GRAY_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.BLACK_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.BLACK_CONCRETE))
                .unlockedBy(getHasName(Blocks.BLACK_CONCRETE), has(Blocks.BLACK_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.BROWN_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.BROWN_CONCRETE))
                .unlockedBy(getHasName(Blocks.BROWN_CONCRETE), has(Blocks.BROWN_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.RED_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.RED_CONCRETE))
                .unlockedBy(getHasName(Blocks.RED_CONCRETE), has(Blocks.RED_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.ORANGE_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.ORANGE_CONCRETE))
                .unlockedBy(getHasName(Blocks.ORANGE_CONCRETE), has(Blocks.ORANGE_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.YELLOW_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.YELLOW_CONCRETE))
                .unlockedBy(getHasName(Blocks.YELLOW_CONCRETE), has(Blocks.YELLOW_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.LIME_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.LIME_CONCRETE))
                .unlockedBy(getHasName(Blocks.LIME_CONCRETE), has(Blocks.LIME_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.GREEN_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.GREEN_CONCRETE))
                .unlockedBy(getHasName(Blocks.GREEN_CONCRETE), has(Blocks.GREEN_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.CYAN_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.CYAN_CONCRETE))
                .unlockedBy(getHasName(Blocks.CYAN_CONCRETE), has(Blocks.CYAN_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.LIGHT_BLUE_CONCRETE))
                .unlockedBy(getHasName(Blocks.LIGHT_BLUE_CONCRETE), has(Blocks.LIGHT_BLUE_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.BLUE_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.BLUE_CONCRETE))
                .unlockedBy(getHasName(Blocks.BLUE_CONCRETE), has(Blocks.BLUE_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.PURPLE_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.PURPLE_CONCRETE))
                .unlockedBy(getHasName(Blocks.PURPLE_CONCRETE), has(Blocks.PURPLE_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.MAGENTA_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.MAGENTA_CONCRETE))
                .unlockedBy(getHasName(Blocks.MAGENTA_CONCRETE), has(Blocks.MAGENTA_CONCRETE))
                .save(output);

        stairBuilder(ModBlocks.PINK_CONCRETE_STAIRS.get(), Ingredient.of(Blocks.PINK_CONCRETE))
                .unlockedBy(getHasName(Blocks.PINK_CONCRETE), has(Blocks.PINK_CONCRETE))
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_SLAB.get(), Blocks.WHITE_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), Blocks.LIGHT_GRAY_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_SLAB.get(), Blocks.GRAY_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_SLAB.get(), Blocks.BLACK_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_SLAB.get(), Blocks.BROWN_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_SLAB.get(), Blocks.RED_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_SLAB.get(), Blocks.ORANGE_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_SLAB.get(), Blocks.YELLOW_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_SLAB.get(), Blocks.LIME_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_SLAB.get(), Blocks.GREEN_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_SLAB.get(), Blocks.CYAN_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), Blocks.LIGHT_BLUE_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_SLAB.get(), Blocks.BLUE_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_SLAB.get(), Blocks.PURPLE_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_SLAB.get(), Blocks.MAGENTA_CONCRETE);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_SLAB.get(), Blocks.PINK_CONCRETE);


        woodFromLogs(ModBlocks.POPLAR_WOOD.get(), ModBlocks.POPLAR_LOG.get());
        planksFromLogs(ModBlocks.POPLAR_PLANKS.get(), ModTags.Items.POPLAR_LOGS, 4);
        doorBuilder(ModBlocks.POPLAR_DOOR.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        trapdoorBuilder(ModBlocks.POPLAR_TRAPDOOR.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        stairBuilder(ModBlocks.POPLAR_STAIRS.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        slab(RecipeCategory.BUILDING_BLOCKS,ModBlocks.POPLAR_SLAB.get(), ModBlocks.POPLAR_PLANKS.get());
        fenceBuilder(ModBlocks.POPLAR_FENCE.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        fenceGateBuilder(ModBlocks.POPLAR_FENCE_GATE.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        pressurePlate(ModBlocks.POPLAR_PRESSURE_PLATE.get(), ModBlocks.POPLAR_PLANKS.get());
        buttonBuilder(ModBlocks.POPLAR_BUTTON.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        signBuilder(ModBlocks.POPLAR_SIGN.get(), Ingredient.of(ModBlocks.POPLAR_PLANKS.get()))
                .unlockedBy(getHasName(ModBlocks.POPLAR_PLANKS.get()), has(ModBlocks.POPLAR_PLANKS.get()))
                .save(output);
        hangingSign(ModBlocks.POPLAR_HANGING_SIGN.get(),ModBlocks.STRIPPED_POPLAR_LOG.get());
        woodenBoat(ModItems.POPLAR_BOAT.get(), ModBlocks.POPLAR_PLANKS.get());
        chestBoat(ModItems.POPLAR_CHEST_BOAT.get(), ModItems.POPLAR_BOAT.get());
        shelf(ModBlocks.POPLAR_SHELF.get(), ModBlocks.STRIPPED_POPLAR_LOG.get());
        woodFromLogs(ModBlocks.STRIPPED_POPLAR_WOOD.get(), ModBlocks.STRIPPED_POPLAR_LOG.get());

        cushionRecipe(ModBlocks.WHITE_WOOL_SLAB.get().asItem(), ModItems.WHITE_CUSHION.get());
        cushionRecipe(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get().asItem(), ModItems.LIGHT_GRAY_CUSHION.get());
        cushionRecipe(ModBlocks.GRAY_WOOL_SLAB.get().asItem(), ModItems.GRAY_CUSHION.get());
        cushionRecipe(ModBlocks.BLACK_WOOL_SLAB.get().asItem(), ModItems.BLACK_CUSHION.get());
        cushionRecipe(ModBlocks.BROWN_WOOL_SLAB.get().asItem(), ModItems.BROWN_CUSHION.get());
        cushionRecipe(ModBlocks.RED_WOOL_SLAB.get().asItem(), ModItems.RED_CUSHION.get());
        cushionRecipe(ModBlocks.ORANGE_WOOL_SLAB.get().asItem(), ModItems.ORANGE_CUSHION.get());
        cushionRecipe(ModBlocks.YELLOW_WOOL_SLAB.get().asItem(), ModItems.YELLOW_CUSHION.get());
        cushionRecipe(ModBlocks.LIME_WOOL_SLAB.get().asItem(), ModItems.LIME_CUSHION.get());
        cushionRecipe(ModBlocks.GREEN_WOOL_SLAB.get().asItem(), ModItems.GREEN_CUSHION.get());
        cushionRecipe(ModBlocks.CYAN_WOOL_SLAB.get().asItem(), ModItems.CYAN_CUSHION.get());
        cushionRecipe(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get().asItem(), ModItems.LIGHT_BLUE_CUSHION.get());
        cushionRecipe(ModBlocks.BLUE_WOOL_SLAB.get().asItem(), ModItems.BLUE_CUSHION.get());
        cushionRecipe(ModBlocks.PURPLE_WOOL_SLAB.get().asItem(), ModItems.PURPLE_CUSHION.get());
        cushionRecipe(ModBlocks.MAGENTA_WOOL_SLAB.get().asItem(), ModItems.MAGENTA_CUSHION.get());
        cushionRecipe(ModBlocks.PINK_WOOL_SLAB.get().asItem(), ModItems.PINK_CUSHION.get());
        shaped(RecipeCategory.MISC,ModBlocks.STRAW_BED.get(),4)
                .pattern("###")
                .define('#', Blocks.HAY_BLOCK)
                .unlockedBy(getHasName(Blocks.HAY_BLOCK), this.has(Blocks.HAY_BLOCK))
                .save(this.output);

        colorItemWithDye(DYE_ITEMS, List.of(
                ModBlocks.WHITE_WOOL_STAIRS.get().asItem(), ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get().asItem(), ModBlocks.GRAY_WOOL_STAIRS.get().asItem(), ModBlocks.BLACK_WOOL_STAIRS.get().asItem(),
                ModBlocks.BROWN_WOOL_STAIRS.get().asItem(), ModBlocks.RED_WOOL_STAIRS.get().asItem(), ModBlocks.ORANGE_WOOL_STAIRS.get().asItem(), ModBlocks.YELLOW_WOOL_STAIRS.get().asItem(),
                ModBlocks.LIME_WOOL_STAIRS.get().asItem(), ModBlocks.GREEN_WOOL_STAIRS.get().asItem(), ModBlocks.CYAN_WOOL_STAIRS.get().asItem(), ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get().asItem(),
                ModBlocks.BLUE_WOOL_STAIRS.get().asItem(), ModBlocks.PURPLE_WOOL_STAIRS.get().asItem(), ModBlocks.MAGENTA_WOOL_STAIRS.get().asItem(), ModBlocks.PINK_WOOL_STAIRS.get().asItem()
        ), "wool_stairs_dye", RecipeCategory.BUILDING_BLOCKS);

        colorItemWithDye(DYE_ITEMS, List.of(
                ModBlocks.WHITE_WOOL_SLAB.get().asItem(), ModBlocks.LIGHT_GRAY_WOOL_SLAB.get().asItem(), ModBlocks.GRAY_WOOL_SLAB.get().asItem(), ModBlocks.BLACK_WOOL_SLAB.get().asItem(),
                ModBlocks.BROWN_WOOL_SLAB.get().asItem(), ModBlocks.RED_WOOL_SLAB.get().asItem(), ModBlocks.ORANGE_WOOL_SLAB.get().asItem(), ModBlocks.YELLOW_WOOL_SLAB.get().asItem(),
                ModBlocks.LIME_WOOL_SLAB.get().asItem(), ModBlocks.GREEN_WOOL_SLAB.get().asItem(), ModBlocks.CYAN_WOOL_SLAB.get().asItem(), ModBlocks.LIGHT_BLUE_WOOL_SLAB.get().asItem(),
                ModBlocks.BLUE_WOOL_SLAB.get().asItem(), ModBlocks.PURPLE_WOOL_SLAB.get().asItem(), ModBlocks.MAGENTA_WOOL_SLAB.get().asItem(), ModBlocks.PINK_WOOL_SLAB.get().asItem()
        ), "WOOL_SLAB.get()_dye", RecipeCategory.BUILDING_BLOCKS);

        colorItemWithDye(DYE_ITEMS, List.of(
                ModItems.WHITE_CUSHION.get(), ModItems.LIGHT_GRAY_CUSHION.get(), ModItems.GRAY_CUSHION.get(), ModItems.BLACK_CUSHION.get(),
                ModItems.BROWN_CUSHION.get(), ModItems.RED_CUSHION.get(), ModItems.ORANGE_CUSHION.get(), ModItems.YELLOW_CUSHION.get(),
                ModItems.LIME_CUSHION.get(), ModItems.GREEN_CUSHION.get(), ModItems.CYAN_CUSHION.get(), ModItems.LIGHT_BLUE_CUSHION.get(),
                ModItems.BLUE_CUSHION.get(), ModItems.PURPLE_CUSHION.get(), ModItems.MAGENTA_CUSHION.get(), ModItems.PINK_CUSHION.get()
        ), "cushion_dye", RecipeCategory.DECORATIONS);

        polished(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.get(), Blocks.CALCITE);
        polished(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS.get(), ModBlocks.POLISHED_CALCITE.get());
        polished(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICKS.get(), Blocks.SNOW_BLOCK);
        polished(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICKS.get(), Blocks.PACKED_ICE);



        stairBuilder(ModBlocks.CALCITE_STAIRS.get(),Ingredient.of(Blocks.CALCITE));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS.get(), Blocks.CALCITE);
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get(), Blocks.CALCITE);

        stairBuilder(ModBlocks.POLISHED_CALCITE_STAIRS.get(),Ingredient.of(ModBlocks.POLISHED_CALCITE.get()));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS.get(), ModBlocks.POLISHED_CALCITE.get());
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get(), ModBlocks.POLISHED_CALCITE.get());

        stairBuilder(ModBlocks.POLISHED_CALCITE_BRICK_STAIRS.get(),Ingredient.of(ModBlocks.POLISHED_CALCITE_BRICKS.get()));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICK_STAIRS.get(), ModBlocks.POLISHED_CALCITE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICK_WALL.get(), ModBlocks.POLISHED_CALCITE_BRICKS.get());

        stairBuilder(ModBlocks.PACKED_ICE_BRICK_STAIRS.get(),Ingredient.of(ModBlocks.PACKED_ICE_BRICKS.get()));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_STAIRS.get(), ModBlocks.PACKED_ICE_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_WALL.get(), ModBlocks.PACKED_ICE_BRICKS.get());

        stairBuilder(ModBlocks.SNOW_BRICK_STAIRS.get(),Ingredient.of(ModBlocks.SNOW_BRICKS.get()));
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_STAIRS.get(), ModBlocks.SNOW_BRICKS.get());
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_WALL.get(), ModBlocks.SNOW_BRICKS.get());

        chiseled(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PACKED_ICE.get(), ModBlocks.PACKED_ICE_BRICK_SLAB.get());

        this.shaped(RecipeCategory.BUILDING_BLOCKS,ModBlocks.CALCITE_PILLAR.get())
                .pattern(" # ")
                .pattern(" # ")
                .define('#', Blocks.CALCITE)
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(output);

        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.get(), Blocks.CALCITE);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS.get(), Blocks.CALCITE);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(), Blocks.CALCITE, 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get(), Blocks.CALCITE);

        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS.get(), ModBlocks.POLISHED_CALCITE.get());
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS.get(), ModBlocks.POLISHED_CALCITE.get());
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB.get(), ModBlocks.POLISHED_CALCITE.get(), 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get(), ModBlocks.POLISHED_CALCITE.get());

        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICK_STAIRS.get(), ModBlocks.POLISHED_CALCITE_BRICKS.get());
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICK_SLAB.get(), ModBlocks.POLISHED_CALCITE_BRICKS.get(), 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICK_WALL.get(), ModBlocks.POLISHED_CALCITE_BRICKS.get());

        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICKS.get(), Blocks.PACKED_ICE);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_STAIRS.get(), ModBlocks.PACKED_ICE_BRICKS.get());
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_SLAB.get(), ModBlocks.PACKED_ICE_BRICKS.get(), 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_WALL.get(), ModBlocks.PACKED_ICE_BRICKS.get());


    }


    protected void cushionRecipe(final Item woolSlab, final Item result) {
        this.shaped(RecipeCategory.DECORATIONS, result, 1).define('#', woolSlab).group("cushion").unlockedBy(getHasName(woolSlab), this.has(woolSlab)).pattern("###").save(this.output);
    }



    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new CommonRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}