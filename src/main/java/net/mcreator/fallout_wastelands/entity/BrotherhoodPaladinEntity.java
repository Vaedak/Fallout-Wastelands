<<<<<<< HEAD
<<<<<<< HEAD

package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

public class BrotherhoodPaladinEntity extends PathfinderMob implements RangedAttackMob {
	public BrotherhoodPaladinEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.BROTHERHOOD_PALADIN.get(), world);
	}

	public BrotherhoodPaladinEntity(EntityType<BrotherhoodPaladinEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FalloutWastelandsModItems.ENEMYLASERWEAPON.get()));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FalloutWastelandsModItems.T_45POWERARMOR_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(FalloutWastelandsModItems.T_45POWERARMOR_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(FalloutWastelandsModItems.T_45POWERARMOR_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(FalloutWastelandsModItems.T_45POWERARMOR_BOOTS.get()));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.5));
		this.goalSelector.addGoal(4, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(5, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, true));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.class, true, true));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, MirelurkEntity.class, true, true));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, GhoulEntity.class, true, true));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, true, true));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.class, true, true));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, BasesupermutantEntity.class, true, true));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.class, true, true));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, BloatflyEntity.class, true, true));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, RaidergunnerEntity.class, true, true));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, Ghast.class, true, true));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, GeckoEntity.class, true, true));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Pillager.class, true, true));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Spider.class, true, true));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, WitherBoss.class, true, true));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Zombie.class, true, true));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Ravager.class, true, true));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Phantom.class, true, true));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true, true));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Witch.class, true, true));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Slime.class, true, true));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Skeleton.class, true, true));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, EnderDragon.class, true, true));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, true, true));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Creeper.class, true, true));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, NightkinEntity.class, true, true));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, GlowingoneEntity.class, true, true));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, DeathclawEntity.class, true, true));
		this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.class, true, true));
		this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.class, true, true));
		this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, true));
		this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, true));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(FalloutWastelandsModItems.BOSSTEELPLATE.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.hit"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		EnemylaserweaponEntity.shoot(this, target);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 35);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
=======

package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.ReturnToVillageGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AreaEffectCloudEntity;

import net.mcreator.fallout_wastelands.item.T45powerarmorItem;
import net.mcreator.fallout_wastelands.item.EnemylaserweaponItem;
import net.mcreator.fallout_wastelands.item.BossteelplateItem;
import net.mcreator.fallout_wastelands.entity.renderer.BrotherhoodPaladinRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

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
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
=======

package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.ReturnToVillageGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AreaEffectCloudEntity;

import net.mcreator.fallout_wastelands.item.T45powerarmorItem;
import net.mcreator.fallout_wastelands.item.EnemylaserweaponItem;
import net.mcreator.fallout_wastelands.item.BossteelplateItem;
import net.mcreator.fallout_wastelands.entity.renderer.BrotherhoodPaladinRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

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
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
