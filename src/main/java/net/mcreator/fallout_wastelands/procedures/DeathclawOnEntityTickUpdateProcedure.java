<<<<<<< HEAD
package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class DeathclawOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 90) {
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y - 1, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y - 1, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y - 1), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y - 1), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y - 1, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y - 1), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y - 1, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y - 1), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y - 1, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y - 2, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y - 2, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y - 2), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y - 2), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y - 2, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y - 2), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y - 2, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y - 2), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y - 2, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x - 1, y, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x - 1, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x - 1), y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x - 1), y, z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x - 1, y, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x - 1), y, z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x - 1, y, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x - 1), y, z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x - 1, y, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x - 2, y, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x - 2, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x - 2), y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x - 2), y, z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x - 2, y, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x - 2), y, z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x - 2, y, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x - 2), y, z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x - 2, y, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y, z - 1), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z - 1),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, (z - 1),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, (z - 1), 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z - 1),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z - 1),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y, z - 1),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, y, (z - 1), 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y, z - 1), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y, z - 2), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z - 2),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, (z - 2),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, (z - 2), 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z - 2),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z - 2),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y, z - 2),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, y, (z - 2), 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y, z - 2), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y + 1, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 1, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y + 1), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y + 1, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y + 1, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y + 2, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 2, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 2), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y + 2), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 2, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y + 2), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y + 2, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y + 2), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y + 2, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x + 1, y, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x + 1, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 1), y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x + 1), y, z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x + 1, y, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 1), y, z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x + 1, y, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x + 1), y, z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x + 1, y, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x + 2, y, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x + 2, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 2), y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, (x + 2), y, z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x + 2, y, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 2), y, z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x + 2, y, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, (x + 2), y, z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x + 2, y, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y + 1, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 1, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y + 1), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y + 1, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y + 1, z), false);
						});
					});
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROOTTENWOODBARRICADE.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKS.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKFENCE.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSTAIRS.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENPLANKSSLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODBARRICADESLAB.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.PLASTERWALL.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.WASTELANDGLASSBLOCK.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.ROTTENWOODDOOR.get()) {
					world.levelEvent(2001, new BlockPos(x, y + 2, z), Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 2, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 2), z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
									SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, (y + 2), z, 30, 2, 2, 2, 0.5);
					FalloutWastelandsMod.queueServerWork(100, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 2, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, (y + 2), z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundSource.BLOCKS, 1, 1, false);
							}
						}
						world.levelEvent(2001, new BlockPos(x, y + 2, z),
								Block.getId(FalloutWastelandsModBlocks.ROTTENPLANKS.get().defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y + 2), z, 30, 2, 2, 2, 0.5);
						FalloutWastelandsMod.queueServerWork(100, () -> {
							world.destroyBlock(new BlockPos(x, y + 2, z), false);
						});
					});
				}
			}
		}
	}
}
=======
package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.block.WastelandglassblockBlock;
import net.mcreator.fallout_wastelands.block.RottenwooddoorBlock;
import net.mcreator.fallout_wastelands.block.RottenwoodbarricadeslabBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksstairsBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksslabBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksBlock;
import net.mcreator.fallout_wastelands.block.RottenplankfenceBlock;
import net.mcreator.fallout_wastelands.block.RoottenwoodbarricadeBlock;
import net.mcreator.fallout_wastelands.block.PlasterwallBlock;
import net.mcreator.fallout_wastelands.block.PlasterBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class DeathclawOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure DeathclawOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure DeathclawOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure DeathclawOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure DeathclawOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure DeathclawOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 90) {
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y - 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y - 1, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y - 1), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 1), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y - 1, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y - 1), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y - 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 1), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y - 1, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y - 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y - 2, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y - 2), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 2), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y - 2, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y - 2), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y - 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 2), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y - 2, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x - 1, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x - 1, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound((x - 1), y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x - 1), y, z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x - 1, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound((x - 1), y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x - 1, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x - 1), y, z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x - 1, y, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x - 2, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x - 2, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound((x - 2), y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x - 2), y, z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x - 2, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound((x - 2), y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x - 2, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x - 2), y, z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x - 2, y, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y, z - 1), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z - 1),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, (z - 1),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z - 1), (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z - 1),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, (z - 1),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y, z - 1), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z - 1), (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y, z - 1), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y, z - 2), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z - 2),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, (z - 2),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z - 2), (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z - 2),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, (z - 2),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y, z - 2), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z - 2), (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y, z - 2), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y + 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y + 1, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y + 1), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y + 1, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y + 1), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y + 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y + 1, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y + 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y + 2, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y + 2), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 2), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y + 2, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y + 2), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y + 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 2), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y + 2, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x + 1, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x + 1, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound((x + 1), y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x + 1), y, z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x + 1, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound((x + 1), y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x + 1, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x + 1), y, z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x + 1, y, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x + 2, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x + 2, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound((x + 2), y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x + 2), y, z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x + 2, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound((x + 2), y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x + 2, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x + 2), y, z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x + 2, y, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y + 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y + 1, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y + 1), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y + 1, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y + 1), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y + 1, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y + 1, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
			if (Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RoottenwoodbarricadeBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplankfenceBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksstairsBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenplanksslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenwoodbarricadeslabBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == PlasterBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == PlasterwallBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == WastelandglassblockBlock.block
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == RottenwooddoorBlock.block) {
					world.playEvent(2001, new BlockPos(x, y + 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y + 2, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, (y + 2), z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
								SoundCategory.BLOCKS, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 2), z, (int) 30, 2, 2, 2, 0.5);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y + 2, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, (y + 2), z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.zombie.break_wooden_door")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							world.playEvent(2001, new BlockPos(x, y + 2, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 2), z, (int) 30, 2, 2, 2, 0.5);
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									world.destroyBlock(new BlockPos(x, y + 2, z), false);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
				}
			}
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
