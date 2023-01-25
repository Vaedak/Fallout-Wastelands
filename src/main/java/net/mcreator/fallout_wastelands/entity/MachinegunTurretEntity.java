
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

<<<<<<< HEAD
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
=======
import net.minecraft.world.World;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.BatEntity;
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
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AreaEffectCloudEntity;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

import net.mcreator.fallout_wastelands.procedures.MachinegunTurretOnInitialEntitySpawnProcedure;
import net.mcreator.fallout_wastelands.procedures.MachinegunTurretOnEntityTickUpdatenewProcedure;
<<<<<<< HEAD
<<<<<<< HEAD
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;
=======
=======
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
import net.mcreator.fallout_wastelands.item.RealTurretProjectileItem;
import net.mcreator.fallout_wastelands.entity.renderer.MachinegunTurretRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

<<<<<<< HEAD
public class MachinegunTurretEntity extends Monster implements RangedAttackMob {
	public MachinegunTurretEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.MACHINEGUN_TURRET.get(), world);
	}
=======
import javax.annotation.Nullable;

import javax.annotation.Nullable;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

<<<<<<< HEAD
	public MachinegunTurretEntity(EntityType<MachinegunTurretEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
=======
@FalloutWastelandsModElements.ModElement.Tag
public class MachinegunTurretEntity extends FalloutWastelandsModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(0.5f, 0.7f)).build("machinegun_turret").setRegistryName("machinegun_turret");

	public MachinegunTurretEntity(FalloutWastelandsModElements instance) {
		super(instance, 1410);
		FMLJavaModLoadingContext.get().getModEventBus().register(new MachinegunTurretRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, EnderDragon.class, true, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.class, true, true));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, MirelurkEntity.class, true, true));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, GhoulEntity.class, true, true));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, true, true));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.class, true, true));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, BasesupermutantEntity.class, true, true));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.class, true, true));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.class, true, true));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, BloatflyEntity.class, true, true));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, RaidergunnerEntity.class, true, true));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, HighwaymanEntity.class, true, true));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Bat.class, true, true));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, Ghast.class, true, true));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, IronGolem.class, true, true));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Pillager.class, true, true));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Spider.class, true, true));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Villager.class, true, true));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, WitherBoss.class, true, true));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Wolf.class, true, true));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Zombie.class, true, true));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Ravager.class, true, true));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Phantom.class, true, true));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true, true));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Witch.class, true, true));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, SnowGolem.class, true, true));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, Slime.class, true, true));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Skeleton.class, true, true));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, EnderDragon.class, true, true));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, true, true));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, Player.class, true, true));
		this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, Creeper.class, true, true));
		this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, true, true));
		this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, true));
		this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, true));
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
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		return super.hurt(source, amount);
	}

<<<<<<< HEAD
	@Override
	public void baseTick() {
		super.baseTick();
		MachinegunTurretOnEntityTickUpdatenewProcedure.execute(this);
	}
=======
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
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, HighwaymanEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, BatEntity.class, true, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, GhastEntity.class, true, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, IronGolemEntity.class, true, true));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, PillagerEntity.class, true, true));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, true));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, VillagerEntity.class, true, true));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, WitherEntity.class, true, true));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, WolfEntity.class, true, true));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, ZombieEntity.class, true, true));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, true));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, PhantomEntity.class, true, true));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, WitherSkeletonEntity.class, true, true));
			this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, WitchEntity.class, true, true));
			this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, SnowGolemEntity.class, true, true));
			this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, SlimeEntity.class, true, true));
			this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, SkeletonEntity.class, true, true));
			this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, EnderDragonEntity.class, true, true));
			this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, ZombifiedPiglinEntity.class, true, true));
			this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, CreeperEntity.class, true, true));
			this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.CustomEntity.class, true, true));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 5, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		TurretFakeProjectileEntity.shoot(this, target);
	}

	public static void init() {
	}

<<<<<<< HEAD
	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		return builder;
=======
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
		public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
				@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;

			MachinegunTurretOnInitialEntitySpawnProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
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
			RealTurretProjectileItem.shoot(this, target);
		}
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
	}
}
