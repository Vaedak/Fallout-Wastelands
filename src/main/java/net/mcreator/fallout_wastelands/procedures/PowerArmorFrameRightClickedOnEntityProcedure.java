package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.world.inventory.FrameInventoryMenu;
import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.concurrent.atomic.AtomicReference;

import io.netty.buffer.Unpooled;

public class PowerArmorFrameRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean PartOne = false;
		boolean PartThree = false;
		boolean PartTwo = false;
		if (sourceentity.isShiftKeyDown()) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.DONT_MOVE.get(), 1000, 1, (false), (false)));
			{
				Entity _ent = sourceentity;
				_ent.teleportTo(x, y, z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
			}
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("FrameInventory");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new FrameInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (sourceentity instanceof Player _player)
				_player.closeContainer();
			if (PartOne == true) {
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("You are already in power armor"), (false));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			if (PartOne == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InPowerArmor = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.CHECKER_IF_EXITED.get(), 120, 1, (false), (false)));
				PartOne = true;
				{
					Entity _ent = sourceentity;
					_ent.teleportTo(x, y, z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
				}
				{
					Entity _ent = sourceentity;
					_ent.setYRot(entity.getYRot());
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
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				if (PartOne == true) {
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
								? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
								: ItemStack.EMPTY);
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
								? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS)
								: ItemStack.EMPTY);
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
								? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
								: ItemStack.EMPTY);
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (sourceentity instanceof Player _player) {
						ItemStack _setstack = (sourceentity instanceof LivingEntity _entGetArmor
								? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD)
								: ItemStack.EMPTY);
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					PartOne = false;
					PartTwo = true;
					{
						Entity _ent = sourceentity;
						_ent.teleportTo(x, y, z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
					}
					{
						Entity _ent = sourceentity;
						_ent.setYRot(entity.getYRot());
						_ent.setXRot(30);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					FalloutWastelandsMod.queueServerWork(1, () -> {
						if (((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
								return _retval.get();
							}
						}.getItemStack(0, entity)).getItem() == Blocks.AIR.asItem()) == true) {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_HELMET.get()));
								}
							}
						} else {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(0, entity)));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(0, entity)));
								}
							}
						}
						if (((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
								return _retval.get();
							}
						}.getItemStack(1, entity)).getItem() == Blocks.AIR.asItem()) == true) {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_CHESTPLATE.get()));
								}
							}
						} else {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(1, entity)));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(1, entity)));
								}
							}
						}
						if (((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
								return _retval.get();
							}
						}.getItemStack(2, entity)).getItem() == Blocks.AIR.asItem()) == true) {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_LEGGINGS.get()));
								}
							}
						} else {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(2, entity)));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(2, entity)));
								}
							}
						}
						if (((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
								return _retval.get();
							}
						}.getItemStack(3, entity)).getItem() == Blocks.AIR.asItem()) == true) {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_BOOTS.get()));
								}
							}
						} else {
							{
								Entity _entity = sourceentity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(3, entity)));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, (new Object() {
										public ItemStack getItemStack(int sltid, Entity entity) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack(3, entity)));
								}
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					});
					if (PartTwo == true) {
						PartTwo = false;
						PartThree = true;
						if (PartThree == true) {
							PartThree = false;
							{
								Entity _ent = sourceentity;
								_ent.teleportTo(x, y, z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
							}
							{
								Entity _ent = sourceentity;
								_ent.setYRot(entity.getYRot());
								_ent.setXRot(30);
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
							FalloutWastelandsMod.queueServerWork(2, () -> {
								if (!entity.level.isClientSide())
									entity.discard();
							});
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
						}
					}
				}
				if (sourceentity instanceof ServerPlayer) {
					PartOne = true;
					{
						Entity _ent = sourceentity;
						_ent.teleportTo(x, y, z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
					}
					{
						Entity _ent = sourceentity;
						_ent.setYRot(entity.getYRot());
						_ent.setXRot(30);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				}
			}
		}
	}
}
