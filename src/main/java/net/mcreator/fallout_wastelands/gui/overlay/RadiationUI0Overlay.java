
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
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_0.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation1UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_1.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation2UIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_2.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				Radiation3UIProcedure.executeProcedure(Collections.emptyMap())) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_3.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);

				}
				if (

				DisplayradiationgreeniconProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager()
							.bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/radiation_ui_base.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 198, posY + -112, 0, 0, 16, 16, 16, 16);

				}
				if (

				RadiationUI4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_4.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_5.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_6.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_7.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_8.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_9.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_10.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_11.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_12.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_13.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_14.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_15.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_16.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_17.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_18.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_19.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_20.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_21.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_22.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
				if (

				RadiationUI23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/rad_23.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, -1, -1, -1, -1);

				}
			}

			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

}
