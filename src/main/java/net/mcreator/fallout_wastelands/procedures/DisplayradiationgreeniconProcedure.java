package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DisplayradiationgreeniconProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure Displayradiationgreenicon!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		return ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge > 0
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).RADUIToggle == false) == true;
	}

}
