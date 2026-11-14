package net.tearpelato.falldrop_backport;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tearpelato.craftcorelib.api.datagen.CraftCoreModelGenerator;
import net.tearpelato.falldrop_backport.datagen.*;
import net.tearpelato.falldrop_backport.datagen.villager.CommonVillagerTradesTagsProvider;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class FallDropBackportDatagen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();


        generator.addProvider(true, new CraftCoreModelGenerator(packOutput, Constants.MOD_ID).add(CommonModelProvider::new));
        generator.addProvider(true, new CommonRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(NeoForgeLootProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(true, new NeoForgeDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new CommonBlockTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new CommonItemTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new NeoForgeDataMapsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new CommonBiomeTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new NeoForgeSoundProvider(packOutput));
        generator.addProvider(true, new CommonVillagerTradesTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new CommonAdvancementProvider(packOutput,lookupProvider));


    }
}
