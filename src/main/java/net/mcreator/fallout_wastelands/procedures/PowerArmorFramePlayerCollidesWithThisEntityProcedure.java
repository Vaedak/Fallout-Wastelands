package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

public class PowerArmorFramePlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean transferer = false;
		boolean getisframelegs = false;
		boolean transfer3 = false;
		boolean getisframechest = false;
		boolean transfer2 = false;
		boolean getisframeboots = false;
		boolean getisframe = false;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(FalloutWastelandsModMobEffects.FRAME_IDENTIFIER.get()) : false) {
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (sourceentity instanceof LivingEntity _livEnt
						? _livEnt.hasEffect(FalloutWastelandsModMobEffects.CHECK_IF_EXITED_MARKER.get())
						: false) {
					transferer = true;
					if (transferer == true) {
						{
							Entity _ent = entity;
							_ent.setYRot(sourceentity.getYRot());
							_ent.setXRot(20);
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						{
							Entity _ent = sourceentity;
							_ent.setYRot(sourceentity.getYRot());
							_ent.setXRot(20);
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						sourceentity.setDeltaMovement(new Vec3(0, 0, 0));
						if (((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.getItem() == FalloutWastelandsModItems.FRAME_ARMOR_HELMET.get()) == true) {
							{
								final int _slotid = 0;
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
							getisframe = false;
						} else if (getisframe == false) {
							{
								final int _slotid = 0;
								final ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD)
										: ItemStack.EMPTY);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
						}
						if (((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
								.getItem() == FalloutWastelandsModItems.FRAME_ARMOR_CHESTPLATE.get()) == true) {
							{
								final int _slotid = 1;
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
							getisframechest = false;
						} else if (getisframechest == false) {
							{
								final int _slotid = 1;
								final ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
										: ItemStack.EMPTY);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
						}
						if (((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
								.getItem() == FalloutWastelandsModItems.FRAME_ARMOR_LEGGINGS.get()) == true) {
							{
								final int _slotid = 2;
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
							getisframelegs = false;
						} else if (getisframelegs == false) {
							{
								final int _slotid = 2;
								final ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS)
										: ItemStack.EMPTY);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
						}
						if (((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
								.getItem() == FalloutWastelandsModItems.FRAME_ARMOR_BOOTS.get()) == true) {
							{
								final int _slotid = 3;
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
							getisframeboots = false;
						} else if (getisframeboots == false) {
							{
								final int _slotid = 3;
								final ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
										: ItemStack.EMPTY);
								_setstack.setCount(1);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
						}
						transfer2 = true;
						if (transfer2 == true) {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(FalloutWastelandsModMobEffects.FRAME_IDENTIFIER.get());
							if (sourceentity instanceof LivingEntity _entity)
								_entity.removeEffect(FalloutWastelandsModMobEffects.CHECKER_IF_EXITED.get());
							if (sourceentity instanceof LivingEntity _entity)
								_entity.removeEffect(FalloutWastelandsModMobEffects.CHECK_IF_EXITED_MARKER.get());
							transfer2 = false;
							transfer3 = true;
							if (transfer3 == true) {
								transfer3 = false;
								{
									Entity _entity = sourceentity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
									}
								}
								{
									Entity _entity = sourceentity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
									}
								}
								{
									Entity _entity = sourceentity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
									}
								}
								{
									Entity _entity = sourceentity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
									}
								}
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.CHECKER_IF_EXITED.get(), 240, 1, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.ARMOR_PLACER.get(), 60, 1, (false), (false)));
	}
}
