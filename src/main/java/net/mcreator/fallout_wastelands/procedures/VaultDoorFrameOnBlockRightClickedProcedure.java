package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.block.DoorMovingAni205Block;
import net.mcreator.fallout_wastelands.block.Closing204Block;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class VaultDoorFrameOnBlockRightClickedProcedure extends FalloutWastelandsModElements.ModElement {
	public VaultDoorFrameOnBlockRightClickedProcedure(FalloutWastelandsModElements instance) {
		super(instance, 1060);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure VaultDoorFrameOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure VaultDoorFrameOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure VaultDoorFrameOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure VaultDoorFrameOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			if ((((world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 0), (int) (z + 1)))).getBlock() == DoorMovingAni205Block.block
					.getDefaultState().getBlock()) == (true))) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)), Closing204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)), _bs.with(_property, Direction.NORTH), 3);
					} else {
						world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				world.setBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((new Object() {
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH)) {
			if ((((world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 0), (int) (z - 1)))).getBlock() == DoorMovingAni205Block.block
					.getDefaultState().getBlock()) == (true))) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 1)), Closing204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 1)));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 1)), _bs.with(_property, Direction.SOUTH), 3);
					} else {
						world.setBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 1)), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.SOUTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				world.setBlockState(new BlockPos((int) (x - 3), (int) y, (int) (z - 1)), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((new Object() {
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 3)))).getBlock() == DoorMovingAni205Block.block
					.getDefaultState().getBlock()) == (true))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 2)), Closing204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 2)));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 2)), _bs.with(_property, Direction.WEST), 3);
					} else {
						world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 2)), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 3)), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((new Object() {
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 3)))).getBlock() == DoorMovingAni205Block.block
					.getDefaultState().getBlock()) == (true))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 2)), Closing204Block.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 2)));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 2)), _bs.with(_property, Direction.EAST), 3);
					} else {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 2)), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 3)), Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
