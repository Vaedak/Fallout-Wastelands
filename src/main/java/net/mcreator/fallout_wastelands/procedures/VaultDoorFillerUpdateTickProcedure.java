package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.block.VaultDoorBlock;
import net.mcreator.fallout_wastelands.block.PassableVaultDoorBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class VaultDoorFillerUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure VaultDoorFillerUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure VaultDoorFillerUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure VaultDoorFillerUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure VaultDoorFillerUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == PassableVaultDoorBlock.block) == false) {
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH || (new Object() {
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
				world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == VaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).getBlock() == PassableVaultDoorBlock.block
				|| (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == PassableVaultDoorBlock.block) == false) {
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
			}.getDirection(new BlockPos(x, y, z))) == Direction.WEST || (new Object() {
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
				world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
