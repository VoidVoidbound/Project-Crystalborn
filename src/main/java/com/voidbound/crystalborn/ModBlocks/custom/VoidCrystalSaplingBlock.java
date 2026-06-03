package com.voidbound.crystalborn.ModBlocks.custom;

import com.voidbound.crystalborn.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class VoidCrystalSaplingBlock extends SaplingBlock {

    public VoidCrystalSaplingBlock(AbstractTreeGrower grower, Properties props) {
        super(grower, props);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ModTags.Blocks.SAPLING_CAN_PLACE_ON)
                || super.mayPlaceOn(state, level, pos);
    }
}

