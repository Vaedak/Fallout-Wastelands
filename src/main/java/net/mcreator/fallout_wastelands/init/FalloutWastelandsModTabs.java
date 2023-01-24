
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class FalloutWastelandsModTabs {
	public static CreativeModeTab TAB_BLOCS_W;
	public static CreativeModeTab TAB_WASTELANDERSITEMS;
	public static CreativeModeTab TAB_WASTELANDERSCOMBATTAB;

	public static void load() {
		TAB_BLOCS_W = new CreativeModeTab("tabblocs_w") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(FalloutWastelandsModBlocks.MILITARYPLATEDRADIATIONWARRIOR.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_WASTELANDERSITEMS = new CreativeModeTab("tabwastelandersitems") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(FalloutWastelandsModItems.NUCLEARWASTE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_WASTELANDERSCOMBATTAB = new CreativeModeTab("tabwastelanderscombattab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(FalloutWastelandsModItems.THEMACHINEGUN.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
