package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Optional;

public class SpeleothemFeature extends Feature<SpeleothemConfiguration> {

    public SpeleothemFeature(Codec<SpeleothemConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SpeleothemConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        SpeleothemConfiguration config = context.config();

        Optional<Direction> tipDirection = getTipDirection(level, origin, random, config);
        if (tipDirection.isEmpty()) {
            return false;
        }

        Direction tip = tipDirection.get();
        BlockPos rootPos = origin.relative(tip.getOpposite());
        createPatchOfBaseBlocks(level, random, rootPos, config);

        int height = random.nextFloat() < config.chanceOfTallerGeneration()
                && SpeleothemUtils.isEmptyOrWater(level.getBlockState(origin.relative(tip))) ? 2 : 1;

        SpeleothemUtils.growSpeleothem(level, origin, tip, height, false,
                config.baseBlock().getBlock(), config.pointedBlock().getBlock(), config.replaceableBlocks());
        return true;
    }

    private Optional<Direction> getTipDirection(WorldGenLevel level, BlockPos pos, RandomSource random, SpeleothemConfiguration config) {
        boolean canPlaceAbove = SpeleothemUtils.isBase(level.getBlockState(pos.above()), config.baseBlock().getBlock(), config.replaceableBlocks());
        boolean canPlaceBelow = SpeleothemUtils.isBase(level.getBlockState(pos.below()), config.baseBlock().getBlock(), config.replaceableBlocks());

        if (canPlaceAbove && canPlaceBelow) {
            return Optional.of(random.nextBoolean() ? Direction.DOWN : Direction.UP);
        } else if (canPlaceAbove) {
            return Optional.of(Direction.DOWN);
        } else if (canPlaceBelow) {
            return Optional.of(Direction.UP);
        }
        return Optional.empty();
    }

    private void createPatchOfBaseBlocks(WorldGenLevel level, RandomSource random, BlockPos pos, SpeleothemConfiguration config) {
        SpeleothemUtils.placeBaseBlockIfPossible(level, pos, config.baseBlock().getBlock(), config.replaceableBlocks());

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (random.nextFloat() > config.chanceOfDirectionalSpread()) continue;

            BlockPos pos1 = pos.relative(direction);
            SpeleothemUtils.placeBaseBlockIfPossible(level, pos1, config.baseBlock().getBlock(), config.replaceableBlocks());

            if (random.nextFloat() > config.chanceOfSpreadRadius2()) continue;
            BlockPos pos2 = pos1.relative(Direction.getRandom(random));
            SpeleothemUtils.placeBaseBlockIfPossible(level, pos2, config.baseBlock().getBlock(), config.replaceableBlocks());

            if (random.nextFloat() > config.chanceOfSpreadRadius3()) continue;
            BlockPos pos3 = pos2.relative(Direction.getRandom(random));
            SpeleothemUtils.placeBaseBlockIfPossible(level, pos3, config.baseBlock().getBlock(), config.replaceableBlocks());
        }
    }
}