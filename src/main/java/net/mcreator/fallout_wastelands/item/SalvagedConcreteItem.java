<<<<<<< HEAD

package net.mcreator.fallout_wastelands.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;

public class SalvagedConcreteItem extends Item {
	public SalvagedConcreteItem() {
		super(new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSITEMS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
=======

package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.itemgroup.WastelandersitemsItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class SalvagedConcreteItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:salvaged_concrete")
	public static final Item block = null;

	public SalvagedConcreteItem(FalloutWastelandsModElements instance) {
		super(instance, 1656);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WastelandersitemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("salvaged_concrete");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
