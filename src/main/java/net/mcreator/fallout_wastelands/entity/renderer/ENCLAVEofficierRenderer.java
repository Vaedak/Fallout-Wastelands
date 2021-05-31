package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.fallout_wastelands.entity.ENCLAVEofficierEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ENCLAVEofficierRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ENCLAVEofficierEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelenclaveofficer(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/enclaveofficer_2.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelenclaveofficer extends EntityModel<Entity> {
		private final ModelRenderer enclaveofficer;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		private final ModelRenderer torso;
		private final ModelRenderer rightarm;
		private final ModelRenderer frontarm;
		private final ModelRenderer rightarm_r1;
		private final ModelRenderer pistol;
		private final ModelRenderer leftarm;
		private final ModelRenderer head;
		private final ModelRenderer visor;
		private final ModelRenderer visor_r1;
		public Modelenclaveofficer() {
			textureWidth = 64;
			textureHeight = 64;
			enclaveofficer = new ModelRenderer(this);
			enclaveofficer.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			enclaveofficer.addChild(rightleg);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
			enclaveofficer.addChild(leftleg);
			leftleg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 0.0F, 0.0F);
			enclaveofficer.addChild(torso);
			torso.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-4.0F, -22.0F, 0.0F);
			enclaveofficer.addChild(rightarm);
			setRotationAngle(rightarm, 0.0F, -0.3054F, 0.0436F);
			rightarm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			frontarm = new ModelRenderer(this);
			frontarm.setRotationPoint(-1.959F, 3.7311F, -0.4912F);
			rightarm.addChild(frontarm);
			setRotationAngle(frontarm, -1.309F, -0.0436F, 0.0F);
			rightarm_r1 = new ModelRenderer(this);
			rightarm_r1.setRotationPoint(1.959F, -3.7311F, 0.4912F);
			frontarm.addChild(rightarm_r1);
			setRotationAngle(rightarm_r1, -0.2182F, 0.0F, 0.0F);
			rightarm_r1.setTextureOffset(40, 26).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
			pistol = new ModelRenderer(this);
			pistol.setRotationPoint(-1.5206F, 5.7691F, -3.99F);
			frontarm.addChild(pistol);
			setRotationAngle(pistol, -0.7418F, 0.0F, 0.3054F);
			pistol.setTextureOffset(0, 32).addBox(-0.5F, -2.5F, -2.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(4.0F, -22.0F, 0.0F);
			enclaveofficer.addChild(leftarm);
			leftarm.setTextureOffset(32, 48).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			enclaveofficer.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			visor = new ModelRenderer(this);
			visor.setRotationPoint(0.0F, -4.5F, -4.0F);
			head.addChild(visor);
			setRotationAngle(visor, 0.3054F, 0.0F, 0.0F);
			visor_r1 = new ModelRenderer(this);
			visor_r1.setRotationPoint(-3.0F, 0.5F, 0.0F);
			visor.addChild(visor_r1);
			setRotationAngle(visor_r1, 0.1745F, 0.0F, 0.0F);
			visor_r1.setTextureOffset(38, 9).addBox(-1.0F, -1.0F, -1.6F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			enclaveofficer.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
