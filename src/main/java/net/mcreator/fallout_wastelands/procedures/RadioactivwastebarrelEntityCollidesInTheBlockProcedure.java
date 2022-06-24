package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class RadioactivwastebarrelEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadioactivwastebarrelEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
		entity.attackEntityFrom(DamageSource.IN_WALL, (float) 1);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 6000, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 6000, (int) 1));
	}
}
