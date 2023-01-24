package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;

public class MachinegunTurretOnEntityTickUpdatenewProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(FalloutWastelandsModMobEffects.RADIATION.get());
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.RADIOPROTECTION.get(), 10, 1, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 100, (false), (false)));
	}
}
