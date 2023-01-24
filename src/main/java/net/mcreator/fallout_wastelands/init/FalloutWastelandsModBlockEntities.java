
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.fallout_wastelands.block.entity.MedicalboxBlockEntity;
import net.mcreator.fallout_wastelands.block.entity.LockerBlockEntity;
import net.mcreator.fallout_wastelands.block.entity.FridgeBlockEntity;
import net.mcreator.fallout_wastelands.block.entity.DeadrootsBlockEntity;
import net.mcreator.fallout_wastelands.block.entity.DeadgrassBlockEntity;
import net.mcreator.fallout_wastelands.block.entity.AmmunitionboxBlockEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			FalloutWastelandsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> DEADGRASS = register("deadgrass", FalloutWastelandsModBlocks.DEADGRASS,
			DeadgrassBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DEADROOTS = register("deadroots", FalloutWastelandsModBlocks.DEADROOTS,
			DeadrootsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AMMUNITIONBOX = register("ammunitionbox", FalloutWastelandsModBlocks.AMMUNITIONBOX,
			AmmunitionboxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MEDICALBOX = register("medicalbox", FalloutWastelandsModBlocks.MEDICALBOX,
			MedicalboxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LOCKER = register("locker", FalloutWastelandsModBlocks.LOCKER, LockerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FRIDGE = register("fridge", FalloutWastelandsModBlocks.FRIDGE, FridgeBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
