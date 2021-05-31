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

import net.mcreator.fallout_wastelands.entity.BasesupermutantEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BasesupermutantRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BasesupermutantEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsupermutant(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/supermutantbase.png");
					}
				};
			});
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelsupermutant extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		public Modelsupermutant() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -14.0F, -2.0F);
			addBoxHelper(Head, 0, 18, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			addBoxHelper(Body, 0, 0, -6.0F, -10.0F, -4.0F, 12, 10, 8, 0.0F, false);
			addBoxHelper(Body, 26, 28, -5.0F, 0.0F, -3.0F, 10, 6, 6, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-8.0F, -7.0F, -1.0F);
			addBoxHelper(RightArm, 40, 0, -2.0F, 5.0F, -2.0F, 4, 11, 4, 0.0F, false);
			addBoxHelper(RightArm, 52, 52, -2.0F, -2.0F, -2.25F, 4, 7, 4, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(8.0F, -7.0F, -1.0F);
			addBoxHelper(LeftArm, 40, 40, -2.0F, 5.0F, -2.0F, 4, 11, 4, 0.0F, false);
			addBoxHelper(LeftArm, 36, 15, -2.0F, -2.0F, -2.25F, 4, 7, 4, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 6.0F, 0.0F);
			addBoxHelper(RightLeg, 20, 40, -3.1F, 0.0F, -3.0F, 5, 18, 5, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 6.0F, 0.0F);
			addBoxHelper(LeftLeg, 0, 34, -1.9F, 0.0F, -3.0F, 5, 18, 5, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			Head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			RightArm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			LeftArm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			RightLeg.render(ms, vb, i1, i2, f1, f2, f3, f4);
			LeftLeg.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
