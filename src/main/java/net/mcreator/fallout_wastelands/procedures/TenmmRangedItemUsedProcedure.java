package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class TenmmRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure TenmmRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure TenmmRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^1 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^1 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^1 ~ ~ 0 0 0 force");
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 4);
		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCount") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCount", (itemstack.getOrCreateTag().getDouble("BulletCount") - 1));
				(itemstack).setDamage((int) ((itemstack).getDamage() + 100));
			}
		}
	}
}
