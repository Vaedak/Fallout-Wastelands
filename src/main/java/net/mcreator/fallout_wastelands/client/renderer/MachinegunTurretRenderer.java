
package net.mcreator.fallout_wastelands.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.fallout_wastelands.procedures.MachinegunTurretEntityShakingConditionProcedure;
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;

public class MachinegunTurretRenderer extends HumanoidMobRenderer<MachinegunTurretEntity, HumanoidModel<MachinegunTurretEntity>> {
	public MachinegunTurretRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(MachinegunTurretEntity entity) {
		return new ResourceLocation("fallout_wastelands:textures/entities/turret_second.png");
	}

	@Override
	protected boolean isShaking(MachinegunTurretEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return MachinegunTurretEntityShakingConditionProcedure.execute(entity);
	}
}
