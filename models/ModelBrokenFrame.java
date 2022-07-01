// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelBrokenFrame extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone5;
	private final ModelRenderer bone3;
	private final ModelRenderer bone6;
	private final ModelRenderer bone4;

	public ModelBrokenFrame() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 22.0F, 0.0F);
		setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-2.0F, 6.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0873F, 0.0F, 0.3054F);
		bone2.setTextureOffset(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(2.0F, 6.0F, 0.0F);
		bone.addChild(bone5);
		setRotationAngle(bone5, 0.4363F, 0.0F, -0.6109F);
		bone5.setTextureOffset(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-6.0F, -4.0F, 0.0F);
		bone.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.6109F);
		bone3.setTextureOffset(24, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(6.0F, -4.0F, 0.0F);
		bone.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, -0.48F);
		bone6.setTextureOffset(24, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -6.0F, 0.0F);
		bone.addChild(bone4);
		setRotationAngle(bone4, -0.2618F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.bone3.rotateAngleZ = f4 / (180F / (float) Math.PI);
		this.bone2.rotateAngleX = f3 / (180F / (float) Math.PI);
		this.bone5.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.bone4.rotateAngleZ = f3 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.bone6.rotateAngleZ = f3 / (180F / (float) Math.PI);
	}
}