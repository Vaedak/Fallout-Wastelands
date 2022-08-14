
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class BrotherhoodPaladinEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("brotherhood_paladin").setRegistryName("brotherhood_paladin");

	public BrotherhoodPaladinEntity(FalloutWastelandsModElements instance) {
		super(instance, 1630);

		FMLJavaModLoadingContext.get().getModEventBus().register(new BrotherhoodPaladinRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -10066330, -10066177, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("brotherhood_paladin_spawn_egg"));
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
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 35);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends CreatureEntity implements IRangedAttackMob {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

			enablePersistence();

			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(EnemylaserweaponItem.block));
			this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(T45powerarmorItem.helmet));
			this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(T45powerarmorItem.body));
			this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(T45powerarmorItem.legs));
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(T45powerarmorItem.boots));

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp());
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.5));
			this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.5));
			this.goalSelector.addGoal(4, new OpenDoorGoal(this, true));
			this.goalSelector.addGoal(5, new ReturnToVillageGoal(this, 0.6, false));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, GhastEntity.class, true, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, GeckoEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, PillagerEntity.class, true, true));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, true));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, WitherEntity.class, true, true));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, true));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, true));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, PhantomEntity.class, true, true));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, WitherSkeletonEntity.class, true, true));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, WitchEntity.class, true, true));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, SlimeEntity.class, true, true));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, true));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, EnderDragonEntity.class, true, true));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, ZombifiedPiglinEntity.class, true, true));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, CreeperEntity.class, true, true));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, NightkinEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, GlowingoneEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, DeathclawEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.CustomEntity.class, true, true));

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
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BossteelplateItem.block));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.hit"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			EnemylaserweaponItem.shoot(this, target);
		}

	}

}
