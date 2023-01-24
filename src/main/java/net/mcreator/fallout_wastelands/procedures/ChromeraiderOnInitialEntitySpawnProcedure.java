package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class ChromeraiderOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) <= 1) {
			if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDDIRT.get())) {
				if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDDIRT.get())) {
					if (!entity.level.isClientSide())
						entity.discard();
				}
			}
		}
		if (Math.random() < 0.7) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
