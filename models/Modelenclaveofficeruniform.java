// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelenclaveofficeruniform extends EntityModel<Entity> {
	private final ModelRenderer enclaveofficer;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer torso;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer head;
	private final ModelRenderer visor;
	private final ModelRenderer visor_r1;

	public Modelenclaveofficeruniform() {
		textureWidth = 128;
		textureHeight = 32;

		enclaveofficer = new ModelRenderer(this);
		enclaveofficer.setRotationPoint(0.0F, 24.0F, 0.0F);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
		enclaveofficer.addChild(leftleg);
		leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		enclaveofficer.addChild(rightleg);
		rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -24.0F, 0.0F);
		enclaveofficer.addChild(torso);
		torso.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.2F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		enclaveofficer.addChild(rightarm);
		rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
		enclaveofficer.addChild(leftarm);
		leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		enclaveofficer.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.3F, false);

		visor = new ModelRenderer(this);
		visor.setRotationPoint(0.0F, -4.5F, -4.0F);
		head.addChild(visor);
		setRotationAngle(visor, 0.3054F, 0.0F, 0.0F);

		visor_r1 = new ModelRenderer(this);
		visor_r1.setRotationPoint(-3.0F, 0.5F, 0.0F);
		visor.addChild(visor_r1);
		setRotationAngle(visor_r1, 0.1745F, 0.0F, 0.0F);
		visor_r1.setTextureOffset(92, 17).addBox(-1.0F, -1.0F, -1.6F, 8.0F, 1.0F, 2.0F, 0.2F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		enclaveofficer.render(matrixStack, buffer, packedLight, packedOverlay);
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