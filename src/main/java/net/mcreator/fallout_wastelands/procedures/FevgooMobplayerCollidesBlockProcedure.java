package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.fallout_wastelands.entity.RangedsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.ClosecombatsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.BasesupermutantEntity;

public class FevgooMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BasesupermutantEntity) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		} else {
			if (!(entity instanceof BasesupermutantEntity)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 10));
			}
		}
		if (entity instanceof ClosecombatsupermutantEntity) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		} else {
			if (!(entity instanceof BasesupermutantEntity)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 10));
			}
		}
		if (entity instanceof RangedsupermutantEntity) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			if (!(entity instanceof BasesupermutantEntity)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 6000, 5));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 10));
			}
		}
	}
}
