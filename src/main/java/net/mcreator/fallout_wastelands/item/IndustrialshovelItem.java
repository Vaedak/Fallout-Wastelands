
package net.mcreator.fallout_wastelands.item;

import net.minecraft.entity.ai.attributes.Attributes;

@FalloutWastelandsModElements.ModElement.Tag
public class IndustrialshovelItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:industrialshovel")
	public static final Item block = null;

	public IndustrialshovelItem(FalloutWastelandsModElements instance) {
		super(instance, 1561);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 4.5f;
			}

			public float getAttackDamage() {
				return -1f;
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
		}, 1, -2.5f, new Item.Properties().group(WastelandersitemsItemGroup.tab)) {

		}.setRegistryName("industrialshovel"));
	}

}
