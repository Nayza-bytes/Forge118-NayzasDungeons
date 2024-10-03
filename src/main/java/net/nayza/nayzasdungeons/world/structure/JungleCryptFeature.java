package net.nayza.nayzasdungeons.world.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.JigsawFeature;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;

import java.util.Optional;

public class JungleCryptFeature extends StructureFeature<JigsawConfiguration> {
    public JungleCryptFeature(Codec<JigsawConfiguration> codec) {
        super(codec, JungleCryptFeature::generatePieces, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> generatePieces(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        if (!JungleCryptFeature.canGenerate(context)) {
            return Optional.empty();
        }

        ChunkPos chunkPos = context.chunkPos();
        int x = chunkPos.getMinBlockX();
        int z = chunkPos.getMinBlockZ();

        BlockPos blockPos = new BlockPos(x, context.chunkGenerator().getFirstFreeHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor()), z);

        return JigsawPlacement.addPieces(
                context,
                PoolElementStructurePiece::new,
                blockPos,
                false,
                true
        );
    }

    public static boolean canGenerate(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        return true;
    }
}
