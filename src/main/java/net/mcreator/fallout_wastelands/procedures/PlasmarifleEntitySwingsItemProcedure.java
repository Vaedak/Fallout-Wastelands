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

public class PlasmarifleEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") == 0) {
			itemstack.getOrCreateTag().putBoolean("magcheck", (false));
			itemstack.getOrCreateTag().putBoolean("NewMagLoaded", (false));
			if ((entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.FUSIONMICROCELL.get()))
					: false) == true) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 70);
				FalloutWastelandsMod.queueServerWork(50, () -> {
					itemstack.getOrCreateTag().putBoolean("NewMagLoaded", (true));
					itemstack.getOrCreateTag().putBoolean("magcheck", (true));
				});
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.FUSIONMICROCELL.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
							_player.inventoryMenu.getCraftSlots());
				}
				itemstack.getOrCreateTag().putDouble("BulletCountLaserRifle", 15);
				(itemstack).setDamageValue(4);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:removingfusioncell")),
								SoundSource.NEUTRAL, 2, 2);
					} else {
						_level.playLocalSound(x, y, z,
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:removingfusioncell")),
								SoundSource.NEUTRAL, 2, 2, false);
					}
				}
				FalloutWastelandsMod.queueServerWork(50, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:laserriflereload")),
									SoundSource.NEUTRAL, 2, 2);
						} else {
							_level.playLocalSound(x, y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:laserriflereload")),
									SoundSource.NEUTRAL, 2, 2, false);
						}
					}
				});
			}
			if ((entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.FUSIONMICROCELL.get()))
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
		if (itemstack.getOrCreateTag().getDouble("BulletCountLaserRifle") > 0) {
			if (entity.getPersistentData().getBoolean("magcheck") == true) {
				itemstack.getOrCreateTag().putBoolean("NewMagLoaded", (true));
			}
		}
	}
}
