package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.block.InvisiblelightsourceBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class CellinglightsClientDisplayRandomTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure CellinglightsClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure CellinglightsClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure CellinglightsClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure CellinglightsClientDisplayRandomTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos(x, y, z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:neontest")),
					SoundCategory.AMBIENT, (float) 4, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:neontest")),
					SoundCategory.AMBIENT, (float) 4, (float) 1, false);
		}
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos(x, y - 1, z), InvisiblelightsourceBlock.block.getDefaultState(), 3);
			if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.AIR) {
				world.setBlockState(new BlockPos(x, y - 2, z), InvisiblelightsourceBlock.block.getDefaultState(), 3);
				if ((world.getBlockState(new BlockPos(x, y - 3, z))).getBlock() == Blocks.AIR) {
					world.setBlockState(new BlockPos(x, y - 3, z), InvisiblelightsourceBlock.block.getDefaultState(), 3);
					if ((world.getBlockState(new BlockPos(x, y - 4, z))).getBlock() == Blocks.AIR) {
						world.setBlockState(new BlockPos(x, y - 4, z), InvisiblelightsourceBlock.block.getDefaultState(), 3);
					}
				}
			}
		}
	}
}
