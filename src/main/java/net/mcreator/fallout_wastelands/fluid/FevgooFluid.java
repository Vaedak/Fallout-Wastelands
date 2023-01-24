
package net.mcreator.fallout_wastelands.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModFluids;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModFluidTypes;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

public abstract class FevgooFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> FalloutWastelandsModFluidTypes.FEVGOO_TYPE.get(), () -> FalloutWastelandsModFluids.FEVGOO.get(),
			() -> FalloutWastelandsModFluids.FLOWING_FEVGOO.get()).explosionResistance(100f)
			.bucket(() -> FalloutWastelandsModItems.FEVGOO_BUCKET.get()).block(() -> (LiquidBlock) FalloutWastelandsModBlocks.FEVGOO.get());

	private FevgooFluid() {
		super(PROPERTIES);
	}

	public static class Source extends FevgooFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends FevgooFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
