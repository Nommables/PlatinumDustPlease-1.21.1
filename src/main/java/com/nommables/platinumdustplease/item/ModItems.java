package com.nommables.platinumdustplease.item;

import com.nommables.platinumdustplease.PlatinumDustPlease;
import com.nommables.platinumdustplease.item.custom.CustomBowItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PlatinumDustPlease.MOD_ID);

    public static final DeferredItem<Item> PLATINUM_DUST = ITEMS.register("platinum_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<BowItem> CRUDE_BOW = ITEMS.register("crude_bow",
            () -> new CustomBowItem(new Item.Properties()
                    .durability(100)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
