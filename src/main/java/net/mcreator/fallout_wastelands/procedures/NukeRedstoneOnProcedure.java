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
