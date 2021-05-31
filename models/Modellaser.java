// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modellaser extends EntityModel<Entity> {
	private final ModelRenderer shot;
	private final ModelRenderer west;

	public Modellaser() {
		textureWidth = 128;
		textureHeight = 128;

		shot = new ModelRenderer(this);
		shot.setRotationPoint(0.0F, 24.0F, 0.0F);
		shot.setTextureOffset(0, 0).addBox(0.0F, -128.0F, -4.0F, 0.0F, 128.0F, 8.0F, 0.0F, false);

		west = new ModelRenderer(this);
		west.setRotationPoint(0.0F, -64.0F, 0.0F);
		shot.addChild(west);
		setRotationAngle(west, 0.0F, -1.5708F, 0.0F);
		west.setTextureOffset(0, 0).addBox(0.0F, -64.0F, -4.0F, 0.0F, 128.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		shot.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}