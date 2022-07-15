package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class RadiationUI23Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadiationUI23!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge > 2300
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).RADUIToggle == false) == true;
	}
}
