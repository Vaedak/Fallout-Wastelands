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

import net.mcreator.fallout_wastelands.entity.BloatflyEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BloatflyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BloatflyEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelbloatfly(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/bloatflytexture.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelbloatfly extends EntityModel<Entity> {
		private final ModelRenderer bloatfly;
		private final ModelRenderer thorax;
		private final ModelRenderer sting;
		private final ModelRenderer torso;
		private final ModelRenderer head;
		private final ModelRenderer rightpeds;
		private final ModelRenderer leftpeds;
		public Modelbloatfly() {
			textureWidth = 64;
			textureHeight = 32;
			bloatfly = new ModelRenderer(this);
			bloatfly.setRotationPoint(0.0F, 24.0F, 0.0F);
			thorax = new ModelRenderer(this);
			thorax.setRotationPoint(0.0F, -8.0F, 1.5F);
			bloatfly.addChild(thorax);
			setRotationAngle(thorax, 0.2618F, 0.0F, 0.0F);
			thorax.setTextureOffset(42, 19).addBox(-3.0F, -4.0F, -2.5F, 6.0F, 8.0F, 5.0F, 0.0F, false);
			sting = new ModelRenderer(this);
			sting.setRotationPoint(0.0F, 3.6022F, -1.5176F);
			thorax.addChild(sting);
			setRotationAngle(sting, -1.1345F, 0.0F, 0.0F);
			sting.setTextureOffset(54, 0).addBox(-1.5F, 0.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, -12.5F, -0.5F);
			bloatfly.addChild(torso);
			setRotationAngle(torso, -0.5236F, 0.0F, 0.0F);
			torso.setTextureOffset(0, 0).addBox(-2.5F, -3.5F, -2.0F, 5.0F, 6.0F, 4.0F, 0.0F, false);
			torso.setTextureOffset(0, 12).addBox(-8.0F, -6.0F, 0.0F, 16.0F, 5.0F, 0.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -15.5F, -0.5F);
			bloatfly.addChild(head);
			setRotationAngle(head, -0.1745F, 0.0F, 0.0F);
			head.setTextureOffset(20, 24).addBox(-2.0F, -1.5F, -2.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);
			rightpeds = new ModelRenderer(this);
			rightpeds.setRotationPoint(-2.0F, -9.0F, 0.0F);
			bloatfly.addChild(rightpeds);
			setRotationAngle(rightpeds, 0.1745F, -0.6109F, 0.0F);
			rightpeds.setTextureOffset(0, 20).addBox(-6.0F, -5.0F, -1.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);
			leftpeds = new ModelRenderer(this);
			leftpeds.setRotationPoint(2.0F, -9.0F, 0.0F);
			bloatfly.addChild(leftpeds);
			setRotationAngle(leftpeds, 0.1745F, 0.6109F, 0.0F);
			leftpeds.setTextureOffset(0, 20).addBox(0.0F, -5.0F, -1.0F, 6.0F, 12.0F, 0.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bloatfly.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.torso.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.sting.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
