package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

<<<<<<< HEAD
<<<<<<< HEAD
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
=======
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

<<<<<<< HEAD
<<<<<<< HEAD
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;
import net.mcreator.fallout_wastelands.entity.RealTurretProjectileEntity;
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MachinegunTurretOnEntityTickUpdateProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

<<<<<<< HEAD
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof MachinegunTurretEntity == true) {
=======
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MachinegunTurretOnEntityTickUpdate!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof MachinegunTurretEntity.CustomEntity == true) {
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") == 0) {
<<<<<<< HEAD
<<<<<<< HEAD
				{
					Entity _shootFrom = sourceentity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new RealTurretProjectileEntity(
										FalloutWastelandsModEntities.REAL_TURRET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity, (float) 0.1, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
=======
				sourceentity.getPersistentData().putDouble("ShootingTimer", 10);
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======
				sourceentity.getPersistentData().putDouble("ShootingTimer", 10);
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
				{
					Entity _ent = sourceentity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
										_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
										_ent.getDisplayName(), _ent.level.getServer(), _ent),
								"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1.5 ~ ~ 0 0 0 force");
					}
				}
<<<<<<< HEAD
<<<<<<< HEAD
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:tenmmshot")), SoundSource.NEUTRAL, 1,
								1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:tenmmshot")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				sourceentity.getPersistentData().putDouble("ShootingTimer", 10);
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
			}
			if (sourceentity.getPersistentData().getDouble("ShootingTimer") > 0) {
				sourceentity.getPersistentData().putDouble("ShootingTimer", (sourceentity.getPersistentData().getDouble("ShootingTimer") - 1));
			}
		}
	}
}
