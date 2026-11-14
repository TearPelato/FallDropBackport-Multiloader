package net.tearpelato.falldrop_backport.entity.renderer;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import net.tearpelato.falldrop_backport.entity.client.BabyFrostbiteModel;
import net.tearpelato.falldrop_backport.entity.client.FrostbiteModel;
import net.tearpelato.falldrop_backport.entity.client.FrostbiteOuterLayer;
import net.tearpelato.falldrop_backport.entity.client.ModModelLayerLocations;
import net.tearpelato.falldrop_backport.entity.client.custom.Frostbite;

public class FrostbiteRenderer extends AbstractZombieRenderer<Frostbite, ZombieRenderState, ZombieModel<ZombieRenderState>> {
    private static final Identifier FROSTBITE_LOCATION = Identifier.withDefaultNamespace("textures/entity/zombie/frostbite.png");
    private static final Identifier FROSTBITE_BABY_LOCATION = Identifier.withDefaultNamespace("textures/entity/zombie/frostbite_baby.png");

    public FrostbiteRenderer(final EntityRendererProvider.Context context) {
        super(context, new FrostbiteModel(context.bakeLayer(ModModelLayerLocations.FROSTBITE)), new BabyFrostbiteModel(context.bakeLayer(ModModelLayerLocations.FROSTBITE_BABY)), ArmorModelSet.bake(ModModelLayerLocations.FROSTBITE_ARMOR, context.getModelSet(), FrostbiteModel::new), ArmorModelSet.bake(ModModelLayerLocations.FROSTBITE_BABY_ARMOR, context.getModelSet(), BabyFrostbiteModel::new));
        this.addLayer(new FrostbiteOuterLayer(this, context.getModelSet()));
    }

    public ZombieRenderState createRenderState() {
        return new ZombieRenderState();
    }

    public Identifier getTextureLocation(final ZombieRenderState state) {
        return state.isBaby ? FROSTBITE_BABY_LOCATION : FROSTBITE_LOCATION;
    }
}