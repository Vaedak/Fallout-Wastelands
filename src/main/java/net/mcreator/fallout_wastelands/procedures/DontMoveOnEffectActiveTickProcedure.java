package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DontMoveOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure DontMoveOnEffectActiveTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.setMotion(0, 0, 0);
	}

}
