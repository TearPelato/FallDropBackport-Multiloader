package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.tearpelato.falldrop_backport.Constants;

public class ModNoises {

    public static final ResourceKey<NormalNoise.NoiseParameters> ICE_CAVE_GRADIENT =
            ResourceKey.create(Registries.NOISE, Constants.vanilla("ice_cave_gradient"));

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        context.register(ICE_CAVE_GRADIENT, new NormalNoise.NoiseParameters(-4, 1.0, 0.0, 1.0));
    }
}