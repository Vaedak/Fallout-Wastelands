package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class XanderrootRightClickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDDIRT.get()) {
			(itemstack).shrink(1);
			world.setBlock(new BlockPos(x, y + 1, z), FalloutWastelandsModBlocks.XANDER_1.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.FARMLAND) {
			(itemstack).shrink(1);
			world.setBlock(new BlockPos(x, y + 1, z), FalloutWastelandsModBlocks.XANDER_1.get().defaultBlockState(), 3);
		}
	}
}
