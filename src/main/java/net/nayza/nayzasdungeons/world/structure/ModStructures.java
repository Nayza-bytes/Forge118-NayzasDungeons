package net.nayza.nayzasdungeons.world.structure;

import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.nayzasdungeons.NayzasDungeons;

public class ModStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTERY_STRUCTURE
            = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, NayzasDungeons.MOD_ID);

   public static final RegistryObject<StructureFeature<JigsawConfiguration>> DUNGEONS_STRUCTURE
            = DEFERRED_REGISTERY_STRUCTURE.register("dungeons_structure", () -> new JungleCryptFeature(JigsawConfiguration.CODEC));


    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTERY_STRUCTURE.register(eventBus);
    }
}
