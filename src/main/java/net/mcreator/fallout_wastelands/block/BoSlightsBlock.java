
package net.mcreator.fallout_wastelands.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.itemgroup.BlocsWItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import java.util.List;
import java.util.Collections;

@FalloutWastelandsModElements.ModElement.Tag
public class BoSlightsBlock extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:bo_slights")
	public static final Block block = null;
	public BoSlightsBlock(FalloutWastelandsModElements instance) {
		super(instance, 185);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(15f, 20f).setLightLevel(s -> 13).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).setRequiresTool().setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("bo_slights");
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
