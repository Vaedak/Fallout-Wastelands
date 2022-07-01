package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.potion.CheckIfExitedMarkerPotionEffect;
import net.mcreator.fallout_wastelands.item.FusionCoreItem;
import net.mcreator.fallout_wastelands.item.FrameArmorItem;
import net.mcreator.fallout_wastelands.entity.BrokenFrameEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collection;

public class PowerArmorTrueFeaturesProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure PowerArmorTrueFeatures!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure PowerArmorTrueFeatures!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure PowerArmorTrueFeatures!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure PowerArmorTrueFeatures!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PowerArmorTrueFeatures!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double randumframeyawgv = 0;
		double randumframex = 0;
		double RandomNuberX = 0;
		double RandomNumberY = 0;
		double RandomNumberZ = 0;
		if ((new Object() {
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
		}.check(entity)) == false) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == false) {
				{
					double _setval = 0;
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) == 0) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
				{
					boolean _setval = (false);
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InPowerArmor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/kill @e[type=minecraft:item,name=\"Frame Armor Helmet\"]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/kill @e[type=minecraft:item,name=\"Frame Armor Body\"]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/kill @e[type=minecraft:item,name=\"Frame Armor Leggings\"]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/kill @e[type=minecraft:item,name=\"Frame Armor Boots\"]");
				}
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new BrokenFrameEntity.CustomEntity(BrokenFrameEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, z, (float) randumframex, (float) randumframeyawgv);
					entityToSpawn.setRenderYawOffset((float) randumframex);
					entityToSpawn.setRotationYawHead((float) randumframex);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				randumframex = (Math.random() * 360);
				randumframeyawgv = (Math.random() * 360);
			}
		}
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == false) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FrameArmorItem.helmet);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FrameArmorItem.body);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FrameArmorItem.legs);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FrameArmorItem.boots);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FusionCoreItem.block))
					: false) == false) {
				entity.getPersistentData().putBoolean("coreassigned", (false));
				{
					double _setval = 0;
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (3.5 / 2d), y - (3.5 / 2d), z - (3.5 / 2d), x + (3.5 / 2d), y + (3.5 / 2d), z + (3.5 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ArrowEntity) {
						if ((entityiterator.getMotion().getX() < 0 && entityiterator.getMotion().getX() > 0 && entityiterator.getMotion().getZ() < 0
								&& entityiterator.getMotion().getZ() > 0 && entityiterator.getMotion().getY() < 0
								&& entityiterator.getMotion().getY() > 0) == false) {
							if (entityiterator.getMotion().getX() < 2.5 && entityiterator.getMotion().getX() > -2.5
									&& entityiterator.getMotion().getZ() < 2.5 && entityiterator.getMotion().getZ() > -2.5
									&& entityiterator.getMotion().getY() < 2.5 && entityiterator.getMotion().getY() > -2.5) {
								if (entityiterator.getPersistentData().getBoolean("reflected") == false) {
									if ((entityiterator.getMotion().getX() == 0 && entityiterator.getMotion().getZ() == 0
											&& entityiterator.getMotion().getY() == 0) == false) {
										entityiterator.setMotion(((entityiterator.getMotion().getX() * RandomNuberX) / (-1.5)),
												((entityiterator.getMotion().getY() * RandomNumberY) / (-1.5)),
												((entityiterator.getMotion().getZ() * RandomNumberZ) / (-1.5)));
										entityiterator.getPersistentData().putBoolean("reflected", (true));
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("fallout_wastelands:armorhitbyarrow")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("fallout_wastelands:armorhitbyarrow")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
			RandomNuberX = (Math.random() * 1);
			RandomNumberZ = (Math.random() * 1);
			RandomNumberY = (Math.random() * 1);
			entity.fallDistance = (float) (0);
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
					.getItem() == FrameArmorItem.helmet
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
							.getItem() == Blocks.AIR.asItem()) == false) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.POISON);
				}
			}
		}
	}
}