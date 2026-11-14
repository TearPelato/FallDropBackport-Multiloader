package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;
import net.tearpelato.falldrop_backport.Constants;

public class ModJukeboxSongs {
    public static final ResourceKey<JukeboxSong> FLURRY = ResourceKey.create(Registries.JUKEBOX_SONG, Constants.vanilla("flurry"));


    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        context.register(FLURRY, new JukeboxSong(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(ModSounds.MUSIC_DISC_FLURRY.get()), Component.translatable("jukebox_song.minecraft.flurry"),154, 7));
    }

}
