package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;
import net.mcreator.fallout_wastelands.entity.BrokenFrameEntity;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PowerArmorTrueFeaturesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randumframeyawgv = 0;
		double randumframex = 0;
		double RandomNuberX = 0;
		double RandomNumberY = 0;
		double RandomNumberZ = 0;
		if ((entity instanceof LivingEntity _livEnt
				? _livEnt.hasEffect(FalloutWastelandsModMobEffects.CHECK_IF_EXITED_MARKER.get())
				: false) == false) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 0) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
				{
					boolean _setval = false;
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InPowerArmor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									"/kill @e[type=minecraft:item,name=\"Frame Armor Helmet\"]");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									"/kill @e[type=minecraft:item,name=\"Frame Armor Body\"]");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									"/kill @e[type=minecraft:item,name=\"Frame Armor Leggings\"]");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands()
							.performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""),
											_level.getServer(), null).withSuppressedOutput(),
									"/kill @e[type=minecraft:item,name=\"Frame Armor Boots\"]");
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BrokenFrameEntity(FalloutWastelandsModEntities.BROKEN_FRAME.get(), _level);
					entityToSpawn.moveTo(x, y, z, (float) randumframex, (float) randumframeyawgv);
					entityToSpawn.setYBodyRot((float) randumframex);
					entityToSpawn.setYHeadRot((float) randumframex);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
				randumframex = Math.random() * 360;
				randumframeyawgv = Math.random() * 360;
			}
		}
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_HELMET.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_CHESTPLATE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_LEGGINGS.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(FalloutWastelandsModItems.FRAME_ARMOR_BOOTS.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
		}
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if ((entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.FUSION_CORE.get()))
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
<<<<<<< HEAD
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.5 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
=======
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Arrow) {
						if ((entityiterator.getDeltaMovement().x() < 0 && entityiterator.getDeltaMovement().x() > 0
								&& entityiterator.getDeltaMovement().z() < 0 && entityiterator.getDeltaMovement().z() > 0
								&& entityiterator.getDeltaMovement().y() < 0 && entityiterator.getDeltaMovement().y() > 0) == false) {
							if (entityiterator.getDeltaMovement().x() < 2.5 && entityiterator.getDeltaMovement().x() > -2.5
									&& entityiterator.getDeltaMovement().z() < 2.5 && entityiterator.getDeltaMovement().z() > -2.5
									&& entityiterator.getDeltaMovement().y() < 2.5 && entityiterator.getDeltaMovement().y() > -2.5) {
								if (entityiterator.getPersistentData().getBoolean("reflected") == false) {
									if ((entityiterator.getDeltaMovement().x() == 0 && entityiterator.getDeltaMovement().z() == 0
											&& entityiterator.getDeltaMovement().y() == 0) == false) {
										entityiterator.setDeltaMovement(new Vec3(((entityiterator.getDeltaMovement().x() * RandomNuberX) / (-1.5)),
												((entityiterator.getDeltaMovement().y() * RandomNumberY) / (-1.5)),
												((entityiterator.getDeltaMovement().z() * RandomNumberZ) / (-1.5))));
										entityiterator.getPersistentData().putBoolean("reflected", (true));
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x, y, z),
														ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("fallout_wastelands:armorhitbyarrow")),
														SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z,
														ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("fallout_wastelands:armorhitbyarrow")),
														SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			RandomNuberX = Math.random() * 1;
			RandomNumberZ = Math.random() * 1;
			RandomNumberY = Math.random() * 1;
			entity.fallDistance = 0;
			if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
					.getItem() == FalloutWastelandsModItems.FRAME_ARMOR_HELMET.get()
					|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
							.getItem() == Blocks.AIR.asItem()) == false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 20, (int) 2, (false), (false)));
		}
	}
}
