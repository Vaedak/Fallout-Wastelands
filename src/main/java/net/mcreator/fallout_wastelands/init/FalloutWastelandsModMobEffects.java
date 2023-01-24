
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.fallout_wastelands.potion.TurretShakeActivatorMobEffect;
import net.mcreator.fallout_wastelands.potion.RadioprotectionMobEffect;
import net.mcreator.fallout_wastelands.potion.RadiationMobEffect;
import net.mcreator.fallout_wastelands.potion.FrameIdentifierMobEffect;
import net.mcreator.fallout_wastelands.potion.DontMoveMobEffect;
import net.mcreator.fallout_wastelands.potion.CheckerIfExitedMobEffect;
import net.mcreator.fallout_wastelands.potion.CheckIfExitedMarkerMobEffect;
import net.mcreator.fallout_wastelands.potion.ArmorPlacerMobEffect;
import net.mcreator.fallout_wastelands.potion.AddArmorBackchestMobEffect;
import net.mcreator.fallout_wastelands.potion.AddArmorBackLegsMobEffect;
import net.mcreator.fallout_wastelands.potion.AddArmorBackHelmetMobEffect;
import net.mcreator.fallout_wastelands.potion.AddArmorBackBootsMobEffect;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

public class FalloutWastelandsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FalloutWastelandsMod.MODID);
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", () -> new RadiationMobEffect());
	public static final RegistryObject<MobEffect> RADIOPROTECTION = REGISTRY.register("radioprotection", () -> new RadioprotectionMobEffect());
	public static final RegistryObject<MobEffect> TURRET_SHAKE_ACTIVATOR = REGISTRY.register("turret_shake_activator",
			() -> new TurretShakeActivatorMobEffect());
	public static final RegistryObject<MobEffect> ADD_ARMOR_BACK_BOOTS = REGISTRY.register("add_armor_back_boots",
			() -> new AddArmorBackBootsMobEffect());
	public static final RegistryObject<MobEffect> ADD_ARMOR_BACK_LEGS = REGISTRY.register("add_armor_back_legs",
			() -> new AddArmorBackLegsMobEffect());
	public static final RegistryObject<MobEffect> ADD_ARMOR_BACK_HELMET = REGISTRY.register("add_armor_back_helmet",
			() -> new AddArmorBackHelmetMobEffect());
	public static final RegistryObject<MobEffect> ADD_ARMOR_BACKCHEST = REGISTRY.register("add_armor_backchest",
			() -> new AddArmorBackchestMobEffect());
	public static final RegistryObject<MobEffect> FRAME_IDENTIFIER = REGISTRY.register("frame_identifier", () -> new FrameIdentifierMobEffect());
	public static final RegistryObject<MobEffect> CHECKER_IF_EXITED = REGISTRY.register("checker_if_exited", () -> new CheckerIfExitedMobEffect());
	public static final RegistryObject<MobEffect> CHECK_IF_EXITED_MARKER = REGISTRY.register("check_if_exited_marker",
			() -> new CheckIfExitedMarkerMobEffect());
	public static final RegistryObject<MobEffect> ARMOR_PLACER = REGISTRY.register("armor_placer", () -> new ArmorPlacerMobEffect());
	public static final RegistryObject<MobEffect> DONT_MOVE = REGISTRY.register("dont_move", () -> new DontMoveMobEffect());
}
