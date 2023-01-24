package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LaserriffleRangedItemUsedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCountLaserRifle", (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") - 1));
				(itemstack).setDamageValue((int) ((itemstack).getDamageValue() + 100));
			}
		}
	}
}
