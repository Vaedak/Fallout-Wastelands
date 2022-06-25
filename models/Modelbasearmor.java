// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelbasearmor extends EntityModel<Entity> {
	private final ModelRenderer group;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelbasearmor() {
		textureWidth = 64;
		textureHeight = 64;

		group = new ModelRenderer(this);
		group.setRotationPoint(-8.0F, 16.0F, 8.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(8.0F, -16.0F, -8.0F);
		group.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.2F, -8.1F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(8.0F, -16.0F, -8.0F);
		group.addChild(Body);
		Body.setTextureOffset(16, 16).addBox(-4.2F, -0.1F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(3.0F, -14.0F, -8.0F);
		group.addChild(RightArm);
		RightArm.setTextureOffset(40, 16).addBox(8.9F, -2.1F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(13.0F, -14.0F, -8.0F);
		group.addChild(LeftArm);
		LeftArm.setTextureOffset(32, 48).addBox(-13.1F, -2.1F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(6.1F, -4.0F, -8.0F);
		group.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 16).addBox(1.7F, -0.1F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(9.9F, -4.0F, -8.0F);
		group.addChild(LeftLeg);
		LeftLeg.setTextureOffset(16, 48).addBox(-6.1F, -0.1F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		group.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}