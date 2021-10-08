package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.block.VaultDoorFrameBlock;
import net.mcreator.fallout_wastelands.block.PassableVaultDoorBlock;
import net.mcreator.fallout_wastelands.block.FillerPassableBlock;
import net.mcreator.fallout_wastelands.block.DoorMovingAni202Block;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class VaultDoorFrameUpdateTickProcedure extends FalloutWastelandsModElements.ModElement {
	public VaultDoorFrameUpdateTickProcedure(FalloutWastelandsModElements instance) {
		super(instance, 1051);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure VaultDoorFrameUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure VaultDoorFrameUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure VaultDoorFrameUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure VaultDoorFrameUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == VaultDoorFrameBlock.block.getDefaultState().getBlock())) {
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
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == DoorMovingAni202Block.block.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PassableVaultDoorBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), _bs.with(_property, Direction.NORTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.NORTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), _bs.with(_property, Direction.NORTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.NORTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), _bs.with(_property, Direction.NORTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.NORTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, Direction.NORTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.NORTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
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
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == DoorMovingAni202Block.block.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PassableVaultDoorBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
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
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == DoorMovingAni202Block.block.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PassableVaultDoorBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), _bs.with(_property, Direction.WEST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.WEST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), _bs.with(_property, Direction.WEST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.WEST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), _bs.with(_property, Direction.WEST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.WEST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, Direction.WEST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.WEST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
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
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == DoorMovingAni202Block.block.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), FillerPassableBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PassableVaultDoorBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FillerPassableBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), _bs.with(_property, Direction.EAST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.EAST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), _bs.with(_property, Direction.EAST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.EAST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), _bs.with(_property, Direction.EAST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.EAST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, Direction.EAST), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.EAST.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
				}
			}
		}
	}
}
