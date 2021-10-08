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
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class DoorMovingAni205UpdateTickProcedure extends FalloutWastelandsModElements.ModElement {
	public DoorMovingAni205UpdateTickProcedure(FalloutWastelandsModElements instance) {
		super(instance, 1059);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure DoorMovingAni205UpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure DoorMovingAni205UpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure DoorMovingAni205UpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure DoorMovingAni205UpdateTick!");
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
			if (((((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 1), (int) (z - 1)))).getBlock() == VaultDoorBlock.block
					.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 1), (int) (z - 1)))).getBlock() == PassableVaultDoorBlock.block
							.getDefaultState().getBlock())) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
			if (((((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 1), (int) (z + 1)))).getBlock() == VaultDoorBlock.block
					.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 1), (int) (z + 1)))).getBlock() == PassableVaultDoorBlock.block
							.getDefaultState().getBlock())) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
			if (((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 3)))).getBlock() == VaultDoorBlock.block
					.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 3)))).getBlock() == PassableVaultDoorBlock.block
							.getDefaultState().getBlock())) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
			if (((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 3)))).getBlock() == VaultDoorBlock.block
					.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 3)))).getBlock() == PassableVaultDoorBlock.block
							.getDefaultState().getBlock())) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
