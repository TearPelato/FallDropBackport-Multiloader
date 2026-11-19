package net.tearpelato.falldrop_backport.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.tearpelato.falldrop_backport.noise.SpatialNoiseThresholdConditionSource;

import java.util.List;

public class ModSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.RuleSource calcite = SurfaceRules.state(Blocks.CALCITE.defaultBlockState());
        SurfaceRules.RuleSource packedIce = SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState());
        SurfaceRules.RuleSource stone = SurfaceRules.state(Blocks.STONE.defaultBlockState());

        SurfaceRules.RuleSource iceCaveBands = SurfaceRules.sequence(
                band(-0.6F, -0.5F, calcite),
                band(-0.5F,  0.2F, packedIce),
                band( 0.2F,  0.3F, calcite),
                band( 0.3F,  0.5F, packedIce),
                band( 0.5F,  0.7F, calcite)
        );

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.ICE_CAVES),
                        SurfaceRules.sequence(
                                bedrock(),
                                iceCaveBands,
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), stone)
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource band(float min, float max, SurfaceRules.RuleSource block) {
        return SurfaceRules.ifTrue(noiseCondition3d(ModNoises.ICE_CAVE_GRADIENT, (double) min, (double) max), block);
    }


    public static SurfaceRules.ConditionSource noiseCondition3d(ResourceKey<NormalNoise.NoiseParameters> noise, double minRange, double maxRange) {
        return new SpatialNoiseThresholdConditionSource(noise, minRange, maxRange);
    }

    private static SurfaceRules.RuleSource bedrock() {
        SurfaceRules.RuleSource bedrock = SurfaceRules.state(Blocks.BEDROCK.defaultBlockState());
        SurfaceRules.ConditionSource bedrockCondition = SurfaceRules.verticalGradient("bedrock", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5));
        return SurfaceRules.ifTrue(bedrockCondition, bedrock);
    }

    public static SurfaceRules.RuleSource merge(SurfaceRules.RuleSource original, List<SurfaceRules.RuleSource> rules) {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        builder.addAll(rules);
        builder.add(original);
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }
}