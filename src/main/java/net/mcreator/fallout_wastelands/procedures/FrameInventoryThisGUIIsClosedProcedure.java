package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;
import net.mcreator.fallout_wastelands.entity.PowerArmorFrameEntity;

import java.util.Comparator;

public class FrameInventoryThisGUIIsClosedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((Entity) world.getEntitiesOfClass(PowerArmorFrameEntity.class, AABB.ofSize(new Vec3(x, y, z), 0.5, 0.5, 0.5), e -> true).stream()
				.sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity)
			_entity.removeEffect(FalloutWastelandsModMobEffects.ARMOR_PLACER.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(FalloutWastelandsModMobEffects.DONT_MOVE.get());
	}
}
