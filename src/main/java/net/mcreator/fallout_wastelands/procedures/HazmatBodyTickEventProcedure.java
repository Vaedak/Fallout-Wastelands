package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.potion.RadioprotectionPotionEffect;
import net.mcreator.fallout_wastelands.item.HazmatItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

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
	}
}
