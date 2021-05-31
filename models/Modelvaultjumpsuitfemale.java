// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelvaultjumpsuitfemale extends EntityModel<Entity> {
	private final ModelRenderer jumpsuit;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer body;
	private final ModelRenderer breast;

	public Modelvaultjumpsuitfemale() {
		textureWidth = 64;
		textureHeight = 32;

		jumpsuit = new ModelRenderer(this);
		jumpsuit.setRotationPoint(0.0F, 24.0F, 0.0F);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
		jumpsuit.addChild(leftleg);
		leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.26F, true);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		jumpsuit.addChild(rightleg);
		rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.26F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		jumpsuit.addChild(rightarm);
		rightarm.setTextureOffset(40, 16).addBox(-2.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.26F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
		jumpsuit.addChild(leftarm);
		leftarm.setTextureOffset(40, 16).addBox(-1.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.26F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -24.0F, 0.0F);
		jumpsuit.addChild(body);
		body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.26F, false);

		breast = new ModelRenderer(this);
		breast.setRotationPoint(0.0F, 1.0F, -0.5F);
		body.addChild(breast);
		setRotationAngle(breast, -0.4363F, 0.0F, 0.0F);
		breast.setTextureOffset(18, 10).addBox(-4.0F, 0.65F, -1.49F, 8.0F, 4.0F, 2.0F, 0.26F, false);
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
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}