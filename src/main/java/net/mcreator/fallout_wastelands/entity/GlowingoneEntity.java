
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class GlowingoneEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("glowingone").setRegistryName("glowingone");

	public GlowingoneEntity(FalloutWastelandsModElements instance) {
		super(instance, 1456);

		FMLJavaModLoadingContext.get().getModEventBus().register(new GlowingoneRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -6837150, -4003507, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("glowingone_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 60);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0.5);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);

			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.1);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 15;
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
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, GeckoEntity.CustomEntity.class, false, false));
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
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.CustomEntity.class, false, false));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:ghoulliving"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:ghoulinjured"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:ghouldeath"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
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

	}

}
