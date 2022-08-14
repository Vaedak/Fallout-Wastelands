
package net.mcreator.fallout_wastelands.item;

import net.minecraft.entity.ai.attributes.Attributes;

@FalloutWastelandsModElements.ModElement.Tag
public class HachetItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:hachet")
	public static final Item block = null;

	public HachetItem(FalloutWastelandsModElements instance) {
		super(instance, 1560);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 4.5f;
			}

			public float getAttackDamage() {
				return 1.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelingotItem.block));
			}
		}, 1, -3.2000000000000001f, new Item.Properties().group(WastelandersitemsItemGroup.tab)) {

		}.setRegistryName("hachet"));
	}

}
