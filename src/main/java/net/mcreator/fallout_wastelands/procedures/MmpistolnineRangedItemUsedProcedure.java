package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MmpistolnineRangedItemUsedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent),
						"execute at @s anchored eyes run particle minecraft:flame ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
								_ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level.getServer(), _ent),
						"execute at @s anchored eyes run particle minecraft:smoke ^-0.45 ^-0.38 ^2 ~ ~ 0 0 0 force");
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 4);
		if (itemstack.getOrCreateTag().getBoolean("NewMagLoaded") == true) {
			if (itemstack.getOrCreateTag().getDouble("BulletCount") > 0) {
				itemstack.getOrCreateTag().putDouble("BulletCount", (itemstack.getOrCreateTag().getDouble("BulletCount") - 1));
				(itemstack).setDamageValue((int) ((itemstack).getDamageValue() + 100));
			}
		}
	}
}
