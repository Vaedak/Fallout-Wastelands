package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class CellinglightsClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:neontest")), SoundSource.AMBIENT, 1,
						(float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:neontest")),
						SoundSource.AMBIENT, 1, (float) 0.5, false);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR) {
			world.setBlock(new BlockPos(x, y - 1, z), FalloutWastelandsModBlocks.INVISIBLELIGHTSOURCE.get().defaultBlockState(), 3);
			if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.AIR) {
				world.setBlock(new BlockPos(x, y - 2, z), FalloutWastelandsModBlocks.INVISIBLELIGHTSOURCE.get().defaultBlockState(), 3);
				if ((world.getBlockState(new BlockPos(x, y - 3, z))).getBlock() == Blocks.AIR) {
					world.setBlock(new BlockPos(x, y - 3, z), FalloutWastelandsModBlocks.INVISIBLELIGHTSOURCE.get().defaultBlockState(), 3);
					if ((world.getBlockState(new BlockPos(x, y - 4, z))).getBlock() == Blocks.AIR) {
						world.setBlock(new BlockPos(x, y - 4, z), FalloutWastelandsModBlocks.INVISIBLELIGHTSOURCE.get().defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
