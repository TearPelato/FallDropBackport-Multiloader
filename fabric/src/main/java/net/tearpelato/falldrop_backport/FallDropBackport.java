package net.tearpelato.falldrop_backport;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.fabric.init.ModFlammableBlocks;
import net.tearpelato.falldrop_backport.fabric.init.ModFuels;
import net.tearpelato.falldrop_backport.fabric.init.ModStrippableBlocks;
import net.tearpelato.falldrop_backport.init.*;
import terrablender.api.TerraBlenderApi;

public class FallDropBackport implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModParticleTypes.init();
        ModTrunkPlacerTypes.init();
        ModFoliagePlacerTypes.init();
        ModEntities.init();
        ModBlockEntities.init();
        ModStats.init();
        ModSounds.init();
        ModMapDecorationTypes.init();
        ModTreeDecoratorType.init();
        ModEntityDataSerializer.init();

        //TODO Investigate how to optimize
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.SOUND_EVENT);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.PARTICLE_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.ENTITY_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.BLOCK);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.BLOCK_ENTITY_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.ITEM);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.CREATIVE_MODE_TAB);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.CUSTOM_STAT);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.TREE_DECORATOR_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.FOLIAGE_PLACER_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.TRUNK_PLACER_TYPE);
        ObjectRegistries.createAll(Constants.NAMESPACE, BuiltInRegistries.MAP_DECORATION_TYPE);

        ModFlammableBlocks.init();
        ModStrippableBlocks.init();
        ModFuels.init();
    }

    @Override
    public void onTerraBlenderInitialized() {

        ModBiomes.registerBiomes();
    }
}
