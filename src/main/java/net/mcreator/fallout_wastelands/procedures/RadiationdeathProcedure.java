package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;

public class RadiationdeathProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).radioactivity_gauge >= 5000) {
			entity.hurt(DamageSource.GENERIC, 10000);
		}
	}
}
