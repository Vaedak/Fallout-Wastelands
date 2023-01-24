package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class InvisiblelightsourceClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() > 0.9) {
			if ((((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.CELLINGLIGHTS
					.get()) != ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.CELLINGLIGHTS
							.get())) != (((world.getBlockState(new BlockPos(x, y + 3, z))).getBlock() == FalloutWastelandsModBlocks.CELLINGLIGHTS
									.get()) != ((world.getBlockState(new BlockPos(x, y + 4, z)))
											.getBlock() == FalloutWastelandsModBlocks.CELLINGLIGHTS.get()))) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
