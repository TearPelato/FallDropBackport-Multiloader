package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.block.custom.*;
import net.tearpelato.falldrop_backport.worldgen.ModTreeGrowers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModBlocks {
    public static final List<ObjectRegistries<? extends Block>> BLOCKS = new ArrayList<>();

    //WoolSet
    public static final ObjectRegistries<Block> WHITE_WOOL_STAIRS = registerCopy("white_wool_stairs", Blocks.WHITE_WOOL,
            properties -> new ModStairBlock(Blocks.WHITE_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> LIGHT_GRAY_WOOL_STAIRS = registerCopy("light_gray_wool_stairs", Blocks.LIGHT_GRAY_WOOL,
            properties -> new ModStairBlock(Blocks.LIGHT_GRAY_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> GRAY_WOOL_STAIRS = registerCopy("gray_wool_stairs", Blocks.GRAY_WOOL,
            properties -> new ModStairBlock(Blocks.GRAY_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> BLACK_WOOL_STAIRS = registerCopy("black_wool_stairs", Blocks.BLACK_WOOL,
            properties -> new ModStairBlock(Blocks.BLACK_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> BROWN_WOOL_STAIRS = registerCopy("brown_wool_stairs", Blocks.BROWN_WOOL,
            properties -> new ModStairBlock(Blocks.BROWN_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> RED_WOOL_STAIRS = registerCopy("red_wool_stairs", Blocks.RED_WOOL,
            properties -> new ModStairBlock(Blocks.RED_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> ORANGE_WOOL_STAIRS = registerCopy("orange_wool_stairs", Blocks.ORANGE_WOOL,
            properties -> new ModStairBlock(Blocks.ORANGE_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> YELLOW_WOOL_STAIRS = registerCopy("yellow_wool_stairs", Blocks.YELLOW_WOOL,
            properties -> new ModStairBlock(Blocks.YELLOW_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> LIME_WOOL_STAIRS = registerCopy("lime_wool_stairs", Blocks.LIME_WOOL,
            properties -> new ModStairBlock(Blocks.LIME_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> GREEN_WOOL_STAIRS = registerCopy("green_wool_stairs", Blocks.GREEN_WOOL,
            properties -> new ModStairBlock(Blocks.GREEN_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> CYAN_WOOL_STAIRS = registerCopy("cyan_wool_stairs", Blocks.CYAN_WOOL,
            properties -> new ModStairBlock(Blocks.CYAN_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> LIGHT_BLUE_WOOL_STAIRS = registerCopy("light_blue_wool_stairs", Blocks.LIGHT_BLUE_WOOL,
            properties -> new ModStairBlock(Blocks.LIGHT_BLUE_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> BLUE_WOOL_STAIRS = registerCopy("blue_wool_stairs", Blocks.BLUE_WOOL,
            properties -> new ModStairBlock(Blocks.BLUE_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> PURPLE_WOOL_STAIRS = registerCopy("purple_wool_stairs", Blocks.PURPLE_WOOL,
            properties -> new ModStairBlock(Blocks.PURPLE_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> MAGENTA_WOOL_STAIRS = registerCopy("magenta_wool_stairs", Blocks.MAGENTA_WOOL,
            properties -> new ModStairBlock(Blocks.MAGENTA_WOOL.defaultBlockState(), properties));
    public static final ObjectRegistries<Block> PINK_WOOL_STAIRS = registerCopy("pink_wool_stairs", Blocks.PINK_WOOL,
            properties -> new ModStairBlock(Blocks.PINK_WOOL.defaultBlockState(), properties));


    public static final ObjectRegistries<Block> WHITE_WOOL_SLAB = registerCopy("white_wool_slab",Blocks.WHITE_WOOL,SlabBlock::new);
    public static final ObjectRegistries<Block> LIGHT_GRAY_WOOL_SLAB = registerCopy("light_gray_wool_slab",Blocks.LIGHT_GRAY_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> GRAY_WOOL_SLAB = registerCopy("gray_wool_slab",Blocks.GRAY_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> BLACK_WOOL_SLAB = registerCopy("black_wool_slab",Blocks.BLACK_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> BROWN_WOOL_SLAB = registerCopy("brown_wool_slab",Blocks.BROWN_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> RED_WOOL_SLAB = registerCopy("red_wool_slab",Blocks.RED_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> ORANGE_WOOL_SLAB = registerCopy("orange_wool_slab",Blocks.ORANGE_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> YELLOW_WOOL_SLAB = registerCopy("yellow_wool_slab",Blocks.YELLOW_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> LIME_WOOL_SLAB = registerCopy("lime_wool_slab",Blocks.LIME_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> GREEN_WOOL_SLAB = registerCopy("green_wool_slab",Blocks.GREEN_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> CYAN_WOOL_SLAB = registerCopy("cyan_wool_slab",Blocks.CYAN_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> LIGHT_BLUE_WOOL_SLAB = registerCopy("light_blue_wool_slab",Blocks.LIGHT_BLUE_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> BLUE_WOOL_SLAB = registerCopy("blue_wool_slab",Blocks.BLUE_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> PURPLE_WOOL_SLAB = registerCopy("purple_wool_slab",Blocks.PURPLE_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> MAGENTA_WOOL_SLAB = registerCopy("magenta_wool_slab",Blocks.MAGENTA_WOOL, SlabBlock::new);
    public static final ObjectRegistries<Block> PINK_WOOL_SLAB = registerCopy("pink_wool_slab",Blocks.PINK_WOOL, SlabBlock::new);

    //Concrete variants
    public static final ObjectRegistries<Block> WHITE_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("white_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> LIGHT_GRAY_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("light_gray_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> GRAY_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("gray_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> BLACK_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("black_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> BROWN_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("brown_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> RED_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("red_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> ORANGE_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("orange_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> YELLOW_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("yellow_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> LIME_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("lime_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> GREEN_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("green_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> CYAN_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("cyan_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> LIGHT_BLUE_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("light_blue_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> BLUE_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("blue_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> PURPLE_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("purple_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> MAGENTA_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("magenta_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));
    public static final ObjectRegistries<Block> PINK_CONCRETE_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("pink_concrete_stairs"),
            properties -> new ModStairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(), properties.strength(1.8F).sound(SoundType.STONE).ignitedByLava().requiresCorrectToolForDrops()));


    public static final ObjectRegistries<Block> WHITE_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("white_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> LIGHT_GRAY_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("light_gray_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> GRAY_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("gray_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> BLACK_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("black_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> BROWN_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("brown_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> RED_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("red_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> ORANGE_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("orange_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> YELLOW_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("yellow_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> LIME_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("lime_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> GREEN_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("green_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> CYAN_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("cyan_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> LIGHT_BLUE_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("light_blue_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> BLUE_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("blue_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> PURPLE_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("purple_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> MAGENTA_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("magenta_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));
    public static final ObjectRegistries<Block> PINK_CONCRETE_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("pink_concrete_slab"),
            properties -> new SlabBlock(properties.strength(0.8F).sound(SoundType.STONE).ignitedByLava()));


    public static final ObjectRegistries<Block> POPLAR_LOG = ObjectRegistries.registerBlock(Constants.vanilla("poplar_log"),
            properties -> new ModFlammablePillars(properties.sound(SoundType.WOOD).strength(2.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_WOOD = ObjectRegistries.registerBlock(Constants.vanilla("poplar_wood"),
            properties -> new ModFlammablePillars(properties.sound(SoundType.WOOD).strength(2.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> STRIPPED_POPLAR_LOG = ObjectRegistries.registerBlock(Constants.vanilla("stripped_poplar_log"),
            properties -> new ModFlammablePillars(properties.sound(SoundType.WOOD).strength(2.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> STRIPPED_POPLAR_WOOD = ObjectRegistries.registerBlock(Constants.vanilla("stripped_poplar_wood"),
            properties -> new ModFlammablePillars(properties.sound(SoundType.WOOD).strength(2.0F).ignitedByLava()));


    public static final ObjectRegistries<Block> RED_POPLAR_LEAVES = ObjectRegistries.registerBlock(Constants.vanilla("red_poplar_leaves"),
            properties -> new UntintedParticleLeavesBlock(0.01f, ModParticleTypes.redPoplarLeaves(), properties.mapColor(MapColor.COLOR_RED)
                    .strength(0.2F).randomTicks().sound(ModSounds.POPLAR_LEAVES.get()).noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot).isSuffocating((_, _, _) -> false)
                    .isViewBlocking((_, _, _) -> false)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((_, _, _) -> false)));

    public static final ObjectRegistries<Block> ORANGE_POPLAR_LEAVES = ObjectRegistries.registerBlock(Constants.vanilla("orange_poplar_leaves"),
            properties -> new UntintedParticleLeavesBlock(0.01f, ModParticleTypes.orangePoplarLeaves(), properties.mapColor(MapColor.COLOR_ORANGE)
                    .strength(0.2F).randomTicks().sound(ModSounds.POPLAR_LEAVES.get()).noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot).isSuffocating((_, _, _) -> false)
                    .isViewBlocking((_, _, _) -> false)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((_, _, _) -> false)));


    public static final ObjectRegistries<Block> YELLOW_POPLAR_LEAVES = ObjectRegistries.registerBlock(Constants.vanilla("yellow_poplar_leaves"),
            properties -> new UntintedParticleLeavesBlock(0.01f, ModParticleTypes.yellowPoplarLeaves(), properties.mapColor(MapColor.COLOR_YELLOW)
                    .strength(0.2F).randomTicks().sound(ModSounds.POPLAR_LEAVES.get()).noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot).isSuffocating((_, _, _) -> false)
                    .isViewBlocking((_, _, _) -> false)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((_, _, _) -> false)));


    public static final ObjectRegistries<Block> POPLAR_PLANKS = ObjectRegistries.registerBlock(Constants.vanilla("poplar_planks"),
            properties -> new Block(properties.sound(SoundType.WOOD).strength(2F).ignitedByLava()));


    public static final ObjectRegistries<Block> POPLAR_STAIRS = ObjectRegistries.registerBlock(Constants.vanilla("poplar_stairs"),
            properties -> new ModStairBlock(POPLAR_PLANKS.get().defaultBlockState(), properties.strength(2.0F).sound(SoundType.WOOD).ignitedByLava().requiresCorrectToolForDrops()));

    public static final ObjectRegistries<Block> POPLAR_SLAB = ObjectRegistries.registerBlock(Constants.vanilla("poplar_slab"),
            properties -> new SlabBlock(properties.strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_FENCE = ObjectRegistries.registerBlock(Constants.vanilla("poplar_fence"),
            properties -> new FenceBlock(properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.WOOD).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_FENCE_GATE = ObjectRegistries.registerBlock(Constants.vanilla("poplar_fence_gate"),
            properties -> new FenceGateBlock(WoodType.PALE_OAK, properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.WOOD).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_DOOR = ObjectRegistries.registerBlock(Constants.vanilla("poplar_door"),
            properties -> new ModDoorBlock(BlockSetType.PALE_OAK, properties.strength(2f)
                    .requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_TRAPDOOR = ObjectRegistries.registerBlock(Constants.vanilla("poplar_trapdoor"),
            properties -> new TrapDoorBlock(BlockSetType.PALE_OAK, properties.strength(2f)
                    .requiresCorrectToolForDrops().noOcclusion().isValidSpawn(Blocks::never).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_PRESSURE_PLATE = ObjectRegistries.registerBlock(Constants.vanilla("poplar_pressure_plate"),
            properties -> new ModPressurePlateBlock(BlockSetType.PALE_OAK,
                    properties.strength(2f).requiresCorrectToolForDrops().forceSolidOn().noCollision().pushReaction(PushReaction.DESTROY)));

    public static final ObjectRegistries<Block> POPLAR_BUTTON = ObjectRegistries.registerBlock(Constants.vanilla("poplar_button"),
            properties -> new ModButtonBlock(BlockSetType.PALE_OAK, 20,
                    properties.strength(2f).requiresCorrectToolForDrops().noCollision().pushReaction(PushReaction.DESTROY)));


    public static final ObjectRegistries<Block> POPLAR_SIGN = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("poplar_sign"),
            () -> new ModStandingSignBlock(ModWoodType.POPLAR, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("poplar_sign")))
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_WALL_SIGN = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("poplar_wall_sign"),
            () -> new ModWallSignBlock(ModWoodType.POPLAR, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("poplar_wall_sign")))
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_HANGING_SIGN = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("poplar_hanging_sign"),
            () -> new ModHangingSignBlock(ModWoodType.POPLAR, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("poplar_hanging_sign")))
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> POPLAR_WALL_HANGING_SIGN = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("poplar_wall_hanging_sign"),
            () -> new ModWallHangingSignBlock(ModWoodType.POPLAR, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("poplar_wall_hanging_sign")))
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava()));

    public static final ObjectRegistries<Block> RED_SHRUB_POTTED = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("red_shrub_potted"),
            () -> new ModBushBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("red_shrub_potted")))
                    .strength(0.2f).sound(ModSounds.RED_SHRUB.get()).noCollision().instabreak().pushReaction(PushReaction.DESTROY)));

    public static final ObjectRegistries<Block> POPLAR_SAPLING = ObjectRegistries.registerBlock(Constants.vanilla("poplar_sapling"),
            properties -> new ModSaplingBlock(ModTreeGrowers.POPLAR, properties.mapColor(MapColor.PLANT).noCollision()
                    .randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    public static final ObjectRegistries<Block> POPLAR_SAPLING_POTTED = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("potted_poplar_sapling"),
            () -> new FlowerPotBlock(POPLAR_SAPLING.get(), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("potted_poplar_sapling")))
                    .noOcclusion().instabreak().pushReaction(PushReaction.DESTROY)));

    public static final ObjectRegistries<StrawBedBlock> STRAW_BED = ObjectRegistries.registerCustom(BuiltInRegistries.BLOCK, Constants.vanilla("straw_bed"),
            () -> new StrawBedBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Constants.vanilla("straw_bed")))
                    .strength(0.2f).noOcclusion().sound(ModSounds.STRAW_BED.get())));
    public static final ObjectRegistries<Block> POPLAR_SHELF = ObjectRegistries.registerBlock(Constants.vanilla("poplar_shelf"),
            properties -> new ModShelfBlock(properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.SHELF)));

    public static final ObjectRegistries<Block> RED_SHRUB = ObjectRegistries.registerBlock(Constants.vanilla("red_shrub"),
            properties -> new ModBushBlock(properties.strength(0.2f).sound(ModSounds.RED_SHRUB.get()).noCollision().instabreak().pushReaction(PushReaction.DESTROY)));


    public static final ObjectRegistries<Block> SHELF_MUSHROOM = ObjectRegistries.registerBlock(Constants.vanilla("shelf_mushroom"),
            properties -> new ShelfMushroomBlock(properties.strength(1.0F).mapColor(MapColor.PLANT).sound(ModSounds.SHELF_MUSHROOM.get()).noOcclusion().pushReaction(PushReaction.DESTROY)));

    //Ice
    public static final ObjectRegistries<Block> ICICLE = ObjectRegistries.registerBlock(Constants.vanilla("icicle"),
            properties -> new IcicleBlock(Blocks.PACKED_ICE.defaultBlockState(), properties.mapColor(MapColor.COLOR_LIGHT_BLUE).forceSolidOn().instrument(NoteBlockInstrument.CHIME).noOcclusion().sound(ModSounds.ICICLE.get()).randomTicks().strength(0.5F, 0.5F).dynamicShape().pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::never).noOcclusion()));

    public static final ObjectRegistries<Block> ICE_CRYSTAL = ObjectRegistries.registerBlock(Constants.vanilla("ice_crystal"),
            properties -> new IceCrystalBlock(properties.mapColor(MapColor.ICE).sound(ModSounds.ICE_CRYSTAL.get()).instrument(NoteBlockInstrument.CHIME).strength(1.5F, 1.5F).lightLevel((state) -> 4).pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::never).noOcclusion()));

    public static final ObjectRegistries<Block> BRITTLE_ICE = ObjectRegistries.registerBlock(Constants.vanilla("brittle_ice"),
            properties-> new BrittleIceBlock(properties.mapColor(MapColor.ICE).friction(0.98F).strength(0.5F).sound(ModSounds.BRITTLE_ICE.get()).noOcclusion().instrument(NoteBlockInstrument.CHIME).isValidSpawn((state, blockGetter, blockPos, entityType) -> entityType == EntityType.POLAR_BEAR).isRedstoneConductor(Blocks::never).pushReaction(PushReaction.DESTROY)));

    public static final ObjectRegistries<Block> PACKED_ICE_BRICKS = ObjectRegistries.registerBlock(Constants.vanilla("packed_ice_bricks"),
            properties -> new Block(properties.mapColor(MapColor.ICE).instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().friction(0.6F).strength(0.5F).sound(ModSounds.PACKED_ICE.get())));

    public static final ObjectRegistries<Block> PACKED_ICE_BRICK_SLAB =
            registerCopy("packed_ice_brick_slab", PACKED_ICE_BRICKS, SlabBlock::new);

    public static final ObjectRegistries<Block> PACKED_ICE_BRICK_STAIRS =
            registerCopy("packed_ice_brick_stairs", PACKED_ICE_BRICKS,
                    properties -> new ModStairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), properties));

    public static final ObjectRegistries<Block> PACKED_ICE_BRICK_WALL =
            registerCopy("packed_ice_brick_wall", PACKED_ICE_BRICKS, WallBlock::new);

    public static final ObjectRegistries<Block> CHISELED_PACKED_ICE =
            registerCopy("chiseled_packed_ice", PACKED_ICE_BRICKS, Block::new);

    //Snow
    public static final ObjectRegistries<Block> SNOW_BRICKS = ObjectRegistries.registerBlock(Constants.vanilla("snow_bricks"),
            properties -> new Block(properties.mapColor(MapColor.SNOW).friction(0.6F).requiresCorrectToolForDrops().strength(0.6F).sound(SoundType.SNOW)));

    public static final ObjectRegistries<Block> SNOW_BRICK_SLAB = registerCopy("snow_brick_slab",SNOW_BRICKS, SlabBlock::new);

    public static final ObjectRegistries<Block> SNOW_BRICK_STAIRS = registerCopy("snow_brick_stairs",
            SNOW_BRICKS ,properties -> new ModStairBlock(SNOW_BRICKS.get().defaultBlockState(), properties));

    public static final ObjectRegistries<Block> SNOW_BRICK_WALL = registerCopy("snow_brick_wall", SNOW_BRICKS, WallBlock::new);

    //Calcite
    public static final ObjectRegistries<Block> CALCITE_SLAB = registerCopy("calcite_slab",Blocks.CALCITE, SlabBlock::new);

    public static final ObjectRegistries<Block> CALCITE_STAIRS = registerCopy("calcite_stairs",
            Blocks.CALCITE ,properties -> new ModStairBlock(Blocks.CALCITE.defaultBlockState(), properties));

    public static final ObjectRegistries<Block> CALCITE_WALL = registerCopy("calcite_wall", Blocks.CALCITE, WallBlock::new);



    public static final ObjectRegistries<Block> POLISHED_CALCITE = registerCopy("polished_calcite", Blocks.CALCITE, Block::new);

    public static final ObjectRegistries<Block> POLISHED_CALCITE_SLAB = registerCopy("polished_calcite_slab",POLISHED_CALCITE, SlabBlock::new);

    public static final ObjectRegistries<Block> POLISHED_CALCITE_STAIRS = registerCopy("polished_calcite_stairs",
            POLISHED_CALCITE ,properties -> new ModStairBlock(POLISHED_CALCITE.get().defaultBlockState(), properties));

    public static final ObjectRegistries<Block> POLISHED_CALCITE_WALL = registerCopy("polished_calcite_wall", POLISHED_CALCITE, WallBlock::new);

    public static final ObjectRegistries<Block> POLISHED_CALCITE_BRICKS = registerCopy("polished_calcite_bricks", Blocks.CALCITE, Block::new);

    public static final ObjectRegistries<Block> POLISHED_CALCITE_BRICK_SLAB = registerCopy("polished_calcite_brick_slab",POLISHED_CALCITE_BRICKS, SlabBlock::new);

    public static final ObjectRegistries<Block> POLISHED_CALCITE_BRICK_STAIRS = registerCopy("polished_calcite_brick_stairs",
            POLISHED_CALCITE_BRICKS ,properties -> new ModStairBlock(POLISHED_CALCITE_BRICKS.get().defaultBlockState(), properties));

    public static final ObjectRegistries<Block> POLISHED_CALCITE_BRICK_WALL = registerCopy("polished_calcite_brick_wall", POLISHED_CALCITE_BRICKS, WallBlock::new);

    public static final ObjectRegistries<Block> CALCITE_PILLAR = registerCopy("calcite_pillar", Blocks.CALCITE, RotatedPillarBlock::new);




    private static <T extends Block> ObjectRegistries<T> registerCopy(String name, Supplier<? extends Block> copyFrom,
                                                                      UnaryOperator<BlockBehaviour.Properties> tweak,
                                                                      Function<BlockBehaviour.Properties, T> function) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK,
                Identifier.fromNamespaceAndPath(Constants.NAMESPACE, name));

        ObjectRegistries<T> toReturn = ObjectRegistries.registerBlock(Constants.vanilla(name), ignored ->
                function.apply(tweak.apply(BlockBehaviour.Properties.ofFullCopy(copyFrom.get())).setId(key)));
        BLOCKS.add(toReturn);
        return toReturn;
    }

    private static <T extends Block> ObjectRegistries<T> registerCopy(String name, Supplier<? extends Block> copyFrom,
                                                                      Function<BlockBehaviour.Properties, T> function) {
        return registerCopy(name, copyFrom, UnaryOperator.identity(), function);
    }

    private static <T extends Block> ObjectRegistries<T> registerCopy(String name, Block copyFrom,
                                                                      Function<BlockBehaviour.Properties, T> function) {
        return registerCopy(name, () -> copyFrom, UnaryOperator.identity(), function);
    }

    public static void init() {
    }


    public static Block getWool(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_WOOL;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
            case GRAY -> Blocks.GRAY_WOOL;
            case BLACK -> Blocks.BLACK_WOOL;
            case BROWN -> Blocks.BROWN_WOOL;
            case RED -> Blocks.RED_WOOL;
            case ORANGE -> Blocks.ORANGE_WOOL;
            case YELLOW -> Blocks.YELLOW_WOOL;
            case LIME -> Blocks.LIME_WOOL;
            case GREEN -> Blocks.GREEN_WOOL;
            case CYAN -> Blocks.CYAN_WOOL;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
            case BLUE -> Blocks.BLUE_WOOL;
            case PURPLE -> Blocks.PURPLE_WOOL;
            case MAGENTA -> Blocks.MAGENTA_WOOL;
            case PINK -> Blocks.PINK_WOOL;
        };
    }

}
