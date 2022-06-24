package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class CloseGUIProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure CloseGUI!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
