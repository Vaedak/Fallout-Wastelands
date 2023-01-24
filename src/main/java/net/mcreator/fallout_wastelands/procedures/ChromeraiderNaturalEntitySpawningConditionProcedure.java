package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class ChromeraiderNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean canspawn = false;
		if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) <= 3
				&& !((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDDIRT.get())) {
			if (!entity.level.isClientSide())
				entity.discard();
			canspawn = false;
		}
		return canspawn;
	}
}
