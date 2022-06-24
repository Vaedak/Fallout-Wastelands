package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.fallout_wastelands.item.LaserriffleItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class LaserriffleRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LaserriffleItem.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<LaserriffleItem.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/laser.png");

		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(LaserriffleItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modellaser();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(LaserriffleItem.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modellaser extends EntityModel<Entity> {
		private final ModelRenderer shot;
		private final ModelRenderer west;

		public Modellaser() {
			textureWidth = 128;
			textureHeight = 128;
			shot = new ModelRenderer(this);
			shot.setRotationPoint(0.0F, 24.0F, 0.0F);
			shot.setTextureOffset(0, 0).addBox(0.0F, -128.0F, -4.0F, 0.0F, 128.0F, 8.0F, 0.0F, false);
			west = new ModelRenderer(this);
			west.setRotationPoint(0.0F, -64.0F, 0.0F);
			shot.addChild(west);
			setRotationAngle(west, 0.0F, -1.5708F, 0.0F);
			west.setTextureOffset(0, 0).addBox(0.0F, -64.0F, -4.0F, 0.0F, 128.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			shot.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

		}
	}

}
