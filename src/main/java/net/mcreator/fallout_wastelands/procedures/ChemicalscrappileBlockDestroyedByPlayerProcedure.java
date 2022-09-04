package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.fallout_wastelands.item.SalvagedConcreteItem;
import net.mcreator.fallout_wastelands.item.RadxItem;
import net.mcreator.fallout_wastelands.item.RadawayItem;
import net.mcreator.fallout_wastelands.item.NuclearwasteItem;
import net.mcreator.fallout_wastelands.item.FueljerricanItem;
import net.mcreator.fallout_wastelands.item.FertilizerItem;
import net.mcreator.fallout_wastelands.item.AsbestosItem;
import net.mcreator.fallout_wastelands.item.AcidItem;
import net.mcreator.fallout_wastelands.item.AbraxoItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class ChemicalscrappileBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure ChemicalscrappileBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure ChemicalscrappileBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure ChemicalscrappileBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure ChemicalscrappileBlockDestroyedByPlayer!");
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
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(RadxItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(AsbestosItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(AcidItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(FertilizerItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(RadawayItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(NuclearwasteItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				}
				if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(FueljerricanItem.block));
						entityToSpawn.setPickupDelay((int) 1);
						world.addEntity(entityToSpawn);
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(AbraxoItem.block));
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
