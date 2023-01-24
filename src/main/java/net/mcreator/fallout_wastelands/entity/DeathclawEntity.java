
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.fallout_wastelands.procedures.DeathclawblocbreakerProcedure;
import net.mcreator.fallout_wastelands.procedures.DeathclawThisEntityKillsAnotherOneProcedure;
import net.mcreator.fallout_wastelands.procedures.ChromeraiderOnInitialEntitySpawnProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

import javax.annotation.Nullable;

public class DeathclawEntity extends Monster {
	public DeathclawEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.DEATHCLAW.get(), world);
	}

	public DeathclawEntity(EntityType<DeathclawEntity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.7, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, BasesupermutantEntity.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, BloatflyEntity.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, false, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.class, false, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.class, false, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.class, false, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Femalevaultdweller1Entity.class, false, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Femalevaultdweller2Entity.class, false, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.class, false, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, GhoulEntity.class, false, false));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, MachinegunTurretEntity.class, false, false));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Malevaultdweller1Entity.class, false, false));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Malevaultdweller2Entity.class, false, false));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Malewastelander1Entity.class, false, false));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Malewastelander2Entity.class, false, false));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Malewastelander3Entity.class, false, false));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Malewastelander4Entity.class, false, false));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, MirelurkEntity.class, false, false));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, OverseerEntity.class, false, false));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, RaidergunnerEntity.class, false, false));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.class, false, false));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, Wolf.class, false, false));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, GhoulEntity.class, false, false));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, GlowingoneEntity.class, false, false));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, ProtectronEntity.class, false, false));
		this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, NightkinEntity.class, false, false));
		this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, false, false));
		this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, false, false));
		this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, false, false));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.LEATHER));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.FALL)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason,
			@Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ChromeraiderOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		DeathclawThisEntityKillsAnotherOneProcedure.execute(entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		DeathclawblocbreakerProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.7);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);
		return builder;
	}
}
