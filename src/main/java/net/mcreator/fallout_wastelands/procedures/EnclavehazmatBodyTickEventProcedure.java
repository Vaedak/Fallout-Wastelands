package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.potion.RadioprotectionPotionEffect;
import net.mcreator.fallout_wastelands.item.EnclavehazmatItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class EnclavehazmatBodyTickEventProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure EnclavehazmatBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
									.addPotionEffect(new EffectInstance(RadioprotectionPotionEffect.potion, (int) 60, (int) 2, (false), (false)));
					}
				}
			}
		}
	}
}
