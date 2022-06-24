
package net.mcreator.fallout_wastelands.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WastelandspawnchoiceinterfaceGuiWindow extends ContainerScreen<WastelandspawnchoiceinterfaceGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = WastelandspawnchoiceinterfaceGui.guistate;

	public WastelandspawnchoiceinterfaceGuiWindow(WastelandspawnchoiceinterfaceGui.GuiContainerMod container, PlayerInventory inventory,
			ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/wastelandspawnchoiceinterface.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/entering_wastelands.png"));
		this.blit(ms, this.guiLeft + -20, this.guiTop + -11, 0, 0, 240, 182, 240, 182);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Do you want to start in the Wasteland ?", -2, -2, -13395712);
		this.font.drawString(ms, "If so you will spawn in a vault .", 15, 16, -13395712);
		this.font.drawString(ms, "Spawning in the vault will trigger the main quest", -20, 34, -13395712);
		this.font.drawString(ms, "The main quest is actually early WIP (1% done)", -11, 52, -3407872);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + 106, 40, 20, new StringTextComponent("YES"), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new WastelandspawnchoiceinterfaceGui.ButtonPressedMessage(0, x, y, z));
				WastelandspawnchoiceinterfaceGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 106, 45, 20, new StringTextComponent("NO  "), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new WastelandspawnchoiceinterfaceGui.ButtonPressedMessage(1, x, y, z));
				WastelandspawnchoiceinterfaceGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
