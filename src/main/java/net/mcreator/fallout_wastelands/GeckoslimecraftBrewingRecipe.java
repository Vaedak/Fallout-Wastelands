
package net.mcreator.fallout_wastelands;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.fallout_wastelands.item.GeckoeggItem;

@FalloutWastelandsModElements.ModElement.Tag
public class GeckoslimecraftBrewingRecipe extends FalloutWastelandsModElements.ModElement {
	public GeckoslimecraftBrewingRecipe(FalloutWastelandsModElements instance) {
		super(instance, 1472);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.POTION;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == GeckoeggItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(Items.SLIME_BALL);
			}
			return ItemStack.EMPTY;
		}
	}
}
