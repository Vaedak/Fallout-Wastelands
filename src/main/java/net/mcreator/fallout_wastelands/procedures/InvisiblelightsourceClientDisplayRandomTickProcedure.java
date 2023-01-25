<<<<<<< HEAD
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
=======
package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.block.CellinglightsBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class InvisiblelightsourceClientDisplayRandomTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure InvisiblelightsourceClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure InvisiblelightsourceClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure InvisiblelightsourceClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure InvisiblelightsourceClientDisplayRandomTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() > 0.9) {
			if ((((world.getBlockState(new BlockPos(x, y + 1, z)))
					.getBlock() == CellinglightsBlock.block) != ((world.getBlockState(new BlockPos(x, y + 2, z)))
							.getBlock() == CellinglightsBlock.block)) != (((world.getBlockState(new BlockPos(x, y + 3, z)))
									.getBlock() == CellinglightsBlock.block) != ((world.getBlockState(new BlockPos(x, y + 4, z)))
											.getBlock() == CellinglightsBlock.block))) {
				world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
