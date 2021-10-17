
package net.mcreator.fallout_wastelands.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.fallout_wastelands.block.MilitaryplatedradiationwarriorBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class BlocsWItemGroup extends FalloutWastelandsModElements.ModElement {
	public BlocsWItemGroup(FalloutWastelandsModElements instance) {
		super(instance, 89);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabblocs_w") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MilitaryplatedradiationwarriorBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
