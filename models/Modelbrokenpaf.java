// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelbrokenpaf extends EntityModel<Entity> {
	private final ModelRenderer Frambody;
	private final ModelRenderer HEAD;
	private final ModelRenderer RIGHTLEG;
	private final ModelRenderer right_leg_r1;
	private final ModelRenderer LEFTLEG;
	private final ModelRenderer left_leg_r1;
	private final ModelRenderer LEFTARM;
	private final ModelRenderer RIGHTARM;

	public Modelbrokenpaf() {
		textureWidth = 64;
		textureHeight = 32;

		Frambody = new ModelRenderer(this);
		Frambody.setRotationPoint(0.0F, 23.0F, -3.0F);
		setRotationAngle(Frambody, -1.5708F, 0.0F, 0.0F);
		Frambody.setTextureOffset(16, 16).addBox(-4.0F, -15.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		HEAD = new ModelRenderer(this);
		HEAD.setRotationPoint(0.0F, -8.5F, 0.0F);
		Frambody.addChild(HEAD);
		HEAD.setTextureOffset(0, 0).addBox(-4.0F, -14.5F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		RIGHTLEG = new ModelRenderer(this);
		RIGHTLEG.setRotationPoint(0.0F, 22.5F, -3.0F);

		right_leg_r1 = new ModelRenderer(this);
		right_leg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		RIGHTLEG.addChild(right_leg_r1);
		setRotationAngle(right_leg_r1, -1.5598F, 0.3435F, 0.0631F);
		right_leg_r1.setTextureOffset(0, 16).addBox(-4.5F, -1.5F, -1.5F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LEFTLEG = new ModelRenderer(this);
		LEFTLEG.setRotationPoint(0.0F, 22.5F, -3.0F);
		setRotationAngle(LEFTLEG, -1.4399F, 0.0F, 0.0F);

		left_leg_r1 = new ModelRenderer(this);
		left_leg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		LEFTLEG.addChild(left_leg_r1);
		setRotationAngle(left_leg_r1, 0.0F, 0.0F, -0.3054F);
		left_leg_r1.setTextureOffset(0, 16).addBox(0.8F, -1.5F, -1.6F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LEFTARM = new ModelRenderer(this);
		LEFTARM.setRotationPoint(4.0F, 24.5F, 10.0F);
		setRotationAngle(LEFTARM, 1.478F, -0.3477F, 0.0317F);
		LEFTARM.setTextureOffset(40, 16).addBox(-0.0179F, -10.5491F, -1.4023F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RIGHTARM = new ModelRenderer(this);
		RIGHTARM.setRotationPoint(-4.0F, 24.5F, 10.0F);
		setRotationAngle(RIGHTARM, 1.5256F, 0.2615F, -0.0117F);
		RIGHTARM.setTextureOffset(40, 16).addBox(-3.9932F, -9.5253F, -1.4006F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Frambody.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RIGHTLEG.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LEFTLEG.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LEFTARM.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RIGHTARM.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}