
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, FalloutWastelandsMod.MODID);
	public static final RegistryObject<Potion> RADIATION = REGISTRY.register("radiation",
			() -> new Potion(new MobEffectInstance(FalloutWastelandsModMobEffects.RADIATION.get(), 3600, 0, false, true)));
}
