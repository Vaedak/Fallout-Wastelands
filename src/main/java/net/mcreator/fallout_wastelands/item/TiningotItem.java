
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.itemgroup.WastelandersitemsItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class TiningotItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:ingot_tin")
	public static final Item block = null;

	public TiningotItem(FalloutWastelandsModElements instance) {
		super(instance, 328);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WastelandersitemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ingot_tin");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
