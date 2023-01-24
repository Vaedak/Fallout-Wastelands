
package net.mcreator.fallout_wastelands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.fallout_wastelands.entity.BrokenFrameEntity;

public class BrokenFrameRenderer extends HumanoidMobRenderer<BrokenFrameEntity, HumanoidModel<BrokenFrameEntity>> {
	public BrokenFrameRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(BrokenFrameEntity entity) {
		return new ResourceLocation("fallout_wastelands:textures/entities/brokenframe.png");
	}
}
