
package net.mcreator.fallout_wastelands.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CheckIfExitedMarkerPotionEffect {

	@ObjectHolder("fallout_wastelands:check_if_exited_marker")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("check_if_exited_marker");
		}

		@Override
		public String getName() {
			return "effect.check_if_exited_marker";
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
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
