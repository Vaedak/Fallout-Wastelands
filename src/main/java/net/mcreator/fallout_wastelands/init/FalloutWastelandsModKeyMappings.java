
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.fallout_wastelands.network.ExitPowerArmorMessage;
import net.mcreator.fallout_wastelands.network.AimtestMessage;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class FalloutWastelandsModKeyMappings {
	public static final KeyMapping AIMTEST = new KeyMapping("key.fallout_wastelands.aimtest", GLFW.GLFW_KEY_SCROLL_LOCK, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new AimtestMessage(0, 0));
				AimtestMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXIT_POWER_ARMOR = new KeyMapping("key.fallout_wastelands.exit_power_armor", GLFW.GLFW_KEY_N,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EXIT_POWER_ARMOR_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - EXIT_POWER_ARMOR_LASTPRESS);
				FalloutWastelandsMod.PACKET_HANDLER.sendToServer(new ExitPowerArmorMessage(1, dt));
				ExitPowerArmorMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long EXIT_POWER_ARMOR_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(AIMTEST);
		event.register(EXIT_POWER_ARMOR);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				AIMTEST.consumeClick();
				EXIT_POWER_ARMOR.consumeClick();
			}
		}
	}
}
