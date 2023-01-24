
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.fallout_wastelands.world.inventory.Work2whilequestMenu;
import net.mcreator.fallout_wastelands.world.inventory.Work2Menu;
import net.mcreator.fallout_wastelands.world.inventory.Work1whilequestrueMenu;
import net.mcreator.fallout_wastelands.world.inventory.Work1whilequestMenu;
import net.mcreator.fallout_wastelands.world.inventory.Work1Menu;
import net.mcreator.fallout_wastelands.world.inventory.Work1C2Menu;
import net.mcreator.fallout_wastelands.world.inventory.Work1BMenu;
import net.mcreator.fallout_wastelands.world.inventory.WastelandspawnchoiceinterfaceMenu;
import net.mcreator.fallout_wastelands.world.inventory.TownMenu;
import net.mcreator.fallout_wastelands.world.inventory.ShitholeMenu;
import net.mcreator.fallout_wastelands.world.inventory.PipboyguiMenu;
import net.mcreator.fallout_wastelands.world.inventory.PaulotradeMenu;
import net.mcreator.fallout_wastelands.world.inventory.Overseer1Menu;
import net.mcreator.fallout_wastelands.world.inventory.MexicoMenu;
import net.mcreator.fallout_wastelands.world.inventory.MexicanMenu;
import net.mcreator.fallout_wastelands.world.inventory.MedicalboxGUIMenu;
import net.mcreator.fallout_wastelands.world.inventory.LockeropMenu;
import net.mcreator.fallout_wastelands.world.inventory.IntroductionwhilequestMenu;
import net.mcreator.fallout_wastelands.world.inventory.IntroductionMenu;
import net.mcreator.fallout_wastelands.world.inventory.HighwaymantrunkMenu;
import net.mcreator.fallout_wastelands.world.inventory.HighwaymanGUImenuMenu;
import net.mcreator.fallout_wastelands.world.inventory.GobacktoworkMenu;
import net.mcreator.fallout_wastelands.world.inventory.FrameInventoryMenu;
import net.mcreator.fallout_wastelands.world.inventory.AmmunitionboxguiMenu;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FalloutWastelandsMod.MODID);
	public static final RegistryObject<MenuType<AmmunitionboxguiMenu>> AMMUNITIONBOXGUI = REGISTRY.register("ammunitionboxgui",
			() -> IForgeMenuType.create(AmmunitionboxguiMenu::new));
	public static final RegistryObject<MenuType<PipboyguiMenu>> PIPBOYGUI = REGISTRY.register("pipboygui",
			() -> IForgeMenuType.create(PipboyguiMenu::new));
	public static final RegistryObject<MenuType<MedicalboxGUIMenu>> MEDICALBOX_GUI = REGISTRY.register("medicalbox_gui",
			() -> IForgeMenuType.create(MedicalboxGUIMenu::new));
	public static final RegistryObject<MenuType<HighwaymanGUImenuMenu>> HIGHWAYMAN_GU_IMENU = REGISTRY.register("highwayman_gu_imenu",
			() -> IForgeMenuType.create(HighwaymanGUImenuMenu::new));
	public static final RegistryObject<MenuType<HighwaymantrunkMenu>> HIGHWAYMANTRUNK = REGISTRY.register("highwaymantrunk",
			() -> IForgeMenuType.create(HighwaymantrunkMenu::new));
	public static final RegistryObject<MenuType<LockeropMenu>> LOCKEROP = REGISTRY.register("lockerop",
			() -> IForgeMenuType.create(LockeropMenu::new));
	public static final RegistryObject<MenuType<Overseer1Menu>> OVERSEER_1 = REGISTRY.register("overseer_1",
			() -> IForgeMenuType.create(Overseer1Menu::new));
	public static final RegistryObject<MenuType<WastelandspawnchoiceinterfaceMenu>> WASTELANDSPAWNCHOICEINTERFACE = REGISTRY
			.register("wastelandspawnchoiceinterface", () -> IForgeMenuType.create(WastelandspawnchoiceinterfaceMenu::new));
	public static final RegistryObject<MenuType<FrameInventoryMenu>> FRAME_INVENTORY = REGISTRY.register("frame_inventory",
			() -> IForgeMenuType.create(FrameInventoryMenu::new));
	public static final RegistryObject<MenuType<PaulotradeMenu>> PAULOTRADE = REGISTRY.register("paulotrade",
			() -> IForgeMenuType.create(PaulotradeMenu::new));
	public static final RegistryObject<MenuType<IntroductionMenu>> INTRODUCTIONPAULO = REGISTRY.register("introductionpaulo",
			() -> IForgeMenuType.create(IntroductionMenu::new));
	public static final RegistryObject<MenuType<MexicanMenu>> MEXICAN = REGISTRY.register("mexican", () -> IForgeMenuType.create(MexicanMenu::new));
	public static final RegistryObject<MenuType<Work1Menu>> WORK_1 = REGISTRY.register("work_1", () -> IForgeMenuType.create(Work1Menu::new));
	public static final RegistryObject<MenuType<Work1BMenu>> WORK_1_B = REGISTRY.register("work_1_b", () -> IForgeMenuType.create(Work1BMenu::new));
	public static final RegistryObject<MenuType<Work2Menu>> WORK_2 = REGISTRY.register("work_2", () -> IForgeMenuType.create(Work2Menu::new));
	public static final RegistryObject<MenuType<TownMenu>> TOWN = REGISTRY.register("town", () -> IForgeMenuType.create(TownMenu::new));
	public static final RegistryObject<MenuType<Work1C2Menu>> WORK_1_C_2 = REGISTRY.register("work_1_c_2",
			() -> IForgeMenuType.create(Work1C2Menu::new));
	public static final RegistryObject<MenuType<IntroductionwhilequestMenu>> INTRODUCTIONWHILEQUEST = REGISTRY.register("introductionwhilequest",
			() -> IForgeMenuType.create(IntroductionwhilequestMenu::new));
	public static final RegistryObject<MenuType<Work1whilequestMenu>> WORK_1WHILEQUEST = REGISTRY.register("work_1whilequest",
			() -> IForgeMenuType.create(Work1whilequestMenu::new));
	public static final RegistryObject<MenuType<Work2whilequestMenu>> WORK_2WHILEQUEST = REGISTRY.register("work_2whilequest",
			() -> IForgeMenuType.create(Work2whilequestMenu::new));
	public static final RegistryObject<MenuType<Work1whilequestrueMenu>> WORK_1WHILEQUESTRUE = REGISTRY.register("work_1whilequestrue",
			() -> IForgeMenuType.create(Work1whilequestrueMenu::new));
	public static final RegistryObject<MenuType<GobacktoworkMenu>> GOBACKTOWORK = REGISTRY.register("gobacktowork",
			() -> IForgeMenuType.create(GobacktoworkMenu::new));
	public static final RegistryObject<MenuType<MexicoMenu>> MEXICO = REGISTRY.register("mexico", () -> IForgeMenuType.create(MexicoMenu::new));
	public static final RegistryObject<MenuType<ShitholeMenu>> SHITHOLE = REGISTRY.register("shithole",
			() -> IForgeMenuType.create(ShitholeMenu::new));
}
