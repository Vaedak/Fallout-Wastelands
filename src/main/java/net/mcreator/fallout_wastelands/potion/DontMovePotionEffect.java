
package net.mcreator.fallout_wastelands.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DontMovePotionEffect {

	@ObjectHolder("fallout_wastelands:dont_move")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("dont_move");
		}

		@Override
		public String getName() {
			return "effect.dont_move";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public void performEffect(LivingEntity entity, int amplifier) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			DontMoveOnEffectActiveTickProcedure.executeProcedure(Collections.emptyMap());
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
