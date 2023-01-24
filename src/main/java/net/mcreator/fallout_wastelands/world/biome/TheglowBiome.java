
package net.mcreator.fallout_wastelands.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

public class TheglowBiome {
	public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(Climate.Parameter.span(0.033333333333f, 0.099999999999f),
			Climate.Parameter.span(-1.033333333333f, -0.966666666667f), Climate.Parameter.span(0.476666666667f, 0.543333333333f),
			Climate.Parameter.span(0.866666666667f, 0.933333333333f), Climate.Parameter.point(0),
			Climate.Parameter.span(-0.767498107115f, -0.700831440449f), 0);

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-8213437).waterColor(-12626896).waterFogColor(-14404839)
				.skyColor(-8213437).foliageColorOverride(-10202046).grassColorOverride(-10202046)
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("fallout_wastelands:unnaturalglow")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.UNDERWATER, 0.003f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(FalloutWastelandsModEntities.GHOUL.get(), 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(FalloutWastelandsModEntities.GLOWINGONE.get(), 6, 1, 1));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).temperature(0.6f).downfall(0f).specialEffects(effects)
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
