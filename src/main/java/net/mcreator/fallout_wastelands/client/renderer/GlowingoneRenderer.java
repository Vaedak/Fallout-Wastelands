
package net.mcreator.fallout_wastelands.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.fallout_wastelands.entity.GlowingoneEntity;

public class GlowingoneRenderer extends HumanoidMobRenderer<GlowingoneEntity, HumanoidModel<GlowingoneEntity>> {
	public GlowingoneRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<GlowingoneEntity, HumanoidModel<GlowingoneEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("fallout_wastelands:textures/entities/glowing_one_glowing_pattern.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GlowingoneEntity entity) {
		return new ResourceLocation("fallout_wastelands:textures/entities/glowing_one.png");
	}
}
