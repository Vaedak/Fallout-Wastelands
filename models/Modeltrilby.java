// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeltrilby extends EntityModel<Entity> {
	private final ModelRenderer trilby;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;

	public Modeltrilby() {
		textureWidth = 64;
		textureHeight = 32;

		trilby = new ModelRenderer(this);
		trilby.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		trilby.addChild(head);
		head.setTextureOffset(24, 2).addBox(-5.0F, -6.1F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, -6.3F, 1.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, -0.0436F, 0.0F, 0.0F);
		head_r1.setTextureOffset(0, 0).addBox(-4.0F, -1.8F, -4.8F, 8.0F, 4.0F, 8.0F, 0.2F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		trilby.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}