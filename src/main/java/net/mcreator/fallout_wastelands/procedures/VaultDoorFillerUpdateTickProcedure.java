package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public class VaultDoorFillerUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR
						.get()) == false) {
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH || (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.SOUTH) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR.get()
				|| (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == FalloutWastelandsModBlocks.PASSABLE_VAULT_DOOR
						.get()) == false) {
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.WEST || (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))) == Direction.EAST) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
