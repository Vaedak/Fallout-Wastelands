// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelxoone extends EntityModel<Entity> {
	private final ModelRenderer powerarmor;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightarm;
	private final ModelRenderer rightshoulder;
	private final ModelRenderer leftarm;
	private final ModelRenderer leftshoulder;
	private final ModelRenderer body;
	private final ModelRenderer torso;
	private final ModelRenderer plate;
	private final ModelRenderer back;
	private final ModelRenderer head;
	private final ModelRenderer pipe;
	private final ModelRenderer nose;

	public Modelxoone() {
		textureWidth = 128;
		textureHeight = 32;

		powerarmor = new ModelRenderer(this);
		powerarmor.setRotationPoint(0.0F, 24.0F, 0.0F);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		powerarmor.addChild(rightleg);
		rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
		powerarmor.addChild(leftleg);
		leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		powerarmor.addChild(rightarm);
		rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);

		rightshoulder = new ModelRenderer(this);
		rightshoulder.setRotationPoint(1.5F, -4.0F, 0.0F);
		rightarm.addChild(rightshoulder);
		setRotationAngle(rightshoulder, 0.0F, 0.0F, -0.2618F);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
		powerarmor.addChild(leftarm);
		leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);

		leftshoulder = new ModelRenderer(this);
		leftshoulder.setRotationPoint(-1.5F, -4.0F, 0.0F);
		leftarm.addChild(leftshoulder);
		setRotationAngle(leftshoulder, 0.0F, 0.0F, 0.2618F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -24.0F, 0.0F);
		powerarmor.addChild(body);
		body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.4F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 3.0F, -2.0F);
		body.addChild(torso);
		setRotationAngle(torso, 0.3491F, 0.0F, 0.0F);
		torso.setTextureOffset(16, 16).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.4F, false);

		plate = new ModelRenderer(this);
		plate.setRotationPoint(0.0F, 0.0F, 1.0F);
		body.addChild(plate);
		setRotationAngle(plate, 0.3491F, 0.0F, 0.0F);
		plate.setTextureOffset(56, 19).addBox(-8.0F, -2.6041F, -6.1278F, 16.0F, 3.0F, 10.0F, 0.4F, false);

		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 0.0F, 4.0F);
		body.addChild(back);
		setRotationAngle(back, -0.384F, 0.0F, 0.0F);
		back.setTextureOffset(78, 16).addBox(-8.0F, -1.173F, -2.6391F, 16.0F, 4.0F, 3.0F, 0.4F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		powerarmor.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);
		head.setTextureOffset(83, 17).addBox(-5.0F, -4.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.4F, false);

		pipe = new ModelRenderer(this);
		pipe.setRotationPoint(-4.5F, -8.0F, 0.5F);
		head.addChild(pipe);
		setRotationAngle(pipe, 0.0F, 0.0F, 0.6981F);
		pipe.setTextureOffset(108, 23).addBox(0.0F, -1.0F, -3.5F, 1.0F, 2.0F, 7.0F, 0.4F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(-2.0F, 0.0F, 0.0F);
		head.addChild(nose);
		setRotationAngle(nose, 0.0F, 0.0F, 0.7854F);
		nose.setTextureOffset(13, 16).addBox(-1.1F, -4.0F, -5.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
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