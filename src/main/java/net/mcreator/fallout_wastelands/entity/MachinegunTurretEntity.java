
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

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

import net.mcreator.fallout_wastelands.procedures.MachinegunTurretOnEntityTickUpdatenewProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

public class MachinegunTurretEntity extends Monster implements RangedAttackMob {
	public MachinegunTurretEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.MACHINEGUN_TURRET.get(), world);
	}

	public MachinegunTurretEntity(EntityType<MachinegunTurretEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
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

	@Override
	public void baseTick() {
		super.baseTick();
		MachinegunTurretOnEntityTickUpdatenewProcedure.execute(this);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		TurretFakeProjectileEntity.shoot(this, target);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		return builder;
	}
}
