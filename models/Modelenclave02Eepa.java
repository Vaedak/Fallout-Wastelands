// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelenclave02Eepa extends EntityModel<Entity> {
	private final ModelRenderer pa;
	private final ModelRenderer Head;
	private final ModelRenderer partB1;
	private final ModelRenderer partB2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Body;
	private final ModelRenderer partA1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer partA2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelenclave02Eepa() {
		textureWidth = 64;
		textureHeight = 64;

		pa = new ModelRenderer(this);
		pa.setRotationPoint(0.0F, 6.0F, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -6.0F, 0.0F);
		pa.addChild(Head);
		Head.setTextureOffset(0, 13).addBox(-4.1F, -8.0F, -4.1F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		partB1 = new ModelRenderer(this);
		partB1.setRotationPoint(0.0F, -4.0F, 0.0F);
		Head.addChild(partB1);
		partB1.setTextureOffset(32, 13).addBox(-5.2F, -0.2F, -2.2F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		partB1.setTextureOffset(32, 13).addBox(-5.0F, -4.0F, -3.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		partB2 = new ModelRenderer(this);
		partB2.setRotationPoint(8.0F, 0.0F, -8.0F);
		Head.addChild(partB2);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-4.0F, -3.0F, 8.0F);
		partB2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-0.2F, -0.2F, -2.2F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		pa.addChild(Body);
		Body.setTextureOffset(28, 28).addBox(-4.25F, -6.25F, -2.35F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		partA1 = new ModelRenderer(this);
		partA1.setRotationPoint(8.0F, -6.0F, -8.0F);
		Body.addChild(partA1);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-8.0F, -6.0F, 8.0F);
		partA1.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-8.2F, 3.6F, -8.2F, 16.0F, 3.0F, 10.0F, 0.0F, false);

		partA2 = new ModelRenderer(this);
		partA2.setRotationPoint(8.0F, -6.0F, -8.0F);
		Body.addChild(partA2);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-8.0F, 0.9821F, 10.7608F);
		partA2.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3927F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(14, 58).addBox(-8.201F, -2.201F, -1.3108F, 16.0F, 4.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-6.0F, -4.0F, 1.0F);
		pa.addChild(RightArm);
		RightArm.setTextureOffset(0, 45).addBox(-2.4F, -2.3F, -3.3F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(6.0F, -4.0F, 0.0F);
		pa.addChild(LeftArm);
		LeftArm.setTextureOffset(32, 44).addBox(-2.1F, -2.3F, -2.3F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, 5.78F, -0.22F);
		pa.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 29).addBox(-2.12F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.68F, 5.78F, -0.22F);
		pa.addChild(LeftLeg);
		LeftLeg.setTextureOffset(16, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		pa.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}