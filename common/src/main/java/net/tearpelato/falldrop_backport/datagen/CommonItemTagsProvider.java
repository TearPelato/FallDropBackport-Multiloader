package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.tearpelato.falldrop_backport.init.ModBlocks;
import net.tearpelato.falldrop_backport.init.ModItems;
import net.tearpelato.falldrop_backport.init.ModTags;

import java.util.concurrent.CompletableFuture;

public class CommonItemTagsProvider extends IntrinsicHolderTagsProvider<Item> {
    public CommonItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.ITEM,lookupProvider, item-> item.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.POPLAR_LOGS)
                .add(ModBlocks.POPLAR_LOG.get().asItem())
                .add(ModBlocks.POPLAR_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_POPLAR_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_POPLAR_WOOD.get().asItem());
        tag(ItemTags.WOODEN_TOOL_MATERIALS).add(ModBlocks.POPLAR_PLANKS.get().asItem());
        tag(ItemTags.PLANKS).add(ModBlocks.POPLAR_PLANKS.get().asItem());

        tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.POPLAR_BUTTON.get().asItem());
        tag(ItemTags.WOODEN_DOORS).add(ModBlocks.POPLAR_DOOR.get().asItem());
        tag(ItemTags.WOODEN_FENCES).add(ModBlocks.POPLAR_FENCE.get().asItem());
        tag(ItemTags.WOODEN_SLABS).add(ModBlocks.POPLAR_SLAB.get().asItem());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.POPLAR_PRESSURE_PLATE.get().asItem());
        tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.POPLAR_STAIRS.get().asItem());
        tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.POPLAR_TRAPDOOR.get().asItem());
        tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.POPLAR_STAIRS.get().asItem());
        tag(ItemTags.FENCE_GATES).add(ModBlocks.POPLAR_FENCE_GATE.get().asItem());
        tag(ItemTags.SIGNS).add(ModBlocks.POPLAR_SIGN.get().asItem());
        tag(ItemTags.HANGING_SIGNS).add(ModBlocks.POPLAR_HANGING_SIGN.get().asItem());
        tag(ItemTags.BOATS).add(ModItems.POPLAR_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(ModItems.POPLAR_CHEST_BOAT.get());

        tag(ModTags.Items.WOOL_SET)
                .add(ModBlocks.WHITE_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.GRAY_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.BLACK_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.BROWN_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.RED_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.ORANGE_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.YELLOW_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.LIME_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.GREEN_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.CYAN_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.BLUE_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.PURPLE_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.MAGENTA_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.PINK_WOOL_STAIRS.get().asItem())
                .add(ModBlocks.WHITE_WOOL_SLAB.get().asItem())
                .add(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get().asItem())
                .add(ModBlocks.GRAY_WOOL_SLAB.get().asItem())
                .add(ModBlocks.BLACK_WOOL_SLAB.get().asItem())
                .add(ModBlocks.BROWN_WOOL_SLAB.get().asItem())
                .add(ModBlocks.RED_WOOL_SLAB.get().asItem())
                .add(ModBlocks.ORANGE_WOOL_SLAB.get().asItem())
                .add(ModBlocks.YELLOW_WOOL_SLAB.get().asItem())
                .add(ModBlocks.LIME_WOOL_SLAB.get().asItem())
                .add(ModBlocks.GREEN_WOOL_SLAB.get().asItem())
                .add(ModBlocks.CYAN_WOOL_SLAB.get().asItem())
                .add(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get().asItem())
                .add(ModBlocks.BLUE_WOOL_SLAB.get().asItem())
                .add(ModBlocks.PURPLE_WOOL_SLAB.get().asItem())
                .add(ModBlocks.MAGENTA_WOOL_SLAB.get().asItem())
                .add(ModBlocks.PINK_WOOL_SLAB.get().asItem());
    }
}