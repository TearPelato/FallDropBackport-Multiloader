package net.tearpelato.falldrop_backport;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID)
public class FallDropBackportClient {

    public FallDropBackportClient() {

    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {

    }

}
