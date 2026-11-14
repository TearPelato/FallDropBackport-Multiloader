package net.tearpelato.falldrop_backport;


import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.init.*;

@Mod(Constants.MOD_ID)
public class FallDropBackport {

    public FallDropBackport(IEventBus eventBus) {
        ModCreativeTabs.init();
        ModItems.init();
        ModBlocks.init();
        ModBlockEntities.init();
        ModMobEffects.init();
        ModEntities.init();
        ModParticleTypes.init();
        ModTrunkPlacerTypes.init();
        ModFoliagePlacerTypes.init();
        ModTreeDecoratorType.init();
        ModStats.init();
        ModSounds.init();
        ModMapDecorationTypes.init();
        ModEntityDataSerializer.init();
        ModFeatures.init();
        ModMaterialConditions.init();



        eventBus.addListener(this::register);
        eventBus.addListener(this::commonSetup);
    }

    public void register(RegisterEvent event) {
        ObjectRegistries.createAll(Constants.NAMESPACE, event.getRegistry());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.RED_SHRUB.getId(), ModBlocks.RED_SHRUB_POTTED);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.POPLAR_SAPLING.getId(), ModBlocks.POPLAR_SAPLING_POTTED);
            ModBiomes.registerBiomes();
        });

    }

}
