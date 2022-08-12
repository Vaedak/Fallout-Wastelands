package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.block.InvisiblelightsourceBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class CellinglightsPlayerStartsToDestroyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure CellinglightsPlayerStartsToDestroy!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure CellinglightsPlayerStartsToDestroy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure CellinglightsPlayerStartsToDestroy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure CellinglightsPlayerStartsToDestroy!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == InvisiblelightsourceBlock.block) {
			world.setBlockState(new BlockPos(x, y - 1, z), Blocks.AIR.getDefaultState(), 3);
			if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == InvisiblelightsourceBlock.block) {
				world.setBlockState(new BlockPos(x, y - 2, z), Blocks.AIR.getDefaultState(), 3);
				if ((world.getBlockState(new BlockPos(x, y - 3, z))).getBlock() == InvisiblelightsourceBlock.block) {
					world.setBlockState(new BlockPos(x, y - 3, z), Blocks.AIR.getDefaultState(), 3);
					if ((world.getBlockState(new BlockPos(x, y - 4, z))).getBlock() == InvisiblelightsourceBlock.block) {
						world.setBlockState(new BlockPos(x, y - 4, z), Blocks.AIR.getDefaultState(), 3);
					}
				}
			}
		}
	}
}
