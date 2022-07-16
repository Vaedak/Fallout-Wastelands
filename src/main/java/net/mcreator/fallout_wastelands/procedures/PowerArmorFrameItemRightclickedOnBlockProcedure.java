package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.item.PowerArmorFrameItemItem;
import net.mcreator.fallout_wastelands.entity.PowerArmorFrameEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

public class PowerArmorFrameItemRightclickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure PowerArmorFrameItemRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency x for procedure PowerArmorFrameItemRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency y for procedure PowerArmorFrameItemRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency z for procedure PowerArmorFrameItemRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PowerArmorFrameItemRightclickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new PowerArmorFrameEntity.CustomEntity(PowerArmorFrameEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, (y + 1), z, (float) (entity.rotationYaw), (float) (entity.rotationPitch));
			entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
			entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
			entityToSpawn.setMotion(0, 0, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false) == false) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(PowerArmorFrameItemItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
