// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelpowerarmorhelmet extends EntityModel<Entity> {
	private final ModelRenderer powerarmor;
	private final ModelRenderer head;
	private final ModelRenderer tube;
	private final ModelRenderer lamptow;

	public Modelpowerarmorhelmet() {
		textureWidth = 64;
		textureHeight = 32;

		powerarmor = new ModelRenderer(this);
		powerarmor.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		powerarmor.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);
		head.setTextureOffset(38, 16).addBox(2.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.4F, false);

		tube = new ModelRenderer(this);
		tube.setRotationPoint(0.0F, -2.5F, 0.5F);
		head.addChild(tube);
		setRotationAngle(tube, 0.1745F, 0.0F, 0.0F);
		tube.setTextureOffset(0, 17).addBox(-5.0F, -0.5F, -4.0F, 10.0F, 1.0F, 7.0F, 0.4F, false);

		lamptow = new ModelRenderer(this);
		lamptow.setRotationPoint(-5.6F, -7.0F, -0.5F);
		head.addChild(lamptow);
		setRotationAngle(lamptow, 0.0F, 0.0F, -0.7854F);
		lamptow.setTextureOffset(36, 23).addBox(-1.0F, -0.5F, -3.5F, 1.0F, 2.0F, 4.0F, 0.4F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		powerarmor.render(matrixStack, buffer, packedLight, packedOverlay);
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