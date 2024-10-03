package net.nayza.nayzasdungeons.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.nayza.nayzasdungeons.NayzasDungeons;
import net.nayza.nayzasdungeons.item.custom.PhantomSightGoggles;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class PhantomStoneBlock extends Block {

    public static final BooleanProperty HASPHANTOMSIGHTGOGGLESEFFECT = BooleanProperty.create("has_phantomsight_goggles_effect");

    public PhantomStoneBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HASPHANTOMSIGHTGOGGLESEFFECT, false));
    }

    public static void shouldBeTransparent(Level level, BlockState state, BlockPos pos) {
        if(!level.isClientSide()) {
            if(PhantomSightGoggles.returnApplyGogglePhantomSightEffect()) {
                boolean currentState = state.getValue(HASPHANTOMSIGHTGOGGLESEFFECT);
                level.setBlock(pos, state.setValue(HASPHANTOMSIGHTGOGGLESEFFECT, !currentState), 3);
            }
        }
    }

    @Override
    public void tick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull Random random) {
        shouldBeTransparent(pLevel, pState, pPos);
        NayzasDungeons.LOGGER.info("Updating blockstate property of phantomstone | Current Value {}", pState.getValue(HASPHANTOMSIGHTGOGGLESEFFECT));

        if(!pState.getValue(HASPHANTOMSIGHTGOGGLESEFFECT)) {
            properties.noCollission();
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HASPHANTOMSIGHTGOGGLESEFFECT);
    }
}
