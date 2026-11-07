package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.block.entity.ModHangingSignBlockEntity;
import net.tearpelato.falldrop_backport.block.entity.ModShelfBlockEntity;
import net.tearpelato.falldrop_backport.block.entity.ModSignBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final ObjectRegistries<BlockEntityType<HangingSignBlockEntity>> HANGING_SIGN =
            ObjectRegistries.registerBlockEntity(Constants.vanilla("poplar_hanging_sign"),
                    ModHangingSignBlockEntity::new, ()-> new Block[]{ ModBlocks.POPLAR_HANGING_SIGN.get(), ModBlocks.POPLAR_WALL_HANGING_SIGN.get()});


    public static final Supplier<BlockEntityType<ModSignBlockEntity>> SIGN =
            ObjectRegistries.registerBlockEntity(Constants.vanilla("poplar_sign"),
                    ModSignBlockEntity::new,()-> new Block[]{ModBlocks.POPLAR_SIGN.get(),  ModBlocks.POPLAR_WALL_SIGN.get()});

    public static final Supplier<BlockEntityType<ModShelfBlockEntity>> SHELF =
            ObjectRegistries.registerBlockEntity(Constants.vanilla("poplar_shelf"),
                    ModShelfBlockEntity::new,()-> new Block[]{ ModBlocks.POPLAR_SHELF.get()});

    public static void init() {}
}
