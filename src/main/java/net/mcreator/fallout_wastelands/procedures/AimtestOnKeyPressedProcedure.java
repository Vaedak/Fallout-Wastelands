package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.MmpistolnineaimItem;
import net.mcreator.fallout_wastelands.item.MmpistolnineItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class AimtestOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure AimtestOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == MmpistolnineItem.block) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(MmpistolnineItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MmpistolnineaimItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == MmpistolnineaimItem.block) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(MmpistolnineaimItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MmpistolnineItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
