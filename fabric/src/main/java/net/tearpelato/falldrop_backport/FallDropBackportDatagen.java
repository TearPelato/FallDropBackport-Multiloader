package net.tearpelato.falldrop_backport;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.tearpelato.craftcorelib.api.datagen.CraftCoreModelGenerator;
import net.tearpelato.falldrop_backport.datagen.*;
import net.tearpelato.falldrop_backport.datagen.villager.CommonVillagerTradesTagsProvider;
import net.tearpelato.falldrop_backport.datagen.villager.CommonWanderingTraderTrades;
import net.tearpelato.falldrop_backport.init.ModBiomes;
import net.tearpelato.falldrop_backport.init.ModJukeboxSongs;
import net.tearpelato.falldrop_backport.init.ModNoises;
import net.tearpelato.falldrop_backport.worldgen.ModConfiguredFeatures;
import net.tearpelato.falldrop_backport.worldgen.ModPlacedFeatures;

public class FallDropBackportDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataGenerator.Pack.Factory<CraftCoreModelGenerator>) output ->
                new CraftCoreModelGenerator(output,Constants.MOD_ID).add(CommonModelProvider::new));
        pack.addProvider(FabricLootProvider::new);
        pack.addProvider(CommonBlockTagsProvider::new);
        pack.addProvider(CommonRecipeProvider.Runner::new);
        pack.addProvider(CommonItemTagsProvider::new);
        pack.addProvider(FabricRegistryDataProvider::new);
        pack.addProvider(FabricSoundProvider::new);
        pack.addProvider(CommonVillagerTradesTagsProvider::new);
        pack.addProvider(CommonBiomeTagsProvider::new);
        pack.addProvider(CommonAdvancementProvider::new);

    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.BIOME, ModBiomes::bootstrap);
        registryBuilder.add(Registries.VILLAGER_TRADE, CommonWanderingTraderTrades::bootstrap);
        registryBuilder.add(Registries.NOISE, ModNoises::bootstrap);
        registryBuilder.add(Registries.JUKEBOX_SONG, ModJukeboxSongs::bootstrap);

    }
}
