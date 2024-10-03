package net.nayza.nayzasdungeons.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nayza.nayzasdungeons.block.ModBlocks;
import net.nayza.nayzasdungeons.util.ModRessource.ResourceLocation;

public class ModCreativeModTab {
    public static final CreativeModeTab NAYZAS_DUNGEONS = new CreativeModeTab("nayzas_dungeons") {
        private ResourceLocation backgroundLocation;
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.WRAITHSTONE_BRICK.get());
        }


        public net.minecraft.resources.ResourceLocation getBackgroundImage(){
            if(backgroundLocation != null) return backgroundLocation;
            return new ResourceLocation("textures/gui/container/creative_inventory/tab_items.png");
        }

        private static final ResourceLocation MOD_CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
        public net.minecraft.resources.ResourceLocation getTabsImage() {
            return MOD_CREATIVE_INVENTORY_TABS;
        }


        public CreativeModeTab setBackgroundImage() {
            backgroundLocation = (ResourceLocation) getBackgroundImage();
            return this;
        }
    };

}
