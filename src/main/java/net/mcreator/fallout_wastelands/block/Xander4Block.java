
package net.mcreator.fallout_wastelands.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.procedures.Xander4UpdateTickProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

import java.util.List;
import java.util.Collections;

public class Xander4Block extends FlowerBlock {
	public Xander4Block() {
		super(MobEffects.SATURATION, 0, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).randomTicks().sound(SoundType.GRASS)
				.strength(0.1f, 0.1f).noCollission());
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(FalloutWastelandsModItems.XANDERROOT.get()));
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		Xander4UpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
