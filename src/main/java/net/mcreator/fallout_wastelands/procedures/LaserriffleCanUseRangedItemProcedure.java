package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;

public class LaserriffleCanUseRangedItemProcedure {
	public static boolean execute(ItemStack itemstack) {
		return (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") > 0
				&& itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) == true;
	}
}
