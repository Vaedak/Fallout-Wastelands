
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.fallout_wastelands.client.gui.Work2whilequestScreen;
import net.mcreator.fallout_wastelands.client.gui.Work2Screen;
import net.mcreator.fallout_wastelands.client.gui.Work1whilequestrueScreen;
import net.mcreator.fallout_wastelands.client.gui.Work1whilequestScreen;
import net.mcreator.fallout_wastelands.client.gui.Work1Screen;
import net.mcreator.fallout_wastelands.client.gui.Work1C2Screen;
import net.mcreator.fallout_wastelands.client.gui.Work1BScreen;
import net.mcreator.fallout_wastelands.client.gui.WastelandspawnchoiceinterfaceScreen;
import net.mcreator.fallout_wastelands.client.gui.TownScreen;
import net.mcreator.fallout_wastelands.client.gui.ShitholeScreen;
import net.mcreator.fallout_wastelands.client.gui.PipboyguiScreen;
import net.mcreator.fallout_wastelands.client.gui.PaulotradeScreen;
import net.mcreator.fallout_wastelands.client.gui.Overseer1Screen;
import net.mcreator.fallout_wastelands.client.gui.MexicoScreen;
import net.mcreator.fallout_wastelands.client.gui.MexicanScreen;
import net.mcreator.fallout_wastelands.client.gui.MedicalboxGUIScreen;
import net.mcreator.fallout_wastelands.client.gui.LockeropScreen;
import net.mcreator.fallout_wastelands.client.gui.IntroductionwhilequestScreen;
import net.mcreator.fallout_wastelands.client.gui.IntroductionScreen;
import net.mcreator.fallout_wastelands.client.gui.HighwaymantrunkScreen;
import net.mcreator.fallout_wastelands.client.gui.HighwaymanGUImenuScreen;
import net.mcreator.fallout_wastelands.client.gui.GobacktoworkScreen;
import net.mcreator.fallout_wastelands.client.gui.FrameInventoryScreen;
import net.mcreator.fallout_wastelands.client.gui.AmmunitionboxguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FalloutWastelandsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(FalloutWastelandsModMenus.AMMUNITIONBOXGUI.get(), AmmunitionboxguiScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.PIPBOYGUI.get(), PipboyguiScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.MEDICALBOX_GUI.get(), MedicalboxGUIScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.HIGHWAYMAN_GU_IMENU.get(), HighwaymanGUImenuScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.HIGHWAYMANTRUNK.get(), HighwaymantrunkScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.LOCKEROP.get(), LockeropScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.OVERSEER_1.get(), Overseer1Screen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WASTELANDSPAWNCHOICEINTERFACE.get(), WastelandspawnchoiceinterfaceScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.FRAME_INVENTORY.get(), FrameInventoryScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.PAULOTRADE.get(), PaulotradeScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.INTRODUCTIONPAULO.get(), IntroductionScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.MEXICAN.get(), MexicanScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_1.get(), Work1Screen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_1_B.get(), Work1BScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_2.get(), Work2Screen::new);
			MenuScreens.register(FalloutWastelandsModMenus.TOWN.get(), TownScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_1_C_2.get(), Work1C2Screen::new);
			MenuScreens.register(FalloutWastelandsModMenus.INTRODUCTIONWHILEQUEST.get(), IntroductionwhilequestScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_1WHILEQUEST.get(), Work1whilequestScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_2WHILEQUEST.get(), Work2whilequestScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.WORK_1WHILEQUESTRUE.get(), Work1whilequestrueScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.GOBACKTOWORK.get(), GobacktoworkScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.MEXICO.get(), MexicoScreen::new);
			MenuScreens.register(FalloutWastelandsModMenus.SHITHOLE.get(), ShitholeScreen::new);
		});
	}
}
