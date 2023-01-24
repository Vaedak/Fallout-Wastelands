
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.fallout_wastelands.fluid.FevgooFluid;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, FalloutWastelandsMod.MODID);
	public static final RegistryObject<FlowingFluid> FEVGOO = REGISTRY.register("fevgoo", () -> new FevgooFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_FEVGOO = REGISTRY.register("flowing_fevgoo", () -> new FevgooFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FEVGOO.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FEVGOO.get(), RenderType.translucent());
		}
	}
}
