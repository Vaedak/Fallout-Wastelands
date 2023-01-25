
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.fallout_wastelands.particle.MotesParticle;
import net.mcreator.fallout_wastelands.client.particle.PlasmaParticle;
import net.mcreator.fallout_wastelands.client.particle.MotesParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FalloutWastelandsModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(FalloutWastelandsModParticleTypes.PLASMA.get(), PlasmaParticle::provider);
		event.register(FalloutWastelandsModParticleTypes.MOTES.get(), MotesParticle::provider);
	}
}
