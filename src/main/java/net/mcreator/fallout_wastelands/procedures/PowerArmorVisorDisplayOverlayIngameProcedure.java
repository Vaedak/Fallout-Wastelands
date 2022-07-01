package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.T45powerarmorItem;
import net.mcreator.fallout_wastelands.item.EnclaveX01paItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class PowerArmorVisorDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PowerArmorVisorDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == T45powerarmorItem.helmet
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
						.getItem() == EnclaveX01paItem.helmet) == true;
	}
}
