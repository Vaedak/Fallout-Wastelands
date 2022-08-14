
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class CaravanguardEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("caravanguard").setRegistryName("caravanguard");

	public CaravanguardEntity(FalloutWastelandsModElements instance) {
		super(instance, 1492);

		FMLJavaModLoadingContext.get().getModEventBus().register(new CaravanguardRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -10066432, -4805739, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("caravanguard_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 20);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
			experienceValue = 2;
			setNoAI(false);

			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ThemachinegunItem.block));
			this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(CombatarmorItem.helmet));
			this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(CombatarmorItem.body));
			this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(CombatarmorItem.legs));
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(CombatarmorItem.boots));

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.6));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp());
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
			this.goalSelector.addGoal(5, new ReturnToVillageGoal(this, 0.6, false));
			this.goalSelector.addGoal(6, new OpenDoorGoal(this, true));
			this.goalSelector.addGoal(7, new OpenDoorGoal(this, false));
			this.targetSelector.addGoal(8, new HurtByTargetGoal(this).setCallsForHelp());
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, DeathclawEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, GlowingoneEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, ProtectronEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, NightkinEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, GeckoEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(29, new LookAtGoal(this, Malewastelander1Entity.CustomEntity.class, (float) 40));
			this.goalSelector.addGoal(30, new LookAtGoal(this, Malewastelander2Entity.CustomEntity.class, (float) 40));

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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.death"));
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			MobmachinegunItem.shoot(this, target);
		}

	}

}
