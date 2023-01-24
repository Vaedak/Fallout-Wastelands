
package net.mcreator.fallout_wastelands.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.world.inventory.IntroductionMenu;
import net.mcreator.fallout_wastelands.network.IntroductionButtonMessage;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class IntroductionScreen extends AbstractContainerScreen<IntroductionMenu> {
	private final static HashMap<String, Object> guistate = IntroductionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public IntroductionScreen(IntroductionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/screens/introductionpaulo.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("fallout_wastelands:textures/screens/paulo.png"));
		this.blit(ms, this.leftPos + -83, this.topPos + -38, 0, 0, 340, 240, 340, 240);

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
		this.font.draw(poseStack, "Hey stranger ! What can an old Mexican", -11, 79, -10040320);
		this.font.draw(poseStack, "trader do for you ?", -11, 88, -10040320);
		this.font.draw(poseStack, "Mexican ? What is that ?", -11, 133, -10040320);
		this.font.draw(poseStack, "Got work for me ?", -11, 151, -10040320);
		this.font.draw(poseStack, "Tell me about the town .", -11, 169, -10040320);
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
		this.addRenderableWidget(new Button(this.leftPos + 222, this.topPos + 124, 30, 20, Component.literal("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new IntroductionButtonMessage(0, x, y, z));
				IntroductionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 159, this.topPos + 124, 30, 20, Component.literal("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new IntroductionButtonMessage(1, x, y, z));
				IntroductionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 159, this.topPos + 142, 30, 20, Component.literal("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new IntroductionButtonMessage(2, x, y, z));
				IntroductionButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 159, this.topPos + 160, 30, 20, Component.literal("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new IntroductionButtonMessage(3, x, y, z));
				IntroductionButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
