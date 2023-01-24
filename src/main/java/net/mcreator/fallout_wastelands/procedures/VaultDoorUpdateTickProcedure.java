package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class VaultDoorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
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
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.NORTH || (new Object() {
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
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.SOUTH) {
			FalloutWastelandsMod.queueServerWork(2, () -> {
				if (((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR) == true) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			});
		}
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
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.WEST || (new Object() {
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
		}.getDirection(new BlockPos(x, y + 1, z))) == Direction.EAST) {
			FalloutWastelandsMod.queueServerWork(2, () -> {
				if (((world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.VAULT_DOOR_FILLER.get()
						|| (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == FalloutWastelandsModBlocks.FILLER_PASSABLE
								.get()) == false) {
					world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
					{
						BlockPos _pos = new BlockPos(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			});
		}
	}
}
