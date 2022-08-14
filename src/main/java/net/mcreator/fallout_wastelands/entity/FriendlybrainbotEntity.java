
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.GiantEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.item.MilitarygradeaccessbadgeItem;
import net.mcreator.fallout_wastelands.item.FrbcannonItem;
import net.mcreator.fallout_wastelands.entity.renderer.FriendlybrainbotRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class FriendlybrainbotEntity extends FalloutWastelandsModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(164).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(3f, 3f))
			.build("friendlybrainbot").setRegistryName("friendlybrainbot");

	public FriendlybrainbotEntity(FalloutWastelandsModElements instance) {
		super(instance, 245);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FriendlybrainbotRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -10066330, -13421773, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("friendlybrainbot_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 200);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 50);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 100);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends TameableEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
			this.goalSelector.addGoal(2, new OwnerHurtTargetGoal(this));
			this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 0.3, (float) 10, (float) 2, false));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.4));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setCallsForHelp());
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, EnderDragonEntity.class, true, false));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, false));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, WitchEntity.class, true, false));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, VindicatorEntity.class, true, false));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, BlazeEntity.class, true, false));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, CaveSpiderEntity.class, true, false));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, DrownedEntity.class, true, false));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, FireballEntity.class, true, false));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, GiantEntity.class, true, false));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, GuardianEntity.class, true, false));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, IllusionerEntity.class, true, false));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, PillagerEntity.class, true, false));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, ZombifiedPiglinEntity.class, true, false));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, ShulkerEntity.class, true, false));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, false));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, false));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, SlimeEntity.class, true, false));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, VexEntity.class, true, false));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, VindicatorEntity.class, true, false));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, WitchEntity.class, true, false));
			this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, WitherEntity.class, true, false));
			this.targetSelector.addGoal(39, new NearestAttackableTargetGoal(this, WitherSkeletonEntity.class, true, false));
			this.targetSelector.addGoal(40, new NearestAttackableTargetGoal(this, WitherSkullEntity.class, true, false));
			this.targetSelector.addGoal(41, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, false));
			this.targetSelector.addGoal(42, new NearestAttackableTargetGoal(this, PhantomEntity.class, true, false));
			this.targetSelector.addGoal(43, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, false));
			this.targetSelector.addGoal(44, new NearestAttackableTargetGoal(this, MonsterEntity.class, true, false));
			this.targetSelector.addGoal(45, new NearestAttackableTargetGoal(this, ZombieVillagerEntity.class, true, false));
			this.targetSelector.addGoal(46, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, true, false));
			this.targetSelector.addGoal(47, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, true, false));
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

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:robobrainliving"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound(
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:robobraintracks")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.func_230254_b_(sourceentity, hand);
			} else if (this.world.isRemote()) {
				retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
						? ActionResultType.func_233537_a_(this.world.isRemote())
						: ActionResultType.PASS;
			} else {
				if (this.isTamed()) {
					if (this.isOwner(sourceentity)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal((float) item.getFood().getHealing());
							retval = ActionResultType.func_233537_a_(this.world.isRemote());
						} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal(4);
							retval = ActionResultType.func_233537_a_(this.world.isRemote());
						} else {
							retval = super.func_230254_b_(sourceentity, hand);
						}
					}
				} else if (this.isBreedingItem(itemstack)) {
					this.consumeItemFromStack(sourceentity, itemstack);
					if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.setTamedBy(sourceentity);
						this.world.setEntityState(this, (byte) 7);
					} else {
						this.world.setEntityState(this, (byte) 6);
					}
					this.enablePersistence();
					retval = ActionResultType.func_233537_a_(this.world.isRemote());
				} else {
					retval = super.func_230254_b_(sourceentity, hand);
					if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
						this.enablePersistence();
				}
			}
			return retval;
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			FrbcannonItem.shoot(this, target);
		}

		@Override
		public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(serverWorld);
			retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (MilitarygradeaccessbadgeItem.block == stack.getItem())
				return true;
			return false;
		}
	}
}
