package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

<<<<<<< HEAD
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
=======
import net.mcreator.fallout_wastelands.item.BrokenPowerArmorFrameItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

public class BrokenFrameRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
<<<<<<< HEAD
		if (!entity.level.isClientSide())
			entity.discard();
		if (world instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(FalloutWastelandsModItems.POWER_ARMOR_FRAME_ITEM.get()));
			entityToSpawn.setPickUpDelay(5);
			entityToSpawn.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn);
=======
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure BrokenFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure BrokenFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure BrokenFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure BrokenFrameRightClickedOnEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.world.isRemote())
			entity.remove();
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(BrokenPowerArmorFrameItem.block));
			entityToSpawn.setPickupDelay((int) 5);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
		}
	}
}
