package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FusionCoreItemIsDroppedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure FusionCoreItemIsDroppedByPlayer!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure FusionCoreItemIsDroppedByPlayer!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		entity.getPersistentData().putBoolean("coreassigned", (false));
		itemstack.getOrCreateTag().putBoolean("CoreInUse", (false));
		{
			double _setval = 0;
			entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Power = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

}
