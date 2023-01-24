package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

import java.util.concurrent.atomic.AtomicReference;

public class FusionCoreItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean dontstop = false;
		double cores = 0;
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if (itemstack.getOrCreateTag().getBoolean("Unusable") == false) {
				if ((itemstack).getDamageValue() < 100) {
					if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Power == 0) {
						if (entity.getPersistentData().getBoolean("coreassigned") == false) {
							entity.getPersistentData().putBoolean("coreassigned", (true));
							if (itemstack.getOrCreateTag().getBoolean("CoreInUse") == false) {
								itemstack.getOrCreateTag().putBoolean("CoreInUse", (true));
							}
						}
					}
					if (itemstack.getOrCreateTag().getBoolean("CoreInUse") == true) {
						for (int index0 = 0; index0 < (int) (4); index0++) {
							{
								double _setval = 100 - (itemstack).getDamageValue();
								entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Power = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((itemstack).getDamageValue() > 99) {
						entity.getPersistentData().putBoolean("coreassigned", (false));
						itemstack.getOrCreateTag().putBoolean("CoreInUse", (false));
						itemstack.getOrCreateTag().putBoolean("Unusable", (true));
						{
							double _setval = 0;
							entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Power = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.getPersistentData().getDouble("counter") == 0) {
						if ((itemstack).getDamageValue() < 99) {
							{
								ItemStack _ist = itemstack;
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							entity.getPersistentData().putDouble("counter", 480);
							{
								double _setval = 2;
								entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Power = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if (entity.getPersistentData().getDouble("counter") > 0) {
						entity.getPersistentData().putDouble("counter", (entity.getPersistentData().getDouble("counter") - 1));
					}
				}
			}
			if (!world.getEntitiesOfClass(LightningBolt.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty() == true) {
				(itemstack).setDamageValue((int) (-1000 + (itemstack).getDamageValue()));
			}
			if ((itemstack).getDamageValue() < 99) {
				itemstack.getOrCreateTag().putBoolean("Unusable", (false));
			}
		}
		cores = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (FalloutWastelandsModItems.FUSION_CORE.get() == itemstackiterator.getItem()) {
						if (itemstackiterator.getOrCreateTag().getBoolean("CoreInUse") == true) {
							cores = cores + (itemstackiterator).getCount();
						}
					}
				}
			}
		}
		if (cores > 1) {
			itemstack.getOrCreateTag().putBoolean("CoreInUse", (false));
		}
	}
}
