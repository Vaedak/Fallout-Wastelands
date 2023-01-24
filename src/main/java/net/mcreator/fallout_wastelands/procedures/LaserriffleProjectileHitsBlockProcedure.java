package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LaserriffleProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(new BlockPos(x, y, z)).getDestroySpeed(world, new BlockPos(x, y, z)) < 0.3) {
			world.destroyBlock(new BlockPos(x, y, z), false);
			world.levelEvent(2001, new BlockPos(x, y, z), Block.getId((world.getBlockState(new BlockPos(x, y, z)))));
		}
	}
}
