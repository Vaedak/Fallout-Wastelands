package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class RadioactiveairEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadioactiveairEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		{
			double _setval = ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge + 1);
			entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Radioacitvity = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

}
