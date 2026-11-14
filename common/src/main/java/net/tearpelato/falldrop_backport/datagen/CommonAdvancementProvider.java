package net.tearpelato.falldrop_backport.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.DamageSourcePredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.KilledTrigger;
import net.minecraft.advancements.criterion.TagPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.tearpelato.falldrop_backport.Constants;
import net.tearpelato.falldrop_backport.init.ModEntities;
import net.tearpelato.falldrop_backport.init.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CommonAdvancementProvider extends AdvancementProvider {
    public CommonAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new Advancements()));
    }

    public static class Advancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
            var entityTypes = provider.lookupOrThrow(Registries.ENTITY_TYPE);

            AdvancementHolder frostbite = Advancement.Builder.advancement()
                    .parent(Constants.vanilla("adventure/kill_a_mob"))
                    .display(ModItems.ICE_BALL.get(),
                            Component.translatable("advancements.adventure.what_goes_around_comes_around.title"),
                            Component.translatable("advancements.adventure.what_goes_around_comes_around.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("kill_a_frostbite_with_ice_ball",
                            KilledTrigger.TriggerInstance.playerKilledEntity(
                                    EntityPredicate.Builder.entity()
                                            .of(entityTypes, ModEntities.FROSTBITE.get()),
                                    DamageSourcePredicate.Builder.damageType()
                                            .tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                                            .direct(EntityPredicate.Builder.entity()
                                                    .of(entityTypes, ModEntities.ICE_BALL.get()))))
                                    .requirements(net.minecraft.advancements.AdvancementRequirements.Strategy.AND)
                                    .sendsTelemetryEvent()
                                    .save(consumer, "adventure/what_goes_around_comes_around");
        }
    }



}
