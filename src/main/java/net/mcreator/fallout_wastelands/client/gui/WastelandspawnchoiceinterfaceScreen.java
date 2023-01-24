
package net.mcreator.fallout_wastelands.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.world.inventory.WastelandspawnchoiceinterfaceMenu;
import net.mcreator.fallout_wastelands.network.WastelandspawnchoiceinterfaceButtonMessage;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WastelandspawnchoiceinterfaceScreen extends AbstractContainerScreen<WastelandspawnchoiceinterfaceMenu> {
	private final static HashMap<String, Object> guistate = WastelandspawnchoiceinterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WastelandspawnchoiceinterfaceScreen(WastelandspawnchoiceinterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/screens/wastelandspawnchoiceinterface.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/entering_wastelands.png"));
		this.blit(ms, this.leftPos + -20, this.topPos + -11, 0, 0, 240, 182, 240, 182);

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
		this.font.draw(poseStack, "Do you want to start in the Wasteland ?", -2, -2, -13395712);
		this.font.draw(poseStack, "If so you will spawn in a vault .", 15, 16, -13395712);
		this.font.draw(poseStack, "Spawning in the vault will trigger the main quest", -20, 34, -13395712);
		this.font.draw(poseStack, "The main quest is actually early WIP (1% done)", -11, 52, -3407872);
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
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 106, 40, 20, Component.literal("YES"), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new WastelandspawnchoiceinterfaceButtonMessage(0, x, y, z));
				WastelandspawnchoiceinterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 132, this.topPos + 106, 45, 20, Component.literal("NO  "), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new WastelandspawnchoiceinterfaceButtonMessage(1, x, y, z));
				WastelandspawnchoiceinterfaceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
