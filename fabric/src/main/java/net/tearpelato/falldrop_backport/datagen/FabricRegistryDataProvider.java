package net.tearpelato.falldrop_backport.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.tearpelato.falldrop_backport.datagen.villager.CommonWanderingTraderTrades;
import net.tearpelato.falldrop_backport.init.ModBiomes;
import net.tearpelato.falldrop_backport.init.ModJukeboxSongs;
import net.tearpelato.falldrop_backport.init.ModNoises;
import net.tearpelato.falldrop_backport.worldgen.ModConfiguredFeatures;
import net.tearpelato.falldrop_backport.worldgen.ModPlacedFeatures;

import java.util.concurrent.CompletableFuture;

public class FabricRegistryDataProvider extends FabricDynamicRegistryProvider {

    public FabricRegistryDataProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.JUKEBOX_SONG));

        HolderLookup.RegistryLookup<ConfiguredFeature<?,?>> configuredFeatures =
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE);
        entries.add(ModConfiguredFeatures.FALLEN_POPLAR,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_POPLAR).value());
        entries.add(ModConfiguredFeatures.POPLAR_ORANGE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.POPLAR_ORANGE).value());
        entries.add(ModConfiguredFeatures.POPLAR_RED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.POPLAR_RED).value());
        entries.add(ModConfiguredFeatures.POPLAR_YELLOW,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.POPLAR_YELLOW).value());
        entries.add(ModConfiguredFeatures.TREES_DAPPLED_FOREST,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.TREES_DAPPLED_FOREST).value());
        entries.add(ModConfiguredFeatures.POPLAR_TREES,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.POPLAR_TREES).value());
        entries.add(ModConfiguredFeatures.RED_SHRUB,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_SHRUB).value());
        entries.add(ModConfiguredFeatures.SHELF_MUSHROOM,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SHELF_MUSHROOM).value());
        entries.add(ModConfiguredFeatures.ORANGE_POPLAR_LEAF_LITTER,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_LEAF_LITTER).value());
        entries.add(ModConfiguredFeatures.YELLOW_POPLAR_LEAF_LITTER,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_LEAF_LITTER).value());
        entries.add(ModConfiguredFeatures.RED_POPLAR_LEAF_LITTER,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_POPLAR_LEAF_LITTER).value());
        entries.add(ModConfiguredFeatures.SNOW_LAYER,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SNOW_LAYER).value());
        entries.add(ModConfiguredFeatures.ICE_CRYSTAL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CRYSTAL).value());
        entries.add(ModConfiguredFeatures.ICE_CREVASSE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CREVASSE).value());
        entries.add(ModConfiguredFeatures.ICICLE_CLUSTER,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICICLE_CLUSTER).value());
        entries.add(ModConfiguredFeatures.LARGE_ICICLE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_ICICLE).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_COAL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COAL).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_COAL_BURIED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COAL_BURIED).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_COPPPER_SMALL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COPPPER_SMALL).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_SMALL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_SMALL).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_LARGE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_LARGE).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_BURIED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_BURIED).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_IRON,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_IRON).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_IRON_SMALL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_IRON_SMALL).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_GOLD_BURIED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_GOLD_BURIED).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS_BURIED,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS_BURIED).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_REDSTONE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_REDSTONE).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_ANDESITE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_ANDESITE).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_DIORITE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIORITE).value());
        entries.add(ModConfiguredFeatures.ICE_CAVE_ORE_GRAVEL,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_GRAVEL).value());


        HolderLookup.RegistryLookup<PlacedFeature> placedFeatures =
                registries.lookupOrThrow(Registries.PLACED_FEATURE);
        entries.add(ModPlacedFeatures.BROWN_MUSHROOM_DAPPLED_FOREST,
                placedFeatures.getOrThrow(ModPlacedFeatures.BROWN_MUSHROOM_DAPPLED_FOREST).value());
        entries.add(ModPlacedFeatures.RED_POPLAR,
                placedFeatures.getOrThrow(ModPlacedFeatures.RED_POPLAR).value());
        entries.add(ModPlacedFeatures.ORANGE_POPLAR,
                placedFeatures.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR).value());
        entries.add(ModPlacedFeatures.YELLOW_POPLAR,
                placedFeatures.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR).value());
        entries.add(ModPlacedFeatures.FALLEN_POPLAR,
                placedFeatures.getOrThrow(ModPlacedFeatures.FALLEN_POPLAR).value());
        entries.add(ModPlacedFeatures.RED_SHRUB,
                placedFeatures.getOrThrow(ModPlacedFeatures.RED_SHRUB).value());
        entries.add(ModPlacedFeatures.SHELF_MUSHROOM,
                placedFeatures.getOrThrow(ModPlacedFeatures.SHELF_MUSHROOM).value());
        entries.add(ModPlacedFeatures.BAMBOO_IN_STRUCTURE,
                placedFeatures.getOrThrow(ModPlacedFeatures.BAMBOO_IN_STRUCTURE).value());
        entries.add(ModPlacedFeatures.TREES_DAPPLED_FOREST,
                placedFeatures.getOrThrow(ModPlacedFeatures.TREES_DAPPLED_FOREST).value());
        entries.add(ModPlacedFeatures.SNOW_LAYERS,
                placedFeatures.getOrThrow(ModPlacedFeatures.SNOW_LAYERS).value());
        entries.add(ModPlacedFeatures.ICE_CRYSTALS,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CRYSTALS).value());
        entries.add(ModPlacedFeatures.ICE_CREVASSE,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CREVASSE).value());
        entries.add(ModPlacedFeatures.ICICLE_CLUSTER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICICLE_CLUSTER).value());
        entries.add(ModPlacedFeatures.LARGE_ICICLE,
                placedFeatures.getOrThrow(ModPlacedFeatures.LARGE_ICICLE).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_COAL_UPPER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_COAL_UPPER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_COAL_LOWER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_COAL_LOWER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_COPPER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_COPPER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_LARGE,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_LARGE).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_BURIED,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_BURIED).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_IRON_UPPER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_IRON_UPPER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_IRON_MIDDLE,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_IRON_MIDDLE).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_IRON_SMALL,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_IRON_SMALL).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_GOLD,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_GOLD).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_GOLD_LOWER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_GOLD_LOWER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_LAPIS,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_LAPIS).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_LAPIS_BURIED,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_LAPIS_BURIED).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE_LOWER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE_LOWER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_UPPER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_UPPER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_LOWER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_LOWER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_UPPER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_UPPER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_LOWER,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_LOWER).value());
        entries.add(ModPlacedFeatures.ICE_CAVE_ORE_GRAVEL,
                placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CAVE_ORE_GRAVEL).value());


        HolderLookup.RegistryLookup<Biome> biomes =
                registries.lookupOrThrow(Registries.BIOME);
        entries.add(ModBiomes.DAPPLED_FOREST,
                biomes.getOrThrow(ModBiomes.DAPPLED_FOREST).value());
        entries.add(ModBiomes.ICE_CAVES,
                biomes.getOrThrow(ModBiomes.ICE_CAVES).value());

        HolderLookup.RegistryLookup<VillagerTrade> trades =
                registries.lookupOrThrow(Registries.VILLAGER_TRADE);

        entries.add(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_POPLAR_LOG,
                trades.getOrThrow(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_POPLAR_LOG).value());
        entries.add(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_POPLAR_SAPLING,
                trades.getOrThrow(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_POPLAR_SAPLING).value());
        entries.add(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_SHELF_MUSHROOM,
                trades.getOrThrow(CommonWanderingTraderTrades.WANDERING_TRADER_UNCOMMON_SHELF_MUSHROOM).value());
        HolderLookup.RegistryLookup<NormalNoise.NoiseParameters> noises =
                registries.lookupOrThrow(Registries.NOISE);
        entries.add(ModNoises.ICE_CAVE_GRADIENT,
                noises.getOrThrow(ModNoises.ICE_CAVE_GRADIENT).value());

        HolderLookup.RegistryLookup<JukeboxSong> songs = registries.lookupOrThrow(Registries.JUKEBOX_SONG);
        entries.add(ModJukeboxSongs.FLURRY, songs.getOrThrow(ModJukeboxSongs.FLURRY).value());



    }

    @Override
    public String getName() {
        return "FallDropBackport Dynamic Registry";
    }
}
