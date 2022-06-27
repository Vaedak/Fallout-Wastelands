package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.potion.TurretShakeActivatorPotionEffect;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;
import java.util.Collection;

public class MachinegunTurretEntityShakingConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure MachinegunTurretEntityShakingCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == TurretShakeActivatorPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) == true;
	}
}
