
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
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.fallout_wastelands.procedures.MachinegunTurretEntityShakingConditionProcedure;
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MachinegunTurretRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MachinegunTurretEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelturret(), 0.5f) {

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
			});
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelturret extends EntityModel<Entity> {
		private final ModelRenderer turret;
		private final ModelRenderer core;
		private final ModelRenderer cannon_r1;
		private final ModelRenderer side2_r1;
		private final ModelRenderer side_1_r1;
		private final ModelRenderer legs;
		private final ModelRenderer leg_3_r1;
		private final ModelRenderer leg_2_r1;
		private final ModelRenderer leg_1_r1;

		public Modelturret() {
			textureWidth = 64;
			textureHeight = 64;
			turret = new ModelRenderer(this);
			turret.setRotationPoint(0.0F, 20.0F, 0.0F);
			core = new ModelRenderer(this);
			core.setRotationPoint(0.0F, 4.0F, 0.0F);
			turret.addChild(core);
			core.setTextureOffset(1, 1).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);
			cannon_r1 = new ModelRenderer(this);
			cannon_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
			core.addChild(cannon_r1);
			setRotationAngle(cannon_r1, 0.1745F, 0.0F, 0.0F);
			cannon_r1.setTextureOffset(19, 51).addBox(-0.5F, -7.0F, -11.0F, 1.0F, 2.0F, 7.0F, -0.0009F, false);
			cannon_r1.setTextureOffset(43, 3).addBox(-3.0F, -8.0F, -4.0F, 6.0F, 5.0F, 3.0F, -0.0009F, false);
			side2_r1 = new ModelRenderer(this);
			side2_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
			core.addChild(side2_r1);
			setRotationAngle(side2_r1, 0.262F, 0.0421F, 0.0113F);
			side2_r1.setTextureOffset(0, 24).addBox(-6.0F, -8.0F, -2.0F, 3.0F, 4.0F, 8.0F, 0.0F, false);
			side_1_r1 = new ModelRenderer(this);
			side_1_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
			core.addChild(side_1_r1);
			setRotationAngle(side_1_r1, 0.262F, -0.0421F, -0.0113F);
			side_1_r1.setTextureOffset(0, 24).addBox(3.0F, -8.0F, -2.0F, 3.0F, 4.0F, 8.0F, 0.0F, true);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 2.0F, 0.0F);
			turret.addChild(legs);
			leg_3_r1 = new ModelRenderer(this);
			leg_3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			legs.addChild(leg_3_r1);
			setRotationAngle(leg_3_r1, -1.5708F, -1.309F, 1.5708F);
			leg_3_r1.setTextureOffset(4, 51).addBox(-3.0F, -4.0F, -1.0F, 0.0F, 7.0F, 2.0F, -0.0009F, false);
			leg_2_r1 = new ModelRenderer(this);
			leg_2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			legs.addChild(leg_2_r1);
			setRotationAngle(leg_2_r1, 0.2533F, 0.7519F, 0.4059F);
			leg_2_r1.setTextureOffset(4, 51).addBox(-3.0F, -4.0F, -1.0F, 0.0F, 7.0F, 2.0F, -0.0009F, false);
			leg_1_r1 = new ModelRenderer(this);
			leg_1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			legs.addChild(leg_1_r1);
			setRotationAngle(leg_1_r1, 2.8883F, 0.7519F, 2.7357F);
			leg_1_r1.setTextureOffset(4, 51).addBox(-3.0F, -4.0F, -1.0F, 0.0F, 7.0F, 2.0F, -0.0009F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			turret.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.core.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.core.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.cannon_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
		}
	}

}
