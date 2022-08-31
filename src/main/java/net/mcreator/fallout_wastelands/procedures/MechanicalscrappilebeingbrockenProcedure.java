package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.fallout_wastelands.item.WrenchItem;
import net.mcreator.fallout_wastelands.item.TrackItem;
import net.mcreator.fallout_wastelands.item.SheetmetalplatingItem;
import net.mcreator.fallout_wastelands.item.ScrapmetalItem;
import net.mcreator.fallout_wastelands.item.SalvagedConcreteItem;
import net.mcreator.fallout_wastelands.item.RotativepartItem;
import net.mcreator.fallout_wastelands.item.RobobrainengineItem;
import net.mcreator.fallout_wastelands.item.JerricanItem;
import net.mcreator.fallout_wastelands.item.FusionmicrocellItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class MechanicalscrappilebeingbrockenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure Mechanicalscrappilebeingbrocken!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure Mechanicalscrappilebeingbrocken!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure Mechanicalscrappilebeingbrocken!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure Mechanicalscrappilebeingbrocken!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		for (int index0 = 0; index0 < (int) (10); index0++) {
			if (Math.random() < 0.4) {
				break;
			} else if (Math.random() < 0.6) {
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(RotativepartItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(TrackItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(JerricanItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.05) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(RobobrainengineItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(WrenchItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(FusionmicrocellItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.4) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SheetmetalplatingItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.6) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ScrapmetalItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedConcreteItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
