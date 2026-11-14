package net.tearpelato.falldrop_backport.init;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.tearpelato.craftcorelib.api.registry.HolderRegistry;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.mob_effects.FreezingMobEffect;

public class ModMobEffects {

    public static final HolderRegistry<MobEffect> FREEZING = ObjectRegistries.registerModEffect(Constants.vanilla("freezing"),
            ()-> new FreezingMobEffect(MobEffectCategory.HARMFUL, 10415854).withSoundOnAdded(ModSounds.APPLY_EFFECT_FREEZING.get()));


    public static void init() {}
}
