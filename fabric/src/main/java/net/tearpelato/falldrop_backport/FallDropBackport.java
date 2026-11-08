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
        ModCreativeTabs.init();
        ModSounds.init();
        ModEntities.init();
        ModItems.init();
        ModBlocks.init();

        ModParticleTypes.init();
        ModTrunkPlacerTypes.init();
        ModFoliagePlacerTypes.init();
        ModEntities.init();
        ModBlockEntities.init();
        ModStats.init();

        ModMapDecorationTypes.init();
        ModTreeDecoratorType.init();
        ModEntityDataSerializer.init();

        ObjectRegistries.createAll(Constants.NAMESPACE);

        ModFlammableBlocks.init();
        ModStrippableBlocks.init();
        ModFuels.init();
    }

    @Override
    public void onTerraBlenderInitialized() {

        ModBiomes.registerBiomes();
    }
}
