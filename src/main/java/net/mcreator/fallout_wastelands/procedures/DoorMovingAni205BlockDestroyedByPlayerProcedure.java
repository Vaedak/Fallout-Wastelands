package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.block.VaultDoorFrameBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class DoorMovingAni205BlockDestroyedByPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure DoorMovingAni205BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure DoorMovingAni205BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure DoorMovingAni205BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure DoorMovingAni205BlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 0), (int) (z - 1)))).getBlock() == VaultDoorFrameBlock.block)) {
			world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 0), (int) (z - 1)), Blocks.AIR.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 0), (int) (z + 1)))).getBlock() == VaultDoorFrameBlock.block)) {
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 0), (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 3)))).getBlock() == VaultDoorFrameBlock.block)) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 3)), Blocks.AIR.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 3)))).getBlock() == VaultDoorFrameBlock.block)) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 3)), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
