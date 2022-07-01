package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AddArmorBackchestEffectExpiresProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure AddArmorBackchestEffectExpires!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		boolean waiter2 = false;
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
					: ItemStack.EMPTY);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		waiter2 = (true);
		if (waiter2 == true) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Blocks.AIR));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Blocks.AIR));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			waiter2 = (true);
		}
	}

}
