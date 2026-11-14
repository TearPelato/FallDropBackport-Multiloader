package net.tearpelato.falldrop_backport.init;

import net.minecraft.stats.StatFormatter;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tearpelato.craftcorelib.api.registry.StatRegistry;
import net.tearpelato.falldrop_backport.Constants;

public class ModStats {

    public static final StatRegistry SLEEP_IN_STRAW_BED = ObjectRegistries.registerStat(Constants.vanilla("sleep_in_straw_bed"), StatFormatter.DEFAULT);


    public static void init() {}


}
