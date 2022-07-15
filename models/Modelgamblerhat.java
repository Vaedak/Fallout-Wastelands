// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelgamblerhat extends EntityModel<Entity> {
	private final ModelRenderer jumpsuit;
	private final ModelRenderer head;
	private final ModelRenderer feather_r1;

	public Modelgamblerhat() {
		textureWidth = 64;
		textureHeight = 32;

		jumpsuit = new ModelRenderer(this);
		jumpsuit.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		jumpsuit.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.2F, false);

		feather_r1 = new ModelRenderer(this);
		feather_r1.setRotationPoint(0.0F, -6.2426F, -5.0F);
		head.addChild(feather_r1);
		setRotationAngle(feather_r1, 0.3491F, -0.3491F, 0.7418F);
		feather_r1.setTextureOffset(33, 5).addBox(-5.6975F, -5.8284F, 0.8505F, 6.0F, 6.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		jumpsuit.render(matrixStack, buffer, packedLight, packedOverlay);
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