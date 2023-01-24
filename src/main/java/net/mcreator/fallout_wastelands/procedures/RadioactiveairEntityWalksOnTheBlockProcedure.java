package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;

public class RadioactiveairEntityWalksOnTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge + 1;
			entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.radioactivity_gauge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
