package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class HighwaymanFuelUseTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure HighwaymanFuelUseTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.getPersistentData().getDouble("Fuel") == 0 || entity.isBeingRidden() == false) {
			entity.rotationYaw = (float) ((entity.rotationYaw));
			entity.setRenderYawOffset(entity.rotationYaw);
			entity.prevRotationYaw = entity.rotationYaw;
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
				((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
				((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
			}
			entity.rotationPitch = (float) ((entity.rotationPitch));
			entity.setMotion(0, (-1), 0);
		}
		if (entity.getPersistentData().getDouble("Timer") > 0) {
			entity.getPersistentData().putDouble("Timer", (entity.getPersistentData().getDouble("Timer") - 1));
		}
		if (entity.isBeingRidden()) {
			if (entity.getPersistentData().getDouble("Fuel") > 0) {
				if (entity.getPersistentData().getDouble("Timer") == 0) {
					entity.getPersistentData().putDouble("Timer", 50);
					if (entity.getPersistentData().getDouble("Fuel") > 0) {
						entity.getPersistentData().putDouble("Fuel", (entity.getPersistentData().getDouble("Fuel") - 1));
					}
				}
			}
		}
	}
}
