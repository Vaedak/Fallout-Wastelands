package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class OpenedvaultblastdoorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")),
						SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), SoundSource.NEUTRAL,
						1, 1, false);
			}
		}
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.setBlock(new BlockPos(x, y, z), FalloutWastelandsModBlocks.VAULTBLASTDOOR.get().defaultBlockState(), 3);
		if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.OPENEDVAULTBLASTDOOR.get()) {
			world.setBlock(new BlockPos(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y, z), FalloutWastelandsModBlocks.VAULTBLASTDOOR.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.OPENEDVAULTBLASTDOOR.get()) {
			world.setBlock(new BlockPos(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y, z), FalloutWastelandsModBlocks.VAULTBLASTDOOR.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.OPENEDVAULTBLASTDOOR.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y, z - 1), FalloutWastelandsModBlocks.VAULTBLASTDOOR.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == FalloutWastelandsModBlocks.OPENEDVAULTBLASTDOOR.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y, z + 1), FalloutWastelandsModBlocks.VAULTBLASTDOOR.get().defaultBlockState(), 3);
		}
	}
}
