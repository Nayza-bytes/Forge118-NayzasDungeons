package net.nayza.nayzasdungeons.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.nayza.nayzasdungeons.NayzasDungeons;

public class ModTags {
    public static class Block {

        private static Tags.IOptionalNamedTag<net.minecraft.world.level.block.Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(NayzasDungeons.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<net.minecraft.world.level.block.Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(NayzasDungeons.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
