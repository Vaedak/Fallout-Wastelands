
package net.mcreator.fallout_wastelands.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RadioprotectionMobEffect extends MobEffect {
	public RadioprotectionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3152267);
	}

	@Override
	public String getDescriptionId() {
		return "effect.fallout_wastelands.radioprotection";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
