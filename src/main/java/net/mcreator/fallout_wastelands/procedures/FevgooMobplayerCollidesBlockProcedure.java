package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.entity.RangedsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.ClosecombatsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.BasesupermutantEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class FevgooMobplayerCollidesBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure FevgooMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof BasesupermutantEntity.CustomEntity) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
		} else {
			if (!(entity instanceof BasesupermutantEntity.CustomEntity)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 6000, (int) 10));
			}
		}
		if (entity instanceof ClosecombatsupermutantEntity.CustomEntity) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
		} else {
			if (!(entity instanceof BasesupermutantEntity.CustomEntity)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 6000, (int) 10));
			}
		}
		if (entity instanceof RangedsupermutantEntity.CustomEntity) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
			if (!(entity instanceof BasesupermutantEntity.CustomEntity)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 6000, (int) 5));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 6000, (int) 10));
			}
		}
	}
}
