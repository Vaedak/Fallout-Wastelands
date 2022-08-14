
package net.mcreator.fallout_wastelands.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class TaloncompagnysoldierRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TaloncompagnysoldierEntity.entity, renderManager -> {
				BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/entities/pmcskin3d-steve-simple_3.png");
					}

				};
				customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

				return customRender;
			});

		}
	}

}
