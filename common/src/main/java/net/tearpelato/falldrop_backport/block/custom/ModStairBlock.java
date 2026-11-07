package net.tearpelato.falldrop_backport.block.custom;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * This class exist only to create a custom Stair:
 * {@link StairBlock} constructor is protected
 * */
public class ModStairBlock extends StairBlock {
    public ModStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }
}
