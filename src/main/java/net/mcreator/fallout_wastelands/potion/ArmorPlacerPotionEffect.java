
package net.mcreator.fallout_wastelands.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.World;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.LivingEntity;

import net.mcreator.fallout_wastelands.procedures.ArmorPlacerEffectExpiresProcedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorPlacerPotionEffect {
	@ObjectHolder("fallout_wastelands:armor_placer")
	public static final Effect potion = null;

	@SubscribeEvent
	public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {
		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("armor_placer");
		}

		@Override
		public String getName() {
			return "effect.armor_placer";
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
		public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			ArmorPlacerEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
