// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeltfourtyfive extends EntityModel<Entity> {
	private final ModelRenderer powerarmor;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightshoulder;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftshoulder;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer tube;
	private final ModelRenderer lamptow;

	public Modeltfourtyfive() {
		textureWidth = 128;
		textureHeight = 32;

		powerarmor = new ModelRenderer(this);
		powerarmor.setRotationPoint(0.0F, 24.0F, 0.0F);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		powerarmor.addChild(rightleg);
		rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);
		rightleg.setTextureOffset(120, 19).addBox(-1.5F, 4.0F, -3.0F, 3.0F, 3.0F, 1.0F, 0.4F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
		powerarmor.addChild(leftleg);
		leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);
		leftleg.setTextureOffset(120, 19).addBox(-1.5F, 4.0F, -3.0F, 3.0F, 3.0F, 1.0F, 0.4F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		powerarmor.addChild(rightarm);
		rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);

		rightshoulder = new ModelRenderer(this);
		rightshoulder.setRotationPoint(1.5F, -4.0F, 0.0F);
		rightarm.addChild(rightshoulder);
		setRotationAngle(rightshoulder, 0.0F, 0.0F, -0.2618F);
		rightshoulder.setTextureOffset(57, 24).addBox(-7.5F, 0.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.4F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
		powerarmor.addChild(leftarm);
		leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);

		leftshoulder = new ModelRenderer(this);
		leftshoulder.setRotationPoint(-1.5F, -4.0F, 0.0F);
		leftarm.addChild(leftshoulder);
		setRotationAngle(leftshoulder, 0.0F, 0.0F, 0.2618F);
		leftshoulder.setTextureOffset(57, 24).addBox(0.5F, 0.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.4F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -24.0F, 0.0F);
		powerarmor.addChild(body);
		body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.4F, false);
		body.setTextureOffset(89, 17).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.4F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		powerarmor.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);
		head.setTextureOffset(123, 24).addBox(2.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.4F, false);

		tube = new ModelRenderer(this);
		tube.setRotationPoint(0.0F, -2.5F, 0.5F);
		head.addChild(tube);
		setRotationAngle(tube, 0.1745F, 0.0F, 0.0F);
		tube.setTextureOffset(58, 15).addBox(-5.0F, -0.5F, -4.0F, 10.0F, 1.0F, 7.0F, 0.4F, false);

		lamptow = new ModelRenderer(this);
		lamptow.setRotationPoint(-5.6F, -7.0F, -0.5F);
		head.addChild(lamptow);
		setRotationAngle(lamptow, 0.0F, 0.0F, -0.7854F);
		lamptow.setTextureOffset(76, 24).addBox(-1.0F, -0.5F, -3.5F, 1.0F, 2.0F, 4.0F, 0.4F, false);
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