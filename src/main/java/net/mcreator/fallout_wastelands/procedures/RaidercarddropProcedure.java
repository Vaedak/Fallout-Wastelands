package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.StrangeelectroniccardsItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class RaidercarddropProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure Raidercarddrop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure Raidercarddrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure Raidercarddrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure Raidercarddrop!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure Raidercarddrop!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).paulo_quest_in_progress == true) {
			if (Math.random() < 0.9) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(StrangeelectroniccardsItem.block));
					entityToSpawn.setPickupDelay((int) 100);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				FalloutWastelandsModVariables.WorldVariables
						.get(world).are10cardsdropped = (FalloutWastelandsModVariables.WorldVariables.get(world).are10cardsdropped + 1);
				FalloutWastelandsModVariables.WorldVariables.get(world).syncData(world);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You looted an electronic card ."), (false));
				}
			}
		}
	}
}
