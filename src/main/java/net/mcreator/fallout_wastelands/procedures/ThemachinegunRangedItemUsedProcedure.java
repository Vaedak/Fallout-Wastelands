package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ThemachinegunRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure ThemachinegunRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThemachinegunRangedItemUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCounter") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCounter", (itemstack.getOrCreateTag().getDouble("BulletCounter") - 1));
				(itemstack).setDamage((int) ((itemstack).getDamage() + 100));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
	}

}
