package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

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
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		if (entity.getPersistentData().getDouble("ShootingTimer") == 0) {
			if (entity instanceof LivingEntity) {
				LivingEntity _ent = (LivingEntity) entity;
				if (!_ent.world.isRemote()) {
					ThemachinegunItem.shoot(_ent.world, _ent, new Random(), 1, 5, 5);
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1 ~ ~ 0 0 0 force");
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:gun")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:gun")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			entity.getPersistentData().putDouble("ShootingTimer", 20);
			entity.getPersistentData().putBoolean("Shot", (true));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addPotionEffect(new EffectInstance(TurretShakeActivatorPotionEffect.potion, (int) 7, (int) 1, (false), (false)));
		}
		if (entity.getPersistentData().getDouble("ShootingTimer") > 0) {
			entity.getPersistentData().putDouble("ShootingTimer", (entity.getPersistentData().getDouble("ShootingTimer") - 1));
			if (entity.getPersistentData().getBoolean("Shot") == true) {
				entity.getPersistentData().putBoolean("Shot", (false));
			}
		}
	}

}
