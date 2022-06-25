package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class PlasmarifleCanUseRangedItemProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure PlasmarifleCanUseRangedItem!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") > 0
				&& itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) == true;
	}
}
