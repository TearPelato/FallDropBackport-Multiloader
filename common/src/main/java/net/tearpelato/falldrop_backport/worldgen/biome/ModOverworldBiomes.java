package net.tearpelato.falldrop_backport.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.tearpelato.falldrop_backport.init.ModEntities;
import net.tearpelato.falldrop_backport.worldgen.ModPlacedFeatures;

public class ModOverworldBiomes {

    public static Biome dappledForest(HolderGetter<PlacedFeature> placedFeatures,
                                      HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(placedFeatures, carvers);
        globalOverworldGeneration(generation, true);
        BackgroundMusic music = new BackgroundMusic(SoundEvents.MUSIC_BIOME_FOREST);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.TREES_DAPPLED_FOREST);
        addDappledForestVegetation(generation);
        BiomeDefaultFeatures.addForestGrass(generation);

        MobSpawnSettings.Builder mobs = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobs);
        BiomeDefaultFeatures.commonSpawns(mobs);
        mobs.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 4));
        mobs.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.FOX, 2, 4));

        return baseBiome(0.6F, 0.6F)
                .putAttributes(EnvironmentAttributeMap.builder()
                        .set(EnvironmentAttributes.BACKGROUND_MUSIC, music)
                        .set(EnvironmentAttributes.SKY_COLOR, 0xFF000000 | 8168447)
                        .set(EnvironmentAttributes.FOG_COLOR, 0xFF000000 | 13424866)
                        .set(EnvironmentAttributes.WATER_FOG_COLOR, 0xFF000000 | 3625300)
                        .build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(3625300)
                        .grassColorOverride(14641191)
                        .foliageColorOverride(15109680)
                        .dryFoliageColorOverride(9189892)
                        .build())
                .mobSpawnSettings(mobs.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome iceCaves(final HolderGetter<PlacedFeature> placedFeatures, final HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        MobSpawnSettings.Builder mobs = new MobSpawnSettings.Builder();
        mobs.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 90, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(ModEntities.FROSTBITE.get(), 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        mobs.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        mobs.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        mobs.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));
        mobs.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 2, 4));
        mobs.addSpawn(MobCategory.AMBIENT, 10, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));

        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(placedFeatures, carvers);
        globalOverworldGeneration(generation, false);
        addIceCaveOres(generation);
        addIceCaveUndergroundVariety(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        addIceCavesFeatures(generation);

        return baseBiome(0.0F, 0.0F)
                .putAttributes(EnvironmentAttributeMap.builder()
                        .set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FOREST)) // o quello che usi
                        .set(EnvironmentAttributes.SKY_COLOR, 0xFF000000 | 8168447)
                        .set(EnvironmentAttributes.FOG_COLOR, 0xFF000000 | -15444581)
                        .set(EnvironmentAttributes.WATER_FOG_COLOR, 0xFF000000 | -15444581)
                        .build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(-15444581)
                        .build())
                .mobSpawnSettings(mobs.build())
                .generationSettings(generation.build())
                .build();
    }

    private static Biome.BiomeBuilder baseBiome(float temperature, float downfall) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(new BiomeSpecialEffects.Builder().waterColor(4159204).build());
    }

    private static void globalOverworldGeneration(final BiomeGenerationSettings.Builder generation, final boolean hasUndergroundVariety) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generation);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generation);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generation);
        if (hasUndergroundVariety) {
            BiomeDefaultFeatures.addDefaultUndergroundVariety(generation);
        }

        BiomeDefaultFeatures.addDefaultSprings(generation);
        BiomeDefaultFeatures.addSurfaceFreezing(generation);
    }

    private static void addDappledForestVegetation(BiomeGenerationSettings.Builder generation) {
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BROWN_MUSHROOM_DAPPLED_FOREST);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.RED_SHRUB);
    }

    public static void addIceCaveOres(final BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_TUFF);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_IRON_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_IRON_MIDDLE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_IRON_SMALL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_GOLD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_GOLD_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_REDSTONE_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_LARGE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIAMOND_BURIED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_LAPIS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_LAPIS_BURIED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_COPPER);
    }

    public static void addIceCaveUndergroundVariety(final BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_GRAVEL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_DIORITE_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ICE_CAVE_ORE_ANDESITE_LOWER);
    }

    public static void addIceCavesFeatures(final BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.LARGE_ICICLE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.SNOW_LAYERS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.ICE_CRYSTALS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.ICICLE_CLUSTER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.ICE_CREVASSE);
    }

}
