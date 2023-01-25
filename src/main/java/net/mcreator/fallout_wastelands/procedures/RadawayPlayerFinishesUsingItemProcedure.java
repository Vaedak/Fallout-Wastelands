package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;

public class RadawayPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
<<<<<<< HEAD
		{
			double _setval = (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge - 250;
			entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.radioactivity_gauge = _setval;
				capability.syncPlayerVariables(entity);
			});
=======
		}
		Entity entity = (Entity) dependencies.get("entity");
		for (int index0 = 0; index0 < (int) (250); index0++) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge > 0) {
				{
					double _setval = ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge - 1);
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.radioactivity_gauge = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
		}
	}
}
