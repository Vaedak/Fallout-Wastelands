package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;

public class FusionCoreItemIsDroppedByPlayerProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
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
