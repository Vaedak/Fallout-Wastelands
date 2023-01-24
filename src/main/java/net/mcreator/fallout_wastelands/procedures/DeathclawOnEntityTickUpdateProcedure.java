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
