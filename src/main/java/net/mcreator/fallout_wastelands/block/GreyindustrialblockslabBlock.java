
package net.mcreator.fallout_wastelands.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FalloutWastelandsModElements.ModElement.Tag
public class GreyindustrialblockslabBlock extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:greyindustrialblockslab")
	public static final Block block = null;

	public GreyindustrialblockslabBlock(FalloutWastelandsModElements instance) {
		super(instance, 1616);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(7f, 10f).setLightLevel(s -> 0));

			setRegistryName("greyindustrialblockslab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
