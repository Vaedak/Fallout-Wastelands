
package net.mcreator.fallout_wastelands.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.fallout_wastelands.item.ThemachinegunItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class WastelanderscombattabItemGroup extends FalloutWastelandsModElements.ModElement {
	public WastelanderscombattabItemGroup(FalloutWastelandsModElements instance) {
		super(instance, 226);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwastelanderscombattab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ThemachinegunItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
