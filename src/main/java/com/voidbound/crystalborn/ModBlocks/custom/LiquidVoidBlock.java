package com.voidbound.crystalborn.ModBlocks.custom;

import com.voidbound.crystalborn.ModBlocks.ModBlocks;
import com.voidbound.crystalborn.ModEffects.ModEffects;
import com.voidbound.crystalborn.ModFluids.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;


public class LiquidVoidBlock extends LiquidBlock {
    public LiquidVoidBlock() {
        super(() -> ModFluids.LIQUIDVOID.get(), BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BLACK).strength(100f).noCollission().noLootTable().liquid()
                .pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean moving) {
        super.neighborChanged(state, level, pos, block, fromPos, moving);

        if (!level.isClientSide) {
            // Check if water is touching this Void block
            for (Direction dir : Direction.values()) {
                BlockPos adjacentPos = pos.relative(dir);
                BlockState adjacentState = level.getBlockState(adjacentPos);


//                if (adjacentState.getFluidState().getType() == Fluids.WATER) {
//                    // Replace with hardened honeycomb
//                    level.setBlock(pos, ModBlocks.CRACKED_OBSIDIAN.get().defaultBlockState(), 3);
//                    level.levelEvent(2001, pos, Block.getId(adjacentState)); // play block break particles
//                    break;
//                }
            }
        }
    }
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (!level.isClientSide && entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(
                    ModEffects.VOIDCORRUPTION.get(),
                    400,
                    0,
                    false, false, true
            ));
        }
    }

}
