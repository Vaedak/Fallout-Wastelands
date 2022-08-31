
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

import net.mcreator.fallout_wastelands.entity.ArmyrobobrainEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ArmyrobobrainRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ArmyrobobrainEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelarmyrobobrain(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fallout_wastelands:textures/entities/robobrainfix.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelarmyrobobrain extends EntityModel<Entity> {
		private final ModelRenderer armyrobobrain;
		private final ModelRenderer transportation;
		private final ModelRenderer righttrackassembly;
		private final ModelRenderer trackchain;
		private final ModelRenderer tracklink;
		private final ModelRenderer tracklink9;
		private final ModelRenderer tracklink10;
		private final ModelRenderer tracklink11;
		private final ModelRenderer tracklink12;
		private final ModelRenderer tracklink13;
		private final ModelRenderer tracklink14;
		private final ModelRenderer tracklink15;
		private final ModelRenderer tracklink16;
		private final ModelRenderer tracklink17;
		private final ModelRenderer tracklink18;
		private final ModelRenderer tracklink19;
		private final ModelRenderer tracklink20;
		private final ModelRenderer tracklink21;
		private final ModelRenderer tracklink22;
		private final ModelRenderer tracklink23;
		private final ModelRenderer tracklink24;
		private final ModelRenderer tracklink2;
		private final ModelRenderer tracklink3;
		private final ModelRenderer tracklink4;
		private final ModelRenderer tracklink5;
		private final ModelRenderer tracklink6;
		private final ModelRenderer tracklink7;
		private final ModelRenderer tracklink8;
		private final ModelRenderer lefttrackassembly;
		private final ModelRenderer trackchain2;
		private final ModelRenderer tracklink25;
		private final ModelRenderer tracklink26;
		private final ModelRenderer tracklink27;
		private final ModelRenderer tracklink28;
		private final ModelRenderer tracklink29;
		private final ModelRenderer tracklink30;
		private final ModelRenderer tracklink31;
		private final ModelRenderer tracklink32;
		private final ModelRenderer tracklink33;
		private final ModelRenderer tracklink34;
		private final ModelRenderer tracklink35;
		private final ModelRenderer tracklink36;
		private final ModelRenderer tracklink37;
		private final ModelRenderer tracklink38;
		private final ModelRenderer tracklink39;
		private final ModelRenderer tracklink40;
		private final ModelRenderer tracklink41;
		private final ModelRenderer tracklink42;
		private final ModelRenderer tracklink43;
		private final ModelRenderer tracklink44;
		private final ModelRenderer tracklink45;
		private final ModelRenderer tracklink46;
		private final ModelRenderer tracklink47;
		private final ModelRenderer tracklink48;
		private final ModelRenderer body;
		private final ModelRenderer handle;
		private final ModelRenderer head;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightarm;

		public Modelarmyrobobrain() {
			textureWidth = 128;
			textureHeight = 256;
			armyrobobrain = new ModelRenderer(this);
			armyrobobrain.setRotationPoint(0.0F, 24.0F, 0.0F);
			transportation = new ModelRenderer(this);
			transportation.setRotationPoint(0.0F, 0.0F, 0.0F);
			armyrobobrain.addChild(transportation);
			transportation.setTextureOffset(0, 19).addBox(-4.0F, -17.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);
			transportation.setTextureOffset(0, 43).addBox(-7.0F, -8.0F, -4.0F, 14.0F, 6.0F, 8.0F, 0.0F, false);
			righttrackassembly = new ModelRenderer(this);
			righttrackassembly.setRotationPoint(0.0F, 0.0F, 0.0F);
			transportation.addChild(righttrackassembly);
			righttrackassembly.setTextureOffset(0, 84).addBox(6.5F, -15.0F, -16.0F, 6.0F, 15.0F, 30.0F, 0.0F, false);
			trackchain = new ModelRenderer(this);
			trackchain.setRotationPoint(0.0F, 0.0F, 0.0F);
			righttrackassembly.addChild(trackchain);
			tracklink = new ModelRenderer(this);
			tracklink.setRotationPoint(10.0F, -14.0F, -2.0F);
			trackchain.addChild(tracklink);
			setRotationAngle(tracklink, 0.1745F, 0.0F, 0.0F);
			tracklink.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink9 = new ModelRenderer(this);
			tracklink9.setRotationPoint(10.0F, -14.0F, 1.0F);
			trackchain.addChild(tracklink9);
			setRotationAngle(tracklink9, -0.3491F, 0.0F, 0.0F);
			tracklink9.setTextureOffset(0, 0).addBox(-4.0F, -1.4739F, -0.221F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink10 = new ModelRenderer(this);
			tracklink10.setRotationPoint(10.0F, -14.0F, 5.0F);
			trackchain.addChild(tracklink10);
			setRotationAngle(tracklink10, -0.6981F, 0.0F, 0.0F);
			tracklink10.setTextureOffset(0, 0).addBox(-4.0F, 0.1753F, -0.6149F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink11 = new ModelRenderer(this);
			tracklink11.setRotationPoint(10.0F, -11.0F, 8.0F);
			trackchain.addChild(tracklink11);
			setRotationAngle(tracklink11, -0.6981F, 0.0F, 0.0F);
			tracklink11.setTextureOffset(0, 0).addBox(-4.0F, -0.1945F, -1.8414F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink12 = new ModelRenderer(this);
			tracklink12.setRotationPoint(10.0F, -8.0F, 11.0F);
			trackchain.addChild(tracklink12);
			setRotationAngle(tracklink12, -0.6981F, 0.0F, 0.0F);
			tracklink12.setTextureOffset(0, 0).addBox(-4.0F, -0.5642F, -3.0679F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink13 = new ModelRenderer(this);
			tracklink13.setRotationPoint(10.0F, -6.0F, 13.0F);
			trackchain.addChild(tracklink13);
			setRotationAngle(tracklink13, -0.6981F, 0.0F, 0.0F);
			tracklink13.setTextureOffset(0, 0).addBox(-4.0F, -0.8107F, -2.8855F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink14 = new ModelRenderer(this);
			tracklink14.setRotationPoint(10.0F, -6.0F, 15.0F);
			trackchain.addChild(tracklink14);
			setRotationAngle(tracklink14, -1.1345F, 0.0F, 0.0F);
			tracklink14.setTextureOffset(0, 0).addBox(-4.0F, 0.9358F, -0.6615F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink15 = new ModelRenderer(this);
			tracklink15.setRotationPoint(10.0F, -6.0F, 15.0F);
			trackchain.addChild(tracklink15);
			setRotationAngle(tracklink15, -2.0071F, 0.0F, 0.0F);
			tracklink15.setTextureOffset(0, 0).addBox(-4.0F, -1.5471F, 2.986F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink16 = new ModelRenderer(this);
			tracklink16.setRotationPoint(10.0F, -6.0F, 15.0F);
			trackchain.addChild(tracklink16);
			setRotationAngle(tracklink16, 3.1416F, 0.0F, 0.0F);
			tracklink16.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink17 = new ModelRenderer(this);
			tracklink17.setRotationPoint(10.0F, -6.0F, 12.0F);
			trackchain.addChild(tracklink17);
			setRotationAngle(tracklink17, 3.1416F, 0.0F, 0.0F);
			tracklink17.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink18 = new ModelRenderer(this);
			tracklink18.setRotationPoint(10.0F, -6.0F, 9.0F);
			trackchain.addChild(tracklink18);
			setRotationAngle(tracklink18, 3.1416F, 0.0F, 0.0F);
			tracklink18.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink19 = new ModelRenderer(this);
			tracklink19.setRotationPoint(10.0F, -6.0F, 6.0F);
			trackchain.addChild(tracklink19);
			setRotationAngle(tracklink19, 3.1416F, 0.0F, 0.0F);
			tracklink19.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink20 = new ModelRenderer(this);
			tracklink20.setRotationPoint(10.0F, -6.0F, 3.0F);
			trackchain.addChild(tracklink20);
			setRotationAngle(tracklink20, 3.1416F, 0.0F, 0.0F);
			tracklink20.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink21 = new ModelRenderer(this);
			tracklink21.setRotationPoint(10.0F, -6.0F, 0.0F);
			trackchain.addChild(tracklink21);
			setRotationAngle(tracklink21, 3.1416F, 0.0F, 0.0F);
			tracklink21.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink22 = new ModelRenderer(this);
			tracklink22.setRotationPoint(10.0F, -6.0F, -3.0F);
			trackchain.addChild(tracklink22);
			setRotationAngle(tracklink22, 3.1416F, 0.0F, 0.0F);
			tracklink22.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink23 = new ModelRenderer(this);
			tracklink23.setRotationPoint(10.0F, -6.0F, -6.0F);
			trackchain.addChild(tracklink23);
			setRotationAngle(tracklink23, 3.1416F, 0.0F, 0.0F);
			tracklink23.setTextureOffset(0, 0).addBox(-4.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink24 = new ModelRenderer(this);
			tracklink24.setRotationPoint(10.0F, -6.0F, -9.0F);
			trackchain.addChild(tracklink24);
			setRotationAngle(tracklink24, 3.0543F, 0.0F, 0.0F);
			tracklink24.setTextureOffset(0, 0).addBox(-4.0F, -6.8122F, 1.5332F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink2 = new ModelRenderer(this);
			tracklink2.setRotationPoint(10.0F, -14.0F, -5.0F);
			trackchain.addChild(tracklink2);
			setRotationAngle(tracklink2, 0.6109F, 0.0F, 0.0F);
			tracklink2.setTextureOffset(0, 0).addBox(-4.0F, 0.7207F, -0.5425F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink3 = new ModelRenderer(this);
			tracklink3.setRotationPoint(10.0F, -14.0F, -9.0F);
			trackchain.addChild(tracklink3);
			setRotationAngle(tracklink3, 0.6109F, 0.0F, 0.0F);
			tracklink3.setTextureOffset(0, 0).addBox(-4.0F, 3.015F, -0.2659F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink4 = new ModelRenderer(this);
			tracklink4.setRotationPoint(10.0F, -14.0F, -13.0F);
			trackchain.addChild(tracklink4);
			setRotationAngle(tracklink4, 0.6109F, 0.0F, 0.0F);
			tracklink4.setTextureOffset(0, 0).addBox(-4.0F, 5.3093F, 0.0107F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink5 = new ModelRenderer(this);
			tracklink5.setRotationPoint(10.0F, -14.0F, -11.0F);
			trackchain.addChild(tracklink5);
			setRotationAngle(tracklink5, 0.6109F, 0.0F, 0.0F);
			tracklink5.setTextureOffset(0, 0).addBox(-4.0F, 4.1622F, -4.6276F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink6 = new ModelRenderer(this);
			tracklink6.setRotationPoint(10.0F, -12.0F, -15.0F);
			trackchain.addChild(tracklink6);
			setRotationAngle(tracklink6, 0.6109F, 0.0F, 0.0F);
			tracklink6.setTextureOffset(0, 0).addBox(-4.0F, 4.8182F, -3.2039F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink7 = new ModelRenderer(this);
			tracklink7.setRotationPoint(10.0F, -12.0F, -15.0F);
			trackchain.addChild(tracklink7);
			setRotationAngle(tracklink7, 1.0472F, 0.0F, 0.0F);
			tracklink7.setTextureOffset(0, 0).addBox(-4.0F, 2.9191F, -8.3626F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			tracklink8 = new ModelRenderer(this);
			tracklink8.setRotationPoint(10.0F, -7.0F, -15.0F);
			trackchain.addChild(tracklink8);
			setRotationAngle(tracklink8, 2.2689F, 0.0F, 0.0F);
			tracklink8.setTextureOffset(0, 0).addBox(-4.0F, -4.3039F, -5.7127F, 7.0F, 1.0F, 3.0F, 0.0F, false);
			lefttrackassembly = new ModelRenderer(this);
			lefttrackassembly.setRotationPoint(0.0F, 0.0F, 0.0F);
			transportation.addChild(lefttrackassembly);
			lefttrackassembly.setTextureOffset(0, 84).addBox(-12.5F, -15.0F, -16.0F, 6.0F, 15.0F, 30.0F, 0.0F, true);
			trackchain2 = new ModelRenderer(this);
			trackchain2.setRotationPoint(0.0F, 0.0F, 0.0F);
			lefttrackassembly.addChild(trackchain2);
			tracklink25 = new ModelRenderer(this);
			tracklink25.setRotationPoint(-10.0F, -14.0F, -2.0F);
			trackchain2.addChild(tracklink25);
			setRotationAngle(tracklink25, 0.1745F, 0.0F, 0.0F);
			tracklink25.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink26 = new ModelRenderer(this);
			tracklink26.setRotationPoint(-10.0F, -14.0F, 1.0F);
			trackchain2.addChild(tracklink26);
			setRotationAngle(tracklink26, -0.3491F, 0.0F, 0.0F);
			tracklink26.setTextureOffset(0, 0).addBox(-3.0F, -1.4739F, -0.221F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink27 = new ModelRenderer(this);
			tracklink27.setRotationPoint(-10.0F, -14.0F, 5.0F);
			trackchain2.addChild(tracklink27);
			setRotationAngle(tracklink27, -0.6981F, 0.0F, 0.0F);
			tracklink27.setTextureOffset(0, 0).addBox(-3.0F, 0.1753F, -0.6149F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink28 = new ModelRenderer(this);
			tracklink28.setRotationPoint(-10.0F, -11.0F, 8.0F);
			trackchain2.addChild(tracklink28);
			setRotationAngle(tracklink28, -0.6981F, 0.0F, 0.0F);
			tracklink28.setTextureOffset(0, 0).addBox(-3.0F, -0.1945F, -1.8414F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink29 = new ModelRenderer(this);
			tracklink29.setRotationPoint(-10.0F, -8.0F, 11.0F);
			trackchain2.addChild(tracklink29);
			setRotationAngle(tracklink29, -0.6981F, 0.0F, 0.0F);
			tracklink29.setTextureOffset(0, 0).addBox(-3.0F, -0.5642F, -3.0679F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink30 = new ModelRenderer(this);
			tracklink30.setRotationPoint(-10.0F, -6.0F, 13.0F);
			trackchain2.addChild(tracklink30);
			setRotationAngle(tracklink30, -0.6981F, 0.0F, 0.0F);
			tracklink30.setTextureOffset(0, 0).addBox(-3.0F, -0.8107F, -2.8855F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink31 = new ModelRenderer(this);
			tracklink31.setRotationPoint(-10.0F, -6.0F, 15.0F);
			trackchain2.addChild(tracklink31);
			setRotationAngle(tracklink31, -1.1345F, 0.0F, 0.0F);
			tracklink31.setTextureOffset(0, 0).addBox(-3.0F, 0.9358F, -0.6615F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink32 = new ModelRenderer(this);
			tracklink32.setRotationPoint(-10.0F, -6.0F, 15.0F);
			trackchain2.addChild(tracklink32);
			setRotationAngle(tracklink32, -2.0071F, 0.0F, 0.0F);
			tracklink32.setTextureOffset(0, 0).addBox(-3.0F, -1.5471F, 2.986F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink33 = new ModelRenderer(this);
			tracklink33.setRotationPoint(-10.0F, -6.0F, 15.0F);
			trackchain2.addChild(tracklink33);
			setRotationAngle(tracklink33, 3.1416F, 0.0F, 0.0F);
			tracklink33.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink34 = new ModelRenderer(this);
			tracklink34.setRotationPoint(-10.0F, -6.0F, 12.0F);
			trackchain2.addChild(tracklink34);
			setRotationAngle(tracklink34, 3.1416F, 0.0F, 0.0F);
			tracklink34.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink35 = new ModelRenderer(this);
			tracklink35.setRotationPoint(-10.0F, -6.0F, 9.0F);
			trackchain2.addChild(tracklink35);
			setRotationAngle(tracklink35, 3.1416F, 0.0F, 0.0F);
			tracklink35.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink36 = new ModelRenderer(this);
			tracklink36.setRotationPoint(-10.0F, -6.0F, 6.0F);
			trackchain2.addChild(tracklink36);
			setRotationAngle(tracklink36, 3.1416F, 0.0F, 0.0F);
			tracklink36.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink37 = new ModelRenderer(this);
			tracklink37.setRotationPoint(-10.0F, -6.0F, 3.0F);
			trackchain2.addChild(tracklink37);
			setRotationAngle(tracklink37, 3.1416F, 0.0F, 0.0F);
			tracklink37.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink38 = new ModelRenderer(this);
			tracklink38.setRotationPoint(-10.0F, -6.0F, 0.0F);
			trackchain2.addChild(tracklink38);
			setRotationAngle(tracklink38, 3.1416F, 0.0F, 0.0F);
			tracklink38.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink39 = new ModelRenderer(this);
			tracklink39.setRotationPoint(-10.0F, -6.0F, -3.0F);
			trackchain2.addChild(tracklink39);
			setRotationAngle(tracklink39, 3.1416F, 0.0F, 0.0F);
			tracklink39.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink40 = new ModelRenderer(this);
			tracklink40.setRotationPoint(-10.0F, -6.0F, -6.0F);
			trackchain2.addChild(tracklink40);
			setRotationAngle(tracklink40, 3.1416F, 0.0F, 0.0F);
			tracklink40.setTextureOffset(0, 0).addBox(-3.0F, -6.6564F, 2.034F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink41 = new ModelRenderer(this);
			tracklink41.setRotationPoint(-10.0F, -6.0F, -9.0F);
			trackchain2.addChild(tracklink41);
			setRotationAngle(tracklink41, 3.0543F, 0.0F, 0.0F);
			tracklink41.setTextureOffset(0, 0).addBox(-3.0F, -6.8122F, 1.5332F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink42 = new ModelRenderer(this);
			tracklink42.setRotationPoint(-10.0F, -14.0F, -5.0F);
			trackchain2.addChild(tracklink42);
			setRotationAngle(tracklink42, 0.6109F, 0.0F, 0.0F);
			tracklink42.setTextureOffset(0, 0).addBox(-3.0F, 0.7207F, -0.5425F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink43 = new ModelRenderer(this);
			tracklink43.setRotationPoint(-10.0F, -14.0F, -9.0F);
			trackchain2.addChild(tracklink43);
			setRotationAngle(tracklink43, 0.6109F, 0.0F, 0.0F);
			tracklink43.setTextureOffset(0, 0).addBox(-3.0F, 3.015F, -0.2659F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink44 = new ModelRenderer(this);
			tracklink44.setRotationPoint(-10.0F, -14.0F, -13.0F);
			trackchain2.addChild(tracklink44);
			setRotationAngle(tracklink44, 0.6109F, 0.0F, 0.0F);
			tracklink44.setTextureOffset(0, 0).addBox(-3.0F, 5.3093F, 0.0107F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink45 = new ModelRenderer(this);
			tracklink45.setRotationPoint(-10.0F, -14.0F, -11.0F);
			trackchain2.addChild(tracklink45);
			setRotationAngle(tracklink45, 0.6109F, 0.0F, 0.0F);
			tracklink45.setTextureOffset(0, 0).addBox(-3.0F, 4.1622F, -4.6276F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink46 = new ModelRenderer(this);
			tracklink46.setRotationPoint(-10.0F, -12.0F, -15.0F);
			trackchain2.addChild(tracklink46);
			setRotationAngle(tracklink46, 0.6109F, 0.0F, 0.0F);
			tracklink46.setTextureOffset(0, 0).addBox(-3.0F, 4.8182F, -3.2039F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink47 = new ModelRenderer(this);
			tracklink47.setRotationPoint(-10.0F, -12.0F, -15.0F);
			trackchain2.addChild(tracklink47);
			setRotationAngle(tracklink47, 1.0472F, 0.0F, 0.0F);
			tracklink47.setTextureOffset(0, 0).addBox(-3.0F, 2.9191F, -8.3626F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			tracklink48 = new ModelRenderer(this);
			tracklink48.setRotationPoint(-10.0F, -7.0F, -15.0F);
			trackchain2.addChild(tracklink48);
			setRotationAngle(tracklink48, 2.2689F, 0.0F, 0.0F);
			tracklink48.setTextureOffset(0, 0).addBox(-3.0F, -4.3039F, -5.7127F, 7.0F, 1.0F, 3.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -13.0F, 0.0F);
			armyrobobrain.addChild(body);
			body.setTextureOffset(56, 52).addBox(-9.0F, -22.0F, -9.0F, 18.0F, 18.0F, 18.0F, 0.0F, false);
			handle = new ModelRenderer(this);
			handle.setRotationPoint(0.0F, -19.0F, -9.0F);
			body.addChild(handle);
			setRotationAngle(handle, 0.3491F, 0.0F, 0.0F);
			handle.setTextureOffset(0, 169).addBox(-11.0F, -1.0F, -1.0F, 22.0F, 2.0F, 22.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -35.1667F, -1.0F);
			armyrobobrain.addChild(head);
			head.setTextureOffset(37, 197).addBox(-6.0F, -10.8333F, -7.0F, 12.0F, 8.0F, 14.0F, 0.0F, false);
			head.setTextureOffset(69, 8).addBox(-3.0F, -2.8333F, -4.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
			head.setTextureOffset(88, 136).addBox(-3.0F, -9.8333F, -3.0F, 6.0F, 6.0F, 7.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(9.0F, -26.0F, 0.0F);
			armyrobobrain.addChild(leftarm);
			setRotationAngle(leftarm, 0.0F, 0.0F, 0.6109F);
			leftarm.setTextureOffset(87, 200).addBox(-1.0F, -1.0F, -3.0F, 16.0F, 5.0F, 5.0F, 0.0F, false);
			leftarm.setTextureOffset(41, 235).addBox(11.3954F, -0.9176F, -16.0F, 5.0F, 5.0F, 16.0F, 0.0F, false);
			leftarm.setTextureOffset(0, 240).addBox(11.5F, -1.0F, -27.0F, 6.0F, 6.0F, 11.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-9.0F, -26.0F, 0.0F);
			armyrobobrain.addChild(rightarm);
			setRotationAngle(rightarm, 0.0F, 0.0F, -0.6109F);
			rightarm.setTextureOffset(86, 200).addBox(-15.0F, -1.0F, -3.0F, 16.0F, 5.0F, 5.0F, 0.0F, true);
			rightarm.setTextureOffset(41, 235).addBox(-16.3954F, -0.9176F, -16.0F, 5.0F, 5.0F, 16.0F, 0.0F, true);
			rightarm.setTextureOffset(0, 240).addBox(-17.5F, -1.0F, -27.1F, 6.0F, 6.0F, 11.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			armyrobobrain.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
