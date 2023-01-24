
package net.mcreator.fallout_wastelands.world.features.ores;

import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModBlocks;

import java.util.Set;
import java.util.List;

public class TheglowdirtFeature extends OreFeature {
	public static TheglowdirtFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new TheglowdirtFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("fallout_wastelands:theglowdirt", FEATURE,
				new OreConfiguration(
						List.of(OreConfiguration.target(new BlockStateMatchTest(FalloutWastelandsModBlocks.WASTELANDDIRT.get().defaultBlockState()),
								FalloutWastelandsModBlocks.THEGLOWDIRT.get().defaultBlockState())),
						56));
		PLACED_FEATURE = PlacementUtils.register("fallout_wastelands:theglowdirt", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(5), InSquarePlacement.spread(),
						HeightRangePlacement.uniform(VerticalAnchor.absolute(67), VerticalAnchor.absolute(97)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set
			.of(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("fallout_wastelands:wasteland")), Level.OVERWORLD);

	public TheglowdirtFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}
}
