package net.nayza.nayzasdungeons.item.custom;

import net.minecraft.world.entity.EquipmentSlot;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nayza.nayzasdungeons.NayzasDungeons;


public class PhantomSightGoggles extends ArmorItem {
    public PhantomSightGoggles(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    public static boolean applyGogglePhantomSightEffect = false;

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            NayzasDungeons.LOGGER.info("Updating on tick correctly | Value of applyGogglePhantomSightEffect: {}", applyGogglePhantomSightEffect);

             if(hasGogglesEquipped(player)) {
                applyGogglePhantomSightEffect = true;
            }
            else {
                applyGogglePhantomSightEffect = false;
            }
        }
    }

    public static boolean returnApplyGogglePhantomSightEffect() {
        return applyGogglePhantomSightEffect;
    }

    private boolean hasGogglesEquipped(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty();
    }
}
