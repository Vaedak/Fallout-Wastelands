
package net.mcreator.fallout_wastelands.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.entity.RaidergunnerEntity;
import net.mcreator.fallout_wastelands.entity.MirelurkEntity;
import net.mcreator.fallout_wastelands.entity.GhoulEntity;
import net.mcreator.fallout_wastelands.entity.ChromeraiderEntity;
import net.mcreator.fallout_wastelands.entity.ChromedraiderfemaleEntity;
import net.mcreator.fallout_wastelands.entity.BloatflyEntity;
import net.mcreator.fallout_wastelands.block.WastlandstoneBlock;
import net.mcreator.fallout_wastelands.block.WastelanddirtBlock;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class CapitalwastelandBiome extends FalloutWastelandsModElements.ModElement {
	public static Biome biome;

	public CapitalwastelandBiome(FalloutWastelandsModElements instance) {
		super(instance, 161);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-12886976).setWaterColor(-14474990).setWaterFogColor(-14474990)
						.withSkyColor(-12886976).withFoliageColor(-13226463).withGrassColor(-13226463)
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
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ChromeraiderEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ChromedraiderfemaleEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ChromeraiderEntity.entity, 1, 2, 2));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(MirelurkEntity.entity, 3, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BloatflyEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(GhoulEntity.entity, 1, 1, 1));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(RaidergunnerEntity.entity, 1, 1, 1));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0f).scale(0f).temperature(1f)
						.downfall(0.1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("fallout_wastelands:capitalwasteland"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
