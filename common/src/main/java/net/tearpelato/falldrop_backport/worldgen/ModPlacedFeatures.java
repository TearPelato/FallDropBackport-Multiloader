package net.tearpelato.falldrop_backport.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.init.ModBlocks;
import net.tearpelato.falldrop_backport.init.ModTags;
import net.tearpelato.falldrop_backport.worldgen.placer.util.VegetationPlacementsUtils;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RED_SHRUB = registerKey("red_shrub");
    public static final ResourceKey<PlacedFeature> RED_POPLAR = registerKey("red_poplar");
    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR = registerKey("yellow_poplar");
    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR = registerKey("orange_poplar");
    public static final ResourceKey<PlacedFeature> SHELF_MUSHROOM = registerKey("shelf_mushroom");
    public static final ResourceKey<PlacedFeature> FALLEN_POPLAR = registerKey("fallen_poplar");
    public static final ResourceKey<PlacedFeature> BROWN_MUSHROOM_DAPPLED_FOREST = registerKey("brown_mushroom_dappled_forest");
    public static final ResourceKey<PlacedFeature> BAMBOO_IN_STRUCTURE = registerKey("bamboo_in_structure");
    public static final ResourceKey<PlacedFeature> TREES_DAPPLED_FOREST = registerKey("trees_dappled_forest");

    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_COAL_UPPER = registerKey("ice_cave_ore_coal_upper");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_COAL_LOWER = registerKey("ice_cave_ore_coal_lower");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_COPPER = registerKey("ice_cave_ore_copper");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIAMOND = registerKey("ice_cave_ore_diamond");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIAMOND_MEDIUM = registerKey("ice_cave_ore_diamond_medium");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIAMOND_LARGE = registerKey("ice_cave_ore_diamond_large");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIAMOND_BURIED = registerKey("ice_cave_ore_diamond_buried");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_IRON_UPPER = registerKey("ice_cave_ore_iron_upper");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_IRON_MIDDLE = registerKey("ice_cave_ore_iron_middle");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_IRON_SMALL = registerKey("ice_cave_ore_iron_small");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_GOLD = registerKey("ice_cave_ore_gold");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_GOLD_LOWER = registerKey("ice_cave_ore_gold_lower");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_LAPIS = registerKey("ice_cave_ore_lapis");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_LAPIS_BURIED = registerKey("ice_cave_ore_lapis_buried");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_REDSTONE = registerKey("ice_cave_ore_redstone");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_REDSTONE_LOWER = registerKey("ice_cave_ore_redstone_lower");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_ANDESITE_UPPER = registerKey("ice_cave_ore_andesite_upper");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_ANDESITE_LOWER = registerKey("ice_cave_ore_andesite_lower");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIORITE_UPPER = registerKey("ice_cave_ore_diorite_upper");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_DIORITE_LOWER = registerKey("ice_cave_ore_diorite_lower");
    public static final ResourceKey<PlacedFeature> ICE_CAVE_ORE_GRAVEL = registerKey("ice_cave_ore_gravel");

    public static final ResourceKey<PlacedFeature> SNOW_LAYERS = registerKey("snow_layers");
    public static final ResourceKey<PlacedFeature> ICE_CRYSTALS = registerKey("ice_crystals");
    public static final ResourceKey<PlacedFeature> ICE_CREVASSE = registerKey("ice_crevasse");
    public static final ResourceKey<PlacedFeature> ICICLE_CLUSTER = registerKey("icicle_cluster");
    public static final ResourceKey<PlacedFeature> LARGE_ICICLE = registerKey("large_icicle");
    
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, RED_SHRUB, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_SHRUB), List.of(new PlacementModifier[]{InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome(), CountPlacement.of(8), RandomOffsetPlacement.ofTriangle(7, 3), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)}));

        register(context, RED_POPLAR, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_POPLAR_LEAF_LITTER),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 2),
                        ModBlocks.POPLAR_SAPLING.get()));

        register(context, YELLOW_POPLAR, configuredFeatures.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_LEAF_LITTER),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 2),
                        ModBlocks.POPLAR_SAPLING.get()));

        register(context, ORANGE_POPLAR, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_LEAF_LITTER),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 2),
                        ModBlocks.POPLAR_SAPLING.get()));

        register(context, FALLEN_POPLAR, configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_POPLAR),
               List.of(new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(ModBlocks.POPLAR_SAPLING.get())}));

        register(context, SHELF_MUSHROOM, configuredFeatures.getOrThrow(ModConfiguredFeatures.SHELF_MUSHROOM),
                List.of(              CountPlacement.of(1),
                        RarityFilter.onAverageOnceEvery(1),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(80)),
                        EnvironmentScanPlacement.scanningFor(
                                Direction.DOWN,
                                BlockPredicate.matchesBlocks(ModBlocks.POPLAR_LOG.get()),
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                12
                        ),
                        BiomeFilter.biome()));

        register(context, TREES_DAPPLED_FOREST, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREES_DAPPLED_FOREST),
                List.of(CountPlacement.of(6),
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_NO_LEAVES,
                        BiomeFilter.biome()));

    register(context, BROWN_MUSHROOM_DAPPLED_FOREST, configuredFeatures.getOrThrow(VegetationFeatures.BROWN_MUSHROOM), VegetationPlacementsUtils.getMushroomPlacement(2, (PlacementModifier)null));

        register(context, BAMBOO_IN_STRUCTURE,
                configuredFeatures.getOrThrow(ResourceKey.create(Registries.CONFIGURED_FEATURE, Constants.vanilla("bamboo_no_podzol"))),
                List.of(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)));


        List<PlacementModifier> oreCoalUpperModifiers = commonOrePlacement(30,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top()));

        List<PlacementModifier> oreCoalLowerModifiers = commonOrePlacement(20,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)));

        List<PlacementModifier> oreCopperModifiers = commonOrePlacement(16,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)));

        List<PlacementModifier> oreDiamondModifiers = commonOrePlacement(7,
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)));

        List<PlacementModifier> oreDiamondMediumModifiers = commonOrePlacement(2,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)));

        List<PlacementModifier> oreDiamondLargeModifiers = rareOrePlacement(9,
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)));

        List<PlacementModifier> oreDiamondBuriedModifiers = commonOrePlacement(4,
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)));

        List<PlacementModifier> oreIronUpperModifiers = commonOrePlacement(90,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)));

        List<PlacementModifier> oreIronMiddleModifiers = commonOrePlacement(10,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)));

        List<PlacementModifier> oreIronSmallModifiers = commonOrePlacement(10,
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72)));

        List<PlacementModifier> oreGoldModifiers = commonOrePlacement(4,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)));

        List<PlacementModifier> oreGoldLowerModifiers = orePlacement(
                CountPlacement.of(UniformInt.of(0, 1)),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)));

        List<PlacementModifier> oreLapisModifiers = commonOrePlacement(2,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)));

        List<PlacementModifier> oreLapisBuriedModifiers = commonOrePlacement(4,
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)));

        List<PlacementModifier> oreRedstoneModifiers = commonOrePlacement(4,
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)));

        List<PlacementModifier> oreRedstoneLowerModifiers = commonOrePlacement(8,
                HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)));

        List<PlacementModifier> depositUpperModifiers = rareOrePlacement(6,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)));

        List<PlacementModifier> depositLowerModifiers = commonOrePlacement(2,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)));

        List<PlacementModifier> gravelModifiers = commonOrePlacement(14,
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));


   register(context, SNOW_LAYERS, configuredFeatures.getOrThrow(ModConfiguredFeatures.SNOW_LAYER), List.of(new PlacementModifier[]{CountPlacement.of(UniformInt.of(16, 24)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(32), RandomOffsetPlacement.ofTriangle(4, 0), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 32), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()}));
   register(context, ICE_CRYSTALS, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CRYSTAL), List.of(new PlacementModifier[]{CountPlacement.of(UniformInt.of(48, 64)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(2), RandomOffsetPlacement.ofTriangle(2, 0), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(new Block[]{Blocks.PACKED_ICE}), BlockPredicate.ONLY_IN_AIR_PREDICATE, 32), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()}));
   register(context, LARGE_ICICLE, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_ICICLE), List.of( new PlacementModifier[]{CountPlacement.of(UniformInt.of(48, 64)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()}));
   register(context, ICE_CREVASSE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CREVASSE), List.of(new PlacementModifier[]{CountPlacement.of(ConstantInt.of(16)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(24), VerticalAnchor.belowTop(64)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesTag(ModTags.Blocks.ICE_CREVASSE_REPLACEABLES), BlockPredicate.ONLY_IN_AIR_PREDICATE, 8), BiomeFilter.biome()}));
   register(context, ICICLE_CLUSTER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICICLE_CLUSTER), List.of(new PlacementModifier[]{CountPlacement.of(UniformInt.of(24, 64)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()}));


   register(context, ICE_CAVE_ORE_COAL_UPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COAL), oreCoalUpperModifiers);
   register(context, ICE_CAVE_ORE_COAL_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COAL_BURIED), oreCoalLowerModifiers);
   register(context, ICE_CAVE_ORE_COPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_COPPPER_SMALL), oreCopperModifiers);
   register(context, ICE_CAVE_ORE_DIAMOND, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_SMALL), oreDiamondModifiers);
   register(context, ICE_CAVE_ORE_DIAMOND_MEDIUM, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_MEDIUM), oreDiamondMediumModifiers);
   register(context, ICE_CAVE_ORE_DIAMOND_LARGE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_LARGE), oreDiamondLargeModifiers);
   register(context, ICE_CAVE_ORE_DIAMOND_BURIED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIAMOND_BURIED), oreDiamondBuriedModifiers);
   register(context, ICE_CAVE_ORE_IRON_UPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_IRON), oreIronUpperModifiers);
   register(context, ICE_CAVE_ORE_IRON_MIDDLE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_IRON), oreIronMiddleModifiers);
   register(context, ICE_CAVE_ORE_IRON_SMALL, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_IRON_SMALL), oreIronSmallModifiers);
   register(context, ICE_CAVE_ORE_GOLD, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_GOLD_BURIED), oreGoldModifiers);
   register(context, ICE_CAVE_ORE_GOLD_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_GOLD_BURIED), oreGoldLowerModifiers);
   register(context, ICE_CAVE_ORE_LAPIS, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS), oreLapisModifiers);
   register(context, ICE_CAVE_ORE_LAPIS_BURIED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_LAPIS_BURIED), oreLapisBuriedModifiers);
   register(context, ICE_CAVE_ORE_REDSTONE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_REDSTONE), oreRedstoneModifiers);
   register(context, ICE_CAVE_ORE_REDSTONE_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_REDSTONE), oreRedstoneLowerModifiers);
   register(context, ICE_CAVE_ORE_ANDESITE_UPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_ANDESITE), depositUpperModifiers);
   register(context, ICE_CAVE_ORE_ANDESITE_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_ANDESITE), depositLowerModifiers);
   register(context, ICE_CAVE_ORE_DIORITE_UPPER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIORITE), depositUpperModifiers);
   register(context, ICE_CAVE_ORE_DIORITE_LOWER, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_DIORITE), depositLowerModifiers);
   register(context, ICE_CAVE_ORE_GRAVEL, configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_CAVE_ORE_GRAVEL), gravelModifiers);

    }




    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Constants.vanilla(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


    private static List<PlacementModifier> orePlacement(PlacementModifier frequencyModifier, PlacementModifier heightRange) {
        return List.of(frequencyModifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightRange);
    }
}