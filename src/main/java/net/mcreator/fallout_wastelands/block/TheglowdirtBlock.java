
package net.mcreator.fallout_wastelands.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FalloutWastelandsModElements.ModElement.Tag
public class TheglowdirtBlock extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:theglowdirt")
	public static final Block block = null;

	public TheglowdirtBlock(FalloutWastelandsModElements instance) {
		super(instance, 1421);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.SOUL_SAND).hardnessAndResistance(4f, 10f).setLightLevel(s -> 0));

			setRegistryName("theglowdirt");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
