
package net.mcreator.fallout_wastelands.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class NightkinRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(NightkinEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsupermutantnightkincc(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/entities/nightkin.png");
					}

				};
			});

		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports

	public static class Modelsupermutantnightkincc extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;

		public Modelsupermutantnightkincc() {
			textureWidth = 128;
			textureHeight = 128;

			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -14.0F, -2.0F);
			Head.setTextureOffset(0, 18).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(0, 0).addBox(-6.0F, -10.0F, -4.0F, 12.0F, 10.0F, 8.0F, 0.0F, false);
			Body.setTextureOffset(26, 28).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 6.0F, 6.0F, 0.0F, false);

			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-8.0F, -7.0F, -1.0F);
			RightArm.setTextureOffset(40, 0).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
			RightArm.setTextureOffset(52, 52).addBox(-2.0F, -2.0F, -2.25F, 4.0F, 7.0F, 4.0F, 0.0F, false);
			RightArm.setTextureOffset(0, 64).addBox(-1.0F, 14.0F, -22.0F, 2.0F, 1.0F, 33.0F, 0.0F, false);
			RightArm.setTextureOffset(0, 112).addBox(-3.0F, 10.0F, -19.0F, 6.0F, 7.0F, 9.0F, 0.0F, false);

			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(8.0F, -7.0F, -1.0F);
			LeftArm.setTextureOffset(40, 40).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
			LeftArm.setTextureOffset(36, 15).addBox(-2.0F, -2.0F, -2.25F, 4.0F, 7.0F, 4.0F, 0.0F, false);

			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 6.0F, 0.0F);
			RightLeg.setTextureOffset(20, 40).addBox(-3.1F, 0.0F, -3.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);

			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 6.0F, 0.0F);
			LeftLeg.setTextureOffset(0, 34).addBox(-1.9F, 0.0F, -3.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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

}
