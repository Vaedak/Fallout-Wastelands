
package net.mcreator.fallout_wastelands.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FalloutWastelandsModElements.ModElement.Tag
public class RedrottenwoodplatingBlock extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:redrottenwoodplating")
	public static final Block block = null;

	public RedrottenwoodplatingBlock(FalloutWastelandsModElements instance) {
		super(instance, 1557);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 6f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.AXE).setRequiresTool());

			setRegistryName("redrottenwoodplating");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 9;
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
