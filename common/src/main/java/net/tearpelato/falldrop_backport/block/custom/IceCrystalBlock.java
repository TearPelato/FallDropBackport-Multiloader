package net.tearpelato.falldrop_backport.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.falldrop_backport.block.custom.core.AbstractCrystalClusterBlock;
import net.tearpelato.falldrop_backport.sound.AmbientIceCrystalBlockSoundsPlayer;

public class IceCrystalBlock extends AbstractCrystalClusterBlock {
    public IceCrystalBlock(final BlockBehaviour.Properties props) {
        super(7.0F, 10.0F, props);
    }

    public void animateTick(final BlockState state, final Level level, final BlockPos pos, final RandomSource random) {
        AmbientIceCrystalBlockSoundsPlayer.playAmbientIceCrystalSounds(level, pos, random);
    }
}