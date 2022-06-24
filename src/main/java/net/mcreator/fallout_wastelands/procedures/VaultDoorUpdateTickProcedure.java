package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.block.VaultDoorFillerBlock;
import net.mcreator.fallout_wastelands.block.FillerPassableBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class VaultDoorUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure VaultDoorUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure VaultDoorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure VaultDoorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure VaultDoorUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.NORTH || (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.SOUTH) {
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
					if (((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR) == true) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 2, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x + 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x - 1, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2);
		}
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.WEST || (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.EAST) {
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
					if (((world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == VaultDoorFillerBlock.block
							|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FillerPassableBlock.block) == false) {
						world.setBlockState(new BlockPos(x, y + 1, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 2, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z - 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 1, z + 1), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos(x, y + 0, z - 1), Blocks.AIR.getDefaultState(), 3);
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
							world.destroyBlock(new BlockPos(x, y, z), false);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2);
		}
	}
}
