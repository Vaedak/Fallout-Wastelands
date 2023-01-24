
package net.mcreator.fallout_wastelands.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;

public class RobobraintrackItem extends Item {
	public RobobraintrackItem() {
		super(new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSITEMS).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}
