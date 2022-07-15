
package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.fallout_wastelands.entity.ProtectronEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ProtectronRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ProtectronEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelprotectionbasic(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/protectionbasic.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelprotectionbasic extends EntityModel<Entity> {
		private final ModelRenderer protectron;
		private final ModelRenderer leg;
		private final ModelRenderer legright;
		private final ModelRenderer body;
		private final ModelRenderer armright_r1;
		private final ModelRenderer arm_r1;
		private final ModelRenderer bodytop_r1;
		private final ModelRenderer bodytop;
		private final ModelRenderer bodytorso_r1;
		private final ModelRenderer arm;
		private final ModelRenderer claw_r1;
		private final ModelRenderer claw;
		private final ModelRenderer clawpiece_r1;
		private final ModelRenderer armright;
		private final ModelRenderer clawright_r1;
		private final ModelRenderer clawright;
		private final ModelRenderer clawpieceleft_r1;

		public Modelprotectionbasic() {
			textureWidth = 64;
			textureHeight = 64;
			protectron = new ModelRenderer(this);
			protectron.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg = new ModelRenderer(this);
			leg.setRotationPoint(-3.0F, -11.5F, 0.5F);
			protectron.addChild(leg);
			leg.setTextureOffset(12, 33).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, false);
			leg.setTextureOffset(27, 0).addBox(-1.0F, 10.5F, -3.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			legright = new ModelRenderer(this);
			legright.setRotationPoint(3.0F, -11.5F, 0.5F);
			protectron.addChild(legright);
			legright.setTextureOffset(0, 33).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, true);
			legright.setTextureOffset(18, 18).addBox(-1.0F, 10.5F, -3.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -12.3333F, 0.8333F);
			protectron.addChild(body);
			body.setTextureOffset(24, 24).addBox(-2.0F, -6.6667F, -2.8333F, 4.0F, 8.0F, 5.0F, 0.0F, false);
			body.setTextureOffset(0, 17).addBox(-3.0F, -19.6667F, -2.8333F, 6.0F, 10.0F, 6.0F, 0.0F, false);
			armright_r1 = new ModelRenderer(this);
			armright_r1.setRotationPoint(5.5F, -6.1667F, -1.3333F);
			body.addChild(armright_r1);
			setRotationAngle(armright_r1, -0.5824F, 0.0886F, -0.3381F);
			arm_r1 = new ModelRenderer(this);
			arm_r1.setRotationPoint(-5.5F, -6.1667F, -1.3333F);
			body.addChild(arm_r1);
			setRotationAngle(arm_r1, -0.5824F, -0.0886F, 0.3381F);
			bodytop_r1 = new ModelRenderer(this);
			bodytop_r1.setRotationPoint(0.0F, -8.6667F, -0.8333F);
			body.addChild(bodytop_r1);
			setRotationAngle(bodytop_r1, -1.0036F, 0.0F, 0.0F);
			bodytop = new ModelRenderer(this);
			bodytop.setRotationPoint(0.0F, -8.6667F, -0.8333F);
			body.addChild(bodytop);
			setRotationAngle(bodytop, -1.0036F, 0.0F, 0.0F);
			bodytorso_r1 = new ModelRenderer(this);
			bodytorso_r1.setRotationPoint(0.0F, 5.0F, 1.0F);
			bodytop.addChild(bodytorso_r1);
			setRotationAngle(bodytorso_r1, 0.0873F, 0.0F, 0.0F);
			bodytorso_r1.setTextureOffset(0, 0).addBox(-5.0F, -10.7934F, -3.3912F, 10.0F, 10.0F, 7.0F, 0.0F, false);
			arm = new ModelRenderer(this);
			arm.setRotationPoint(-5.5F, -6.1667F, -1.3333F);
			body.addChild(arm);
			setRotationAngle(arm, -0.5824F, -0.0886F, 0.3381F);
			arm.setTextureOffset(34, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, true);
			claw_r1 = new ModelRenderer(this);
			claw_r1.setRotationPoint(0.2557F, 5.5247F, -0.2866F);
			arm.addChild(claw_r1);
			setRotationAngle(claw_r1, -0.3927F, 0.0F, -0.2618F);
			claw = new ModelRenderer(this);
			claw.setRotationPoint(0.2557F, 5.5247F, -0.2866F);
			arm.addChild(claw);
			setRotationAngle(claw, -0.3927F, 0.0F, -0.2618F);
			clawpiece_r1 = new ModelRenderer(this);
			clawpiece_r1.setRotationPoint(1.2443F, 0.9753F, -0.2134F);
			claw.addChild(clawpiece_r1);
			setRotationAngle(clawpiece_r1, -0.1309F, 0.0F, 0.1309F);
			clawpiece_r1.setTextureOffset(36, 37).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);
			armright = new ModelRenderer(this);
			armright.setRotationPoint(5.5F, -6.1667F, -1.3333F);
			body.addChild(armright);
			setRotationAngle(armright, -0.5824F, 0.0886F, -0.3381F);
			armright.setTextureOffset(31, 14).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			clawright_r1 = new ModelRenderer(this);
			clawright_r1.setRotationPoint(-0.2557F, 5.5247F, -0.2866F);
			armright.addChild(clawright_r1);
			setRotationAngle(clawright_r1, -0.3491F, 0.0F, 0.2618F);
			clawright = new ModelRenderer(this);
			clawright.setRotationPoint(-0.2557F, 5.5247F, -0.2866F);
			armright.addChild(clawright);
			setRotationAngle(clawright, -0.3491F, 0.0F, 0.2618F);
			clawpieceleft_r1 = new ModelRenderer(this);
			clawpieceleft_r1.setRotationPoint(-1.2443F, 0.9753F, -0.2134F);
			clawright.addChild(clawpieceleft_r1);
			setRotationAngle(clawpieceleft_r1, -0.1309F, 0.0F, -0.1309F);
			clawpieceleft_r1.setTextureOffset(24, 37).addBox(0.0F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			protectron.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
