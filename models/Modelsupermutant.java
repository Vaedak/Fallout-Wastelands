//Made with Blockbench
//Paste this code into your mod.

public static class Modelsupermutant extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modelsupermutant() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -14.0F, -2.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 18, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -6.0F, -10.0F, -4.0F, 12, 10, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 26, 28, -5.0F, 0.0F, -3.0F, 10, 6, 6, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-8.0F, -7.0F, -1.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 0, -2.0F, 5.0F, -2.0F, 4, 11, 4, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 52, 52, -2.0F, -2.0F, -2.25F, 4, 7, 4, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(8.0F, -7.0F, -1.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 40, 40, -2.0F, 5.0F, -2.0F, 4, 11, 4, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 36, 15, -2.0F, -2.0F, -2.25F, 4, 7, 4, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 6.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 20, 40, -3.1F, 0.0F, -3.0F, 5, 18, 5, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 6.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 34, -1.9F, 0.0F, -3.0F, 5, 18, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
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