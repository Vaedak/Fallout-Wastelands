
package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.BipedRenderer;

import net.mcreator.fallout_wastelands.procedures.MachinegunTurretEntityShakingConditionProcedure;
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@OnlyIn(Dist.CLIENT)
public class MachinegunTurretRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MachinegunTurretEntity.entity, renderManager -> {
				BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/10mm_2.png");
					}

					@Override
					protected boolean func_230495_a_(LivingEntity _ent) {
						Entity entity = _ent;
						World world = entity.world;
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();
						return MachinegunTurretEntityShakingConditionProcedure
								.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				};
				customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

				return customRender;
			});
		}
	}
}
