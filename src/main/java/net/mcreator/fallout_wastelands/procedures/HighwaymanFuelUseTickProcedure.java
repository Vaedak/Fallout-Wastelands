package net.mcreator.fallout_wastelands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HighwaymanFuelUseTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if (entity.getPersistentData().getDouble("Fuel") > 0) {
				if (entity.getPersistentData().getDouble("Timer") == 0) {
					entity.getPersistentData().putDouble("Timer", 50);
					if (entity.getPersistentData().getDouble("Fuel") > 0) {
						entity.getPersistentData().putDouble("Fuel", (entity.getPersistentData().getDouble("Fuel") - 1));
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("Timer") > 0) {
			entity.getPersistentData().putDouble("Timer", (entity.getPersistentData().getDouble("Timer") - 1));
		}
		if (entity.getPersistentData().getDouble("Fuel") == 0 || entity.isVehicle() == false) {
			{
				Entity _ent = entity;
				_ent.setYRot(entity.getYRot());
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			entity.setDeltaMovement(new Vec3(0, (-1), 0));
		}
	}
}
