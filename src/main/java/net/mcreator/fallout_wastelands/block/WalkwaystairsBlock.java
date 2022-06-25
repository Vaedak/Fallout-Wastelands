
package net.mcreator.fallout_wastelands.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.fallout_wastelands.itemgroup.BlocsWItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import java.util.List;
import java.util.Collections;

@FalloutWastelandsModElements.ModElement.Tag
public class WalkwaystairsBlock extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:walkwaystairs")
	public static final Block block = null;

	public WalkwaystairsBlock(FalloutWastelandsModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(10f, 10f).setLightLevel(s -> 0)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(0.7f).notSolid().setOpaque((bs, br, bp) -> false))
					.getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(10f, 10f).setLightLevel(s -> 0)
							.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(0.7f).notSolid()
							.setOpaque((bs, br, bp) -> false));
			setRegistryName("walkwaystairs");
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
