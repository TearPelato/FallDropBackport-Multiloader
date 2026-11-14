package net.tearpelato.falldrop_backport.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.tearpelato.falldrop_backport.block.custom.core.CrackingIceBlock;
import net.tearpelato.falldrop_backport.init.ModSounds;
import net.tearpelato.falldrop_backport.init.ModTags;

public class BrittleIceBlock extends CrackingIceBlock {
    private static final int TICK_DELAY = 24;

    public BrittleIceBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void stepOn(final Level level, final BlockPos pos, final BlockState onState, final Entity entity) {
        if (level instanceof ServerLevel serverLevel) {
            if (this.shouldEntityIncreaseCracking(entity, pos, serverLevel) && !serverLevel.getBlockTicks().hasScheduledTick(pos, this)) {
                if (this.slightlyMelt(onState, serverLevel, pos)) {
                    this.propagateMelting(serverLevel, pos, serverLevel.getRandom());
                }

                serverLevel.scheduleTick(pos, this, this.getTickDelay(serverLevel.getRandom()));
            }
        }

    }

    protected boolean shouldEntityIncreaseCracking(final Entity entity, final BlockPos pos, final ServerLevel level) {
        if (entity instanceof LivingEntity && !entity.is(ModTags.Entity.DOES_NOT_BREAK_BRITTLE_ICE)) {
            if (entity instanceof Player) {
                Player player = (Player)entity;
                return !level.getServer().isUnderSpawnProtection(level, pos, player);
            } else {
                return (Boolean)level.getGameRules().get(GameRules.MOB_GRIEFING);
            }
        } else {
            return false;
        }
    }

    protected int getTickDelay(final RandomSource random) {
        return 24;
    }

    protected void melt(final BlockState state, final Level level, final BlockPos pos) {
        level.destroyBlock(pos, false);
    }

    protected void playCrackingIceParticle(final BlockState state, final Level level, final BlockPos pos) {
        int age = (Integer)state.getValue(AGE);
        if (age == 0) {
            level.levelEvent(2014, pos, getId(state));
        }

    }

    protected SoundEvent getCrackingIceSound() {
        return ModSounds.BRITTLE_ICE_CRACK.get();
    }

    public static BlockState meltsInto() {
        return Blocks.AIR.defaultBlockState();
    }
}
