
package net.mcreator.fallout_wastelands.gui;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

@OnlyIn(Dist.CLIENT)
public class ShitholeGuiWindow extends ContainerScreen<ShitholeGui.GuiContainerMod> {

	private World world;
	private int x, y, z;
	private PlayerEntity entity;

	private final static HashMap guistate = ShitholeGui.guistate;

	public ShitholeGuiWindow(ShitholeGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/screens/shithole.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/paulo.png"));
		this.blit(ms, this.guiLeft + -83, this.guiTop + -38, 0, 0, 340, 240, 340, 240);

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
		this.font.drawString(ms, "Watch your mouth stranger ! Life in", -11, 79, -10040320);
		this.font.drawString(ms, "Mexico may be dangerous but it remains", -11, 88, -10040320);
		this.font.drawString(ms, "Okay ! calm down could we talk ", -11, 133, -10040320);
		this.font.drawString(ms, "a place I grew in and I still love !", -11, 97, -10040320);
		this.font.drawString(ms, "about something else ?", -11, 142, -10040320);
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

		this.addButton(new Button(this.guiLeft + 222, this.guiTop + 124, 30, 20, new StringTextComponent("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new ShitholeGui.ButtonPressedMessage(0, x, y, z));
				ShitholeGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 150, this.guiTop + 133, 30, 20, new StringTextComponent("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new ShitholeGui.ButtonPressedMessage(1, x, y, z));
				ShitholeGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}

}
