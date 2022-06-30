
package net.mcreator.fallout_wastelands.gui.overlay;

@Mod.EventBusSubscriber
public class RadiationUI0Overlay {

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();

			int posX = w / 2;
			int posY = h / 2;

			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;

			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}

			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;

			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();

			if (true) {

				if (

				Radiation0UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_0.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation0UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_1.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation2UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_2.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation3UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_3.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/radiation_ui_base.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 198, posY + -112, 0, 0, 16, 16, 16, 16);

			}

			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

}
