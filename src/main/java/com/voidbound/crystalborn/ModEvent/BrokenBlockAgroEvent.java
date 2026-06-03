package com.voidbound.crystalborn.ModEvent;

import com.voidbound.crystalborn.crystalborn;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = crystalborn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BrokenBlockAgroEvent extends Goal {
    private static final List<BrokenBlockAgroEvent> ACTIVE_GOALS = new ArrayList<>();

    private final Mob mob;
    private final Set<Block> watchedBlocks;
    private final double range;

    private static Block lastBrokenBlock = null;
    private static BlockPos lastBrokenPos = null;
    private static Player lastBreaker = null;

    public BrokenBlockAgroEvent(Mob mob, Set<Block> watchedBlocks, double range) {
        this.mob = mob;
        this.watchedBlocks = watchedBlocks;
        this.range = range;

        ACTIVE_GOALS.add(this);
    }



    @Override
    public boolean canUse() {
        if (mob instanceof TamableAnimal tam && tam.isTame()) {
            if (lastBreaker != null && tam.isOwnedBy(lastBreaker)) {
                return false;
            }
        }
        if (lastBrokenBlock == null || lastBreaker == null || lastBrokenPos == null)
            return false;

        if (!watchedBlocks.contains(lastBrokenBlock))
            return false;

        double dist = mob.distanceToSqr(
                lastBrokenPos.getX() + 0.5,
                lastBrokenPos.getY() + 0.5,
                lastBrokenPos.getZ() + 0.5
        );

        return dist <= (range * range);
    }

    @Override
    public boolean canContinueToUse() {
        if (mob.getTarget() == null)
            return false;

        if (mob.getTarget() != lastBreaker)
            return false;

        if (!lastBreaker.isAlive())
            return false;

        double dist = mob.distanceToSqr(
                lastBreaker.getX(),
                lastBreaker.getY(),
                lastBreaker.getZ()
        );

        return dist <= (range * range);
    }

    @Override
    public void stop() {
        if (mob.getTarget() == lastBreaker) {
            mob.setTarget(null);
        }
    }

    public void start() {
        if (mob instanceof TamableAnimal tam && tam.isTame()) {
            if (lastBreaker != null && tam.isOwnedBy(lastBreaker)) {
                mob.setTarget(null);
            }
        }
        if (lastBreaker != null) {
            mob.setTarget(lastBreaker);
            mob.getNavigation().moveTo(lastBreaker, 1.2);
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Level level = (Level) event.getLevel();
        if (level.isClientSide) return;

        lastBrokenBlock = event.getState().getBlock();
        lastBrokenPos = event.getPos();
        lastBreaker = event.getPlayer();
    }
}

