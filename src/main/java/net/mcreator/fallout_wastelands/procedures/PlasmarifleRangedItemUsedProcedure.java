package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class PlasmarifleRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PlasmarifleRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure PlasmarifleRangedItemUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 7);
		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCountLaserRifle", (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") - 1));
				(itemstack).setDamage((int) ((itemstack).getDamage() + 100));
			}
		}
	}

}
