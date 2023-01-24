package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class DeathclawblocbreakerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Math.random() < 0.2) {
			sx = -2;
			found = false;
			for (int index0 = 0; index0 < (int) (4); index0++) {
				sy = -2;
				for (int index1 = 0; index1 < (int) (4); index1++) {
					sz = -2;
					for (int index2 = 0; index2 < (int) (4); index2++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR
										.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.WIREFENCE
										.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.PLASTERSTAIRS
										.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL
										.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.PLASTERSLAB
										.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.WHITEFABRICBLOCKS.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))
										.getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASS_2.get()
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASS
										.get()) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (Math.random() < 0.05) {
				if (found == true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
									SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
									SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ASH, x, y, z, 8, 2, 5, 2, 0.1);
					FalloutWastelandsMod.queueServerWork(40, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ASH, x, y, z, 8, 3, 3, 3, 0.2);
						FalloutWastelandsMod.queueServerWork(20, () -> {
							world.destroyBlock(new BlockPos(x, y, z), false);
							world.levelEvent(2001, new BlockPos(x, y, z),
									Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
											SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z,
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
											SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					});
				}
			}
		}
	}
}
