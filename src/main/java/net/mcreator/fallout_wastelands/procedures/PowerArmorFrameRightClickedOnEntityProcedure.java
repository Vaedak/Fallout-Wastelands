package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.potion.DontMovePotionEffect;
import net.mcreator.fallout_wastelands.potion.CheckerIfExitedPotionEffect;
import net.mcreator.fallout_wastelands.item.FrameArmorItem;
import net.mcreator.fallout_wastelands.gui.FrameInventoryGui;
import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.Collections;

import io.netty.buffer.Unpooled;

public class PowerArmorFrameRightClickedOnEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PowerArmorFrameRightClickedOnEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		boolean PartOne = false;
		boolean PartThree = false;
		boolean PartTwo = false;
		if (sourceentity.isSneaking()) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(DontMovePotionEffect.potion, (int) 1000, (int) 1, (false), (false)));
			{
				Entity _ent = sourceentity;
				_ent.setPositionAndUpdate(x, y, z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("FrameInventory");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new FrameInventoryGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (sourceentity instanceof PlayerEntity)
				((PlayerEntity) sourceentity).closeScreen();
			if (PartOne == true) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You are already in power armor"), (false));
				}
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
			}
			if (PartOne == false) {
				{
					boolean _setval = (true);
					sourceentity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InPowerArmor = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity)
							.addPotionEffect(new EffectInstance(CheckerIfExitedPotionEffect.potion, (int) 120, (int) 1, (false), (false)));
				PartOne = (true);
				{
					Entity _ent = sourceentity;
					_ent.setPositionAndUpdate(x, y, z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				sourceentity.rotationYaw = (float) ((entity.rotationYaw));
				entity.setRenderYawOffset(entity.rotationYaw);
				entity.prevRotationYaw = entity.rotationYaw;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
					((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
					((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
				}
				sourceentity.rotationPitch = (float) (20);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
				}
				if (PartOne == true) {
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.FEET)
								: ItemStack.EMPTY);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.LEGS)
								: ItemStack.EMPTY);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.CHEST)
								: ItemStack.EMPTY);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD)
								: ItemStack.EMPTY);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					PartOne = (false);
					PartTwo = (true);
					{
						Entity _ent = sourceentity;
						_ent.setPositionAndUpdate(x, y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					sourceentity.rotationYaw = (float) ((entity.rotationYaw));
					entity.setRenderYawOffset(entity.rotationYaw);
					entity.prevRotationYaw = entity.rotationYaw;
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
						((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
						((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
					}
					sourceentity.rotationPitch = (float) (30);
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) (0), entity)).getItem() == Blocks.AIR.asItem()) == true) {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 3, new ItemStack(FrameArmorItem.helmet));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.HEAD,
												new ItemStack(FrameArmorItem.helmet));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							} else {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 3, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (0), entity)));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.HEAD, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (0), entity)));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							}
							if (((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) (1), entity)).getItem() == Blocks.AIR.asItem()) == true) {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 2, new ItemStack(FrameArmorItem.body));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(FrameArmorItem.body));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							} else {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 2, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (1), entity)));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.CHEST, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (1), entity)));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							}
							if (((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) (2), entity)).getItem() == Blocks.AIR.asItem()) == true) {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 1, new ItemStack(FrameArmorItem.legs));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(FrameArmorItem.legs));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							} else {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 1, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (2), entity)));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.LEGS, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (2), entity)));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							}
							if (((new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) (3), entity)).getItem() == Blocks.AIR.asItem()) == true) {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 0, new ItemStack(FrameArmorItem.boots));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(FrameArmorItem.boots));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							} else {
								if (sourceentity instanceof LivingEntity) {
									if (sourceentity instanceof PlayerEntity)
										((PlayerEntity) sourceentity).inventory.armorInventory.set((int) 0, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (3), entity)));
									else
										((LivingEntity) sourceentity).setItemStackToSlot(EquipmentSlotType.FEET, (new Object() {
											public ItemStack getItemStack(int sltid, Entity entity) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).copy());
												});
												return _retval.get();
											}
										}.getItemStack((int) (3), entity)));
									if (sourceentity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) sourceentity).inventory.markDirty();
								}
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 1);
					if (PartTwo == true) {
						PartTwo = (false);
						PartThree = (true);
						if (PartThree == true) {
							PartThree = (false);
							{
								Entity _ent = sourceentity;
								_ent.setPositionAndUpdate(x, y, z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
							sourceentity.rotationYaw = (float) ((entity.rotationYaw));
							entity.setRenderYawOffset(entity.rotationYaw);
							entity.prevRotationYaw = entity.rotationYaw;
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
								((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
								((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
							}
							sourceentity.rotationPitch = (float) (30);
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;

								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (!entity.world.isRemote())
										entity.remove();
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 2);
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
							}
						}
					}
				}
				if (sourceentity instanceof ServerPlayerEntity) {
					PartOne = (true);
					{
						Entity _ent = sourceentity;
						_ent.setPositionAndUpdate(x, y, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
					sourceentity.rotationYaw = (float) ((entity.rotationYaw));
					entity.setRenderYawOffset(entity.rotationYaw);
					entity.prevRotationYaw = entity.rotationYaw;
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
						((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
						((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
					}
					sourceentity.rotationPitch = (float) (30);
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
					}
				}
			}
		}
	}
}
