package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CrevasseFeature extends Feature<CrevasseConfiguration> {

    public CrevasseFeature(Codec<CrevasseConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrevasseConfiguration> ctx) {
        CrevasseConfiguration config = ctx.config();
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        RandomSource random = ctx.random();

        int carveDepth = config.carveDepth().sample(random);
        if (origin.getY() <= level.getMinY() + carveDepth) {
            return false;
        }

        int branchLength = config.maxLength() / 2;
        float yaw = random.nextFloat() * ((float) Math.PI * 2F);
        int fillDepth = config.fillDepth().sample(random);
        Long2ObjectOpenHashMap<CarveColumn> columns = new Long2ObjectOpenHashMap<>(50);

        for (int direction = 0; direction < 2; ++direction) {
            appendBranchColumns(config, columns, level, origin, branchLength, carveDepth,
                    yaw + (float) direction * (float) Math.PI, random);
        }

        removeDisconnectedColumns(columns, origin);
        if (columns.size() < config.minFootprint()) {
            return false;
        }

        int fillLevel = getFillLevel(columns, origin.getY(), fillDepth);
        for (CarveColumn column : columns.values().stream().sorted(CarveColumn::compareTo).toList()) {
            carveColumn(config, level, columns, column, fillLevel, random);
        }
        return true;
    }

    private boolean wouldExposeSideLiquid(WorldGenLevel region, BlockPos pos) {
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (!region.getFluidState(pos.relative(dir)).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private Optional<Surface> findCarvableSurface(CrevasseConfiguration config, WorldGenLevel region, BlockPos centerPos, int searchRange) {
        BlockPos pos = centerPos.above(searchRange / 2);
        boolean isBlockAboveEmpty = region.getBlockState(pos.above()).isAir();
        int minY = Math.max(region.getMinY(), pos.getY() - searchRange);
        BlockPos.MutableBlockPos blockPos = pos.mutable();

        while (blockPos.getY() >= minY) {
            BlockState block = region.getBlockState(blockPos);
            if (config.carvableBlocks().test(region, blockPos) && isBlockAboveEmpty) {
                return Optional.of(new Surface(blockPos.immutable(), block));
            }
            isBlockAboveEmpty = block.isAir();
            blockPos.move(Direction.DOWN);
        }
        return Optional.empty();
    }

    private @Nullable CarveColumn findColumn(Long2ObjectOpenHashMap<CarveColumn> columns, int x, int z) {
        return columns.getOrDefault(ChunkPos.pack(x, z), null);
    }

    private int getFillLevel(Long2ObjectOpenHashMap<CarveColumn> columns, int originSurfaceY, int fillDepth) {
        CarveColumn lowestColumn = columns.values().stream()
                .min(Comparator.comparingInt(a -> a.surfacePos.getY())).get();
        return Math.min(originSurfaceY - fillDepth, lowestColumn.surfacePos.getY() - 1);
    }

    private boolean hasSteepNeighbor(Long2ObjectOpenHashMap<CarveColumn> columns, CarveColumn column) {
        for (Direction facing : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = column.surfacePos.relative(facing);
            CarveColumn neighbor = findColumn(columns, neighborPos.getX(), neighborPos.getZ());
            if (neighbor != null && Math.abs(column.surfacePos.getY() - neighbor.surfacePos.getY()) > 1) {
                return true;
            }
        }
        return false;
    }

    private void removeDisconnectedColumns(Long2ObjectOpenHashMap<CarveColumn> columns, BlockPos originSurfacePos) {
        CarveColumn originColumn = findColumn(columns, originSurfacePos.getX(), originSurfacePos.getZ());
        if (originColumn != null && !hasSteepNeighbor(columns, originColumn)) {
            List<CarveColumn> connectedColumns = new ArrayList<>();
            LongSet processedColumns = new LongOpenHashSet();
            connectedColumns.add(originColumn);
            processedColumns.add(ChunkPos.pack(originSurfacePos.getX(), originSurfacePos.getZ()));

            for (int index = 0; index < connectedColumns.size(); ++index) {
                CarveColumn column = connectedColumns.get(index);
                for (Direction facing : Direction.Plane.HORIZONTAL) {
                    BlockPos neighborPos = column.surfacePos().relative(facing);
                    CarveColumn neighbor = findColumn(columns, neighborPos.getX(), neighborPos.getZ());
                    if (neighbor != null) {
                        long neighborIndex = ChunkPos.pack(neighborPos.getX(), neighborPos.getZ());
                        if (!processedColumns.contains(neighborIndex) && !hasSteepNeighbor(columns, neighbor)) {
                            connectedColumns.add(neighbor);
                            processedColumns.add(neighborIndex);
                        }
                    }
                }
            }

            columns.clear();
            for (CarveColumn column : connectedColumns) {
                columns.put(ChunkPos.pack(column.surfacePos.getX(), column.surfacePos.getZ()), column);
            }
        } else {
            columns.clear();
        }
    }

    private void appendBranchColumns(CrevasseConfiguration config, Long2ObjectOpenHashMap<CarveColumn> columns,
                                     WorldGenLevel region, BlockPos originSurfacePos, int branchLength,
                                     int carveDepth, float yaw, RandomSource random) {
        double cursorX = originSurfacePos.getX();
        double cursorZ = originSurfacePos.getZ();
        int previousSurfaceY = originSurfacePos.getY();
        float yawAcceleration = 0.0F;

        for (int step = 0; step < branchLength; ++step) {
            cursorX += Math.cos(yaw);
            cursorZ += Math.sin(yaw);
            float turnDirection = (float) random.nextGaussian();
            float turnMagnitude = random.nextFloat();
            float damped = yawAcceleration * 0.5F;
            yawAcceleration = damped + turnDirection * turnMagnitude * config.twistiness();
            yaw += yawAcceleration * config.turnFactor();
            int blockX = Mth.floor(cursorX);
            int blockZ = Mth.floor(cursorZ);
            Optional<Surface> surface = findCarvableSurface(config, region,
                    new BlockPos(blockX, previousSurfaceY, blockZ), config.cursorSurfaceSearchRange());
            if (surface.isEmpty()) {
                continue;
            }

            float progress = (float) step / (float) branchLength;
            float taper = 1.0F - progress * config.tapering();
            float radius = Math.max((float) config.maxWidth() * 0.5F * taper, 0.5F);
            float radiusSquared = Mth.square(radius);
            int maxDepth = Math.max((int) ((float) carveDepth * taper), 1);
            int expandedRadius = Mth.ceil(radius);

            for (int x = blockX - expandedRadius; x <= blockX + expandedRadius; ++x) {
                for (int z = blockZ - expandedRadius; z <= blockZ + expandedRadius; ++z) {
                    int dx = x - blockX;
                    int dz = z - blockZ;
                    if (Mth.lengthSquared((float) dx, (float) dz) > radiusSquared) {
                        continue;
                    }
                    long columnIndex = ChunkPos.pack(x, z);
                    if (columns.containsKey(columnIndex)) {
                        continue;
                    }
                    Optional<Surface> columnSurface = findCarvableSurface(config, region,
                            new BlockPos(x, surface.get().pos.getY(), z), config.columnSurfaceSearchRange());
                    if (columnSurface.isPresent()) {
                        int depth = 1;
                        BlockPos.MutableBlockPos testPos = columnSurface.get().pos.mutable().move(Direction.DOWN);
                        while (depth < maxDepth && config.carvableBlocks().test(region, testPos)) {
                            testPos.move(Direction.DOWN);
                            ++depth;
                        }
                        columns.put(columnIndex, new CarveColumn(columnSurface.get().pos, columnSurface.get().block, depth - 1));
                    }
                }
            }
            previousSurfaceY = surface.get().pos.getY();
        }
    }

    private void sealExternalSides(CrevasseConfiguration config, WorldGenLevel region,
                                   Long2ObjectOpenHashMap<CarveColumn> columns, CarveColumn column,
                                   BlockPos pos, Block placementBlock) {
        for (Direction facing : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = pos.relative(facing);
            if (!config.acceptableBarrier().test(region, neighborPos)) {
                CarveColumn neighborColumn = findColumn(columns, neighborPos.getX(), neighborPos.getZ());
                if (neighborColumn == null || !neighborColumn.containsY(pos.getY())) {
                    BlockState neighborBlock = region.getBlockState(neighborPos);
                    if (!neighborBlock.is(placementBlock)) {
                        region.setBlock(neighborPos, column.originalSurfaceBlock, 2);
                    }
                }
            }
        }
    }

    private void sealFilledBottom(CrevasseConfiguration config, WorldGenLevel region,
                                  CarveColumn column, BlockPos pos, Block fillBlock) {
        BlockPos belowPos = pos.below();
        if (!config.acceptableBarrier().test(region, belowPos)) {
            BlockState belowBlock = region.getBlockState(belowPos);
            if (!belowBlock.is(fillBlock)) {
                region.setBlock(belowPos, column.originalSurfaceBlock, 2);
            }
        }
    }

    private void carveColumn(CrevasseConfiguration config, WorldGenLevel region,
                             Long2ObjectOpenHashMap<CarveColumn> columns, CarveColumn column,
                             int fillLevel, RandomSource random) {
        BlockState air = Blocks.AIR.defaultBlockState();
        int carveMinY = column.getBottomY();
        boolean carvedAnyBlock = false;
        BlockPos.MutableBlockPos carvePos = column.surfacePos.mutable();

        while (carvePos.getY() >= carveMinY) {
            BlockState fillBlock = config.fillBlock().getOptionalState(region, random, carvePos);
            boolean shouldFill = fillBlock != null && carvePos.getY() <= fillLevel;
            if (!shouldFill && wouldExposeSideLiquid(region, carvePos)) {
                break;
            }

            Block placementBlock = shouldFill ? fillBlock.getBlock() : air.getBlock();
            sealExternalSides(config, region, columns, column, carvePos, placementBlock);
            region.setBlock(carvePos, shouldFill ? fillBlock : air, 2);
            if (shouldFill && carvePos.getY() == carveMinY) {
                sealFilledBottom(config, region, column, carvePos, placementBlock);
            }

            carvedAnyBlock = true;
            carvePos.move(Direction.DOWN);
        }

        if (carvedAnyBlock) {
            BlockState blockState = config.surfaceBlock().getOptionalState(region, random, column.surfacePos);
            if (blockState != null) {
                region.setBlock(column.surfacePos, blockState, 2);
            }
        }
    }

    private record Surface(BlockPos pos, BlockState block) {}

    private record CarveColumn(BlockPos surfacePos, BlockState originalSurfaceBlock, int depth)
            implements Comparable<CarveColumn> {
        public int getBottomY() {
            return surfacePos.getY() - depth;
        }

        public boolean containsY(int y) {
            return y >= getBottomY() && y <= surfacePos.getY();
        }

        @Override
        public int compareTo(CarveColumn other) {
            int xDiff = surfacePos.getX() - other.surfacePos.getX();
            return xDiff == 0 ? surfacePos.getZ() - other.surfacePos.getZ() : xDiff;
        }
    }
}