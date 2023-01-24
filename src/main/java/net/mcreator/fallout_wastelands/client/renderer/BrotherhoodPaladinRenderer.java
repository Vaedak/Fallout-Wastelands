
package net.mcreator.fallout_wastelands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.fallout_wastelands.entity.BrotherhoodPaladinEntity;

public class BrotherhoodPaladinRenderer extends HumanoidMobRenderer<BrotherhoodPaladinEntity, HumanoidModel<BrotherhoodPaladinEntity>> {
	public BrotherhoodPaladinRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(BrotherhoodPaladinEntity entity) {
		return new ResourceLocation("fallout_wastelands:textures/entities/pmcskin3d-steve-simple_3.png");
	}
}
