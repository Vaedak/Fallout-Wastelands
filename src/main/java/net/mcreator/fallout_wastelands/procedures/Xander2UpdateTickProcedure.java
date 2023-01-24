package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class Xander2UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double RandomNumber = 0;
		if (Math.random() < 0.07) {
			world.setBlock(new BlockPos(x, y, z), FalloutWastelandsModBlocks.XANDER_3.get().defaultBlockState(), 3);
		}
	}
}
