package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ThemachinegunCanUseRangedItemProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThemachinegunCanUseRangedItem!");
			return false;
		}

		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		return (itemstack.getOrCreateTag().getDouble("BulletCounter") > 0 && itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) == true;
	}

}
