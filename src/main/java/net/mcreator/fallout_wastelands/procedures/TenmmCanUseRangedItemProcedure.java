package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;

public class TenmmCanUseRangedItemProcedure {
	public static boolean execute(ItemStack itemstack) {
		return (itemstack.getOrCreateTag().getDouble("BulletCount") > 0 && itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) == true;
	}
}
