package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.RealTurretProjectileItem;
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Random;
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof MachinegunTurretEntity.CustomEntity == true) {
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") == 0) {
				if (sourceentity instanceof LivingEntity) {
					LivingEntity _ent = (LivingEntity) sourceentity;
					if (!_ent.world.isRemote()) {
						RealTurretProjectileItem.shoot(_ent.world, _ent, new Random(), 4, (float) 0.1, 0);
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1.5 ~ ~ 0 0 0 force");
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world)
							.playSound(null, new BlockPos(x, y, z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("fallout_wastelands:tenmmshot")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("fallout_wastelands:tenmmshot")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				sourceentity.getPersistentData().putDouble("ShootingTimer", 10);
			}
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") > 0) {
				sourceentity.getPersistentData().putDouble("ShootingTimer", (sourceentity.getPersistentData().getDouble("ShootingTimer") - 1));
			}
		}
	}
}
