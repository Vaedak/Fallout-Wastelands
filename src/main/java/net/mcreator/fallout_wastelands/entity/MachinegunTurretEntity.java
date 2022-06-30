
package net.mcreator.fallout_wastelands.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@FalloutWastelandsModElements.ModElement.Tag
public class MachinegunTurretEntity extends FalloutWastelandsModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(0.5f, 1.2000000000000002f)).build("machinegun_turret").setRegistryName("machinegun_turret");

	public MachinegunTurretEntity(FalloutWastelandsModElements instance) {
		super(instance, 1410);

		FMLJavaModLoadingContext.get().getModEventBus().register(new MachinegunTurretRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -10066330, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("machinegun_turret_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 4);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);

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
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp());
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, MobEntity.class, true, false));
			this.goalSelector.addGoal(4, new LookAtGoal(this, LivingEntity.class, (float) 10));

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

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			AkItem.shoot(this, target);
		}

	}

}
