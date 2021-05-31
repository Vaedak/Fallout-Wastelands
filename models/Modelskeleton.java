// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelskeleton extends EntityModel<Entity> {
	private final ModelRenderer waist;
	private final ModelRenderer body;
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer rightArm;
	private final ModelRenderer bone;
	private final ModelRenderer rightItem;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftItem;
	private final ModelRenderer rightLeg;
	private final ModelRenderer bone4;
	private final ModelRenderer leftLeg;
	private final ModelRenderer bone5;

	public Modelskeleton() {
		textureWidth = 64;
		textureHeight = 32;

		waist = new ModelRenderer(this);
		waist.setRotationPoint(0.0F, 12.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -12.0F, 0.0F);
		waist.addChild(body);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 18.0F, -4.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.2182F, 0.0F, 0.0F);
		bone3.setTextureOffset(16, 16).addBox(-4.0F, -18.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 3.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
		bone2.setTextureOffset(16, 22).addBox(-4.0F, -19.1749F, -1.4416F, 8.0F, 6.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(hat);
		hat.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		body.addChild(rightArm);
		setRotationAngle(rightArm, -0.1745F, 0.0F, 0.5236F);
		rightArm.setTextureOffset(40, 16).addBox(-0.7252F, -1.6677F, -1.2516F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(7.3757F, 15.0622F, 3.8963F);
		rightArm.addChild(bone);
		setRotationAngle(bone, 0.4363F, 0.1745F, -0.2618F);
		bone.setTextureOffset(40, 22).addBox(-4.0771F, -13.8064F, -0.123F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		rightItem = new ModelRenderer(this);
		rightItem.setRotationPoint(-1.0F, 7.0F, 1.0F);
		rightArm.addChild(rightItem);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		body.addChild(leftArm);
		setRotationAngle(leftArm, -0.2182F, 0.0F, -0.6545F);
		leftArm.setTextureOffset(40, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		leftItem = new ModelRenderer(this);
		leftItem.setRotationPoint(0.134F, 6.5119F, 0.8918F);
		leftArm.addChild(leftItem);
		setRotationAngle(leftItem, 0.2618F, 0.0F, 0.5672F);
		leftItem.setTextureOffset(0, 20).addBox(-2.0819F, -2.1707F, -1.3769F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		setRotationAngle(rightLeg, 0.3054F, -0.1745F, 0.0F);
		rightLeg.setTextureOffset(0, 16).addBox(-1.0F, -0.8434F, -0.4627F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.0F, 10.7972F, -4.8149F);
		rightLeg.addChild(bone4);
		setRotationAngle(bone4, -0.5672F, 0.0F, 0.0F);
		bone4.setTextureOffset(40, 22).addBox(-2.0F, -8.1702F, 0.3267F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(2.0F, 11.0F, 0.0F);
		body.addChild(leftLeg);
		setRotationAngle(leftLeg, 0.2618F, 0.0873F, 0.0F);
		leftLeg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-2.0F, 6.2588F, 0.9659F);
		leftLeg.addChild(bone5);
		setRotationAngle(bone5, -0.48F, 0.0F, 0.0F);
		bone5.setTextureOffset(40, 16).addBox(1.0F, -0.2726F, -2.0706F, 2.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		waist.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}