package net.tearpelato.falldrop_backport.mob_effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.tearpelato.falldrop_backport.init.ModParticleTypes;

public class FreezingMobEffect extends MobEffect {
    public static final int TICKS_ADDED = 1;
    public static final float DAMAGE_VALUE = 1.5F;

    public FreezingMobEffect(final MobEffectCategory category, final int color) {
        super(category, color, ModParticleTypes.freezing());
    }

    public boolean applyEffectTick(final ServerLevel serverLevel, final LivingEntity mob, final int amplification) {
        mob.setTicksFrozen(1);
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(final int tickCount, final int amplification) {
        return true;
    }
}
