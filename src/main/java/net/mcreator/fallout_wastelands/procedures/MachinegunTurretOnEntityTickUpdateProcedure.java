package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;
import java.util.HashMap;

public class MachinegunTurretOnEntityTickUpdateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
			LivingEntity entity = event.getTarget();
			LivingEntity sourceentity = event.getEntityLiving();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", sourceentity.getPosX());
			dependencies.put("y", sourceentity.getPosY());
			dependencies.put("z", sourceentity.getPosZ());
			dependencies.put("world", sourceentity.getEntityWorld());
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof MachinegunTurretEntity.CustomEntity == true) {
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") == 0) {
				sourceentity.getPersistentData().putDouble("ShootingTimer", 10);
				{
					Entity _ent = sourceentity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1.5 ~ ~ 0 0 0 force");
					}
				}
			}
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") > 0) {
				sourceentity.getPersistentData().putDouble("ShootingTimer", (sourceentity.getPersistentData().getDouble("ShootingTimer") - 1));
			}
		}
	}
}
