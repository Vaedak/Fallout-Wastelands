package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.Entity;

public class HighwaymantrunkThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("AddFuel", (false));
	}
}
