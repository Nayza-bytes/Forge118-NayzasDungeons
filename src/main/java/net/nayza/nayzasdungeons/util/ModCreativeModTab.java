package net.nayza.nayzasdungeons.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nayza.nayzasdungeons.block.ModBlocks;

public class ModCreativeModTab {
    public static final CreativeModeTab NAYZAS_DUNGEONS = new CreativeModeTab("nayzas_dungeons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.WRAITHSTONE_BRICK.get());
        }
    };

}
