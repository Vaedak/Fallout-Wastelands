<<<<<<< HEAD
<<<<<<< HEAD

package net.mcreator.fallout_wastelands.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class RoofsheetmetalstairsBlock extends StairBlock {
	public RoofsheetmetalstairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(7f, 10f).requiresCorrectToolForDrops().dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
			return tieredItem.getTier().getLevel() >= 2;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
=======

package net.mcreator.fallout_wastelands.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
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
public class RoofsheetmetalstairsBlock extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:roofsheetmetalstairs")
	public static final Block block = null;

	public RoofsheetmetalstairsBlock(FalloutWastelandsModElements instance) {
		super(instance, 1550);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(7f, 10f).setLightLevel(s -> 0)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()).getDefaultState(),
					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(7f, 10f).setLightLevel(s -> 0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("roofsheetmetalstairs");
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
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======

package net.mcreator.fallout_wastelands.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
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
public class RoofsheetmetalstairsBlock extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:roofsheetmetalstairs")
	public static final Block block = null;

	public RoofsheetmetalstairsBlock(FalloutWastelandsModElements instance) {
		super(instance, 1550);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocsWItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(7f, 10f).setLightLevel(s -> 0)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()).getDefaultState(),
					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(7f, 10f).setLightLevel(s -> 0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("roofsheetmetalstairs");
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
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
