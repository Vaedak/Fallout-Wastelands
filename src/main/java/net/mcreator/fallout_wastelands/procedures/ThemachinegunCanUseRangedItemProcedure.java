package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;

public class ThemachinegunCanUseRangedItemProcedure {
	public static boolean execute(ItemStack itemstack) {
		return (itemstack.getOrCreateTag().getDouble("BulletCounter") > 0 && itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) == true;
	}
}
