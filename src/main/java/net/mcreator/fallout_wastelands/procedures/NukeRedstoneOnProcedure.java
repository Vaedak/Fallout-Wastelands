<<<<<<< HEAD
package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class NukeRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < (int) (15); index0++) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 60, Explosion.BlockInteraction.BREAK);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, (y + 30), z, 70, Explosion.BlockInteraction.DESTROY);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, (y + 10), z, 10, Explosion.BlockInteraction.DESTROY);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x + Math.random() * 15), (y + 30), (z + Math.random() * 15), 70, Explosion.BlockInteraction.DESTROY);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x - Math.random() * 15), (y + 30), (z - Math.random() * 15), 70, Explosion.BlockInteraction.DESTROY);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x + Math.random() * 30), (y + 30), (z - Math.random() * 30), 70, Explosion.BlockInteraction.DESTROY);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x - Math.random() * 30), (y + 30), (z + Math.random() * 30), 70, Explosion.BlockInteraction.DESTROY);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x - Math.random() * 15), (y + 20), (z + 1), 150, 15, 5, 15, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FALLING_LAVA, (x - Math.random() * 15), (y + 20), (z + 1), 150, 15, 5, 15, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, (x - Math.random() * 15), (y + 20), (z + 1), 150, 15, 5, 15, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DRIPPING_LAVA, (x - Math.random() * 15), (y + 20), (z + 1), 150, 15, 5, 15, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (x - 1), (y + 10), (z + 1), 150, 15, 5, 15, 1);
		}
	}
}
=======
package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class NukeRedstoneOnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure NukeRedstoneOn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure NukeRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure NukeRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure NukeRedstoneOn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		for (int index0 = 0; index0 < (int) (30); index0++) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 60, Explosion.Mode.BREAK);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) (y + 30), (int) z, (float) 70, Explosion.Mode.DESTROY);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) (y + 10), (int) z, (float) 10, Explosion.Mode.DESTROY);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (x + Math.random() * 15), (int) (y + 30), (int) (z + Math.random() * 15), (float) 70,
						Explosion.Mode.DESTROY);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (x - Math.random() * 15), (int) (y + 30), (int) (z - Math.random() * 15), (float) 70,
						Explosion.Mode.DESTROY);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (x + Math.random() * 30), (int) (y + 30), (int) (z - Math.random() * 30), (float) 70,
						Explosion.Mode.DESTROY);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (x - Math.random() * 30), (int) (y + 30), (int) (z + Math.random() * 30), (float) 70,
						Explosion.Mode.DESTROY);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, (x - Math.random() * 15), (y + 20), (z + 1), (int) 150, 15, 5, 15, 0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FALLING_LAVA, (x - Math.random() * 15), (y + 20), (z + 1), (int) 150, 15, 5, 15, 0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, (x - Math.random() * 15), (y + 20), (z + 1), (int) 150, 15, 5, 15, 0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.DRIPPING_LAVA, (x - Math.random() * 15), (y + 20), (z + 1), (int) 150, 15, 5, 15,
						0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, (x - 1), (y + 10), (z + 1), (int) 150, 15, 5, 15, 1);
			}
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
