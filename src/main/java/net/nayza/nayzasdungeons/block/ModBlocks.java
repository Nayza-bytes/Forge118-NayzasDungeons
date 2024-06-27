package net.nayza.nayzasdungeons.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nayza.nayzasdungeons.NayzasDungeons;
import net.nayza.nayzasdungeons.item.ModItems;
import net.nayza.nayzasdungeons.util.ModCreativeModTab;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NayzasDungeons.MOD_ID);

    //BLOCKS
    public static final RegistryObject<Block> WRAITHSTONE = registerBlock("wraithstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.2f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> SMOOTH_WRAITHSTONE = registerBlock("smooth_wraithstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.2f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> SMOOTH_WRAITHSTONE_STAIRS = registerBlock("smooth_wraithstone_stairs", () -> new StairBlock(() -> ModBlocks.SMOOTH_WRAITHSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> SMOOTH_WRAITHSTONE_SLABS = registerBlock("smooth_wraithstone_slabs", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> SMOOTH_WRAITHSTONE_WALL = registerBlock("smooth_wraithstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_BRICK = registerBlock("wraithstone_brick", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.2f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_BRICK_STAIRS = registerBlock("wraithstone_brick_stairs", () -> new StairBlock(() -> ModBlocks.WRAITHSTONE_BRICK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_BRICK_SLABS = registerBlock("wraithstone_brick_slabs", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_TILE = registerBlock("wraithstone_tile", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.2f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_TILE_STAIRS = registerBlock("wraithstone_tile_stairs", () -> new StairBlock(() -> ModBlocks.WRAITHSTONE_TILE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> WRAITHSTONE_TILE_SLABS = registerBlock("wraithstone_tile_slabs", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);
    public static final RegistryObject<Block> CHISELED_WRAITHSTONE = registerBlock("chiseled_wraithstone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.2f, 6f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModTab.NAYZAS_DUNGEONS);






    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus);}
}
