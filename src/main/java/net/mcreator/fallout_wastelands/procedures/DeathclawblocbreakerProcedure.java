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
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.block.WirefenceBlock;
import net.mcreator.fallout_wastelands.block.WhitefabricblocksBlock;
import net.mcreator.fallout_wastelands.block.WastelandglassblockBlock;
import net.mcreator.fallout_wastelands.block.WastelandglassBlock;
import net.mcreator.fallout_wastelands.block.Wastelandglass2Block;
import net.mcreator.fallout_wastelands.block.RottenwooddoorBlock;
import net.mcreator.fallout_wastelands.block.RottenwoodbarricadeslabBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksstairsBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksslabBlock;
import net.mcreator.fallout_wastelands.block.RottenplanksBlock;
import net.mcreator.fallout_wastelands.block.RottenplankfenceBlock;
import net.mcreator.fallout_wastelands.block.RoottenwoodbarricadeBlock;
import net.mcreator.fallout_wastelands.block.PlasterwallBlock;
import net.mcreator.fallout_wastelands.block.PlasterstairsBlock;
import net.mcreator.fallout_wastelands.block.PlasterslabBlock;
import net.mcreator.fallout_wastelands.block.PlasterBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class DeathclawblocbreakerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure Deathclawblocbreaker!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure Deathclawblocbreaker!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure Deathclawblocbreaker!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure Deathclawblocbreaker!");
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
		if (Math.random() < 0.2) {
			sx = (-2);
			found = (false);
			for (int index0 = 0; index0 < (int) (4); index0++) {
				sy = (-2);
				for (int index1 = 0; index1 < (int) (4); index1++) {
					sz = (-2);
					for (int index2 = 0; index2 < (int) (4); index2++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenplanksBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenplanksstairsBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenplanksslabBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenplankfenceBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenwooddoorBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RoottenwoodbarricadeBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == RottenwoodbarricadeslabBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == WirefenceBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == PlasterBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == PlasterstairsBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == PlasterwallBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == PlasterslabBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == WhitefabricblocksBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == WastelandglassblockBlock.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Wastelandglass2Block.block
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == WastelandglassBlock.block) {
							found = (true);
						}
						sz = (sz + 1);
					}
					sy = (sy + 1);
				}
				sx = (sx + 1);
			}
			if (Math.random() < 0.05) {
				if (found == true) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.ASH, x, y, z, (int) 8, 2, 5, 2, 0.1);
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
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(ParticleTypes.ASH, x, y, z, (int) 8, 3, 3, 3, 0.2);
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
									world.destroyBlock(new BlockPos(x, y, z), false);
									world.playEvent(2001, new BlockPos(x, y, z), Block.getStateId(RottenplanksBlock.block.getDefaultState()));
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
				}
			}
		}
	}
}
