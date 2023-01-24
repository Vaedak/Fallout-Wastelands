
package net.mcreator.fallout_wastelands.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.procedures.IndustrialscrappileondestroyProcedure;
import net.mcreator.fallout_wastelands.procedures.IndustrialscrappilebeingdestroyedProcedure;
import net.mcreator.fallout_wastelands.procedures.IndustrialpileonpilebyplayerProcedure;

public class IndustrialscrappileBlock extends Block {
	public IndustrialscrappileBlock() {
		super(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GLASS).strength(1f, 3f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false).noLootTable());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		IndustrialpileonpilebyplayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		IndustrialscrappileondestroyProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
		super.attack(blockstate, world, pos, entity);
		IndustrialscrappilebeingdestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
