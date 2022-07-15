// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelporkpie extends EntityModel<Entity> {
	private final ModelRenderer porkpie;
	private final ModelRenderer head;

	public Modelporkpie() {
		textureWidth = 64;
		textureHeight = 32;

		porkpie = new ModelRenderer(this);
		porkpie.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		porkpie.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.3F, -4.0F, 8.0F, 4.0F, 8.0F, 0.2F, false);
		head.setTextureOffset(24, 2).addBox(-5.0F, -6.1F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		porkpie.render(matrixStack, buffer, packedLight, packedOverlay);
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