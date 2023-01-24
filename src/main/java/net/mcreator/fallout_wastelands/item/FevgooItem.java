
package net.mcreator.fallout_wastelands.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModFluids;

public class FevgooItem extends BucketItem {
	public FevgooItem() {
		super(FalloutWastelandsModFluids.FEVGOO,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(FalloutWastelandsModTabs.TAB_BLOCS_W));
	}
}
