package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModMobEffects;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class UraniumblockUpdateTicktest1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(FalloutWastelandsModMobEffects.RADIATION.get(), 60, 1));
			}
		}
	}
}
