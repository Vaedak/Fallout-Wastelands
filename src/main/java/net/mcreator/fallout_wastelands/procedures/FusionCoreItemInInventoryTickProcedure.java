package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.FusionCoreItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;
import java.util.Comparator;

public class FusionCoreItemInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency itemstack for procedure FusionCoreItemInInventoryTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		boolean dontstop = false;
		double cores = 0;
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if (itemstack.getOrCreateTag().getBoolean("Unusable") == false) {
				if ((itemstack).getDamage() < 100) {
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
								double _setval = (100 - (itemstack).getDamage());
								entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Power = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((itemstack).getDamage() > 99) {
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
						if ((itemstack).getDamage() < 99) {
							{
								ItemStack _ist = itemstack;
								if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
									_ist.shrink(1);
									_ist.setDamage(0);
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
			if ((((Entity) world
					.getEntitiesWithinAABB(LightningBoltEntity.class,
							new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) == true) {
				(itemstack).setDamage((int) (-1000 + (itemstack).getDamage()));
			}
			if ((itemstack).getDamage() < 99) {
				itemstack.getOrCreateTag().putBoolean("Unusable", (false));
			}
		}
		cores = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (FusionCoreItem.block == itemstackiterator.getItem()) {
						if (itemstackiterator.getOrCreateTag().getBoolean("CoreInUse") == true) {
							cores = (cores + (itemstackiterator).getCount());
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
