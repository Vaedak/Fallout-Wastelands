
package net.mcreator.fallout_wastelands.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@FalloutWastelandsModElements.ModElement.Tag
public class CapitalwastelandeastBiome extends FalloutWastelandsModElements.ModElement {

	public static Biome biome;

	public CapitalwastelandeastBiome(FalloutWastelandsModElements instance) {
		super(instance, 181);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-12889025).setWaterColor(-14343147).setWaterFogColor(-14343147)
						.withSkyColor(-12889025).withFoliageColor(-12831706).withGrassColor(-12831706)
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("fallout_wastelands:wastelandwind")), 12000, 24000, true))
						.build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(WastelanddirtBlock.block.getDefaultState(),
								WastlandstoneBlock.block.getDefaultState(), WastlandstoneBlock.block.getDefaultState())));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 1))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BROWN_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(1).func_227317_b_().build()));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.RED_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(1).func_227317_b_().build()));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ChromeraiderEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ChromedraiderfemaleEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(MirelurkEntity.entity, 7, 4, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BloatflyEntity.entity, 1, 1, 1));

				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0f).scale(0f).temperature(0.5f)
						.downfall(0.1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("fallout_wastelands:capitalwastelandeast"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

}
