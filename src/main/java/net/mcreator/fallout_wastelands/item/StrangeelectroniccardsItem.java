
package net.mcreator.fallout_wastelands.item;

import net.minecraft.entity.ai.attributes.Attributes;

@FalloutWastelandsModElements.ModElement.Tag
public class StrangeelectroniccardsItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:strangeelectroniccards")
	public static final Item block = null;

	public StrangeelectroniccardsItem(FalloutWastelandsModElements instance) {
		super(instance, 1525);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(WastelandersitemsItemGroup.tab).maxStackSize(10).rarity(Rarity.COMMON));
			setRegistryName("strangeelectroniccards");
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
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("I wonder where do they come from ..."));
		}

	}

}
