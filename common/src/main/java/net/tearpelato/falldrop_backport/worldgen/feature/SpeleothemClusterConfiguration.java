package net.tearpelato.falldrop_backport.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.FloatProviders;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SpeleothemClusterConfiguration(
        BlockState baseBlock,
        BlockState pointedBlock,
        HolderSet<Block> replaceableBlocks,
        int floorToCeilingSearchRange,
        IntProvider height,
        IntProvider radius,
        int maxStalagmiteStalactiteHeightDiff,
        int heightDeviation,
        IntProvider speleothemBlockLayerThickness,
        FloatProvider density,
        FloatProvider wetness,
        float chanceOfSpeleothemAtMaxDistanceFromCenter,
        int maxDistanceFromEdgeAffectingChanceOfSpeleothem,
        int maxDistanceFromCenterAffectingHeightBias,
        PlacementOptions placementOptions
) implements FeatureConfiguration {

    public static final Codec<SpeleothemClusterConfiguration> CODEC = RecordCodecBuilder.create(i -> i.group(
            BlockState.CODEC.fieldOf("base_block").forGetter(SpeleothemClusterConfiguration::baseBlock),
            BlockState.CODEC.fieldOf("pointed_block").forGetter(SpeleothemClusterConfiguration::pointedBlock),
            RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("replaceable_blocks").forGetter(SpeleothemClusterConfiguration::replaceableBlocks),
            Codec.intRange(1, 512).fieldOf("floor_to_ceiling_search_range").forGetter(SpeleothemClusterConfiguration::floorToCeilingSearchRange),
            IntProviders.codec(1, 128).fieldOf("height").forGetter(SpeleothemClusterConfiguration::height),
            IntProviders.codec(1, 128).fieldOf("radius").forGetter(SpeleothemClusterConfiguration::radius),
            Codec.intRange(0, 64).fieldOf("max_stalagmite_stalactite_height_diff").forGetter(SpeleothemClusterConfiguration::maxStalagmiteStalactiteHeightDiff),
            Codec.intRange(1, 64).fieldOf("height_deviation").forGetter(SpeleothemClusterConfiguration::heightDeviation),
            IntProviders.codec(0, 128).fieldOf("speleothem_block_layer_thickness").forGetter(SpeleothemClusterConfiguration::speleothemBlockLayerThickness),
            FloatProviders.codec(0.0F, 2.0F).fieldOf("density").forGetter(SpeleothemClusterConfiguration::density),
            FloatProviders.codec(0.0F, 2.0F).fieldOf("wetness").forGetter(SpeleothemClusterConfiguration::wetness),
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_speleothem_at_max_distance_from_center").forGetter(SpeleothemClusterConfiguration::chanceOfSpeleothemAtMaxDistanceFromCenter),
            Codec.intRange(1, 64).fieldOf("max_distance_from_edge_affecting_chance_of_speleothem").forGetter(SpeleothemClusterConfiguration::maxDistanceFromEdgeAffectingChanceOfSpeleothem),
            Codec.intRange(1, 64).fieldOf("max_distance_from_center_affecting_height_bias").forGetter(SpeleothemClusterConfiguration::maxDistanceFromCenterAffectingHeightBias),
            PlacementOptions.CODEC.optionalFieldOf("placement_options", PlacementOptions.DEFAULT).forGetter(SpeleothemClusterConfiguration::placementOptions)
    ).apply(i, SpeleothemClusterConfiguration::new));

    public SpeleothemClusterConfiguration(
            BlockState baseBlock, BlockState pointedBlock, HolderSet<Block> replaceableBlocks,
            int floorToCeilingSearchRange, IntProvider height, IntProvider radius,
            int maxStalagmiteStalactiteHeightDiff, int heightDeviation,
            IntProvider speleothemBlockLayerThickness, FloatProvider density, FloatProvider wetness,
            float chanceOfSpeleothemAtMaxDistanceFromCenter,
            int maxDistanceFromEdgeAffectingChanceOfSpeleothem,
            int maxDistanceFromCenterAffectingHeightBias) {
        this(baseBlock, pointedBlock, replaceableBlocks, floorToCeilingSearchRange, height, radius,
                maxStalagmiteStalactiteHeightDiff, heightDeviation, speleothemBlockLayerThickness,
                density, wetness, chanceOfSpeleothemAtMaxDistanceFromCenter,
                maxDistanceFromEdgeAffectingChanceOfSpeleothem, maxDistanceFromCenterAffectingHeightBias,
                PlacementOptions.DEFAULT);
    }

    public record PlacementOptions(
            PlacementMode placementMode,
            SpeleothemUtils.BaseBlockTransformer baseBlockTransformer,
            boolean allowWaterPlacement
    ) {
        public static final PlacementOptions DEFAULT = new PlacementOptions(
                PlacementMode.FLOOR_AND_CEILING, SpeleothemUtils.BaseBlockTransformer.NONE, true);

        public static final Codec<PlacementOptions> CODEC = RecordCodecBuilder.create(i -> i.group(
                PlacementMode.CODEC.fieldOf("placement_mode").forGetter(PlacementOptions::placementMode),
                SpeleothemUtils.BaseBlockTransformer.CODEC.fieldOf("base_block_transformer").forGetter(PlacementOptions::baseBlockTransformer),
                Codec.BOOL.fieldOf("allow_water_placement").forGetter(PlacementOptions::allowWaterPlacement)
        ).apply(i, PlacementOptions::new));
    }

    public enum PlacementMode implements net.minecraft.util.StringRepresentable {
        FLOOR_AND_CEILING("floor_and_ceiling"),
        FLOOR_ONLY("floor_only"),
        CEILING_ONLY("ceiling_only");

        public static final Codec<PlacementMode> CODEC = net.minecraft.util.StringRepresentable.fromEnum(PlacementMode::values);
        private final String name;

        PlacementMode(String name) { this.name = name; }
        @Override public String getSerializedName() { return this.name; }
    }
}