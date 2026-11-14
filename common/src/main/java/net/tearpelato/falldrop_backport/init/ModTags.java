package net.tearpelato.falldrop_backport.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tearpelato.falldrop_backport.Constants;

public class ModTags {

    public static class Blocks{

        public static final TagKey<Block> CUSHION_USES_COLLISION_SHAPE = createTag("cushrion_uses_collision_shape");
        public static final TagKey<Block> SPELEOTHEMS = createTag("speleothems");
        public static final TagKey<Block> MELTS_ICICLE_ABOVE = createTag("melt_icicle_above");
        public static final TagKey<Block> ICE_CREVASSE_REPLACEABLES = createTag("ice_crevases_replaceables");
        public static final TagKey<Block> LARGE_ICICLE_REPLACEABLE = createTag("large_icicle_replaceables");
        public static final TagKey<Block> ICE_CAVE_ORE_REPLACEABLES = createTag("ice_cave_ore_replaceables");
        public static final TagKey<Block> BLOCKS_FLUID_FLOW = createTag("blocks_fluid_flow");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK,Constants.vanilla(name));
        }
    }


    public static class Items{

        public static final TagKey<Item> POPLAR_LOGS = createTag("poplar_logs");
        public static final TagKey<Item> WOOL_SET = createTag("wool_set");
        public static final TagKey<Item> FROSTBITE_PREFERRED_WEAPONS = createTag("frostbite_preferred_weapons");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM,Constants.vanilla(name));
        }
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> DOES_NOT_BREAK_BRITTLE_ICE = createTag("does_not_break_brittle_ice");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE,Constants.vanilla(name));
        }
    }

}
