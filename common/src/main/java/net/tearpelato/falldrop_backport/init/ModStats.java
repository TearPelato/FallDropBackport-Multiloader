package net.tearpelato.falldrop_backport.init;

import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.falldrop_backport.Constants;

import java.util.function.Supplier;

public class ModStats {

    public static final Supplier<Identifier> SLEEP_IN_STRAW_BED = makeCustomStat("sleep_in_straw_bed");


    private static Supplier<Identifier> makeCustomStat(String key) {
        Identifier statIdentifier = Constants.vanilla(key);
        return ObjectRegistries.registerStat(statIdentifier, StatFormatter.DEFAULT);
    }

    public static void init() {}


}
