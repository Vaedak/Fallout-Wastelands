package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;

public class RadxPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.RADIOPROTECTION.get(), 6000, 1, (false), (false)));
	}
}
