package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.potion.RemoveframepotionPotionEffect;
import net.mcreator.fallout_wastelands.potion.FrameIdentifierPotionEffect;
import net.mcreator.fallout_wastelands.potion.CheckerIfExitedPotionEffect;
import net.mcreator.fallout_wastelands.potion.CheckIfExitedMarkerPotionEffect;
import net.mcreator.fallout_wastelands.potion.ArmorPlacerPotionEffect;
import net.mcreator.fallout_wastelands.item.FrameArmorItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;
import java.util.Collection;

public class PowerArmorFramePlayerCollidesWithThisEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PowerArmorFramePlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PowerArmorFramePlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		boolean transferer = false;
		boolean getisframelegs = false;
		boolean transfer3 = false;
		boolean getisframechest = false;
		boolean transfer2 = false;
		boolean getisframeboots = false;
		boolean getisframe = false;
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RemoveframepotionPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(sourceentity)) {
			if (sourceentity instanceof LivingEntity) {
				((LivingEntity) sourceentity).removePotionEffect(RemoveframepotionPotionEffect.potion);
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 10000);
		}
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == FrameIdentifierPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if (sourceentity instanceof PlayerEntity || sourceentity instanceof ServerPlayerEntity) {
				if (new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == CheckIfExitedMarkerPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(sourceentity)) {
					transferer = (true);
					if (transferer == true) {
						entity.rotationYaw = (float) ((sourceentity.rotationYaw));
						entity.setRenderYawOffset(entity.rotationYaw);
						entity.prevRotationYaw = entity.rotationYaw;
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
							((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
							((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
						}
						entity.rotationPitch = (float) (20);
						sourceentity.rotationYaw = (float) ((sourceentity.rotationYaw));
						entity.setRenderYawOffset(entity.rotationYaw);
						entity.prevRotationYaw = entity.rotationYaw;
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
							((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
							((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
						}
						sourceentity.rotationPitch = (float) (20);
						sourceentity.setMotion(0, 0, 0);
						if ((((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD)
								: ItemStack.EMPTY).getItem() == FrameArmorItem.helmet) == true) {
							{
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								final int _sltid = (int) (0);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
							getisframe = (false);
						} else if (getisframe == false) {
							{
								final ItemStack _setstack = ((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD)
										: ItemStack.EMPTY);
								final int _sltid = (int) (0);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						if ((((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.CHEST)
								: ItemStack.EMPTY).getItem() == FrameArmorItem.body) == true) {
							{
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								final int _sltid = (int) (1);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
							getisframechest = (false);
						} else if (getisframechest == false) {
							{
								final ItemStack _setstack = ((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.CHEST)
										: ItemStack.EMPTY);
								final int _sltid = (int) (1);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						if ((((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.LEGS)
								: ItemStack.EMPTY).getItem() == FrameArmorItem.legs) == true) {
							{
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								final int _sltid = (int) (2);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
							getisframelegs = (false);
						} else if (getisframelegs == false) {
							{
								final ItemStack _setstack = ((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.LEGS)
										: ItemStack.EMPTY);
								final int _sltid = (int) (2);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						if ((((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.FEET)
								: ItemStack.EMPTY).getItem() == FrameArmorItem.boots) == true) {
							{
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								final int _sltid = (int) (3);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
							getisframeboots = (false);
						} else if (getisframeboots == false) {
							{
								final ItemStack _setstack = ((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.FEET)
										: ItemStack.EMPTY);
								final int _sltid = (int) (3);
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						transfer2 = (true);
						if (transfer2 == true) {
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(FrameIdentifierPotionEffect.potion);
							}
							if (sourceentity instanceof LivingEntity) {
								((LivingEntity) sourceentity).removePotionEffect(CheckerIfExitedPotionEffect.potion);
							}
							if (sourceentity instanceof LivingEntity) {
								((LivingEntity) sourceentity).removePotionEffect(CheckIfExitedMarkerPotionEffect.potion);
							}
							transfer2 = (false);
							transfer3 = (true);
							if (transfer3 == true) {
								transfer3 = (false);
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 3, new ItemStack(Blocks.AIR));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Blocks.AIR));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 2, new ItemStack(Blocks.AIR));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Blocks.AIR));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 1, new ItemStack(Blocks.AIR));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Blocks.AIR));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 0, new ItemStack(Blocks.AIR));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Blocks.AIR));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity)
					.addPotionEffect(new EffectInstance(CheckerIfExitedPotionEffect.potion, (int) 240, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(ArmorPlacerPotionEffect.potion, (int) 60, (int) 1, (false), (false)));
	}
}
