package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class MmpistolnineEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("BulletCount") == 0) {
			itemstack.getOrCreateTag().putBoolean("NewMagLoaded", (false));
			if ((entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.NINEMMAMMO.get()))
					: false) == true) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
				FalloutWastelandsMod.queueServerWork(20, () -> {
					itemstack.getOrCreateTag().putBoolean("NewMagLoaded", (true));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:pistol10mmreload")),
									SoundSource.NEUTRAL, 2, 2);
						} else {
							_level.playLocalSound(x, y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:pistol10mmreload")),
									SoundSource.NEUTRAL, 2, 2, false);
						}
					}
				});
				for (int index0 = 0; index0 < (int) (9); index0++) {
					if ((entity instanceof Player _playerHasItem
							? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.NINEMMAMMO.get()))
							: false) == true) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.NINEMMAMMO.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
									_player.inventoryMenu.getCraftSlots());
						}
						itemstack.getOrCreateTag().putDouble("BulletCount", (itemstack.getOrCreateTag().getDouble("BulletCount") + 1));
						FalloutWastelandsMod.queueServerWork(9, () -> {
							(itemstack).setDamageValue((int) ((itemstack).getDamageValue() - 100));
						});
					}
				}
			}
			if ((entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.NINEMMAMMO.get()))
					: false) == false) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:emptygunfire")), SoundSource.NEUTRAL,
								1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:emptygunfire")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
