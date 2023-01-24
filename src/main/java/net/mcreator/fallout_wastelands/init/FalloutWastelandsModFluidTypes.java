
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.fallout_wastelands.fluid.types.FevgooFluidType;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, FalloutWastelandsMod.MODID);
	public static final RegistryObject<FluidType> FEVGOO_TYPE = REGISTRY.register("fevgoo", () -> new FevgooFluidType());
}
