
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class DeathclawEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2f, 3f))
			.build("deathclaw").setRegistryName("deathclaw");

	public DeathclawEntity(FalloutWastelandsModElements instance) {
		super(instance, 1458);

		FMLJavaModLoadingContext.get().getModEventBus().register(new DeathclawRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -7771830, -11715796, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("deathclaw_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 100);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 10);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 15);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 10);

			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 25;
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
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setCallsForHelp());
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Femalevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Femalevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, MachinegunTurretEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Malevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Malevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Malewastelander1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Malewastelander2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Malewastelander3Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Malewastelander4Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, OverseerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, WolfEntity.class, false, false));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, GlowingoneEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, ProtectronEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, NightkinEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.CustomEntity.class, false, false));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.LEATHER));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
				@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;

			ChromeraiderOnInitialEntitySpawnProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}

		@Override
		public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
			super.awardKillScore(entity, score, damageSource);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = this;

			DeathclawThisEntityKillsAnotherOneProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;

			DeathclawblocbreakerProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

	}

}
