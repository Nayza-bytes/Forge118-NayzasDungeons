package net.nayza.nayzasdungeons.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.nayzasdungeons.NayzasDungeons;
import net.nayza.nayzasdungeons.item.custom.PhantomSightGoggles;
import net.nayza.nayzasdungeons.util.ModCreativeModTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NayzasDungeons.MOD_ID);

    public static final RegistryObject<Item> PHANTOMSIGHT_GOGGLES = ITEMS.register("phantomsight_goggles", () -> new PhantomSightGoggles(ModArmorMaterial.PHANTOMSIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModTab.NAYZAS_DUNGEONS)));


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);}
}
