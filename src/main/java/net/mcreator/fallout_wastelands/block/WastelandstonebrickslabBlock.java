
package net.mcreator.fallout_wastelands.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FalloutWastelandsModElements.ModElement.Tag
public class WastelandstonebrickslabBlock extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:wastelandstonebrickslab")
	public static final Block block = null;

	public WastelandstonebrickslabBlock(FalloutWastelandsModElements instance) {
		super(instance, 1655);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 6f).setLightLevel(s -> 0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("wastelandstonebrickslab");
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
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
