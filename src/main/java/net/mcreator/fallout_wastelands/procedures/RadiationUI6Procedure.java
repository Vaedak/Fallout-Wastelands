package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class RadiationUI6Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadiationUI6!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge > 600
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge < 700
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).DisplayRadUI == false) == true;
	}
}
