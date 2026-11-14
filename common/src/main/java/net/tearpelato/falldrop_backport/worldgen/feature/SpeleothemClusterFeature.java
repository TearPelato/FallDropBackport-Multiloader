package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class SpeleothemClusterFeature extends Feature<SpeleothemClusterConfiguration> {

    public SpeleothemClusterFeature(Codec<SpeleothemClusterConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SpeleothemClusterConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        SpeleothemClusterConfiguration config = context.config();

        if (!SpeleothemUtils.isEmptyOrWater(level, origin)) {
            return false;
        }

        int height = config.height().sample(random);
        float wetness = config.wetness().sample(random);
        float density = config.density().sample(random);
        int xRadius = config.radius().sample(random);
        int zRadius = config.radius().sample(random);

        for (int dx = -xRadius; dx <= xRadius; ++dx) {
            for (int dz = -zRadius; dz <= zRadius; ++dz) {
                double chance = getChanceOfStalagmiteOrStalactite(config, xRadius, zRadius, dx, dz);
                BlockPos pos = origin.offset(dx, 0, dz);
                placeColumn(level, random, pos, dx, dz, wetness, chance, height, density, config);
            }
        }
        return true;
    }

    private void placeColumn(WorldGenLevel level, RandomSource random, BlockPos pos, int dx, int dz,
                             float chanceOfWater, double chanceOfStalagmiteOrStalactite,
                             int clusterHeight, float density, SpeleothemClusterConfiguration config) {

        Predicate<BlockState> canPlace = state -> config.placementOptions().allowWaterPlacement()
                ? SpeleothemUtils.isEmptyOrWater(state)
                : state.isAir();

        Optional<Column> baseColumn = Column.scan(level, pos, config.floorToCeilingSearchRange(),
                canPlace, SpeleothemUtils::isNeitherEmptyNorWater);

        if (baseColumn.isEmpty()) return;

        Column scanned = baseColumn.get();
        Column placementColumn = filterPlacementColumn(scanned, config);
        OptionalInt ceiling = placementColumn.getCeiling();
        OptionalInt baseFloor = placementColumn.getFloor();

        if (ceiling.isEmpty() && baseFloor.isEmpty()) return;

        boolean wantPool = random.nextFloat() < chanceOfWater;
        Column column;
        if (wantPool && baseFloor.isPresent() && canPlacePool(level, pos.atY(baseFloor.getAsInt()), config)) {
            int floorY = baseFloor.getAsInt();
            column = placementColumn.withFloor(OptionalInt.of(floorY - 1));
            level.setBlock(pos.atY(floorY), Blocks.WATER.defaultBlockState(), 2);
        } else {
            column = placementColumn;
        }

        OptionalInt floor = column.getFloor();

        int stalactiteHeight = 0;
        if (ceiling.isPresent() && random.nextDouble() < chanceOfStalagmiteOrStalactite && !isLava(level, pos.atY(ceiling.getAsInt()))) {
            int thickness = config.speleothemBlockLayerThickness().sample(random);
            replaceBlocksWithBaseBlocks(level, pos.atY(ceiling.getAsInt()), thickness, Direction.UP, config);
            int maxH = getMaxHeightForThisColumn(scanned, clusterHeight, config);
            if (config.placementOptions().placementMode() == SpeleothemClusterConfiguration.PlacementMode.FLOOR_AND_CEILING && floor.isPresent()) {
                maxH = Math.min(clusterHeight, ceiling.getAsInt() - floor.getAsInt());
            }
            stalactiteHeight = getSpeleothemHeight(random, dx, dz, density, maxH, config);
        }

        int stalagmiteHeight = 0;
        if (floor.isPresent() && random.nextDouble() < chanceOfStalagmiteOrStalactite && !isLava(level, pos.atY(floor.getAsInt()))) {
            int thickness = config.speleothemBlockLayerThickness().sample(random);
            replaceBlocksWithBaseBlocks(level, pos.atY(floor.getAsInt()), thickness, Direction.DOWN, config);
            if (ceiling.isPresent()) {
                stalagmiteHeight = Math.max(0, stalactiteHeight + Mth.randomBetweenInclusive(random,
                        -config.maxStalagmiteStalactiteHeightDiff(), config.maxStalagmiteStalactiteHeightDiff()));
            } else {
                int maxH = getMaxHeightForThisColumn(scanned, clusterHeight, config);
                stalagmiteHeight = getSpeleothemHeight(random, dx, dz, density, maxH, config);
            }
        }

        int actualStalactite = stalactiteHeight;
        int actualStalagmite = stalagmiteHeight;

        if (ceiling.isPresent() && floor.isPresent() && ceiling.getAsInt() - stalactiteHeight <= floor.getAsInt() + stalagmiteHeight) {
            int floorY = floor.getAsInt();
            int ceilingY = ceiling.getAsInt();
            int lowest = Math.max(ceilingY - stalactiteHeight, floorY + 1);
            int highest = Math.min(floorY + stalagmiteHeight, ceilingY - 1);
            int split = Mth.randomBetweenInclusive(random, lowest, highest + 1);
            actualStalactite = ceilingY - split;
            actualStalagmite = (split - 1) - floorY;
        }

        if (ceiling.isPresent()) {
            actualStalactite = getAvailableSpeleothemHeight(level, pos.atY(ceiling.getAsInt() - 1), Direction.DOWN, actualStalactite, canPlace);
        }
        if (floor.isPresent()) {
            actualStalagmite = getAvailableSpeleothemHeight(level, pos.atY(floor.getAsInt() + 1), Direction.UP, actualStalagmite, canPlace);
        }

        boolean mergeTips = random.nextBoolean() && actualStalactite > 0 && actualStalagmite > 0
                && column.getHeight().isPresent()
                && actualStalactite + actualStalagmite == column.getHeight().getAsInt();

        if (ceiling.isPresent()) {
            SpeleothemUtils.growSpeleothem(level, pos.atY(ceiling.getAsInt() - 1), Direction.DOWN, actualStalactite,
                    mergeTips, config.baseBlock().getBlock(), config.pointedBlock().getBlock(),
                    config.replaceableBlocks(), config.placementOptions().baseBlockTransformer());
        }
        if (floor.isPresent()) {
            SpeleothemUtils.growSpeleothem(level, pos.atY(floor.getAsInt() + 1), Direction.UP, actualStalagmite,
                    mergeTips, config.baseBlock().getBlock(), config.pointedBlock().getBlock(),
                    config.replaceableBlocks(), config.placementOptions().baseBlockTransformer());
        }
    }

    private Column filterPlacementColumn(Column scanned, SpeleothemClusterConfiguration config) {
        OptionalInt floor = config.placementOptions().placementMode() != SpeleothemClusterConfiguration.PlacementMode.CEILING_ONLY
                ? scanned.getFloor() : OptionalInt.empty();
        OptionalInt ceiling = config.placementOptions().placementMode() != SpeleothemClusterConfiguration.PlacementMode.FLOOR_ONLY
                ? scanned.getCeiling() : OptionalInt.empty();
        return Column.create(floor, ceiling);
    }

    private int getMaxHeightForThisColumn(Column scanned, int clusterHeight, SpeleothemClusterConfiguration config) {
        if (config.placementOptions().placementMode() != SpeleothemClusterConfiguration.PlacementMode.FLOOR_AND_CEILING
                && scanned.getHeight().isPresent()) {
            return Math.min(clusterHeight, scanned.getHeight().getAsInt());
        }
        return clusterHeight;
    }

    private boolean isLava(WorldGenLevel level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.LAVA);
    }

    private int getSpeleothemHeight(RandomSource random, int dx, int dz, float density, int maxHeight, SpeleothemClusterConfiguration config) {
        if (random.nextFloat() > density) return 0;
        int distance = Math.abs(dx) + Math.abs(dz);
        float mean = (float) Mth.clampedMap(distance, 0, config.maxDistanceFromCenterAffectingHeightBias(), maxHeight / 2.0F, 0.0F);
        return (int) ClampedNormalFloat.sample(random, mean, config.heightDeviation(), 0.0F, maxHeight);
    }

    private boolean canPlacePool(WorldGenLevel level, BlockPos pos, SpeleothemClusterConfiguration config) {
        BlockState state = level.getBlockState(pos);
        if (state.is(Blocks.WATER) || state.is(config.baseBlock().getBlock()) || state.is(config.pointedBlock().getBlock())) {
            return false;
        }
        if (level.getBlockState(pos.above()).getFluidState().is(FluidTags.WATER)) return false;
        for (Direction d : Direction.Plane.HORIZONTAL) {
            if (!canBeAdjacentToWater(level, pos.relative(d))) return false;
        }
        return canBeAdjacentToWater(level, pos.below());
    }

    private boolean canBeAdjacentToWater(LevelAccessor level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return state.is(net.minecraft.tags.BlockTags.BASE_STONE_OVERWORLD) || state.getFluidState().is(FluidTags.WATER);
    }

    private void replaceBlocksWithBaseBlocks(WorldGenLevel level, BlockPos firstPos, int maxCount, Direction direction, SpeleothemClusterConfiguration config) {
        BlockPos.MutableBlockPos pos = firstPos.mutable();
        for (int i = 0; i < maxCount; i++) {
            if (!SpeleothemUtils.placeBaseBlockIfPossible(level, pos, config.baseBlock().getBlock(), config.replaceableBlocks())) {
                return;
            }
            pos.move(direction);
        }
    }

    private double getChanceOfStalagmiteOrStalactite(SpeleothemClusterConfiguration config, int xRadius, int zRadius, int dx, int dz) {
        int xDist = xRadius - Math.abs(dx);
        int zDist = zRadius - Math.abs(dz);
        int distFromEdge = Math.min(xDist, zDist);
        return Mth.clampedMap(distFromEdge, 0.0F, (float) config.maxDistanceFromEdgeAffectingChanceOfSpeleothem(),
                config.chanceOfSpeleothemAtMaxDistanceFromCenter(), 1.0F);
    }

    private int getAvailableSpeleothemHeight(WorldGenLevel level, BlockPos basePos, Direction direction, int desired, Predicate<BlockState> canPlace) {
        BlockPos pos = basePos;
        int available = 0;
        while (available < desired && canPlace.test(level.getBlockState(pos))) {
            available++;
            pos = pos.relative(direction);
        }
        return available;
    }
}