package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.particles.SimpleParticleType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

import java.util.function.Supplier;

public class ModParticleTypes {


    private static final SimpleParticleType RED_POPLAR_LEAVES_TYPE = new SimpleParticleType(false);
    private static final SimpleParticleType ORANGE_POPLAR_LEAVES_TYPE = new SimpleParticleType(false);
    private static final SimpleParticleType YELLOW_POPLAR_LEAVES_TYPE = new SimpleParticleType(false);
    private static final SimpleParticleType FREEZING_TYPE = new SimpleParticleType(false);


    public static final Supplier<SimpleParticleType> RED_POPLAR_LEAVES =
            ObjectRegistries.registerParticleType(Constants.vanilla("red_poplar_leaves"), () -> RED_POPLAR_LEAVES_TYPE);

    public static final Supplier<SimpleParticleType> ORANGE_POPLAR_LEAVES =
            ObjectRegistries.registerParticleType(Constants.vanilla("orange_poplar_leaves"), () -> ORANGE_POPLAR_LEAVES_TYPE);

    public static final Supplier<SimpleParticleType> YELLOW_POPLAR_LEAVES =
            ObjectRegistries.registerParticleType(Constants.vanilla("yellow_poplar_leaves"), () -> YELLOW_POPLAR_LEAVES_TYPE);

    public static final Supplier<SimpleParticleType> FREEZING =
            ObjectRegistries.registerParticleType(Constants.vanilla("freezing"),()-> FREEZING_TYPE);

    public static SimpleParticleType redPoplarLeaves() { return RED_POPLAR_LEAVES_TYPE; }
    public static SimpleParticleType orangePoplarLeaves() { return ORANGE_POPLAR_LEAVES_TYPE; }
    public static SimpleParticleType yellowPoplarLeaves() { return YELLOW_POPLAR_LEAVES_TYPE; }
    public static SimpleParticleType freezing() { return FREEZING_TYPE; }

    public static void init() {}
}
