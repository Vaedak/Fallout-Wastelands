
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.mcreator.fallout_wastelands.procedures.GeckoEntityDiesProcedure;
import net.mcreator.fallout_wastelands.entity.renderer.GeckoRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@FalloutWastelandsModElements.ModElement.Tag
public class GeckoEntity extends FalloutWastelandsModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(80).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("gecko").setRegistryName("gecko");

	public GeckoEntity(FalloutWastelandsModElements instance) {
		super(instance, 1455);
		FMLJavaModLoadingContext.get().getModEventBus().register(new GeckoRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -12762275, -12755083, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("gecko_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("fallout_wastelands:wastlandsanddesert").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 2, 6, 6));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.7, true) {
				@Override
				protected double getAttackReachSqr(LivingEntity entity) {
					return (double) (4.0 + entity.getWidth() * entity.getWidth());
				}
			});
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, Femalevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Femalevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, MachinegunTurretEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Malevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Malevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Malewastelander1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Malewastelander2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Malewastelander3Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Malewastelander4Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, OverseerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, WolfEntity.class, false, false));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;

			GeckoEntityDiesProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
