
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.fallout_wastelands.world.features.plants.XanderFeature;
import net.mcreator.fallout_wastelands.world.features.plants.MojaveyuccaFeature;
import net.mcreator.fallout_wastelands.world.features.plants.DeadrootsFeature;
import net.mcreator.fallout_wastelands.world.features.plants.DeadgrassFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelanduraniumoreFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandtinoreFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandredstoneFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandleadoreFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandlapislazuliFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandironFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandgravelFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandgoldFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandemeraldFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelanddiamondFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandcopperFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandcoalFeature;
import net.mcreator.fallout_wastelands.world.features.ores.WastelandallumiumoreFeature;
import net.mcreator.fallout_wastelands.world.features.ores.TheglowradioactivedirtFeature;
import net.mcreator.fallout_wastelands.world.features.ores.TheglowdirtFeature;
import net.mcreator.fallout_wastelands.world.features.ores.RootdirtFeature;
import net.mcreator.fallout_wastelands.world.features.Wastelandbuilding5Feature;
import net.mcreator.fallout_wastelands.world.features.Wastelandbrickbuilding1Feature;
import net.mcreator.fallout_wastelands.world.features.TradetownFeature;
import net.mcreator.fallout_wastelands.world.features.RoadmilitarytruckfuelFeature;
import net.mcreator.fallout_wastelands.world.features.RoadmilitarytruckFeature;
import net.mcreator.fallout_wastelands.world.features.RaidercorvegaFeature;
import net.mcreator.fallout_wastelands.world.features.PersonalbunkerFeature;
import net.mcreator.fallout_wastelands.world.features.Nuclearbunker1Feature;
import net.mcreator.fallout_wastelands.world.features.MadmaxgarageFeature;
import net.mcreator.fallout_wastelands.world.features.Garage1Feature;
import net.mcreator.fallout_wastelands.world.features.FloodedmetroFeature;
import net.mcreator.fallout_wastelands.world.features.EnclavecommcenterFeature;
import net.mcreator.fallout_wastelands.world.features.EnclavebuildingfirstFeature;
import net.mcreator.fallout_wastelands.world.features.DesertstructuretwoFeature;
import net.mcreator.fallout_wastelands.world.features.DesertstructurethreeFeature;
import net.mcreator.fallout_wastelands.world.features.DesertstructureoneFeature;
import net.mcreator.fallout_wastelands.world.features.DesertstructurefourFeature;
import net.mcreator.fallout_wastelands.world.features.CapitalironruinFeature;
import net.mcreator.fallout_wastelands.world.features.BoSbunkerFeature;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

