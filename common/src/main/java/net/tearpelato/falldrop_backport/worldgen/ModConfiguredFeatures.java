package net.tearpelato.falldrop_backport.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLogsDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.init.ModBlocks;
import net.tearpelato.falldrop_backport.init.ModFeatures;
import net.tearpelato.falldrop_backport.init.ModTags;
import net.tearpelato.falldrop_backport.worldgen.feature.CrevasseConfiguration;
import net.tearpelato.falldrop_backport.worldgen.feature.LargeSpeleothemConfiguration;
import net.tearpelato.falldrop_backport.worldgen.feature.SpeleothemClusterConfiguration;
import net.tearpelato.falldrop_backport.worldgen.feature.SpeleothemUtils;
import net.tearpelato.falldrop_backport.worldgen.placer.PoplarFoliagePlacer;
import net.tearpelato.falldrop_backport.worldgen.placer.PoplarTrunkPlacer;
import net.tearpelato.falldrop_backport.worldgen.placer.decorator.ShelfMushroomDecorator;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SHRUB = registerKey("red_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_DAPPLED_FOREST = registerKey("trees_dappled_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_TREES = registerKey("poplar_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_RED = registerKey("poplar_red");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_ORANGE = registerKey("poplar_orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_YELLOW = registerKey("poplar_yellow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHELF_MUSHROOM = registerKey("shelf_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_POPLAR = registerKey("fallen_poplar");
    public static final ResourceKey<ConfiguredFeature<?,?>> RED_POPLAR_LEAF_LITTER = registerKey("red_poplar_leaf_litter");
    public static final ResourceKey<ConfiguredFeature<?,?>> ORANGE_POPLAR_LEAF_LITTER = registerKey("orange_poplar_leaf_litter");
    public static final ResourceKey<ConfiguredFeature<?,?>> YELLOW_POPLAR_LEAF_LITTER = registerKey("yellow_poplar_leaf_litter");

    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CRYSTAL = registerKey("ice_crystal");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CREVASSE = registerKey("ice_crevasse");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICICLE_CLUSTER = registerKey("icicle_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> LARGE_ICICLE = registerKey("large_icicle");
    public static final ResourceKey<ConfiguredFeature<?,?>> SNOW_LAYER = registerKey("snow_layer");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_COAL = registerKey("ice_cave_ore_coal");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_COAL_BURIED = registerKey("ice_cave_ore_coal_buried");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_COPPPER_SMALL = registerKey("ice_cave_ore_copper_small");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_DIAMOND_SMALL = registerKey("ice_cave_ore_diamond_small");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_DIAMOND_MEDIUM = registerKey("ice_cave_ore_diamond_medium");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_DIAMOND_LARGE = registerKey("ice_cave_ore_diamond_large");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_DIAMOND_BURIED = registerKey("ice_cave_ore_diamond_buried");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_IRON = registerKey("ice_cave_ore_iron");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_IRON_SMALL = registerKey("ice_cave_ore_iron_small");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_GOLD_BURIED = registerKey("ice_cave_ore_gold_buried");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_LAPIS = registerKey("ice_cave_ore_lapis");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_LAPIS_BURIED = registerKey("ice_cave_ore_lapis_buried");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_REDSTONE = registerKey("ice_cave_ore_redstone");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_ANDESITE = registerKey("ice_cave_ore_andesite");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_DIORITE = registerKey("ice_cave_ore_diorite");
    public static final ResourceKey<ConfiguredFeature<?,?>> ICE_CAVE_ORE_GRAVEL = registerKey("ice_cave_ore_gravel");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
        PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);
        var blocks = context.lookup(Registries.BLOCK);
        PlacementModifier survive = PlacementUtils.filteredByBlockSurvival(ModBlocks.POPLAR_SAPLING.get());

        context.register(SHELF_MUSHROOM, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.SHELF_MUSHROOM.get())
                )
        ));

        context.register(FALLEN_POPLAR, new ConfiguredFeature<>(Feature.FALLEN_TREE,
                createFallenPoplar().build()));

        context.register(RED_POPLAR_LEAF_LITTER, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.RED_POPLAR_LEAVES.get()).decorators(List.of(sparseLeafLitter, thickLeafLitter, new ShelfMushroomDecorator(0.4F))).build()));
        context.register(ORANGE_POPLAR_LEAF_LITTER, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.ORANGE_POPLAR_LEAVES.get()).decorators(List.of(sparseLeafLitter, thickLeafLitter, new ShelfMushroomDecorator(0.4F))).build()));
        context.register(YELLOW_POPLAR_LEAF_LITTER, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.YELLOW_POPLAR_LEAVES.get()).decorators(List.of(sparseLeafLitter, thickLeafLitter, new ShelfMushroomDecorator(0.4F))).build()));



       register(context, RED_SHRUB, Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(PlacementUtils.inlinePlaced(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RED_SHRUB.get())),
                                CountPlacement.of(24),
                                RandomOffsetPlacement.ofTriangle(6, 3),
                                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)))));



        context.register(POPLAR_RED, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.RED_POPLAR_LEAVES.get()).decorators(List.of(new ShelfMushroomDecorator(0.4F))).build()));

        context.register(POPLAR_ORANGE, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.ORANGE_POPLAR_LEAVES.get()).decorators(List.of(new ShelfMushroomDecorator(0.4F))).build()));

        context.register(POPLAR_YELLOW, new ConfiguredFeature<>(Feature.TREE,
                createPoplar(ModBlocks.YELLOW_POPLAR_LEAVES.get()).decorators(List.of(new ShelfMushroomDecorator(0.4F))).build()));



        context.register(TREES_DAPPLED_FOREST, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        List.of(
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(RED_POPLAR_LEAF_LITTER), survive), 200f / 677f),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(ORANGE_POPLAR_LEAF_LITTER), survive), 240f / 477f),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(YELLOW_POPLAR_LEAF_LITTER), survive), 90f / 237f),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(TreeFeatures.SPRUCE),
                                        PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING)), 27f / 147f)),
                        PlacementUtils.inlinePlaced(lookup.getOrThrow(FALLEN_POPLAR)))));

        context.register(POPLAR_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        List.of(
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(POPLAR_RED)), 0.33f),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(lookup.getOrThrow(POPLAR_ORANGE)), 0.33f)),
                        PlacementUtils.inlinePlaced(lookup.getOrThrow(POPLAR_YELLOW)))));

        RuleTest naturalStone = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
        RuleTest naturalStoneOrIce = new TagMatchTest(ModTags.Blocks.ICE_CAVE_ORE_REPLACEABLES);
        RuleTest stoneOreReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> oreIronTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> oreGoldTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> oreDiamondTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> oreLapisTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.LAPIS_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> oreCopperTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> oreCoalTargetList = List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.COAL_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_COAL_ORE.defaultBlockState()));


        context.register(SNOW_LAYER,new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SNOW))));
        context.register(ICE_CRYSTAL, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ICE_CRYSTAL.get()))));
        context.register(LARGE_ICICLE, new ConfiguredFeature<>(ModFeatures.LARGE_SPELEOTHEM.get(),new LargeSpeleothemConfiguration(Blocks.PACKED_ICE.defaultBlockState(), blocks.getOrThrow(ModTags.Blocks.LARGE_ICICLE_REPLACEABLE), 30, ClampedInt.of(UniformInt.of(3, 19), 3, 16), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F)));
        context.register(ICE_CREVASSE,new ConfiguredFeature<>(ModFeatures.CREVASSE.get(), new CrevasseConfiguration(4, 16, 10, 8, 8, 4.0F, 0.6F, 0.05F, UniformInt.of(6, 10), UniformInt.of(4, 6), BlockStateProvider.simple(ModBlocks.BRITTLE_ICE.get()), BlockStateProvider.simple(Blocks.WATER), BlockPredicate.matchesTag(ModTags.Blocks.ICE_CREVASSE_REPLACEABLES), BlockPredicate.matchesTag(ModTags.Blocks.BLOCKS_FLUID_FLOW))));
        context.register(ICICLE_CLUSTER, new ConfiguredFeature<>(ModFeatures.SPELEOTHEM_CLUSTER.get(), new SpeleothemClusterConfiguration(Blocks.PACKED_ICE.defaultBlockState(), ModBlocks.ICICLE.get().defaultBlockState(), blocks.getOrThrow(ModTags.Blocks.ICE_CREVASSE_REPLACEABLES), 32, UniformInt.of(3, 5), ConstantInt.of(6), 1, 3, UniformInt.of(2, 3), UniformFloat.of(0.3F, 0.7F), ConstantFloat.ZERO, 0.1F, 3, 8, new SpeleothemClusterConfiguration.PlacementOptions(SpeleothemClusterConfiguration.PlacementMode.CEILING_ONLY, SpeleothemUtils.BaseBlockTransformer.NONE, false))));
        context.register(ICE_CAVE_ORE_COAL, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreCoalTargetList, 17)));
        context.register(ICE_CAVE_ORE_COAL_BURIED, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreCoalTargetList, 17)));
        context.register(ICE_CAVE_ORE_COPPPER_SMALL, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreCopperTargetList, 10)));
        context.register(ICE_CAVE_ORE_DIAMOND_SMALL, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreDiamondTargetList, 4)));
        context.register(ICE_CAVE_ORE_DIAMOND_MEDIUM, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreDiamondTargetList, 8)));
        context.register(ICE_CAVE_ORE_DIAMOND_LARGE, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreDiamondTargetList, 12)));
        context.register(ICE_CAVE_ORE_DIAMOND_BURIED, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreDiamondTargetList, 8)));
        context.register(ICE_CAVE_ORE_IRON, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreIronTargetList, 9)));
        context.register(ICE_CAVE_ORE_IRON_SMALL, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreIronTargetList, 4)));
        context.register(ICE_CAVE_ORE_GOLD_BURIED, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreGoldTargetList, 9)));
        context.register(ICE_CAVE_ORE_LAPIS, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreLapisTargetList, 7)));
        context.register(ICE_CAVE_ORE_LAPIS_BURIED, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(oreLapisTargetList, 7)));
        context.register(ICE_CAVE_ORE_REDSTONE, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(List.of(OreConfiguration.target(stoneOreReplaceables, Blocks.REDSTONE_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreReplaceables, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState())), 8)));
        context.register(ICE_CAVE_ORE_ANDESITE,new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(naturalStoneOrIce, Blocks.ANDESITE.defaultBlockState(), 64)));
        context.register(ICE_CAVE_ORE_DIORITE, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(naturalStoneOrIce, Blocks.DIORITE.defaultBlockState(), 64)));
        context.register(ICE_CAVE_ORE_GRAVEL, new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(naturalStoneOrIce, Blocks.GRAVEL.defaultBlockState(), 33)));


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Constants.vanilla(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPoplar(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG.get()),
                new PoplarTrunkPlacer(7, 4, 0, ConstantInt.of(4), UniformInt.of(1, 4)),
                BlockStateProvider.simple(leaves),
                new PoplarFoliagePlacer(new WeightedListInt(
                        WeightedList.<IntProvider>builder()
                                .add(ConstantInt.of(5), 5)
                                .add(ConstantInt.of(6), 5)
                                .add(ConstantInt.of(7), 1)
                                .add(ConstantInt.of(8), 1)
                                .build()
                ),
                        ConstantInt.of(0), UniformInt.of(5, 6), 0.15F),
                new TwoLayersFeatureSize(1, 0, 2))
                .ignoreVines();
    }



    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenPoplar() {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG.get()),
                UniformInt.of(4,7))
                .logDecorators(List.of(
                        new AttachedToLogsDecorator(0.1F, BlockStateProvider.simple(Blocks.BROWN_MUSHROOM),
                                List.of(Direction.UP)))).logDecorators(List.of(new ShelfMushroomDecorator(0.8F)));
    }
}