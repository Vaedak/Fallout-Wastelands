// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelLeFangeux extends EntityModel<Entity> {
	private final ModelRenderer mirelurk;
	private final ModelRenderer body;
	private final ModelRenderer adbomn;
	private final ModelRenderer torso;
	private final ModelRenderer scaleone;
	private final ModelRenderer scaletwo;
	private final ModelRenderer scalethree;
	private final ModelRenderer scaleright;
	private final ModelRenderer scaleleft;
	private final ModelRenderer head;
	private final ModelRenderer rightlegtoanimate;
	private final ModelRenderer foreleg;
	private final ModelRenderer feet;
	private final ModelRenderer fingerone;
	private final ModelRenderer fingertwo;
	private final ModelRenderer upperleg;
	private final ModelRenderer leftlegtoanimate;
	private final ModelRenderer forelegright;
	private final ModelRenderer feetright;
	private final ModelRenderer fingeroneright;
	private final ModelRenderer fingertworight;
	private final ModelRenderer upperlegright;
	private final ModelRenderer arm;
	private final ModelRenderer pinch;
	private final ModelRenderer cutterone;
	private final ModelRenderer cuttertwo;
	private final ModelRenderer armright;
	private final ModelRenderer pinch2;
	private final ModelRenderer cutterone2;
	private final ModelRenderer cuttertwo2;

	public ModelLeFangeux() {
		textureWidth = 128;
		textureHeight = 128;

		mirelurk = new ModelRenderer(this);
		mirelurk.setRotationPoint(0.0F, 24.0F, -1.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, -1.0F);
		mirelurk.addChild(body);
		body.setTextureOffset(35, 64).addBox(-7.0F, -28.6341F, -3.4041F, 14.0F, 1.0F, 8.0F, 0.0F, false);

		adbomn = new ModelRenderer(this);
		adbomn.setRotationPoint(0.0F, -13.5F, 2.0F);
		body.addChild(adbomn);
		setRotationAngle(adbomn, -0.2618F, 0.0F, 0.0F);
		adbomn.setTextureOffset(0, 115).addBox(-4.0F, -8.5F, -2.0F, 8.0F, 9.0F, 4.0F, 0.0F, false);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -21.5F, 4.0F);
		body.addChild(torso);
		setRotationAngle(torso, 0.3491F, 0.0F, 0.0F);
		torso.setTextureOffset(85, 112).addBox(-7.0F, -6.5F, -5.0F, 14.0F, 8.0F, 8.0F, 0.0F, false);

		scaleone = new ModelRenderer(this);
		scaleone.setRotationPoint(0.0F, 1.5F, 2.5F);
		torso.addChild(scaleone);
		setRotationAngle(scaleone, -0.2618F, 0.0F, 0.0F);
		scaleone.setTextureOffset(57, 18).addBox(-5.0F, 0.0F, -0.5F, 10.0F, 4.0F, 1.0F, 0.0F, false);

		scaletwo = new ModelRenderer(this);
		scaletwo.setRotationPoint(0.0F, 3.6985F, 0.2899F);
		scaleone.addChild(scaletwo);
		setRotationAngle(scaletwo, -0.3491F, 0.0F, 0.0F);
		scaletwo.setTextureOffset(57, 36).addBox(-3.0F, 0.5535F, -0.6391F, 6.0F, 8.0F, 1.0F, 0.0F, false);

		scalethree = new ModelRenderer(this);
		scalethree.setRotationPoint(0.0F, 4.8296F, 1.2941F);
		scaletwo.addChild(scalethree);
		setRotationAngle(scalethree, 0.5236F, 0.0F, 0.0F);
		scalethree.setTextureOffset(59, 57).addBox(-1.0F, 2.5172F, -3.5702F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		scaleright = new ModelRenderer(this);
		scaleright.setRotationPoint(0.0F, -28.1341F, 0.5959F);
		body.addChild(scaleright);
		setRotationAngle(scaleright, 0.0F, 0.0F, -0.6109F);
		scaleright.setTextureOffset(101, 89).addBox(-11.4473F, -4.4246F, -4.0F, 6.0F, 6.0F, 8.0F, 0.0F, true);

		scaleleft = new ModelRenderer(this);
		scaleleft.setRotationPoint(0.0F, -28.1341F, 0.5959F);
		body.addChild(scaleleft);
		setRotationAngle(scaleleft, 0.0F, 0.0F, 0.6109F);
		scaleleft.setTextureOffset(101, 89).addBox(5.4473F, -4.4246F, -4.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -25.5F, -3.0F);
		mirelurk.addChild(head);
		head.setTextureOffset(105, 0).addBox(-4.5F, -2.5F, -2.0F, 9.0F, 5.0F, 4.0F, 0.0F, false);

		rightlegtoanimate = new ModelRenderer(this);
		rightlegtoanimate.setRotationPoint(-4.0F, -13.0F, 1.0F);
		mirelurk.addChild(rightlegtoanimate);

		foreleg = new ModelRenderer(this);
		foreleg.setRotationPoint(2.0F, 13.0F, 4.0F);
		rightlegtoanimate.addChild(foreleg);
		setRotationAngle(foreleg, 0.6981F, 0.0F, 0.0F);
		foreleg.setTextureOffset(48, 117).addBox(-5.0F, -9.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		feet = new ModelRenderer(this);
		feet.setRotationPoint(-3.0F, -3.0F, 0.0F);
		foreleg.addChild(feet);
		setRotationAngle(feet, -0.3491F, 0.3491F, -0.2618F);
		feet.setTextureOffset(113, 44).addBox(-2.0F, -0.5163F, -3.3289F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		fingerone = new ModelRenderer(this);
		fingerone.setRotationPoint(-1.0F, 0.4837F, -3.3289F);
		feet.addChild(fingerone);
		setRotationAngle(fingerone, -0.3491F, 0.2618F, -0.0873F);
		fingerone.setTextureOffset(110, 50).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		fingertwo = new ModelRenderer(this);
		fingertwo.setRotationPoint(1.0F, 0.4837F, -3.3289F);
		feet.addChild(fingertwo);
		setRotationAngle(fingertwo, -0.3491F, -0.2618F, 0.0873F);
		fingertwo.setTextureOffset(110, 50).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);

		upperleg = new ModelRenderer(this);
		upperleg.setRotationPoint(-1.0F, 6.0F, -2.0F);
		rightlegtoanimate.addChild(upperleg);
		setRotationAngle(upperleg, -0.2618F, 0.0F, 0.1745F);
		upperleg.setTextureOffset(0, 78).addBox(-1.5F, -7.3132F, -1.6211F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		leftlegtoanimate = new ModelRenderer(this);
		leftlegtoanimate.setRotationPoint(4.0F, -13.0F, 1.0F);
		mirelurk.addChild(leftlegtoanimate);

		forelegright = new ModelRenderer(this);
		forelegright.setRotationPoint(-2.0F, 13.0F, 4.0F);
		leftlegtoanimate.addChild(forelegright);
		setRotationAngle(forelegright, 0.6981F, 0.0F, 0.0F);
		forelegright.setTextureOffset(48, 117).addBox(1.0F, -9.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, true);

		feetright = new ModelRenderer(this);
		feetright.setRotationPoint(3.0F, -3.0F, 0.0F);
		forelegright.addChild(feetright);
		setRotationAngle(feetright, -0.3491F, -0.3491F, 0.2618F);
		feetright.setTextureOffset(113, 44).addBox(-2.0F, -0.5163F, -3.3289F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		fingeroneright = new ModelRenderer(this);
		fingeroneright.setRotationPoint(1.0F, 0.4837F, -3.3289F);
		feetright.addChild(fingeroneright);
		setRotationAngle(fingeroneright, -0.3491F, -0.2618F, 0.0873F);
		fingeroneright.setTextureOffset(110, 50).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);

		fingertworight = new ModelRenderer(this);
		fingertworight.setRotationPoint(-1.0F, 0.4837F, -3.3289F);
		feetright.addChild(fingertworight);
		setRotationAngle(fingertworight, -0.3491F, 0.2618F, -0.0873F);
		fingertworight.setTextureOffset(110, 50).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		upperlegright = new ModelRenderer(this);
		upperlegright.setRotationPoint(1.0F, 6.0F, -2.0F);
		leftlegtoanimate.addChild(upperlegright);
		setRotationAngle(upperlegright, -0.2618F, 0.0F, -0.1745F);
		upperlegright.setTextureOffset(0, 78).addBox(-1.5F, -7.3132F, -1.6211F, 3.0F, 8.0F, 3.0F, 0.0F, true);

		arm = new ModelRenderer(this);
		arm.setRotationPoint(-7.0F, -24.0F, 1.0F);
		mirelurk.addChild(arm);
		setRotationAngle(arm, 0.0F, 0.0F, 0.5236F);
		arm.setTextureOffset(0, 38).addBox(-3.5F, -0.134F, -3.0F, 4.0F, 11.0F, 5.0F, 0.0F, false);

		pinch = new ModelRenderer(this);
		pinch.setRotationPoint(-2.2942F, 9.0263F, -2.0F);
		arm.addChild(pinch);
		setRotationAngle(pinch, -0.1745F, 0.0F, 0.0F);
		pinch.setTextureOffset(0, 61).addBox(-2.0F, 0.0F, -7.0F, 5.0F, 5.0F, 10.0F, 0.0F, false);

		cutterone = new ModelRenderer(this);
		cutterone.setRotationPoint(-0.366F, 2.9081F, -8.6261F);
		pinch.addChild(cutterone);
		setRotationAngle(cutterone, 0.0F, 0.1745F, 0.0F);
		cutterone.setTextureOffset(51, 91).addBox(-2.0F, -1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

		cuttertwo = new ModelRenderer(this);
		cuttertwo.setRotationPoint(3.0981F, 0.9385F, -8.9734F);
		pinch.addChild(cuttertwo);
		setRotationAngle(cuttertwo, 0.0F, -0.4363F, 0.0F);
		cuttertwo.setTextureOffset(29, 83).addBox(-1.0674F, 1.7057F, -2.5302F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		armright = new ModelRenderer(this);
		armright.setRotationPoint(7.0F, -24.0F, 1.0F);
		mirelurk.addChild(armright);
		setRotationAngle(armright, 0.0F, 0.0F, -0.5236F);
		armright.setTextureOffset(0, 38).addBox(-0.5F, -0.134F, -3.0F, 4.0F, 11.0F, 5.0F, 0.0F, true);

		pinch2 = new ModelRenderer(this);
		pinch2.setRotationPoint(2.2942F, 9.0263F, -2.0F);
		armright.addChild(pinch2);
		setRotationAngle(pinch2, -0.1745F, 0.0F, 0.0F);
		pinch2.setTextureOffset(0, 61).addBox(-3.0F, 0.0F, -7.0F, 5.0F, 5.0F, 10.0F, 0.0F, true);

		cutterone2 = new ModelRenderer(this);
		cutterone2.setRotationPoint(0.366F, 2.9081F, -8.6261F);
		pinch2.addChild(cutterone2);
		setRotationAngle(cutterone2, 0.0F, -0.1745F, 0.0F);
		cutterone2.setTextureOffset(51, 91).addBox(-1.0F, -1.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, true);

		cuttertwo2 = new ModelRenderer(this);
		cuttertwo2.setRotationPoint(-3.0981F, 0.9385F, -8.9734F);
		pinch2.addChild(cuttertwo2);
		setRotationAngle(cuttertwo2, 0.0F, 0.4363F, 0.0F);
		cuttertwo2.setTextureOffset(29, 83).addBox(-0.9326F, 1.7057F, -2.5302F, 2.0F, 1.0F, 5.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		mirelurk.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightlegtoanimate.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftlegtoanimate.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}