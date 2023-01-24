
package net.mcreator.fallout_wastelands.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.procedures.FevgooMobplayerCollidesBlockProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModFluids;

public class FevgooBlock extends LiquidBlock {
	public FevgooBlock() {
		super(() -> FalloutWastelandsModFluids.FEVGOO.get(),
				BlockBehaviour.Properties.of(Material.WATER).strength(100f).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		FevgooMobplayerCollidesBlockProcedure.execute(entity);
	}
}
