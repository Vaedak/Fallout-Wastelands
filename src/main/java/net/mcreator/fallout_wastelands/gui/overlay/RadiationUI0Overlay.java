
package net.mcreator.fallout_wastelands.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.procedures.RadiationUI9Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI8Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI7Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI6Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI5Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI4Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI23Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI22Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI21Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI20Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI19Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI18Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI17Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI16Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI15Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI14Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI13Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI12Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI11Procedure;
import net.mcreator.fallout_wastelands.procedures.RadiationUI10Procedure;
import net.mcreator.fallout_wastelands.procedures.Radiation3UIProcedure;
import net.mcreator.fallout_wastelands.procedures.Radiation2UIProcedure;
import net.mcreator.fallout_wastelands.procedures.Radiation1UIProcedure;
import net.mcreator.fallout_wastelands.procedures.Radiation0UIProcedure;
import net.mcreator.fallout_wastelands.procedures.DisplayradiationgreeniconProcedure;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class RadiationUI0Overlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {
				if (Radiation0UIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_0.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (Radiation1UIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_1.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (Radiation2UIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_2.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (Radiation3UIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_3.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (DisplayradiationgreeniconProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager()
							.bindTexture(new ResourceLocation("fallout_wastelands:textures/radiation_ui_base.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 198, posY + -112, 0, 0, 16, 16, 16, 16);
				}
				if (RadiationUI4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_4.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_5.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_6.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_7.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_8.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_9.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_10.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_11.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_12.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_13.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_14.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_15.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_16.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_17.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_18.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_19.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_20.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_21.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_22.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
				if (RadiationUI23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/rad_23.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 117, posY + -112, 0, 0, 80, 16, 80, 16);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
