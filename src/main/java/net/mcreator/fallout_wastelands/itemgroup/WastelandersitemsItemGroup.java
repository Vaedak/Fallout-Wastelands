
package net.mcreator.fallout_wastelands.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.fallout_wastelands.item.NuclearwasteItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class WastelandersitemsItemGroup extends FalloutWastelandsModElements.ModElement {
	public WastelandersitemsItemGroup(FalloutWastelandsModElements instance) {
		super(instance, 225);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwastelandersitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NuclearwasteItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
