package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class RadawayPlayerFinishesUsingItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadawayPlayerFinishesUsingItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioacitvity <= 50) {
			{
				double _setval = ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioacitvity - 50);
				entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Radioacitvity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioacitvity > 50) {
			{
				double _setval = 50;
				entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Radioacitvity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
