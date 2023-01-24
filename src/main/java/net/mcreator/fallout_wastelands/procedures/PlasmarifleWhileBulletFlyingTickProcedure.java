package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModParticleTypes;

public class PlasmarifleWhileBulletFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (FalloutWastelandsModParticleTypes.PLASMA.get()), x, y, z, 0, 1, 0);
	}
}
