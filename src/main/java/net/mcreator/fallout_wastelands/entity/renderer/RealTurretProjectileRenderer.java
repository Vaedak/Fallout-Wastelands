package net.mcreator.fallout_wastelands.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class RealTurretProjectileRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RealTurretProjectileItem.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}

}
