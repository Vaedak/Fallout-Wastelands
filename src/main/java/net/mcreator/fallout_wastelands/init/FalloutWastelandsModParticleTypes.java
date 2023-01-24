
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES,
			FalloutWastelandsMod.MODID);
	public static final RegistryObject<SimpleParticleType> PLASMA = REGISTRY.register("plasma", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> MOTES = REGISTRY.register("motes", () -> new SimpleParticleType(false));
}
