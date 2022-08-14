
package net.mcreator.fallout_wastelands.gui;

import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

@OnlyIn(Dist.CLIENT)
public class PaulotradeGuiWindow extends ContainerScreen<PaulotradeGui.GuiContainerMod> {

	private World world;
	private int x, y, z;
	private PlayerEntity entity;

	private final static HashMap guistate = PaulotradeGui.guistate;

	public PaulotradeGuiWindow(PaulotradeGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fallout_wastelands:textures/screens/paulotrade.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/trade.png"));
		this.blit(ms, this.guiLeft + -83, this.guiTop + -38, 0, 0, 340, 240, 340, 240);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + -11, this.guiTop + 7, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 7, 0, 0, 24, 17, 24, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 7, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.guiLeft + -74, this.guiTop + -29, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.guiLeft + -11, this.guiTop + -11, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/radaway.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + -11, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + -11, this.guiTop + 43, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 43, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 43, 0, 0, 24, 17, 24, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 7, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 7, 0, 0, 24, 17, 24, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 168, this.guiTop + 7, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.guiLeft + -11, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/coffee.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + -11, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/reaper.png"));
		this.blit(ms, this.guiLeft + 168, this.guiTop + -11, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 43, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/bottlecaps.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 43, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradearrow1.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 43, 0, 0, 24, 17, 24, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/tradeslot.png"));
		this.blit(ms, this.guiLeft + 168, this.guiTop + 43, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/fusioncoret.png"));
		this.blit(ms, this.guiLeft + 168, this.guiTop + 25, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fallout_wastelands:textures/screens/inventory_tex.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 83, 0, 0, 162, 76, 162, 76);

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
		this.font.drawString(ms, "16", -11, -2, -13382656);
		this.font.drawString(ms, "42", 105, -2, -10040320);
		this.font.drawString(ms, "4", -11, 34, -10040320);
		this.font.drawString(ms, "128", 105, 34, -10040320);
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

		this.addButton(new Button(this.guiLeft + 222, this.guiTop + 160, 30, 20, new StringTextComponent("."), e -> {
			if (true) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new PaulotradeGui.ButtonPressedMessage(0, x, y, z));
				PaulotradeGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}

}
