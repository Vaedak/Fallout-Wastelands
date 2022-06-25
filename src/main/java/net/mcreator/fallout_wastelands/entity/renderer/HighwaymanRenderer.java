
package net.mcreator.fallout_wastelands.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.fallout_wastelands.entity.HighwaymanEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HighwaymanRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HighwaymanEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhighwayman(), 1f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/highwaytwo.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("fallout_wastelands:textures/highwaylights.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelhighwayman extends EntityModel<Entity> {
		private final ModelRenderer car;
		private final ModelRenderer body;
		private final ModelRenderer capot;
		private final ModelRenderer interior;
		private final ModelRenderer steeringwheel;
		private final ModelRenderer seat;
		private final ModelRenderer seat2;
		private final ModelRenderer top;
		private final ModelRenderer windscreen;
		private final ModelRenderer windscreenback;
		private final ModelRenderer shockbar;
		private final ModelRenderer wheel;
		private final ModelRenderer tirepiece;
		private final ModelRenderer tirepiece2;
		private final ModelRenderer tirepiece3;
		private final ModelRenderer tirepiece4;
		private final ModelRenderer tirepiece5;
		private final ModelRenderer tirepiece6;
		private final ModelRenderer tirepiece7;
		private final ModelRenderer tirepiece8;
		private final ModelRenderer wheel2;
		private final ModelRenderer tirepiece9;
		private final ModelRenderer tirepiece10;
		private final ModelRenderer tirepiece11;
		private final ModelRenderer tirepiece12;
		private final ModelRenderer tirepiece13;
		private final ModelRenderer tirepiece14;
		private final ModelRenderer tirepiece15;
		private final ModelRenderer tirepiece16;
		private final ModelRenderer wheel4;
		private final ModelRenderer tirepiece25;
		private final ModelRenderer tirepiece26;
		private final ModelRenderer tirepiece27;
		private final ModelRenderer tirepiece28;
		private final ModelRenderer tirepiece29;
		private final ModelRenderer tirepiece30;
		private final ModelRenderer tirepiece31;
		private final ModelRenderer tirepiece32;
		private final ModelRenderer wheel3;
		private final ModelRenderer tirepiece17;
		private final ModelRenderer tirepiece18;
		private final ModelRenderer tirepiece19;
		private final ModelRenderer tirepiece20;
		private final ModelRenderer tirepiece21;
		private final ModelRenderer tirepiece22;
		private final ModelRenderer tirepiece23;
		private final ModelRenderer tirepiece24;

		public Modelhighwayman() {
			textureWidth = 512;
			textureHeight = 512;
			car = new ModelRenderer(this);
			car.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 1.0F, 0.0F);
			car.addChild(body);
			body.setTextureOffset(0, 299).addBox(-22.0F, -6.0F, -25.0F, 44.0F, 2.0F, 51.0F, 0.0F, false);
			body.setTextureOffset(2, 398).addBox(20.0F, -20.0F, -18.0F, 2.0F, 14.0F, 64.0F, 0.0F, false);
			body.setTextureOffset(2, 398).addBox(-22.0F, -20.0F, -18.0F, 2.0F, 14.0F, 64.0F, 0.0F, true);
			body.setTextureOffset(0, 141).addBox(-22.0F, -16.0F, -52.0F, 44.0F, 10.0F, 34.0F, 0.0F, false);
			body.setTextureOffset(168, 100).addBox(11.0F, -20.0F, -52.0F, 11.0F, 4.0F, 34.0F, 0.0F, false);
			body.setTextureOffset(168, 100).addBox(-22.0F, -20.0F, -52.0F, 11.0F, 4.0F, 34.0F, 0.0F, true);
			body.setTextureOffset(212, 0).addBox(19.0F, -26.0F, 46.0F, 3.0F, 20.0F, 19.0F, 0.0F, false);
			body.setTextureOffset(212, 0).addBox(-22.0F, -26.0F, 46.0F, 3.0F, 20.0F, 19.0F, 0.0F, true);
			body.setTextureOffset(0, 82).addBox(-20.0F, -20.0F, 26.0F, 40.0F, 14.0F, 35.0F, 0.0F, false);
			body.setTextureOffset(370, 150).addBox(-23.0F, -10.0F, -55.0F, 46.0F, 5.0F, 9.0F, 0.0F, false);
			body.setTextureOffset(218, 379).addBox(-4.0F, -22.0F, -34.0F, 8.0F, 4.0F, 12.0F, 0.0F, false);
			capot = new ModelRenderer(this);
			capot.setRotationPoint(0.0F, -18.0F, -27.0F);
			body.addChild(capot);
			setRotationAngle(capot, 0.0873F, 0.0F, 0.0F);
			capot.setTextureOffset(0, 219).addBox(-20.0F, -1.0F, -25.0F, 40.0F, 8.0F, 34.0F, 0.0F, false);
			interior = new ModelRenderer(this);
			interior.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(interior);
			interior.setTextureOffset(485, 274).addBox(2.0F, -17.0F, -16.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			steeringwheel = new ModelRenderer(this);
			steeringwheel.setRotationPoint(10.0F, -16.0F, -15.0F);
			interior.addChild(steeringwheel);
			setRotationAngle(steeringwheel, 0.3491F, 0.0F, 0.0F);
			steeringwheel.setTextureOffset(500, 356).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			steeringwheel.setTextureOffset(352, 269).addBox(-5.0F, -5.0F, 3.0F, 10.0F, 10.0F, 0.0F, 0.0F, false);
			seat = new ModelRenderer(this);
			seat.setRotationPoint(0.0F, -14.5F, 1.5F);
			interior.addChild(seat);
			setRotationAngle(seat, -0.2618F, 0.0F, 0.0F);
			seat.setTextureOffset(424, 482).addBox(-19.0F, -9.0176F, 0.4319F, 38.0F, 17.0F, 3.0F, 0.0F, false);
			seat2 = new ModelRenderer(this);
			seat2.setRotationPoint(0.0F, -14.5F, 24.5F);
			interior.addChild(seat2);
			setRotationAngle(seat2, -0.2618F, 0.0F, 0.0F);
			seat2.setTextureOffset(424, 482).addBox(-19.0F, -8.5F, -1.5F, 38.0F, 17.0F, 3.0F, 0.0F, false);
			top = new ModelRenderer(this);
			top.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(top);
			top.setTextureOffset(360, 0).addBox(-20.0F, -31.0F, -11.0F, 40.0F, 11.0F, 38.0F, 0.0F, false);
			windscreen = new ModelRenderer(this);
			windscreen.setRotationPoint(0.0F, -19.5F, -18.5F);
			top.addChild(windscreen);
			setRotationAngle(windscreen, -0.6109F, 0.0F, 0.0F);
			windscreen.setTextureOffset(176, 221).addBox(-20.0F, -14.5F, 0.5F, 40.0F, 14.0F, 0.0F, 0.0F, false);
			windscreenback = new ModelRenderer(this);
			windscreenback.setRotationPoint(0.0F, -34.5F, 36.5F);
			top.addChild(windscreenback);
			setRotationAngle(windscreenback, -2.3562F, 0.0F, 0.0F);
			windscreenback.setTextureOffset(158, 253).addBox(-20.0F, -17.7574F, 9.1924F, 40.0F, 22.0F, 10.0F, 0.0F, false);
			shockbar = new ModelRenderer(this);
			shockbar.setRotationPoint(0.0F, 0.0F, 50.0F);
			body.addChild(shockbar);
			setRotationAngle(shockbar, 0.0F, 3.1416F, 0.0F);
			shockbar.setTextureOffset(370, 150).addBox(-23.0F, -10.0F, -16.0F, 46.0F, 5.0F, 9.0F, 0.0F, false);
			wheel = new ModelRenderer(this);
			wheel.setRotationPoint(0.0F, -1.0F, -4.0F);
			car.addChild(wheel);
			wheel.setTextureOffset(47, 0).addBox(15.0F, -11.0F, 36.0F, 4.0F, 9.0F, 9.0F, 0.0F, false);
			tirepiece = new ModelRenderer(this);
			tirepiece.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece);
			tirepiece.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece2 = new ModelRenderer(this);
			tirepiece2.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece2);
			setRotationAngle(tirepiece2, 0.7854F, 0.0F, 0.0F);
			tirepiece2.setTextureOffset(0, 0).addBox(-2.5F, 0.2426F, 1.4142F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece3 = new ModelRenderer(this);
			tirepiece3.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece3);
			setRotationAngle(tirepiece3, 1.5708F, 0.0F, 0.0F);
			tirepiece3.setTextureOffset(0, 0).addBox(-2.5F, 4.9497F, 2.9497F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece4 = new ModelRenderer(this);
			tirepiece4.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece4);
			setRotationAngle(tirepiece4, 2.3562F, 0.0F, 0.0F);
			tirepiece4.setTextureOffset(0, 0).addBox(-2.5F, 9.364F, 0.7071F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece5 = new ModelRenderer(this);
			tirepiece5.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece5);
			setRotationAngle(tirepiece5, 3.1416F, 0.0F, 0.0F);
			tirepiece5.setTextureOffset(0, 0).addBox(-2.5F, 10.8995F, -4.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece6 = new ModelRenderer(this);
			tirepiece6.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece6);
			setRotationAngle(tirepiece6, -2.3562F, 0.0F, 0.0F);
			tirepiece6.setTextureOffset(0, 0).addBox(-2.5F, 8.6569F, -8.4142F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece7 = new ModelRenderer(this);
			tirepiece7.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece7);
			setRotationAngle(tirepiece7, -1.5708F, 0.0F, 0.0F);
			tirepiece7.setTextureOffset(0, 0).addBox(-2.5F, 3.9497F, -9.9497F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece8 = new ModelRenderer(this);
			tirepiece8.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel.addChild(tirepiece8);
			setRotationAngle(tirepiece8, -0.7854F, 0.0F, 0.0F);
			tirepiece8.setTextureOffset(0, 0).addBox(-2.5F, -0.4645F, -7.7071F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			wheel2 = new ModelRenderer(this);
			wheel2.setRotationPoint(0.0F, -1.0F, -4.0F);
			car.addChild(wheel2);
			wheel2.setTextureOffset(47, 0).addBox(-19.0F, -11.0F, 36.0F, 4.0F, 9.0F, 9.0F, 0.0F, true);
			tirepiece9 = new ModelRenderer(this);
			tirepiece9.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece9);
			tirepiece9.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece10 = new ModelRenderer(this);
			tirepiece10.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece10);
			setRotationAngle(tirepiece10, 0.7854F, 0.0F, 0.0F);
			tirepiece10.setTextureOffset(0, 0).addBox(-2.5F, 0.2426F, 1.4142F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece11 = new ModelRenderer(this);
			tirepiece11.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece11);
			setRotationAngle(tirepiece11, 1.5708F, 0.0F, 0.0F);
			tirepiece11.setTextureOffset(0, 0).addBox(-2.5F, 4.9497F, 2.9497F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece12 = new ModelRenderer(this);
			tirepiece12.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece12);
			setRotationAngle(tirepiece12, 2.3562F, 0.0F, 0.0F);
			tirepiece12.setTextureOffset(0, 0).addBox(-2.5F, 9.364F, 0.7071F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece13 = new ModelRenderer(this);
			tirepiece13.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece13);
			setRotationAngle(tirepiece13, 3.1416F, 0.0F, 0.0F);
			tirepiece13.setTextureOffset(0, 0).addBox(-2.5F, 10.8995F, -4.0F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece14 = new ModelRenderer(this);
			tirepiece14.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece14);
			setRotationAngle(tirepiece14, -2.3562F, 0.0F, 0.0F);
			tirepiece14.setTextureOffset(0, 0).addBox(-2.5F, 8.6569F, -8.4142F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece15 = new ModelRenderer(this);
			tirepiece15.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece15);
			setRotationAngle(tirepiece15, -1.5708F, 0.0F, 0.0F);
			tirepiece15.setTextureOffset(0, 0).addBox(-2.5F, 3.9497F, -9.9497F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece16 = new ModelRenderer(this);
			tirepiece16.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel2.addChild(tirepiece16);
			setRotationAngle(tirepiece16, -0.7854F, 0.0F, 0.0F);
			tirepiece16.setTextureOffset(0, 0).addBox(-2.5F, -0.4645F, -7.7071F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			wheel4 = new ModelRenderer(this);
			wheel4.setRotationPoint(0.0F, -1.0F, -77.0F);
			car.addChild(wheel4);
			wheel4.setTextureOffset(47, 0).addBox(15.0F, -11.0F, 36.0F, 4.0F, 9.0F, 9.0F, 0.0F, false);
			tirepiece25 = new ModelRenderer(this);
			tirepiece25.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece25);
			tirepiece25.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece26 = new ModelRenderer(this);
			tirepiece26.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece26);
			setRotationAngle(tirepiece26, 0.7854F, 0.0F, 0.0F);
			tirepiece26.setTextureOffset(0, 0).addBox(-2.5F, 0.2426F, 1.4142F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece27 = new ModelRenderer(this);
			tirepiece27.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece27);
			setRotationAngle(tirepiece27, 1.5708F, 0.0F, 0.0F);
			tirepiece27.setTextureOffset(0, 0).addBox(-2.5F, 4.9497F, 2.9497F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece28 = new ModelRenderer(this);
			tirepiece28.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece28);
			setRotationAngle(tirepiece28, 2.3562F, 0.0F, 0.0F);
			tirepiece28.setTextureOffset(0, 0).addBox(-2.5F, 9.364F, 0.7071F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece29 = new ModelRenderer(this);
			tirepiece29.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece29);
			setRotationAngle(tirepiece29, 3.1416F, 0.0F, 0.0F);
			tirepiece29.setTextureOffset(0, 0).addBox(-2.5F, 10.8995F, -4.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece30 = new ModelRenderer(this);
			tirepiece30.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece30);
			setRotationAngle(tirepiece30, -2.3562F, 0.0F, 0.0F);
			tirepiece30.setTextureOffset(0, 0).addBox(-2.5F, 8.6569F, -8.4142F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece31 = new ModelRenderer(this);
			tirepiece31.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece31);
			setRotationAngle(tirepiece31, -1.5708F, 0.0F, 0.0F);
			tirepiece31.setTextureOffset(0, 0).addBox(-2.5F, 3.9497F, -9.9497F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			tirepiece32 = new ModelRenderer(this);
			tirepiece32.setRotationPoint(17.0F, 0.0F, 40.0F);
			wheel4.addChild(tirepiece32);
			setRotationAngle(tirepiece32, -0.7854F, 0.0F, 0.0F);
			tirepiece32.setTextureOffset(0, 0).addBox(-2.5F, -0.4645F, -7.7071F, 5.0F, 4.0F, 7.0F, 0.0F, false);
			wheel3 = new ModelRenderer(this);
			wheel3.setRotationPoint(0.0F, -1.0F, -77.0F);
			car.addChild(wheel3);
			wheel3.setTextureOffset(47, 0).addBox(-19.0F, -11.0F, 36.0F, 4.0F, 9.0F, 9.0F, 0.0F, true);
			tirepiece17 = new ModelRenderer(this);
			tirepiece17.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece17);
			tirepiece17.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece18 = new ModelRenderer(this);
			tirepiece18.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece18);
			setRotationAngle(tirepiece18, 0.7854F, 0.0F, 0.0F);
			tirepiece18.setTextureOffset(0, 0).addBox(-2.5F, 0.2426F, 1.4142F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece19 = new ModelRenderer(this);
			tirepiece19.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece19);
			setRotationAngle(tirepiece19, 1.5708F, 0.0F, 0.0F);
			tirepiece19.setTextureOffset(0, 0).addBox(-2.5F, 4.9497F, 2.9497F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece20 = new ModelRenderer(this);
			tirepiece20.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece20);
			setRotationAngle(tirepiece20, 2.3562F, 0.0F, 0.0F);
			tirepiece20.setTextureOffset(0, 0).addBox(-2.5F, 9.364F, 0.7071F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece21 = new ModelRenderer(this);
			tirepiece21.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece21);
			setRotationAngle(tirepiece21, 3.1416F, 0.0F, 0.0F);
			tirepiece21.setTextureOffset(0, 0).addBox(-2.5F, 10.8995F, -4.0F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece22 = new ModelRenderer(this);
			tirepiece22.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece22);
			setRotationAngle(tirepiece22, -2.3562F, 0.0F, 0.0F);
			tirepiece22.setTextureOffset(0, 0).addBox(-2.5F, 8.6569F, -8.4142F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece23 = new ModelRenderer(this);
			tirepiece23.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece23);
			setRotationAngle(tirepiece23, -1.5708F, 0.0F, 0.0F);
			tirepiece23.setTextureOffset(0, 0).addBox(-2.5F, 3.9497F, -9.9497F, 5.0F, 4.0F, 7.0F, 0.0F, true);
			tirepiece24 = new ModelRenderer(this);
			tirepiece24.setRotationPoint(-17.0F, 0.0F, 40.0F);
			wheel3.addChild(tirepiece24);
			setRotationAngle(tirepiece24, -0.7854F, 0.0F, 0.0F);
			tirepiece24.setTextureOffset(0, 0).addBox(-2.5F, -0.4645F, -7.7071F, 5.0F, 4.0F, 7.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			car.render(matrixStack, buffer, packedLight, packedOverlay);
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