@Mod.EventBusSubscriber
public class FalloutWastelandsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, FalloutWastelandsMod.MODID);
	public static final RegistryObject<Feature<?>> ENCLAVEBUILDINGFIRST = REGISTRY.register("enclavebuildingfirst",
			EnclavebuildingfirstFeature::feature);
	public static final RegistryObject<Feature<?>> BO_SBUNKER = REGISTRY.register("bo_sbunker", BoSbunkerFeature::feature);
	public static final RegistryObject<Feature<?>> DEADGRASS = REGISTRY.register("deadgrass", DeadgrassFeature::feature);
	public static final RegistryObject<Feature<?>> DEADROOTS = REGISTRY.register("deadroots", DeadrootsFeature::feature);
	public static final RegistryObject<Feature<?>> ROADMILITARYTRUCK = REGISTRY.register("roadmilitarytruck", RoadmilitarytruckFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDBRICKBUILDING_1 = REGISTRY.register("wastelandbrickbuilding_1",
			Wastelandbrickbuilding1Feature::feature);
	public static final RegistryObject<Feature<?>> PERSONALBUNKER = REGISTRY.register("personalbunker", PersonalbunkerFeature::feature);
	public static final RegistryObject<Feature<?>> GARAGE_1 = REGISTRY.register("garage_1", Garage1Feature::feature);
	public static final RegistryObject<Feature<?>> FLOODEDMETRO = REGISTRY.register("floodedmetro", FloodedmetroFeature::feature);
	public static final RegistryObject<Feature<?>> NUCLEARBUNKER_1 = REGISTRY.register("nuclearbunker_1", Nuclearbunker1Feature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDIRON = REGISTRY.register("wastelandiron", WastelandironFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDCOAL = REGISTRY.register("wastelandcoal", WastelandcoalFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDDIAMOND = REGISTRY.register("wastelanddiamond", WastelanddiamondFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDGOLD = REGISTRY.register("wastelandgold", WastelandgoldFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDLAPISLAZULI = REGISTRY.register("wastelandlapislazuli",
			WastelandlapislazuliFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDREDSTONE = REGISTRY.register("wastelandredstone", WastelandredstoneFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDEMERALD = REGISTRY.register("wastelandemerald", WastelandemeraldFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDCOPPER = REGISTRY.register("wastelandcopper", WastelandcopperFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDALLUMIUMORE = REGISTRY.register("wastelandallumiumore",
			WastelandallumiumoreFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDTINORE = REGISTRY.register("wastelandtinore", WastelandtinoreFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDLEADORE = REGISTRY.register("wastelandleadore", WastelandleadoreFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDGRAVEL = REGISTRY.register("wastelandgravel", WastelandgravelFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDURANIUMORE = REGISTRY.register("wastelanduraniumore",
			WastelanduraniumoreFeature::feature);
	public static final RegistryObject<Feature<?>> DESERTSTRUCTUREONE = REGISTRY.register("desertstructureone", DesertstructureoneFeature::feature);
	public static final RegistryObject<Feature<?>> DESERTSTRUCTURETWO = REGISTRY.register("desertstructuretwo", DesertstructuretwoFeature::feature);
	public static final RegistryObject<Feature<?>> DESERTSTRUCTURETHREE = REGISTRY.register("desertstructurethree",
			DesertstructurethreeFeature::feature);
	public static final RegistryObject<Feature<?>> DESERTSTRUCTUREFOUR = REGISTRY.register("desertstructurefour",
			DesertstructurefourFeature::feature);
	public static final RegistryObject<Feature<?>> MADMAXGARAGE = REGISTRY.register("madmaxgarage", MadmaxgarageFeature::feature);
	public static final RegistryObject<Feature<?>> RAIDERCORVEGA = REGISTRY.register("raidercorvega", RaidercorvegaFeature::feature);
	public static final RegistryObject<Feature<?>> WASTELANDBUILDING_5 = REGISTRY.register("wastelandbuilding_5", Wastelandbuilding5Feature::feature);
	public static final RegistryObject<Feature<?>> CAPITALIRONRUIN = REGISTRY.register("capitalironruin", CapitalironruinFeature::feature);
	public static final RegistryObject<Feature<?>> ROADMILITARYTRUCKFUEL = REGISTRY.register("roadmilitarytruckfuel",
			RoadmilitarytruckfuelFeature::feature);
	public static final RegistryObject<Feature<?>> ENCLAVECOMMCENTER = REGISTRY.register("enclavecommcenter", EnclavecommcenterFeature::feature);
	public static final RegistryObject<Feature<?>> XANDER = REGISTRY.register("xander", XanderFeature::feature);
	public static final RegistryObject<Feature<?>> MOJAVEYUCCA = REGISTRY.register("mojaveyucca", MojaveyuccaFeature::feature);
	public static final RegistryObject<Feature<?>> THEGLOWDIRT = REGISTRY.register("theglowdirt", TheglowdirtFeature::feature);
	public static final RegistryObject<Feature<?>> ROOTDIRT = REGISTRY.register("rootdirt", RootdirtFeature::feature);
	public static final RegistryObject<Feature<?>> THEGLOWRADIOACTIVEDIRT = REGISTRY.register("theglowradioactivedirt",
			TheglowradioactivedirtFeature::feature);
	public static final RegistryObject<Feature<?>> TRADETOWN = REGISTRY.register("tradetown", TradetownFeature::feature);
}
