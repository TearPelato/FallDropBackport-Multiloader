package net.tearpelato.falldrop_backport.block.custom;

import net.minecraft.world.level.block.RotatedPillarBlock;

public class ModFlammablePillars extends RotatedPillarBlock {
    public ModFlammablePillars(Properties properties) {
        super(properties);
    }

   /* @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }*/
}
