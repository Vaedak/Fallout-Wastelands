
package net.mcreator.fallout_wastelands.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddArmorBackHelmetPotionEffect {

	@ObjectHolder("fallout_wastelands:add_armor_back_helmet")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("add_armor_back_helmet");
		}

		@Override
		public String getName() {
			return "effect.add_armor_back_helmet";
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
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			AddArmorBackHelmetEffectExpiresProcedure.executeProcedure(Collections.emptyMap());
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
