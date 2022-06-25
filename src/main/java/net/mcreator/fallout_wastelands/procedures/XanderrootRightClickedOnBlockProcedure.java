package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.block.Xander1Block;
import net.mcreator.fallout_wastelands.block.WastelanddirtBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class XanderrootRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure XanderrootRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure XanderrootRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure XanderrootRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure XanderrootRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure XanderrootRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == WastelanddirtBlock.block) {
			(itemstack).shrink((int) 1);
			world.setBlockState(new BlockPos(x, y + 1, z), Xander1Block.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.FARMLAND) {
			(itemstack).shrink((int) 1);
			world.setBlockState(new BlockPos(x, y + 1, z), Xander1Block.block.getDefaultState(), 3);
		}
	}
}
