package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;

public class MachinegunTurretEntityShakingConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof LivingEntity _livEnt
				? _livEnt.hasEffect(FalloutWastelandsModMobEffects.TURRET_SHAKE_ACTIVATOR.get())
				: false) == true;
	}
}
