
package net.mcreator.fallout_wastelands.gui.overlay;

@Mod.EventBusSubscriber
public class CurrentPowerOverlay {

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

			if (

			CurrentPowerDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Power) + "",
						posX + 148, posY + 101, -256);
			}

		}
	}

}
