// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelsuit extends EntityModel<Entity> {
	private final ModelRenderer suit;
	private final ModelRenderer legright;
	private final ModelRenderer legleft;
	private final ModelRenderer body;
	private final ModelRenderer armright;
	private final ModelRenderer armleft;

	public Modelsuit() {
		textureWidth = 64;
		textureHeight = 32;

		suit = new ModelRenderer(this);
		suit.setRotationPoint(0.0F, 24.0F, 0.0F);

		legright = new ModelRenderer(this);
		legright.setRotationPoint(-2.0F, -12.0F, 0.0F);
		suit.addChild(legright);
		legright.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, false);

		legleft = new ModelRenderer(this);
		legleft.setRotationPoint(2.0F, -12.0F, 0.0F);
		suit.addChild(legleft);
		legleft.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -22.0F, 0.0F);
		suit.addChild(body);
		body.setTextureOffset(16, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 13.0F, 4.0F, 0.12F, false);

		armright = new ModelRenderer(this);
		armright.setRotationPoint(-5.0F, -22.0F, 0.0F);
		suit.addChild(armright);
		armright.setTextureOffset(40, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.11F, false);

		armleft = new ModelRenderer(this);
		armleft.setRotationPoint(5.0F, -22.0F, 0.0F);
		suit.addChild(armleft);
		armleft.setTextureOffset(40, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.11F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		suit.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.legright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.armleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.legleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}