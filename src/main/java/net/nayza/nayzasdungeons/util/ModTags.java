package net.nayza.nayzasdungeons.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nayza.nayzasdungeons.NayzasDungeons;

public class ModTags {
    public static class Block {

        private static TagKey<net.minecraft.world.level.block.Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(NayzasDungeons.MOD_ID, name));
        }

        private static TagKey<net.minecraft.world.level.block.Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(NayzasDungeons.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
