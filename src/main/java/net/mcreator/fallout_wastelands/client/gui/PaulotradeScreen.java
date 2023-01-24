
package net.mcreator.fallout_wastelands.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.world.inventory.PaulotradeMenu;
import net.mcreator.fallout_wastelands.network.PaulotradeButtonMessage;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PaulotradeScreen extends AbstractContainerScreen<PaulotradeMenu> {
	private final static HashMap<String, Object> guistate = PaulotradeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PaulotradeScreen(PaulotradeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/screens/paulotrade.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/trade.png"));
		this.blit(ms, this.leftPos + -83, this.topPos + -38, 0, 0, 340, 240, 340, 240);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + -11, this.topPos + 7, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.leftPos + 15, this.topPos + 7, 0, 0, 24, 17, 24, 17);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 51, this.topPos + 7, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.leftPos + -74, this.topPos + -29, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.leftPos + -11, this.topPos + -11, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/radaway.png"));
		this.blit(ms, this.leftPos + 51, this.topPos + -11, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + -11, this.topPos + 43, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 51, this.topPos + 43, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.leftPos + 15, this.topPos + 43, 0, 0, 24, 17, 24, 17);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 105, this.topPos + 7, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 7, 0, 0, 24, 17, 24, 17);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 168, this.topPos + 7, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.leftPos + -11, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/coffee.png"));
		this.blit(ms, this.leftPos + 51, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.leftPos + 105, this.topPos + -11, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/reaper.png"));
		this.blit(ms, this.leftPos + 168, this.topPos + -11, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 43, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.leftPos + 105, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 43, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 43, 0, 0, 24, 17, 24, 17);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.leftPos + 168, this.topPos + 43, 0, 0, 18, 18, 18, 18);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/fusioncoret.png"));
		this.blit(ms, this.leftPos + 168, this.topPos + 25, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/inventory_tex.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 83, 0, 0, 162, 76, 162, 76);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "16", -11, -2, -13382656);
		this.font.draw(poseStack, "42", 105, -2, -10040320);
		this.font.draw(poseStack, "4", -11, 34, -10040320);
		this.font.draw(poseStack, "128", 105, 34, -10040320);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 222, this.topPos + 160, 30, 20, Component.literal("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new PaulotradeButtonMessage(0, x, y, z));
				PaulotradeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
