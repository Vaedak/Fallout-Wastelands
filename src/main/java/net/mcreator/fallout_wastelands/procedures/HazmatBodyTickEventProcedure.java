package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class HazmatBodyTickEventProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure HazmatBodyTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == HazmatItem.helmet) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == HazmatItem.body) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
						.getItem() == HazmatItem.legs) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
							.getItem() == HazmatItem.boots) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(RadioprotectionPotionEffect.potion, (int) 100, (int) 2, (false), (false)));
					}
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == EnclavehazmatItem.helmet) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == EnclavehazmatItem.body) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
						.getItem() == EnclavehazmatItem.legs) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
							.getItem() == EnclavehazmatItem.boots) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(RadioprotectionPotionEffect.potion, (int) 100, (int) 2, (false), (false)));
					}
				}
			}
		}
	}

}
