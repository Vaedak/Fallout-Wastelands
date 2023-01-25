package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;

public class Radiation1UIProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
<<<<<<< HEAD
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge < 200
=======
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge > 100
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge < 200
				&& (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioactivity1 == false) == true;
	}
}
