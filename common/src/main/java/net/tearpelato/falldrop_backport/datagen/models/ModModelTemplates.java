package net.tearpelato.falldrop_backport.datagen.models;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ModModelTemplates {
    public static final ModelTemplate ICICLE = create("template_icicle",TextureSlot.CROSS);
    public static final ModelTemplate ICICLE_BASE= create("template_icicle_base",TextureSlot.CROSS, TextureSlot.TOP, TextureSlot.SIDE);

    private static ModelTemplate create(final String id, final TextureSlot... slots) {
        return new ModelTemplate(Optional.of(Identifier.withDefaultNamespace("block/" + id)), Optional.empty(), slots);
    }

}
