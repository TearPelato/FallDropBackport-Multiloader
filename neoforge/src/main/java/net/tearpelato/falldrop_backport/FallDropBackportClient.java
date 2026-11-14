package net.tearpelato.falldrop_backport;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.gui.map.IMapDecorationRenderer;
import net.neoforged.neoforge.client.gui.map.RegisterMapDecorationRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.tearpelato.falldrop_backport.client.item.ExplorerMapItemModel;
import net.tearpelato.falldrop_backport.entity.client.CushionModel;
import net.tearpelato.falldrop_backport.entity.client.FrostbiteModel;
import net.tearpelato.falldrop_backport.entity.client.ModModelLayerLocations;
import net.tearpelato.falldrop_backport.entity.client.custom.Frostbite;
import net.tearpelato.falldrop_backport.entity.renderer.CushionRenderer;
import net.tearpelato.falldrop_backport.entity.renderer.FrostbiteRenderer;
import net.tearpelato.falldrop_backport.init.ModBlockEntities;
import net.tearpelato.falldrop_backport.init.ModEntities;
import net.tearpelato.falldrop_backport.init.ModMapDecorationTypes;
import net.tearpelato.falldrop_backport.init.ModParticleTypes;
import net.tearpelato.falldrop_backport.particle.FreezingParticle;
import net.tearpelato.falldrop_backport.particle.PoplarParticles;

@EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID)
public class FallDropBackportClient {

    public FallDropBackportClient() {}

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        ExplorerMapItemModel.init();
        EntityRenderers.register(ModEntities.POPLAR_BOAT.get(), context -> new BoatRenderer(context, ModModelLayerLocations.POPLAR_BOAT));
        EntityRenderers.register(ModEntities.POPLAR_CHEST_BOAT.get(), context -> new BoatRenderer(context, ModModelLayerLocations.POPLAR_CHEST_BOAT));
        EntityRenderers.register(ModEntities.CUSHION.get(), CushionRenderer::new);
        EntityRenderers.register(ModEntities.ICE_BALL.get(), ThrownItemRenderer::new);
        EntityRenderers.register(ModEntities.FROSTBITE.get(), FrostbiteRenderer::new);

    }


    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SIGN.get(), StandingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SHELF.get(), ShelfRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayerLocations.POPLAR_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayerLocations.POPLAR_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayerLocations.CUSHION, CushionModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.FROSTBITE, FrostbiteModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.FROSTBITE_BABY, FrostbiteModel::createBabyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.FROSTBITE_OUTER_LAYER, FrostbiteModel::createOuterLayer);

        registerArmor(event, ModModelLayerLocations.FROSTBITE_ARMOR,
                HumanoidModel.createArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F)));

        registerArmor(event, ModModelLayerLocations.FROSTBITE_BABY_ARMOR,
                HumanoidModel.createBabyArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F), PartPose.ZERO));
    }

    private static void registerArmor(EntityRenderersEvent.RegisterLayerDefinitions event,
                                      ArmorModelSet<ModelLayerLocation> locations,
                                      ArmorModelSet<MeshDefinition> meshes) {
        event.registerLayerDefinition(locations.head(),  () ->  LayerDefinition.create(meshes.head(),  64, 32));
        event.registerLayerDefinition(locations.chest(), () -> LayerDefinition.create(meshes.chest(), 64, 32));
        event.registerLayerDefinition(locations.legs(),  () -> LayerDefinition.create(meshes.legs(),  64, 32));
        event.registerLayerDefinition(locations.feet(),  () -> LayerDefinition.create(meshes.feet(),  64, 32));
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticleTypes.RED_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        event.registerSpriteSet(ModParticleTypes.ORANGE_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        event.registerSpriteSet(ModParticleTypes.YELLOW_POPLAR_LEAVES.get(), PoplarParticles.PoplarProvider::new);
        event.registerSpriteSet(ModParticleTypes.FREEZING.get(), FreezingParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerMapDecorationRenderers(RegisterMapDecorationRenderersEvent event) {
        event.register(ModMapDecorationTypes.ABANDONED_CAMP.holder().value(), new IMapDecorationRenderer() {
            @Override
            public boolean render(MapRenderState.MapDecorationRenderState decorationRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, MapRenderState mapRenderState, TextureAtlas decorationSprites, boolean inItemFrame, int packedLight, int index) {

                return false;
            }
        });
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FROSTBITE.get(), Frostbite.createAttributes().build());
    }

}
