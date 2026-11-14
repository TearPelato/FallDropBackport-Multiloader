package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.data.BlockFamily;
import net.tearpelato.falldrop_backport.init.ModBlocks;

public class ModBlockFamilies {
    public static final BlockFamily POPLAR_PLANKS = new BlockFamily.Builder(ModBlocks.POPLAR_PLANKS.get())
            .stairs(ModBlocks.POPLAR_STAIRS.get())
            .slab(ModBlocks.POPLAR_SLAB.get())
            .fence(ModBlocks.POPLAR_FENCE.get())
            .fenceGate(ModBlocks.POPLAR_FENCE_GATE.get())
            .pressurePlate(ModBlocks.POPLAR_PRESSURE_PLATE.get())
            .button(ModBlocks.POPLAR_BUTTON.get())
            .sign(ModBlocks.POPLAR_SIGN.get(), ModBlocks.POPLAR_WALL_SIGN.get())
            .door(ModBlocks.POPLAR_DOOR.get())
            .trapdoor(ModBlocks.POPLAR_TRAPDOOR.get())
            .getFamily();

    public static final BlockFamily POLISHED_CALCITE = new BlockFamily.Builder(ModBlocks.POLISHED_CALCITE.get())
            .stairs(ModBlocks.POLISHED_CALCITE_STAIRS.get())
            .slab(ModBlocks.POLISHED_CALCITE_SLAB.get())
            .wall(ModBlocks.POLISHED_CALCITE_WALL.get())
            .getFamily();

    public static final BlockFamily POLISHED_CALCITE_BRICKS = new BlockFamily.Builder(ModBlocks.POLISHED_CALCITE_BRICKS.get())
            .stairs(ModBlocks.POLISHED_CALCITE_BRICK_STAIRS.get())
            .slab(ModBlocks.POLISHED_CALCITE_BRICK_SLAB.get())
            .wall(ModBlocks.POLISHED_CALCITE_BRICK_WALL.get())
            .getFamily();

    public static final BlockFamily SNOW_BRICKS = new BlockFamily.Builder(ModBlocks.SNOW_BRICKS.get())
            .stairs(ModBlocks.SNOW_BRICK_STAIRS.get())
            .slab(ModBlocks.SNOW_BRICK_SLAB.get())
            .wall(ModBlocks.SNOW_BRICK_WALL.get())
            .getFamily();

    public static final BlockFamily PACKED_ICE_BRICKS = new BlockFamily.Builder(ModBlocks.PACKED_ICE_BRICKS.get())
            .stairs(ModBlocks.PACKED_ICE_BRICK_STAIRS.get())
            .slab(ModBlocks.PACKED_ICE_BRICK_SLAB.get())
            .wall(ModBlocks.PACKED_ICE_BRICK_WALL.get())
            .getFamily();



}