package com.nommables.platinumdustplease.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomBowItem extends BowItem {
    public CustomBowItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        //super.shoot(level, shooter, hand, weapon, projectileItems, velocity, inaccuracy, isCrit, target);

        AbstractArrow arrow = ProjectileUtil.getMobArrow(shooter, projectileItems.get(0), velocity, weapon);

        arrow.setBaseDamage(1.0D);
        arrow.setCritArrow(isCrit);

        // Aim the arrow properly
        arrow.shootFromRotation(
                shooter,
                shooter.getXRot(),   // pitch
                shooter.getYRot(),   // yaw
                0.0F,                // roll
                velocity,            // speed
                inaccuracy           // inaccuracy
        );

        level.addFreshEntity(arrow);

        weapon.hurtAndBreak(1, shooter, LivingEntity.getSlotForHand(hand));
    }

}
