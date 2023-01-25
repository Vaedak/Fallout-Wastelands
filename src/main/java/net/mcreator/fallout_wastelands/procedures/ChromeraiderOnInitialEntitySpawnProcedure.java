<<<<<<< HEAD
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
=======
package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.block.WastelanddirtBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class ChromeraiderOnInitialEntitySpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure ChromeraiderOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure ChromeraiderOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure ChromeraiderOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure ChromeraiderOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure ChromeraiderOnInitialEntitySpawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.getLight(new BlockPos(x, y, z)) <= 1) {
			if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == WastelanddirtBlock.block)) {
				if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == WastelanddirtBlock.block)) {
					if (!entity.world.isRemote())
						entity.remove();
				}
			}
		}
		if (Math.random() < 0.7) {
			if (!entity.world.isRemote())
				entity.remove();
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
