
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class TaloncompagnylieutenantEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("taloncompagnylieutenant").setRegistryName("taloncompagnylieutenant");

	public TaloncompagnylieutenantEntity(FalloutWastelandsModElements instance) {
		super(instance, 1632);

		FMLJavaModLoadingContext.get().getModEventBus().register(new TaloncompagnylieutenantRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -3355444, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("taloncompagnylieutenant_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 20);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 5);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 6);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 4;
			setNoAI(false);

			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TenmmItem.block));
			this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(TaloncombatarmorItem.body));
			this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(TaloncombatarmorItem.legs));
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(TaloncombatarmorItem.boots));

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.7));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp());
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
			this.goalSelector.addGoal(5, new ReturnToVillageGoal(this, 0.6, false));
			this.goalSelector.addGoal(6, new OpenDoorGoal(this, true));
			this.targetSelector.addGoal(7, new HurtByTargetGoal(this).setCallsForHelp());
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.goalSelector.addGoal(9, new MeleeAttackGoal(this, 0.7, true) {

				@Override
				protected double getAttackReachSqr(LivingEntity entity) {
					return (double) (4.0 + entity.getWidth() * entity.getWidth());
				}

			});
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, VillagerEntity.class, false, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, DeathclawEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Femalevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Femalevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, GeckoEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, GlowingoneEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Malevaultdweller1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Malevaultdweller2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Malewastelander1Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Malewastelander2Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, Malewastelander3Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, Malewastelander4Entity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, OverseerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, ProtectronEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, NightkinEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.CustomEntity.class, false, false));

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

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BottlecapsItem.block));
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

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			MmpistolnineItem.shoot(this, target);
		}

	}

}
