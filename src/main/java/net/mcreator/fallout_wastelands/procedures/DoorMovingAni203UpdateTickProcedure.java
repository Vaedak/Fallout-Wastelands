package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.block.DoorMovingAni204Block;
import net.mcreator.fallout_wastelands.block.DoorMovingAni203Block;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class DoorMovingAni203UpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure DoorMovingAni203UpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure DoorMovingAni203UpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure DoorMovingAni203UpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure DoorMovingAni203UpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == DoorMovingAni203Block.block) {
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
					world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH) {
				world.setBlockState(new BlockPos(x + 1, y, z), DoorMovingAni204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x + 1, y, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x + 1, y, z), _bs.with(_property, Direction.NORTH), 3);
					} else {
						world.setBlockState(new BlockPos(x + 1, y, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.SOUTH) {
				world.setBlockState(new BlockPos(x - 1, y, z), DoorMovingAni204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x - 1, y, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x - 1, y, z), _bs.with(_property, Direction.SOUTH), 3);
					} else {
						world.setBlockState(new BlockPos(x - 1, y, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.SOUTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.WEST) {
				world.setBlockState(new BlockPos(x, y, z - 1), DoorMovingAni204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y, z - 1));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y, z - 1), _bs.with(_property, Direction.WEST), 3);
					} else {
						world.setBlockState(new BlockPos(x, y, z - 1), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.EAST) {
				world.setBlockState(new BlockPos(x, y, z + 1), DoorMovingAni204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y, z + 1));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y, z + 1), _bs.with(_property, Direction.EAST), 3);
					} else {
						world.setBlockState(new BlockPos(x, y, z + 1), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
			}
		}
	}
}
