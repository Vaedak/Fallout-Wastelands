package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class HighwaymantrunkThisGUIIsOpenedProcedure extends FalloutWastelandsModElements.ModElement {
	public HighwaymantrunkThisGUIIsOpenedProcedure(FalloutWastelandsModElements instance) {
		super(instance, 580);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure HighwaymantrunkThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("AddFuel", (false));
	}
}
