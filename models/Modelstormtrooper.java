// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelstormtrooper extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer bone3;
	private final ModelRenderer RightArm;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelstormtrooper() {
		textureWidth = 64;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
		Head.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
		Body.setTextureOffset(52, 122).addBox(-2.0F, 4.0F, -4.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(58, 78).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 98).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(3.0F, 9.0F, 2.0F);
		Body.addChild(bone3);
		setRotationAngle(bone3, -0.2182F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 84).addBox(-6.0F, -9.0F, 0.0F, 6.0F, 9.0F, 3.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -1.0017F, 0.1144F, 0.2236F);
		RightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(7.1687F, 3.5983F, 3.1548F);
		RightArm.addChild(bone);
		setRotationAngle(bone, -0.615F, 0.1131F, -0.1401F);
		bone.setTextureOffset(26, 71).addBox(-5.7622F, 0.7132F, -3.5353F, 2.0F, 9.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(24, 75).addBox(-5.2709F, -3.0807F, -2.6295F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(27, 101).addBox(-5.1429F, -3.1208F, -1.6799F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(7, 76).addBox(-12.6015F, 5.8524F, -2.2276F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.6749F, 0.2207F, -4.0615F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.7854F, 0.0F);
		bone2.setTextureOffset(0, 73).addBox(-5.0733F, 7.9797F, -3.0093F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, -0.8727F, 1.0036F, 0.3491F);
		LeftArm.setTextureOffset(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}