package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BarbedwireEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure BarbedwireEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.5);

	}

}
