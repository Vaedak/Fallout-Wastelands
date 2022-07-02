
package net.mcreator.fallout_wastelands.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class GeckoRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GeckoEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelgecko(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/gecko.png");
					}

				};
			});

		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports

	public static class Modelgecko extends EntityModel<Entity> {
		private final ModelRenderer geckobase;
		private final ModelRenderer leftarm;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer head;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer tail;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer rightarm;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer body;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer rightleg;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer leftleg;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;

		public Modelgecko() {
			textureWidth = 64;
			textureHeight = 64;

			geckobase = new ModelRenderer(this);
			geckobase.setRotationPoint(0.0F, 24.0F, 0.0F);

			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(-4.0F, -13.0F, -2.0F);
			geckobase.addChild(leftarm);

			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(5.2059F, 12.9781F, 5.2638F);
			leftarm.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.2489F, -0.5132F, -0.0952F);
			cube_r1.setTextureOffset(36, 3).addBox(-8.0F, -12.0F, -5.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 1.0F);
			leftarm.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.6887F, 1.1969F, -0.2464F);
			cube_r2.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setRotationPoint(0.2059F, -15.0219F, -5.7362F);
			geckobase.addChild(head);
			head.setTextureOffset(0, 11).addBox(-2.7059F, 1.0219F, -4.2638F, 5.0F, 2.0F, 6.0F, 0.0F, false);

			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.2059F, 12.1131F, 11.1143F);
			head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2182F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-3.0F, -15.0F, -13.0F, 6.0F, 2.0F, 9.0F, 0.0F, false);

			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(2.7941F, -0.9781F, 2.7362F);
			head.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.7592F, 0.648F, 0.2461F);
			cube_r4.setTextureOffset(0, 22).addBox(2.0F, -2.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F, false);

			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(2.7941F, -0.9781F, 2.7362F);
			head.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.7565F, -0.5787F, -0.2742F);
			cube_r5.setTextureOffset(20, 18).addBox(-7.0F, -1.0F, -1.0F, 0.0F, 5.0F, 8.0F, 0.0F, false);

			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, -6.0F, 3.0F);
			geckobase.addChild(tail);

			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 6.0F, -3.0F);
			tail.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.1745F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(12, 31).addBox(-2.0F, -7.0F, 2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 6.0F, -3.0F);
			tail.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.3927F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(0, 35).addBox(-1.0F, -6.0F, 5.0F, 2.0F, 3.0F, 5.0F, 0.0F, false);

			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(1.0F, 5.8332F, -1.8498F);
			tail.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.6109F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(36, 10).addBox(-2.0F, -4.0F, 8.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(4.3365F, -12.3381F, -1.5215F);
			geckobase.addChild(rightarm);

			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-1.3365F, 1.3381F, 1.5215F);
			rightarm.addChild(cube_r9);
			setRotationAngle(cube_r9, 1.0422F, -0.4508F, 0.0922F);
			cube_r9.setTextureOffset(10, 39).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-2.0F, 1.0F, 2.0F);
			rightarm.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.3229F, 0.2954F, 0.3441F);
			cube_r10.setTextureOffset(34, 36).addBox(2.0F, -1.0F, -7.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

			body = new ModelRenderer(this);
			body.setRotationPoint(3.0F, -2.0F, 0.0F);
			geckobase.addChild(body);

			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-3.0F, -12.8035F, 0.7663F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.6109F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 19).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 7.0F, 4.0F, 0.0F, false);

			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-3.0F, 2.0F, 0.0F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.2618F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(20, 15).addBox(-3.0F, -10.0F, 1.0F, 6.0F, 7.0F, 4.0F, 0.0F, false);

			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(3.0F, -6.48F, 1.2649F);
			geckobase.addChild(rightleg);

			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, 4.48F, -1.2649F);
			rightleg.addChild(cube_r13);
			setRotationAngle(cube_r13, -1.309F, -0.5236F, 0.0F);
			cube_r13.setTextureOffset(30, 26).addBox(-0.5F, 0.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-6.0F, 1.0F, -2.0F);
			rightleg.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.5236F, -0.5236F, 0.0F);
			cube_r14.setTextureOffset(25, 8).addBox(5.0F, -2.0F, -3.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);

			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(-3.0F, -7.48F, 2.2649F);
			geckobase.addChild(leftleg);

			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(6.0F, 5.48F, -2.2649F);
			leftleg.addChild(cube_r15);
			setRotationAngle(cube_r15, -1.309F, 0.48F, 0.0F);
			cube_r15.setTextureOffset(21, 0).addBox(-7.0F, 3.0F, -4.8F, 3.0F, 2.0F, 6.0F, 0.0F, false);

			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.0F, 2.0F, -3.0F);
			leftleg.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.5236F, 0.48F, 0.0F);
			cube_r16.setTextureOffset(23, 34).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			geckobase.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.tail.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
