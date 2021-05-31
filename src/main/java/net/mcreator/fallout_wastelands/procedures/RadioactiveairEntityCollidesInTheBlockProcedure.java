package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fallout_wastelands.potion.RadiationPotion;
import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.Map;

@FalloutWastelandsModElements.ModElement.Tag
public class RadioactiveairEntityCollidesInTheBlockProcedure extends FalloutWastelandsModElements.ModElement {
	public RadioactiveairEntityCollidesInTheBlockProcedure(FalloutWastelandsModElements instance) {
		super(instance, 574);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure RadioactiveairEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency world for procedure RadioactiveairEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof PlayerEntity)) {
			FalloutWastelandsModVariables.WorldVariables
					.get(world).Radioacitvity = (double) ((FalloutWastelandsModVariables.WorldVariables.get(world).Radioacitvity) + 1);
			FalloutWastelandsModVariables.WorldVariables.get(world).syncData(world);
		}
		if (((FalloutWastelandsModVariables.WorldVariables.get(world).Radioacitvity) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(RadiationPotion.potion, (int) 60, (int) 0));
		}
	}
}
