
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class EnclaveMachingunTurretEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(0.5f, 0.6f)).build("enclave_machingun_turret").setRegistryName("enclave_machingun_turret");

	public EnclaveMachingunTurretEntity(FalloutWastelandsModElements instance) {
		super(instance, 1470);

		FMLJavaModLoadingContext.get().getModEventBus().register(new EnclaveMachingunTurretRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -10066330, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("enclave_machingun_turret_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {

		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 20, 4, 4));
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
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 4);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 10);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {

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

			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false) {

				@Override
				protected double getAttackReachSqr(LivingEntity entity) {
					return (double) (4.0 + entity.getWidth() * entity.getWidth());
				}

			});
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, EnderDragonEntity.class, true, false));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, GlowingoneEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, NightkinEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, HighwaymanEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, BatEntity.class, true, true));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, GhastEntity.class, true, true));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, IronGolemEntity.class, true, true));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, PillagerEntity.class, true, true));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, true));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, VillagerEntity.class, true, true));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, WitherEntity.class, true, true));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, WolfEntity.class, true, true));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, true));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, true));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, PhantomEntity.class, true, true));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, WitherSkeletonEntity.class, true, true));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, WitchEntity.class, true, true));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, SnowGolemEntity.class, true, true));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, SlimeEntity.class, true, true));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, true));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, EnderDragonEntity.class, true, true));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, ZombifiedPiglinEntity.class, true, true));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, CreeperEntity.class, true, true));

			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;

			MachinegunTurretOnEntityTickUpdatenewProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			TurretFakeProjectileItem.shoot(this, target);
		}

	}

}
