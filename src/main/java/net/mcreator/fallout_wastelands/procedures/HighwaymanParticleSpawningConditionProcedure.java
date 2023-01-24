package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

public class HighwaymanParticleSpawningConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(FalloutWastelandsModItems.FUELJERRICAN.get()))
				: false) {
			world.addParticle(ParticleTypes.MYCELIUM, x, y, z, 0, 1, 0);
			world.addParticle(ParticleTypes.MYCELIUM, x, y, z, 0, 1, 0);
		}
	}
}
