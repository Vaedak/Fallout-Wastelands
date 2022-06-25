
package net.mcreator.fallout_wastelands.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@FalloutWastelandsModElements.ModElement.Tag
public class WastlandsanddesertBiome extends FalloutWastelandsModElements.ModElement {

	public static Biome biome;

	public WastlandsanddesertBiome(FalloutWastelandsModElements instance) {
		super(instance, 458);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-5257836).setWaterColor(-8687798).setWaterFogColor(-13094366)
						.withSkyColor(-5257836).withFoliageColor(-11844550).withGrassColor(-11844550).build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(WastlandsandBlock.block.getDefaultState(),
								WastlandsandBlock.block.getDefaultState(), WastlandsandBlock.block.getDefaultState())));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.3f).scale(0.3f).temperature(2f)
						.downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("fallout_wastelands:wastlandsanddesert"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)),
				BiomeDictionary.Type.WASTELAND);
	}

}
