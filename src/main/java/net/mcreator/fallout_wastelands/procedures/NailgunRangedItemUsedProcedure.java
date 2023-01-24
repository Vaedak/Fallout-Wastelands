package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class NailgunRangedItemUsedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 2);
		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCount") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCount", (itemstack.getOrCreateTag().getDouble("BulletCount") - 1));
				(itemstack).setDamageValue((int) ((itemstack).getDamageValue() + 100));
			}
		}
	}
}
