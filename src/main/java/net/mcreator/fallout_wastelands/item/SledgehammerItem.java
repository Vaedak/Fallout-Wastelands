<<<<<<< HEAD
<<<<<<< HEAD

package net.mcreator.fallout_wastelands.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

public class SledgehammerItem extends PickaxeItem {
	public SledgehammerItem() {
		super(new Tier() {
			public int getUses() {
				return 200;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(FalloutWastelandsModItems.STEELINGOT.get()));
			}
		}, 1, -3.3f, new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSITEMS));
	}
}
=======

package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.fallout_wastelands.itemgroup.WastelandersitemsItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class SledgehammerItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:sledgehammer")
	public static final Item block = null;

	public SledgehammerItem(FalloutWastelandsModElements instance) {
		super(instance, 1559);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelingotItem.block));
			}
		}, 1, -3.3f, new Item.Properties().group(WastelandersitemsItemGroup.tab)) {
		}.setRegistryName("sledgehammer"));
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======

package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.fallout_wastelands.itemgroup.WastelandersitemsItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class SledgehammerItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:sledgehammer")
	public static final Item block = null;

	public SledgehammerItem(FalloutWastelandsModElements instance) {
		super(instance, 1559);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SteelingotItem.block));
			}
		}, 1, -3.3f, new Item.Properties().group(WastelandersitemsItemGroup.tab)) {
		}.setRegistryName("sledgehammer"));
	}
}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
