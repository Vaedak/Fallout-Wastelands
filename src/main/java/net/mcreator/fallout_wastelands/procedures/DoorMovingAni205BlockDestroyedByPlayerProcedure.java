package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class DoorMovingAni205BlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x - 3, y + 0, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FRAME.get()) {
			world.setBlock(new BlockPos(x - 3, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 3, y + 0, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FRAME.get()) {
			world.setBlock(new BlockPos(x + 3, y + 0, z + 1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x - 1, y + 0, z + 3))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FRAME.get()) {
			world.setBlock(new BlockPos(x - 1, y + 0, z + 3), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 1, y + 0, z - 3))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FRAME.get()) {
			world.setBlock(new BlockPos(x + 1, y + 0, z - 3), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
