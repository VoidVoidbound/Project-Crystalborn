package com.voidbound.crystalborn.ModEntities.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class RandomFlyingGoal extends Goal {
    private final PathfinderMob mob;
    private final double speed;
    private int cooldown = 0;

    public RandomFlyingGoal(PathfinderMob mob, double speed) {
        this.mob = mob;
        this.speed = speed;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return cooldown-- <= 0;
    }

    @Override
    public boolean canContinueToUse() {
        return !mob.getNavigation().isDone();
    }

    @Override
    public void start() {
        Vec3 pos = AirAndWaterRandomPos.getPos(this.mob, 10, 7, 3, 3, 3, 2);
        if (pos != null) {
            this.mob.getNavigation().moveTo(pos.x, pos.y, pos.z, this.speed);
        }
    }

    @Override
    public void stop() {
        mob.getNavigation().stop();
    }
}
