
package net.mcreator.fallout_wastelands.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;

public class FertilizerItem extends Item {
	public FertilizerItem() {
		super(new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSITEMS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
