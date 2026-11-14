package net.tearpelato.falldrop_backport.datagen;

import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.tearpelato.craftcorelib.api.datagen.CoreGenerator;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.block.custom.ShelfMushroomBlock;
import net.tearpelato.falldrop_backport.block.custom.core.porperties.ModBlockStateProperties;
import net.tearpelato.falldrop_backport.block.custom.core.porperties.SpeleothemThickness;
import net.tearpelato.falldrop_backport.datagen.models.ModModelTemplates;
import net.tearpelato.falldrop_backport.init.ModBlocks;
import net.tearpelato.falldrop_backport.init.ModItems;


public class CommonModelProvider extends CoreGenerator {

    public static final VariantMutator Z_ROT_180 = VariantMutator.Z_ROT.withValue(Quadrant.R180);

    public CommonModelProvider(Context context) {
        super(context);
    }
    
    @Override
    public void generate() {


        this.flatItem(ModItems.POPLAR_BOAT.get());
        this.flatItem(ModItems.POPLAR_CHEST_BOAT.get());
        this.flatItem(ModItems.WHITE_CUSHION.get());
        this.flatItem(ModItems.LIGHT_GRAY_CUSHION.get());
        this.flatItem(ModItems.GRAY_CUSHION.get());
        this.flatItem(ModItems.BLACK_CUSHION.get());
        this.flatItem(ModItems.BROWN_CUSHION.get());
        this.flatItem(ModItems.RED_CUSHION.get());
        this.flatItem(ModItems.ORANGE_CUSHION.get());
        this.flatItem(ModItems.YELLOW_CUSHION.get());
        this.flatItem(ModItems.LIME_CUSHION.get());
        this.flatItem(ModItems.GREEN_CUSHION.get());
        this.flatItem(ModItems.CYAN_CUSHION.get());
        this.flatItem(ModItems.LIGHT_BLUE_CUSHION.get());
        this.flatItem(ModItems.BLUE_CUSHION.get());
        this.flatItem(ModItems.PURPLE_CUSHION.get());
        this.flatItem(ModItems.MAGENTA_CUSHION.get());
        this.flatItem(ModItems.PINK_CUSHION.get());
        this.flatItem(ModItems.FLURRY_MUSIC_DISC.get());
        this.flatItem(ModItems.ICE_BALL.get());
        this.flatItem(ModBlocks.ICE_CRYSTAL.get().asItem());
        this.flatItem(ModItems.FROSTBITE_SPAWN_EGG.get());
        this.flatItem(ModBlocks.ICICLE.get().asItem());



        blockModels.family(Blocks.WHITE_WOOL)
                .stairs(ModBlocks.WHITE_WOOL_STAIRS.get())
                .slab(ModBlocks.WHITE_WOOL_SLAB.get());

        blockModels.family(Blocks.LIGHT_GRAY_WOOL)
                .stairs(ModBlocks.LIGHT_GRAY_WOOL_STAIRS.get())
                .slab(ModBlocks.LIGHT_GRAY_WOOL_SLAB.get());


        blockModels.family(Blocks.GRAY_WOOL)
                .stairs(ModBlocks.GRAY_WOOL_STAIRS.get())
                .slab(ModBlocks.GRAY_WOOL_SLAB.get());


        blockModels.family(Blocks.BLACK_WOOL)
                .stairs(ModBlocks.BLACK_WOOL_STAIRS.get())
                .slab(ModBlocks.BLACK_WOOL_SLAB.get());


        blockModels.family(Blocks.BROWN_WOOL)
                .stairs(ModBlocks.BROWN_WOOL_STAIRS.get())
                .slab(ModBlocks.BROWN_WOOL_SLAB.get());


        blockModels.family(Blocks.RED_WOOL)
                .stairs(ModBlocks.RED_WOOL_STAIRS.get())
                .slab(ModBlocks.RED_WOOL_SLAB.get());


        blockModels.family(Blocks.ORANGE_WOOL)
                .stairs(ModBlocks.ORANGE_WOOL_STAIRS.get())
                .slab(ModBlocks.ORANGE_WOOL_SLAB.get());


        blockModels.family(Blocks.YELLOW_WOOL)
                .stairs(ModBlocks.YELLOW_WOOL_STAIRS.get())
                .slab(ModBlocks.YELLOW_WOOL_SLAB.get());


        blockModels.family(Blocks.LIME_WOOL)
                .stairs(ModBlocks.LIME_WOOL_STAIRS.get())
                .slab(ModBlocks.LIME_WOOL_SLAB.get());


        blockModels.family(Blocks.GREEN_WOOL)
                .stairs(ModBlocks.GREEN_WOOL_STAIRS.get())
                .slab(ModBlocks.GREEN_WOOL_SLAB.get());


        blockModels.family(Blocks.CYAN_WOOL)
                .stairs(ModBlocks.CYAN_WOOL_STAIRS.get())
                .slab(ModBlocks.CYAN_WOOL_SLAB.get());


        blockModels.family(Blocks.LIGHT_BLUE_WOOL)
                .stairs(ModBlocks.LIGHT_BLUE_WOOL_STAIRS.get())
                .slab(ModBlocks.LIGHT_BLUE_WOOL_SLAB.get());


        blockModels.family(Blocks.BLUE_WOOL)
                .stairs(ModBlocks.BLUE_WOOL_STAIRS.get())
                .slab(ModBlocks.BLUE_WOOL_SLAB.get());


        blockModels.family(Blocks.PURPLE_WOOL)
                .stairs(ModBlocks.PURPLE_WOOL_STAIRS.get())
                .slab(ModBlocks.PURPLE_WOOL_SLAB.get());


        blockModels.family(Blocks.MAGENTA_WOOL)
                .stairs(ModBlocks.MAGENTA_WOOL_STAIRS.get())
                .slab(ModBlocks.MAGENTA_WOOL_SLAB.get());


        blockModels.family(Blocks.PINK_WOOL)
                .stairs(ModBlocks.PINK_WOOL_STAIRS.get())
                .slab(ModBlocks.PINK_WOOL_SLAB.get());

        blockModels.family(Blocks.WHITE_CONCRETE)
                .stairs(ModBlocks.WHITE_CONCRETE_STAIRS.get())
                .slab(ModBlocks.WHITE_CONCRETE_SLAB.get());

        blockModels.family(Blocks.LIGHT_GRAY_CONCRETE)
                .stairs(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get())
                .slab(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());


        blockModels.family(Blocks.GRAY_CONCRETE)
                .stairs(ModBlocks.GRAY_CONCRETE_STAIRS.get())
                .slab(ModBlocks.GRAY_CONCRETE_SLAB.get());


        blockModels.family(Blocks.BLACK_CONCRETE)
                .stairs(ModBlocks.BLACK_CONCRETE_STAIRS.get())
                .slab(ModBlocks.BLACK_CONCRETE_SLAB.get());


        blockModels.family(Blocks.BROWN_CONCRETE)
                .stairs(ModBlocks.BROWN_CONCRETE_STAIRS.get())
                .slab(ModBlocks.BROWN_CONCRETE_SLAB.get());


        blockModels.family(Blocks.RED_CONCRETE)
                .stairs(ModBlocks.RED_CONCRETE_STAIRS.get())
                .slab(ModBlocks.RED_CONCRETE_SLAB.get());


        blockModels.family(Blocks.ORANGE_CONCRETE)
                .stairs(ModBlocks.ORANGE_CONCRETE_STAIRS.get())
                .slab(ModBlocks.ORANGE_CONCRETE_SLAB.get());


        blockModels.family(Blocks.YELLOW_CONCRETE)
                .stairs(ModBlocks.YELLOW_CONCRETE_STAIRS.get())
                .slab(ModBlocks.YELLOW_CONCRETE_SLAB.get());


        blockModels.family(Blocks.LIME_CONCRETE)
                .stairs(ModBlocks.LIME_CONCRETE_STAIRS.get())
                .slab(ModBlocks.LIME_CONCRETE_SLAB.get());


        blockModels.family(Blocks.GREEN_CONCRETE)
                .stairs(ModBlocks.GREEN_CONCRETE_STAIRS.get())
                .slab(ModBlocks.GREEN_CONCRETE_SLAB.get());


        blockModels.family(Blocks.CYAN_CONCRETE)
                .stairs(ModBlocks.CYAN_CONCRETE_STAIRS.get())
                .slab(ModBlocks.CYAN_CONCRETE_SLAB.get());


        blockModels.family(Blocks.LIGHT_BLUE_CONCRETE)
                .stairs(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get())
                .slab(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());


        blockModels.family(Blocks.BLUE_CONCRETE)
                .stairs(ModBlocks.BLUE_CONCRETE_STAIRS.get())
                .slab(ModBlocks.BLUE_CONCRETE_SLAB.get());


        blockModels.family(Blocks.PURPLE_CONCRETE)
                .stairs(ModBlocks.PURPLE_CONCRETE_STAIRS.get())
                .slab(ModBlocks.PURPLE_CONCRETE_SLAB.get());


        blockModels.family(Blocks.MAGENTA_CONCRETE)
                .stairs(ModBlocks.MAGENTA_CONCRETE_STAIRS.get())
                .slab(ModBlocks.MAGENTA_CONCRETE_SLAB.get());


        blockModels.family(Blocks.PINK_CONCRETE)
                .stairs(ModBlocks.PINK_CONCRETE_STAIRS.get())
                .slab(ModBlocks.PINK_CONCRETE_SLAB.get());


        this.createBrittleIce();
        this.createIceCrystal();
        this.createIcicle();
        blockModels.createAxisAlignedPillarBlock(ModBlocks.CALCITE_PILLAR.get(), TexturedModel.COLUMN);
        blockModels.createTrivialCube(ModBlocks.CHISELED_PACKED_ICE.get());

        blockModels.woodProvider(ModBlocks.POPLAR_LOG.get()).logWithHorizontal(ModBlocks.POPLAR_LOG.get()).wood(ModBlocks.POPLAR_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_POPLAR_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_POPLAR_LOG.get()).wood(ModBlocks.STRIPPED_POPLAR_WOOD.get());
        blockModels.createTrivialBlock(ModBlocks.RED_POPLAR_LEAVES.get(), TexturedModel.LEAVES);
        blockModels.createTrivialBlock(ModBlocks.ORANGE_POPLAR_LEAVES.get(), TexturedModel.LEAVES);
        blockModels.createTrivialBlock(ModBlocks.YELLOW_POPLAR_LEAVES.get(), TexturedModel.LEAVES);
        blockModels.registerSimpleItemModel(ModBlocks.RED_POPLAR_LEAVES.get(),Constants.vanilla("block/red_poplar_leaves"));
        blockModels.registerSimpleItemModel(ModBlocks.ORANGE_POPLAR_LEAVES.get(),Constants.vanilla("block/orange_poplar_leaves"));
        blockModels.registerSimpleItemModel(ModBlocks.YELLOW_POPLAR_LEAVES.get(),Constants.vanilla("block/yellow_poplar_leaves"));
        blockModels.registerSimpleItemModel(ModBlocks.POPLAR_PLANKS.get(),Constants.vanilla("block/poplar_planks"));
        blockModels.registerSimpleItemModel(ModBlocks.POPLAR_PRESSURE_PLATE.get(),Constants.vanilla("block/poplar_pressure_plate"));
        blockModels.registerSimpleItemModel(ModBlocks.POPLAR_FENCE_GATE.get(),Constants.vanilla("block/poplar_fence_gate"));
        blockModels.registerSimpleItemModel(ModBlocks.SHELF_MUSHROOM.get(),Constants.vanilla("block/shelf_mushroom_stage0"));
        blockModels.registerSimpleItemModel(ModBlocks.POLISHED_CALCITE.get(),Constants.vanilla("block/polished_calcite"));
        blockModels.registerSimpleItemModel(ModBlocks.POLISHED_CALCITE_BRICKS.get(),Constants.vanilla("block/polished_calcite_bricks"));
        blockModels.registerSimpleItemModel(ModBlocks.CALCITE_PILLAR.get(),Constants.vanilla("block/calcite_pillar"));
        blockModels.registerSimpleItemModel(ModBlocks.SNOW_BRICKS.get(),Constants.vanilla("block/snow_bricks"));
        blockModels.registerSimpleItemModel(ModBlocks.PACKED_ICE_BRICKS.get(),Constants.vanilla("block/packed_ice_bricks"));
        blockModels.registerSimpleItemModel(ModBlocks.CHISELED_PACKED_ICE.get(),Constants.vanilla("block/chiseled_packed_ice"));


        blockModels.family(Blocks.CALCITE)
                .stairs(ModBlocks.CALCITE_STAIRS.get())
                .slab(ModBlocks.CALCITE_SLAB.get())
                .wall(ModBlocks.CALCITE_WALL.get());

        blockModels.family(ModBlocks.POPLAR_PLANKS.get()).generateFor(ModBlockFamilies.POPLAR_PLANKS);
        blockModels.family(ModBlocks.POLISHED_CALCITE.get()).generateFor(ModBlockFamilies.POLISHED_CALCITE);
        blockModels.family(ModBlocks.POLISHED_CALCITE_BRICKS.get()).generateFor(ModBlockFamilies.POLISHED_CALCITE_BRICKS);
        blockModels.family(ModBlocks.SNOW_BRICKS.get()).generateFor(ModBlockFamilies.SNOW_BRICKS);
        blockModels.family(ModBlocks.PACKED_ICE_BRICKS.get()).generateFor(ModBlockFamilies.PACKED_ICE_BRICKS);
        blockModels.createHangingSign(ModBlocks.POPLAR_PLANKS.get(), ModBlocks.POPLAR_HANGING_SIGN.get(), ModBlocks.POPLAR_WALL_HANGING_SIGN.get());

        blockModels.createPlantWithDefaultItem(ModBlocks.RED_SHRUB.get(), ModBlocks.RED_SHRUB_POTTED.get(), BlockModelGenerators.PlantType.TINTED);
        blockModels.createPlantWithDefaultItem(ModBlocks.POPLAR_SAPLING.get(), ModBlocks.POPLAR_SAPLING_POTTED.get(), BlockModelGenerators.PlantType.TINTED);

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.SHELF_MUSHROOM.get())
                        .with(PropertyDispatch.initial(ShelfMushroomBlock.AGE)
                                .select(0, BlockModelGenerators.plainVariant(Constants.vanilla("block/shelf_mushroom_stage0")))
                                .select(1, BlockModelGenerators.plainVariant(Constants.vanilla("block/shelf_mushroom_stage1"))))
                        .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
        blockModels.createShelf(ModBlocks.POPLAR_SHELF.get(), ModBlocks.STRIPPED_POPLAR_LOG.get());

    }

    private void createBrittleIce() {
        this.createCrackingIce(ModBlocks.BRITTLE_ICE.get());
        this.blockModels.registerSimpleItemModel(ModBlocks.BRITTLE_ICE.get(), ModelLocationUtils.getModelLocation(ModBlocks.BRITTLE_ICE.get(), "_0"));
    }

    private void createCrackingIce(final Block block) {
        this.blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.AGE_3).select(0, BlockModelGenerators.plainVariant(this.blockModels.createSuffixedVariant(block, "_0", ModelTemplates.CUBE_ALL, TextureMapping::cube))).select(1, BlockModelGenerators.plainVariant(this.blockModels.createSuffixedVariant(block, "_1", ModelTemplates.CUBE_ALL, TextureMapping::cube))).select(2, BlockModelGenerators.plainVariant(this.blockModels.createSuffixedVariant(block, "_2", ModelTemplates.CUBE_ALL, TextureMapping::cube))).select(3, BlockModelGenerators.plainVariant(this.blockModels.createSuffixedVariant(block, "_3", ModelTemplates.CUBE_ALL, TextureMapping::cube)))));
    }

    private void createIcicle() {
        Block block = ModBlocks.ICICLE.get();
        PropertyDispatch.C3 generator = PropertyDispatch.initial(BlockStateProperties.VERTICAL_DIRECTION, ModBlockStateProperties.SPELEOTHEM_THICKNESS, BlockStateProperties.ATTACHED);
        Material topTexture = TextureMapping.getBlockTexture(block, "_top");
        Material sideTexture = TextureMapping.getBlockTexture(block, "_side");

        for(SpeleothemThickness speleothemThickness : SpeleothemThickness.values()) {
            String thicknessSuffix = "_" + speleothemThickness.getSerializedName();
            Material thicknessTexture = TextureMapping.getBlockTexture(block, thicknessSuffix);
            TextureMapping mapping = TextureMapping.cross(thicknessTexture);
            TextureMapping baseMapping = (new TextureMapping()).put(TextureSlot.CROSS, thicknessTexture).put(TextureSlot.TOP, topTexture).put(TextureSlot.SIDE, sideTexture);
            Identifier icicleTemplate = ModModelTemplates.ICICLE.createWithSuffix(block, thicknessSuffix, mapping, this.blockModels.modelOutput);
            Identifier icicleBaseTemplate = ModModelTemplates.ICICLE_BASE.createWithSuffix(block, "_base" + thicknessSuffix, baseMapping, this.blockModels.modelOutput);
            generator.select(Direction.DOWN, speleothemThickness, false, BlockModelGenerators.plainVariant(icicleTemplate));
            generator.select(Direction.DOWN, speleothemThickness, true, BlockModelGenerators.plainVariant(icicleBaseTemplate).with(BlockModelGenerators.UV_LOCK));
            generator.select(Direction.UP, speleothemThickness, false, BlockModelGenerators.plainVariant(icicleTemplate).with(Z_ROT_180));
            generator.select(Direction.UP, speleothemThickness, true, BlockModelGenerators.plainVariant(icicleBaseTemplate).with(BlockModelGenerators.X_ROT_180));
        }

        this.blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(generator));
    }

    private void createIceCrystal() {
        this.createCrystalCluster(ModBlocks.ICE_CRYSTAL.get());
    }

    private void createCrystalCluster(final Block crytsalClusterBlock) {
        MultiVariant model = BlockModelGenerators.plainVariant(ModelTemplates.CROSS.create(crytsalClusterBlock, TextureMapping.cross(crytsalClusterBlock), this.blockModels.modelOutput));
        this.blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(crytsalClusterBlock, model).with(blockModels.ROTATIONS_COLUMN_WITH_FACING));
    }

}