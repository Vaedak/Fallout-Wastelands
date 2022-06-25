
package net.mcreator.fallout_wastelands.item;

import net.minecraft.entity.ai.attributes.Attributes;

@FalloutWastelandsModElements.ModElement.Tag
public class TenmmammoItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:tenmmammo")
	public static final Item block = null;

	public TenmmammoItem(FalloutWastelandsModElements instance) {
		super(instance, 509);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(WastelanderscombattabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("tenmmammo");
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
