package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FallingInArmorProcedure {
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
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if ((entity.isOnGround() && entity.isInWater()) == true) {
				if (entity.getPersistentData().getDouble("fallinginarmor") > 15 && entity.getPersistentData().getDouble("fallinginarmor") < 40) {
					entity.getPersistentData().putDouble("fallinginarmor", 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:smallfallboom")),
									SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z,
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:smallfallboom")),
									SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, x, (y + 1), z, 20, 0.1, 0.1, 0.1, 0.1);
				}
			}
			if (entity.getPersistentData().getDouble("fallinginarmor") > 40) {
				entity.getPersistentData().putDouble("fallinginarmor", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:bigfallboom")), SoundSource.NEUTRAL, 1,
								1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:bigfallboom")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WHITE_ASH, x, (y + 1), z, 50, 0.1, 0.1, 0.1, 0.1);
			}
			FalloutWastelandsMod.queueServerWork(2, () -> {
				entity.getPersistentData().putDouble("fallinginarmor", 0);
			});
			if (entity.isOnGround() == false) {
				entity.getPersistentData().putDouble("fallinginarmor", (entity.getPersistentData().getDouble("fallinginarmor") + 1));
			}
		}
	}
}
