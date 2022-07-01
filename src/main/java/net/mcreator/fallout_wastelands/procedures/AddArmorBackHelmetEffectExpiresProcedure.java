package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class AddArmorBackHelmetEffectExpiresProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure AddArmorBackHelmetEffectExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean waiter1 = false;
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD)
					: ItemStack.EMPTY);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		waiter1 = (true);
		if (waiter1 == true) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Blocks.AIR));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Blocks.AIR));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			waiter1 = (true);
		}
	}
}
