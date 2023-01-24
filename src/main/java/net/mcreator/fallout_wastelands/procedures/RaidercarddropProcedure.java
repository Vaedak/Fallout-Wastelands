package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.fallout_wastelands.network.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

public class RaidercarddropProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).paulo_quest_in_progress == true) {
			if (Math.random() < 0.9) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(FalloutWastelandsModItems.STRANGEELECTRONICCARDS.get()));
					entityToSpawn.setPickUpDelay(100);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
				FalloutWastelandsModVariables.WorldVariables
						.get(world).are10cardsdropped = FalloutWastelandsModVariables.WorldVariables.get(world).are10cardsdropped + 1;
				FalloutWastelandsModVariables.WorldVariables.get(world).syncData(world);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("You looted an electronic card ."), (false));
			}
		}
	}
}
