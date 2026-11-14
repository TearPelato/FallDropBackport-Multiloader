package net.tearpelato.falldrop_backport;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.tearpelato.falldrop_backport.client.item.ExplorerMapItemModel;
import net.tearpelato.falldrop_backport.entity.client.CushionModel;
import net.tearpelato.falldrop_backport.entity.client.FrostbiteModel;
import net.tearpelato.falldrop_backport.entity.client.ModModelLayerLocations;
import net.tearpelato.falldrop_backport.entity.client.custom.Frostbite;
import net.tearpelato.falldrop_backport.entity.renderer.CushionRenderer;
import net.tearpelato.falldrop_backport.entity.renderer.FrostbiteRenderer;
import net.tearpelato.falldrop_backport.init.ModBlockEntities;
import net.tearpelato.falldrop_backport.init.ModEntities;
import net.tearpelato.falldrop_backport.init.ModParticleTypes;
import net.tearpelato.falldrop_backport.init.ModWoodType;
import net.tearpelato.falldrop_backport.particle.FreezingParticle;
import net.tearpelato.falldrop_backport.particle.PoplarParticles;

public class FallDropBackportClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExplorerMapItemModel.init();
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.POPLAR_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.POPLAR_CHEST_BOAT, BoatModel::createChestBoatModel);
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.CUSHION, CushionModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.FROSTBITE, FrostbiteModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.FROSTBITE_BABY, FrostbiteModel::createBabyLayer);
        ModelLayerRegistry.registerModelLayer(ModModelLayerLocations.FROSTBITE_OUTER_LAYER, FrostbiteModel::createOuterLayer);
        registerArmor(ModModelLayerLocations.FROSTBITE_ARMOR,
                HumanoidModel.createArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F)));

        registerArmor(ModModelLayerLocations.FROSTBITE_BABY_ARMOR,
                HumanoidModel.createBabyArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F), PartPose.ZERO));
        EntityRenderers.register(ModEntities.POPLAR_BOAT.get(), context -> new BoatRenderer(context, ModModelLayerLocations.POPLAR_BOAT));
        EntityRenderers.register(ModEntities.POPLAR_CHEST_BOAT.get(), context -> new BoatRenderer(context, ModModelLayerLocations.POPLAR_CHEST_BOAT));
        EntityRenderers.register(ModEntities.CUSHION.get(), CushionRenderer::new);
        EntityRenderers.register(ModEntities.ICE_BALL.get(), ThrownItemRenderer::new);
        EntityRenderers.register(ModEntities.FROSTBITE.get(), FrostbiteRenderer::new);


        ParticleProviderRegistry.getInstance().register(ModParticleTypes.RED_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        ParticleProviderRegistry.getInstance().register(ModParticleTypes.ORANGE_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        ParticleProviderRegistry.getInstance().register(ModParticleTypes.YELLOW_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        ParticleProviderRegistry.getInstance().register(ModParticleTypes.FREEZING.get(), FreezingParticle.Provider::new);

        BlockEntityRenderers.register(ModBlockEntities.SHELF.get(), ShelfRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.SIGN.get(), StandingSignRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);


        Sheets.createSignSprite(ModWoodType.POPLAR);
        Sheets.createHangingSignSprite(ModWoodType.POPLAR);

        FabricDefaultAttributeRegistry.register(ModEntities.FROSTBITE.get(), Frostbite.createAttributes());




    }

    private static void registerArmor(ArmorModelSet<ModelLayerLocation> locations,
                                      ArmorModelSet<MeshDefinition> meshes) {
        ModelLayerRegistry.registerModelLayer(locations.head(),  () -> LayerDefinition.create(meshes.head(),  64, 32));
        ModelLayerRegistry.registerModelLayer(locations.chest(), () -> LayerDefinition.create(meshes.chest(), 64, 32));
        ModelLayerRegistry.registerModelLayer(locations.legs(),  () -> LayerDefinition.create(meshes.legs(),  64, 32));
        ModelLayerRegistry.registerModelLayer(locations.feet(),  () -> LayerDefinition.create(meshes.feet(),  64, 32));
    }
}
