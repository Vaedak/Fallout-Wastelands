package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.potion.RadioprotectionPotionEffect;
import net.mcreator.fallout_wastelands.potion.RadiationPotionEffect;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class MachinegunTurretOnEntityTickUpdatenewProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure MachinegunTurretOnEntityTickUpdatenew!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, (entity.getMotion().getY()), 0);
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(RadiationPotionEffect.potion);
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(RadioprotectionPotionEffect.potion, (int) 10, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 40, (int) 100, (false), (false)));
	}
}
