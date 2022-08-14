package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Showwork2WQC1Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure Showwork2WQC1!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(StrangeelectroniccardsItem.block))
				: false) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioacitvity >= 10) {
			}
		}
		{
			boolean _setval = (false);
			entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Radioactivity1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return (entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Radioactivity1 == false;
	}

}
