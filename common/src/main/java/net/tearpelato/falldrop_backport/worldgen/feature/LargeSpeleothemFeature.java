package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LargeSpeleothemFeature extends Feature<LargeSpeleothemConfiguration> {

    public LargeSpeleothemFeature(Codec<LargeSpeleothemConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<LargeSpeleothemConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        LargeSpeleothemConfiguration config = context.config();

        if (!SpeleothemUtils.isEmptyOrWater(level, origin)) {
            return false;
        }

        Optional<Column> columnOpt = Column.scan(
                level,
                origin,
                config.floorToCeilingSearchRange(),
                SpeleothemUtils::isEmptyOrWater,
                state -> SpeleothemUtils.isBaseOrLava(state, config.baseBlock().getBlock(), config.replaceableBlocks())
        );

        if (columnOpt.isEmpty()) {
            return false;
        }

        Column column = columnOpt.get();
        if (!(column instanceof Column.Range columnRange)) {
            return false;
        }

        if (columnRange.height() < 4) {
            return false;
        }

        int maxRadiusFromHeight = (int) (columnRange.height() * config.maxColumnRadiusToCaveHeightRatio());
        int maxRadius = Math.clamp(maxRadiusFromHeight, config.columnRadius().minInclusive(), config.columnRadius().maxInclusive());
        int radius = Mth.randomBetweenInclusive(random, config.columnRadius().minInclusive(), maxRadius);

        LargeSpeleothem stalactite = makeSpeleothem(
                config.baseBlock(),
                origin.atY(columnRange.ceiling() - 1),
                false,
                random,
                radius,
                config.stalactiteBluntness(),
                config.heightScale()
        );

        LargeSpeleothem stalagmite = makeSpeleothem(
                config.baseBlock(),
                origin.atY(columnRange.floor() + 1),
                true,
                random,
                radius,
                config.stalagmiteBluntness(),
                config.heightScale()
        );

        WindOffsetter wind;
        if (stalactite.isSuitableForWind(config.minRadiusForWind(), config.minBluntnessForWind())
                && stalagmite.isSuitableForWind(config.minRadiusForWind(), config.minBluntnessForWind())) {
            wind = new WindOffsetter(origin.getY(), random, config.windSpeed(), 16 - radius);
        } else {
            wind = WindOffsetter.noWind();
        }

        boolean stalactiteOk = stalactite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, wind);
        boolean stalagmiteOk = stalagmite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, wind);

        if (stalactiteOk) {
            stalactite.placeBlocks(level, random, wind);
        }
        if (stalagmiteOk) {
            stalagmite.placeBlocks(level, random, wind);
        }

        return true;
    }

    private static LargeSpeleothem makeSpeleothem(
            BlockState baseBlock,
            BlockPos root,
            boolean pointingUp,
            RandomSource random,
            int radius,
            FloatProvider bluntness,
            FloatProvider heightScale
    ) {
        return new LargeSpeleothem(
                baseBlock,
                root,
                pointingUp,
                radius,
                bluntness.sample(random),
                heightScale.sample(random)
        );
    }

    // ===== Inner classes (logica originale preservata) =====

    private static final class LargeSpeleothem {
        private final BlockState baseBlock;
        private BlockPos root;
        private final boolean pointingUp;
        private int radius;
        private final double bluntness;
        private final double scale;

        private LargeSpeleothem(BlockState baseBlock, BlockPos root, boolean pointingUp, int radius, double bluntness, double scale) {
            this.baseBlock = baseBlock;
            this.root = root;
            this.pointingUp = pointingUp;
            this.radius = radius;
            this.bluntness = bluntness;
            this.scale = scale;
        }

        private int getHeight() {
            return getHeightAtRadius(0.0F);
        }

        private boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel level, WindOffsetter wind) {
            while (this.radius > 1) {
                BlockPos.MutableBlockPos newRoot = this.root.mutable();
                int maxTries = Math.min(10, this.getHeight());

                for (int i = 0; i < maxTries; ++i) {
                    if (level.getBlockState(newRoot).is(Blocks.LAVA)) {
                        return false;
                    }
                    if (SpeleothemUtils.isCircleMostlyEmbeddedInStone(level, wind.offset(newRoot), this.radius)) {
                        this.root = newRoot;
                        return true;
                    }
                    newRoot.move(this.pointingUp ? Direction.DOWN : Direction.UP);
                }
                this.radius /= 2;
            }
            return false;
        }

        private int getHeightAtRadius(float checkRadius) {
            return (int) SpeleothemUtils.getSpeleothemHeight(checkRadius, this.radius, this.scale, this.bluntness);
        }

        private void placeBlocks(WorldGenLevel level, RandomSource random, WindOffsetter wind) {
            for (int dx = -this.radius; dx <= this.radius; ++dx) {
                for (int dz = -this.radius; dz <= this.radius; ++dz) {
                    float currentRadius = Mth.sqrt((float) (dx * dx + dz * dz));
                    if (currentRadius > (float) this.radius) continue;

                    int height = this.getHeightAtRadius(currentRadius);
                    if (height <= 0) continue;

                    if (random.nextFloat() < 0.2F) {
                        height = (int) (height * Mth.randomBetween(random, 0.8F, 1.0F));
                    }

                    BlockPos.MutableBlockPos pos = this.root.offset(dx, 0, dz).mutable();
                    boolean hasBeenOutOfStone = false;
                    int maxY = this.pointingUp
                            ? level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ())
                            : Integer.MAX_VALUE;

                    for (int i = 0; i < height && pos.getY() < maxY; ++i) {
                        BlockPos windPos = wind.offset(pos);
                        if (SpeleothemUtils.isEmptyOrWaterOrLava(level, windPos)) {
                            hasBeenOutOfStone = true;
                            level.setBlock(windPos, this.baseBlock, 2);
                        } else if (hasBeenOutOfStone && level.getBlockState(windPos).is(BlockTags.BASE_STONE_OVERWORLD)) {
                            break;
                        }
                        pos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
                    }
                }
            }
        }

        private boolean isSuitableForWind(int minRadiusForWind, float minBluntnessForWind) {
            return this.radius >= minRadiusForWind && this.bluntness >= minBluntnessForWind;
        }
    }

    private static final class WindOffsetter {
        private final int originY;
        private final @Nullable Vec3 windSpeed;
        private final int maxOffset;

        private WindOffsetter(int originY, RandomSource random, FloatProvider windSpeedRange, int maxOffset) {
            this.originY = originY;
            this.maxOffset = maxOffset;
            float speed = windSpeedRange.sample(random);
            float direction = Mth.randomBetween(random, 0.0F, (float) Math.PI);
            this.windSpeed = new Vec3(Mth.cos(direction) * speed, 0.0, Mth.sin(direction) * speed);
        }

        private WindOffsetter() {
            this.originY = 0;
            this.windSpeed = null;
            this.maxOffset = 0;
        }

        static WindOffsetter noWind() {
            return new WindOffsetter();
        }

        BlockPos offset(BlockPos pos) {
            if (this.windSpeed == null) {
                return pos;
            }
            int dy = this.originY - pos.getY();
            Vec3 total = this.windSpeed.scale(dy);
            int dx = Math.clamp(Mth.floor(total.x), -this.maxOffset, this.maxOffset);
            int dz = Math.clamp(Mth.floor(total.z), -this.maxOffset, this.maxOffset);
            return pos.offset(dx, 0, dz);
        }
    }
}