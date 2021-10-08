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
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.block.VaultdooranimationCytokenisisBlock;
import net.mcreator.fallout_wastelands.block.Vaultanimation135Block;
import net.mcreator.fallout_wastelands.block.VaultDoorFrameBlock;
import net.mcreator.fallout_wastelands.block.DoorDirectionControllerBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class Vaultanimation135UpdateTickProcedure extends FalloutWastelandsModElements.ModElement {
	public Vaultanimation135UpdateTickProcedure(FalloutWastelandsModElements instance) {
		super(instance, 915);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure Vaultanimation135UpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure Vaultanimation135UpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure Vaultanimation135UpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure Vaultanimation135UpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Vaultanimation135Block.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), VaultDoorFrameBlock.block.getDefaultState(), 3);
		}
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, (new Object() {
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
				}.getDirection(new BlockPos((int) x, (int) (y - 1), (int) z)))), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), (new Object() {
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
						}.getDirection(new BlockPos((int) x, (int) (y - 1), (int) z))).getAxis()), 3);
			}
		} catch (Exception e) {
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), (World) world,
						new BlockPos((int) x, (int) y, (int) (z + 1)));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), VaultdooranimationCytokenisisBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), _bs.with(_property, Direction.NORTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), _bs.with(_property, Direction.NORTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), DoorDirectionControllerBlock.block.getDefaultState(), 3);
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
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), (World) world,
						new BlockPos((int) x, (int) y, (int) (z - 1)));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
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
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), VaultdooranimationCytokenisisBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), _bs.with(_property, Direction.SOUTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.SOUTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), DoorDirectionControllerBlock.block.getDefaultState(), 3);
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
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), (World) world,
						new BlockPos((int) (x + 1), (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
			}
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), VaultdooranimationCytokenisisBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), _bs.with(_property, Direction.WEST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), DoorDirectionControllerBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), _bs.with(_property, Direction.WEST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()),
							3);
				}
			} catch (Exception e) {
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
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), (World) world,
						new BlockPos((int) (x - 1), (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
			}
			world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), VaultdooranimationCytokenisisBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), _bs.with(_property, Direction.EAST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), DoorDirectionControllerBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), _bs.with(_property, Direction.EAST), 3);
				} else {
					world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
		}
	}
}
