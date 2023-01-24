package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class Xander5UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.07) {
			world.setBlock(new BlockPos(x, y, z), FalloutWastelandsModBlocks.XANDER.get().defaultBlockState(), 3);
		}
	}
}
