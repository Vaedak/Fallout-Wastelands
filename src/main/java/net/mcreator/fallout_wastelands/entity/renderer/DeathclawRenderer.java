
package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.fallout_wastelands.entity.DeathclawEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DeathclawRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DeathclawEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeldeathclaw(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/deathclaw.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("fallout_wastelands:textures/deathclawg.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modeldeathclaw extends EntityModel<Entity> {
		private final ModelRenderer deathclaw;
		private final ModelRenderer head_r1;
		private final ModelRenderer armleft_r1;
		private final ModelRenderer arm_r1;
		private final ModelRenderer legleft_r1;
		private final ModelRenderer legright_r1;
		private final ModelRenderer body;
		private final ModelRenderer torso_r1;
		private final ModelRenderer torso;
		private final ModelRenderer legright;
		private final ModelRenderer foot_r1;
		private final ModelRenderer legparter_r1;
		private final ModelRenderer legparter;
		private final ModelRenderer foot;
		private final ModelRenderer footclaws_r1;
		private final ModelRenderer footclaws;
		private final ModelRenderer legleft;
		private final ModelRenderer foot2_r1;
		private final ModelRenderer legparter2_r1;
		private final ModelRenderer legparter2;
		private final ModelRenderer foot2;
		private final ModelRenderer footclaws2_r1;
		private final ModelRenderer footclaws2;
		private final ModelRenderer armright;
		private final ModelRenderer frontarm_r1;
		private final ModelRenderer frontarm;
		private final ModelRenderer armleft;
		private final ModelRenderer frontarm2_r1;
		private final ModelRenderer frontarm2;
		private final ModelRenderer head;
		private final ModelRenderer horns_r1;
		private final ModelRenderer face_r1;
		private final ModelRenderer jaw;
		private final ModelRenderer jawpiece_r1;
		private final ModelRenderer jawpiece_r1_r1;
		private final ModelRenderer horns;

		public Modeldeathclaw() {
			textureWidth = 256;
			textureHeight = 256;
			deathclaw = new ModelRenderer(this);
			deathclaw.setRotationPoint(0.0F, 24.0F, 0.0F);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(-0.3333F, -41.6963F, -10.7227F);
			deathclaw.addChild(head_r1);
			armleft_r1 = new ModelRenderer(this);
			armleft_r1.setRotationPoint(12.0F, -39.0F, 1.0F);
			deathclaw.addChild(armleft_r1);
			setRotationAngle(armleft_r1, 0.8136F, -0.3864F, -0.494F);
			arm_r1 = new ModelRenderer(this);
			arm_r1.setRotationPoint(-12.0F, -39.0F, 1.0F);
			deathclaw.addChild(arm_r1);
			setRotationAngle(arm_r1, 0.8136F, 0.3864F, 0.494F);
			legleft_r1 = new ModelRenderer(this);
			legleft_r1.setRotationPoint(6.0F, -18.5F, 5.5F);
			deathclaw.addChild(legleft_r1);
			setRotationAngle(legleft_r1, -0.8727F, -0.2618F, -0.0436F);
			legright_r1 = new ModelRenderer(this);
			legright_r1.setRotationPoint(-6.0F, -18.5F, 5.5F);
			deathclaw.addChild(legright_r1);
			setRotationAngle(legright_r1, -0.8727F, 0.2618F, 0.0436F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -18.6667F, 5.8333F);
			deathclaw.addChild(body);
			body.setTextureOffset(0, 79).addBox(-6.0F, -20.3333F, -5.8333F, 12.0F, 20.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(0.0F, -34.3333F, -7.8333F, 0.0F, 50.0F, 29.0F, 0.0F, false);
			body.setTextureOffset(88, 32).addBox(-6.0F, -27.0F, -17.0F, 12.0F, 10.0F, 8.0F, 0.0F, false);
			torso_r1 = new ModelRenderer(this);
			torso_r1.setRotationPoint(-4.0F, -7.8333F, 0.6667F);
			body.addChild(torso_r1);
			setRotationAngle(torso_r1, 0.9599F, 0.0F, 0.0F);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(-4.0F, -7.8333F, 0.6667F);
			body.addChild(torso);
			setRotationAngle(torso, 0.9599F, 0.0F, 0.0F);
			torso.setTextureOffset(0, 0).addBox(-6.0F, -19.3027F, -0.7531F, 20.0F, 15.0F, 13.0F, 0.0F, false);
			legright = new ModelRenderer(this);
			legright.setRotationPoint(-6.0F, -18.5F, 5.5F);
			deathclaw.addChild(legright);
			setRotationAngle(legright, -0.8727F, 0.2618F, 0.0436F);
			legright.setTextureOffset(112, 82).addBox(-3.0F, -3.5F, -3.5F, 6.0F, 15.0F, 6.0F, 0.0F, false);
			foot_r1 = new ModelRenderer(this);
			foot_r1.setRotationPoint(-0.0847F, 10.8965F, 12.982F);
			legright.addChild(foot_r1);
			setRotationAngle(foot_r1, -0.6981F, 0.0436F, 0.0F);
			legparter_r1 = new ModelRenderer(this);
			legparter_r1.setRotationPoint(1.4241F, 11.9817F, -0.6651F);
			legright.addChild(legparter_r1);
			setRotationAngle(legparter_r1, 0.6109F, 0.0F, 0.0F);
			legparter = new ModelRenderer(this);
			legparter.setRotationPoint(1.4241F, 11.9817F, -0.6651F);
			legright.addChild(legparter);
			setRotationAngle(legparter, 0.6109F, 0.0F, 0.0F);
			legparter.setTextureOffset(86, 88).addBox(-3.4863F, -1.8872F, -2.584F, 4.0F, 4.0F, 17.0F, 0.0F, false);
			legparter.setTextureOffset(58, 58).addBox(-2.8599F, 2.1218F, 11.3985F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			foot = new ModelRenderer(this);
			foot.setRotationPoint(-0.0847F, 10.8965F, 12.982F);
			legright.addChild(foot);
			setRotationAngle(foot, -0.6981F, 0.0436F, 0.0F);
			foot.setTextureOffset(34, 79).addBox(-3.5F, -2.5F, -0.3612F, 7.0F, 5.0F, 2.0F, 0.0F, false);
			foot.setTextureOffset(70, 9).addBox(0.0F, -1.0F, -0.482F, 0.0F, 10.0F, 2.0F, 0.0F, false);
			footclaws_r1 = new ModelRenderer(this);
			footclaws_r1.setRotationPoint(-0.8332F, 3.1422F, 0.5638F);
			foot.addChild(footclaws_r1);
			setRotationAngle(footclaws_r1, 0.0F, 0.0F, 0.7418F);
			footclaws = new ModelRenderer(this);
			footclaws.setRotationPoint(-0.8332F, 3.1422F, 0.5638F);
			foot.addChild(footclaws);
			setRotationAngle(footclaws, 0.0F, 0.0F, 0.7418F);
			footclaws.setTextureOffset(58, 32).addBox(-4.0F, -5.0F, -1.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			legleft = new ModelRenderer(this);
			legleft.setRotationPoint(6.0F, -18.5F, 5.5F);
			deathclaw.addChild(legleft);
			setRotationAngle(legleft, -0.8727F, -0.2618F, -0.0436F);
			legleft.setTextureOffset(90, 109).addBox(-3.0F, -3.5F, -3.5F, 6.0F, 15.0F, 6.0F, 0.0F, false);
			foot2_r1 = new ModelRenderer(this);
			foot2_r1.setRotationPoint(0.0847F, 10.8965F, 12.982F);
			legleft.addChild(foot2_r1);
			setRotationAngle(foot2_r1, -0.6981F, -0.0436F, 0.0F);
			legparter2_r1 = new ModelRenderer(this);
			legparter2_r1.setRotationPoint(-1.4241F, 11.9817F, -0.6651F);
			legleft.addChild(legparter2_r1);
			setRotationAngle(legparter2_r1, 0.6109F, 0.0F, 0.0F);
			legparter2 = new ModelRenderer(this);
			legparter2.setRotationPoint(-1.4241F, 11.9817F, -0.6651F);
			legleft.addChild(legparter2);
			setRotationAngle(legparter2, 0.6109F, 0.0F, 0.0F);
			legparter2.setTextureOffset(44, 88).addBox(-0.5137F, -1.8872F, -2.584F, 4.0F, 4.0F, 17.0F, 0.0F, false);
			legparter2.setTextureOffset(0, 0).addBox(-0.1401F, 2.1218F, 11.3985F, 3.0F, 6.0F, 3.0F, 0.0F, false);
			foot2 = new ModelRenderer(this);
			foot2.setRotationPoint(0.0847F, 10.8965F, 12.982F);
			legleft.addChild(foot2);
			setRotationAngle(foot2, -0.6981F, -0.0436F, 0.0F);
			foot2.setTextureOffset(58, 43).addBox(-3.5F, -2.5F, -0.3612F, 7.0F, 5.0F, 2.0F, 0.0F, false);
			foot2.setTextureOffset(66, 9).addBox(0.0F, -1.0F, -0.482F, 0.0F, 10.0F, 2.0F, 0.0F, false);
			footclaws2_r1 = new ModelRenderer(this);
			footclaws2_r1.setRotationPoint(0.8332F, 3.1422F, 0.5638F);
			foot2.addChild(footclaws2_r1);
			setRotationAngle(footclaws2_r1, 0.0F, 0.0F, -0.7418F);
			footclaws2 = new ModelRenderer(this);
			footclaws2.setRotationPoint(0.8332F, 3.1422F, 0.5638F);
			foot2.addChild(footclaws2);
			setRotationAngle(footclaws2, 0.0F, 0.0F, -0.7418F);
			footclaws2.setTextureOffset(58, 32).addBox(-5.0F, -5.0F, -1.0F, 9.0F, 9.0F, 2.0F, 0.0F, true);
			armright = new ModelRenderer(this);
			armright.setRotationPoint(-12.0F, -39.0F, 1.0F);
			deathclaw.addChild(armright);
			setRotationAngle(armright, 0.8136F, 0.3864F, 0.494F);
			armright.setTextureOffset(64, 109).addBox(-3.4083F, -2.8783F, -3.3347F, 6.0F, 17.0F, 7.0F, 0.0F, false);
			frontarm_r1 = new ModelRenderer(this);
			frontarm_r1.setRotationPoint(1.5628F, 11.9394F, -0.0897F);
			armright.addChild(frontarm_r1);
			setRotationAngle(frontarm_r1, -0.3491F, 0.0F, 0.0F);
			frontarm = new ModelRenderer(this);
			frontarm.setRotationPoint(1.5628F, 11.9394F, -0.0897F);
			armright.addChild(frontarm);
			setRotationAngle(frontarm, -0.3491F, 0.0F, 0.0F);
			frontarm.setTextureOffset(58, 32).addBox(-4.0F, -1.0F, -21.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
			frontarm.setTextureOffset(118, 9).addBox(-4.5021F, -3.8769F, -29.787F, 3.0F, 8.0F, 10.0F, 0.0F, false);
			frontarm.setTextureOffset(0, 109).addBox(-4.5021F, -3.8769F, -29.787F, 9.0F, 8.0F, 10.0F, 0.0F, false);
			armleft = new ModelRenderer(this);
			armleft.setRotationPoint(12.0F, -39.0F, 1.0F);
			deathclaw.addChild(armleft);
			setRotationAngle(armleft, 0.8136F, -0.3864F, -0.494F);
			armleft.setTextureOffset(64, 109).addBox(-2.5917F, -2.8783F, -3.3347F, 6.0F, 17.0F, 7.0F, 0.0F, true);
			frontarm2_r1 = new ModelRenderer(this);
			frontarm2_r1.setRotationPoint(-1.5628F, 11.9394F, -0.0897F);
			armleft.addChild(frontarm2_r1);
			setRotationAngle(frontarm2_r1, -0.3491F, 0.0F, 0.0F);
			frontarm2 = new ModelRenderer(this);
			frontarm2.setRotationPoint(-1.5628F, 11.9394F, -0.0897F);
			armleft.addChild(frontarm2);
			setRotationAngle(frontarm2, -0.3491F, 0.0F, 0.0F);
			frontarm2.setTextureOffset(58, 6).addBox(0.0F, -1.0F, -21.0F, 4.0F, 4.0F, 22.0F, 0.0F, false);
			frontarm2.setTextureOffset(114, 114).addBox(1.5021F, -3.8769F, -29.787F, 3.0F, 8.0F, 10.0F, 0.0F, false);
			frontarm2.setTextureOffset(0, 109).addBox(-4.4979F, -3.8769F, -29.787F, 9.0F, 8.0F, 10.0F, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(-0.3333F, -41.6963F, -10.7227F);
			deathclaw.addChild(head);
			horns_r1 = new ModelRenderer(this);
			horns_r1.setRotationPoint(-0.6667F, -7.0537F, -8.2773F);
			head.addChild(horns_r1);
			setRotationAngle(horns_r1, 0.0F, 0.0F, -0.7854F);
			face_r1 = new ModelRenderer(this);
			face_r1.setRotationPoint(-0.6667F, 0.6074F, -3.4454F);
			head.addChild(face_r1);
			setRotationAngle(face_r1, 0.48F, 0.7418F, 0.3491F);
			face_r1.setTextureOffset(88, 0).addBox(-4.0F, -4.5F, -4.532F, 10.0F, 9.0F, 10.0F, 0.0F, false);
			jaw = new ModelRenderer(this);
			jaw.setRotationPoint(-1.1667F, 4.9463F, -7.7773F);
			head.addChild(jaw);
			jawpiece_r1 = new ModelRenderer(this);
			jawpiece_r1.setRotationPoint(0.5F, 0.0F, 0.0F);
			jaw.addChild(jawpiece_r1);
			setRotationAngle(jawpiece_r1, -0.2182F, 0.0F, 0.0F);
			jawpiece_r1_r1 = new ModelRenderer(this);
			jawpiece_r1_r1.setRotationPoint(1.0F, -1.25F, -1.5F);
			jawpiece_r1.addChild(jawpiece_r1_r1);
			setRotationAngle(jawpiece_r1_r1, 0.3927F, 0.0F, 0.0F);
			jawpiece_r1_r1.setTextureOffset(69, 88).addBox(-3.5F, -4.0237F, -0.7836F, 7.0F, 10.0F, 7.0F, 0.0F, false);
			horns = new ModelRenderer(this);
			horns.setRotationPoint(-0.6667F, -7.0537F, -8.2773F);
			head.addChild(horns);
			setRotationAngle(horns, 0.0F, 0.0F, -0.7854F);
			horns.setTextureOffset(58, 58).addBox(-5.5F, -6.5F, -9.5F, 13.0F, 13.0F, 17.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			deathclaw.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.armleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
