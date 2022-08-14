
package net.mcreator.fallout_wastelands.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@FalloutWastelandsModElements.ModElement.Tag
public class GreyindustrialblockstairsBlock extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:greyindustrialblockstairs")
	public static final Block block = null;

	public GreyindustrialblockstairsBlock(FalloutWastelandsModElements instance) {
		super(instance, 1617);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(10f, 10f).setLightLevel(s -> 0)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()).getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(10f, 10f).setLightLevel(s -> 0)
							.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("greyindustrialblockstairs");
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
