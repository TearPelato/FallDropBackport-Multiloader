package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.tearpelato.falldrop_backport.block.custom.core.porperties.ModBlockStateProperties;
import net.tearpelato.falldrop_backport.block.custom.core.porperties.SpeleothemThickness;

public final class SpeleothemUtils {

    private SpeleothemUtils() {}

    public static boolean isEmptyOrWater(BlockState state) {
        return state.isAir() || state.getFluidState().is(FluidTags.WATER);
    }

    public static boolean isEmptyOrWater(LevelAccessor level, BlockPos pos) {
        return isEmptyOrWater(level.getBlockState(pos));
    }

    public static boolean isNeitherEmptyNorWater(BlockState state) {
        return !isEmptyOrWater(state);
    }

    public static boolean isBase(BlockState state, Block baseBlock, HolderSet<Block> replaceable) {
        return state.is(baseBlock) || replaceable.contains(state.getBlock().builtInRegistryHolder());
    }

    public static boolean placeBaseBlockIfPossible(LevelAccessor level, BlockPos pos, Block baseBlock, HolderSet<Block> replaceable) {
        BlockState current = level.getBlockState(pos);
        if (replaceable.contains(current.getBlock().builtInRegistryHolder()) || current.isAir()) {
            level.setBlock(pos, baseBlock.defaultBlockState(), 2);
            return true;
        }
        return false;
    }

    public static void growSpeleothem(LevelAccessor level, BlockPos start, Direction tipDirection, int height,
                                      boolean mergedTip, Block baseBlock, Block pointedBlock,
                                      HolderSet<Block> replaceable) {
        growSpeleothem(level, start, tipDirection, height, mergedTip, baseBlock, pointedBlock, replaceable, BaseBlockTransformer.NONE);
    }

    public static void growSpeleothem(LevelAccessor level, BlockPos start, Direction tipDirection, int height,
                                      boolean mergedTip, Block baseBlock, Block pointedBlock,
                                      HolderSet<Block> replaceable, BaseBlockTransformer transformer) {
        if (height <= 0) return;

        BlockPos.MutableBlockPos pos = start.mutable();
        placeBaseBlockIfPossible(level, pos.relative(tipDirection.getOpposite()), baseBlock, replaceable);

        for (int i = 0; i < height; i++) {
            BlockState pointed = createPointedState(pointedBlock, tipDirection, i, height, mergedTip);
            if (pointed == null) {
                pointed = pointedBlock.defaultBlockState();
            }
            if (isEmptyOrWater(level.getBlockState(pos))) {
                level.setBlock(pos, pointed, 2);
            }
            pos.move(tipDirection);
        }
    }

    private static BlockState createPointedState(Block pointedBlock, Direction tip, int indexFromTip, int totalHeight, boolean merged) {
        BlockState state = pointedBlock.defaultBlockState();
        if (state.hasProperty(ModBlockStateProperties.SPELEOTHEM_THICKNESS)) {
            SpeleothemThickness thickness;

            if (totalHeight == 1) {
                thickness = merged ? SpeleothemThickness.TIP_MERGE : SpeleothemThickness.TIP;
            } else if (indexFromTip == 0) {
                thickness = merged ? SpeleothemThickness.TIP_MERGE : SpeleothemThickness.TIP;
            } else if (indexFromTip == 1) {
                thickness = SpeleothemThickness.FRUSTUM;
            } else if (indexFromTip == totalHeight - 1) {
                thickness = SpeleothemThickness.BASE;
            } else {
                thickness = SpeleothemThickness.MIDDLE;
            }

            state = state.setValue(ModBlockStateProperties.SPELEOTHEM_THICKNESS, thickness);

            if (state.hasProperty(BlockStateProperties.VERTICAL_DIRECTION)) {
                state = state.setValue(BlockStateProperties.VERTICAL_DIRECTION, tip);
            }

            if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, false);
            }

            return state;
        }

        if (state.hasProperty(BlockStateProperties.DRIPSTONE_THICKNESS)) {
            DripstoneThickness thickness;

            if (totalHeight == 1) {
                thickness = merged ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP;
            } else if (indexFromTip == 0) {
                thickness = merged ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP;
            } else if (indexFromTip == 1) {
                thickness = DripstoneThickness.FRUSTUM;
            } else if (indexFromTip == totalHeight - 1) {
                thickness = DripstoneThickness.BASE;
            } else {
                thickness = DripstoneThickness.MIDDLE;
            }

            return state
                    .setValue(BlockStateProperties.VERTICAL_DIRECTION, tip)
                    .setValue(BlockStateProperties.DRIPSTONE_THICKNESS, thickness)
                    .setValue(BlockStateProperties.WATERLOGGED, false);
        }

        return state;
    }

    public static boolean isBaseOrLava(BlockState state, Block baseBlock, HolderSet<Block> replaceable) {
        return isBase(state, baseBlock, replaceable) || state.is(Blocks.LAVA);
    }

    public static boolean isEmptyOrWaterOrLava(LevelAccessor level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return isEmptyOrWater(state) || state.is(Blocks.LAVA);
    }

    public static boolean isCircleMostlyEmbeddedInStone(WorldGenLevel level, BlockPos center, int radius) {
        if (radius <= 0) return false;

        int[][] offsets = {
                {0, 0},
                {radius, 0}, {-radius, 0},
                {0, radius}, {0, -radius},
                {radius, radius}, {radius, -radius},
                {-radius, radius}, {-radius, -radius}
        };

        int embedded = 0;
        for (int[] o : offsets) {
            BlockState state = level.getBlockState(center.offset(o[0], 0, o[1]));
            if (state.is(BlockTags.BASE_STONE_OVERWORLD)
                    || state.is(Blocks.PACKED_ICE)
                    || state.is(Blocks.ICE)
                    || state.is(Blocks.BLUE_ICE)
                    || state.is(Blocks.CALCITE)
                    || state.is(Blocks.SNOW_BLOCK)) {
                embedded++;
            }
        }

        return embedded >= 6;
    }

    public static double getSpeleothemHeight(double xzDistanceFromCenter, double radius, double scale, double bluntness) {
        double normalized = xzDistanceFromCenter / radius;
        return scale * (1.0 - Math.pow(normalized, bluntness));
    }




    public enum BaseBlockTransformer implements net.minecraft.util.StringRepresentable {
        NONE("none");

        public static final Codec<BaseBlockTransformer> CODEC = net.minecraft.util.StringRepresentable.fromEnum(BaseBlockTransformer::values);
        private final String name;
        BaseBlockTransformer(String name) { this.name = name; }
        @Override public String getSerializedName() { return name; }
    }
}