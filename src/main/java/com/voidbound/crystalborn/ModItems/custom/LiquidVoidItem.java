package com.voidbound.crystalborn.ModItems.custom;

import com.voidbound.crystalborn.ModFluids.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

public class LiquidVoidItem extends BucketItem {
    public LiquidVoidItem() {
        super(ModFluids.LIQUIDVOID, new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }
}
