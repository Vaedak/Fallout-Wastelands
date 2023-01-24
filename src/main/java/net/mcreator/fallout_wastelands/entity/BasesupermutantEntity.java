
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.procedures.ChromeraiderOnInitialEntitySpawnProcedure;
import net.mcreator.fallout_wastelands.procedures.BasesupermutantOnEntityTickUpdateProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

import javax.annotation.Nullable;

public class BasesupermutantEntity extends Monster {
	public BasesupermutantEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.BASESUPERMUTANT.get(), world);
	}

	public BasesupermutantEntity(EntityType<BasesupermutantEntity> type, Level world) {
		super(type, world);
		xpReward = 2;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.7, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.4));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.class, true, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, MirelurkEntity.class, true, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, GhoulEntity.class, true, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, true, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, Villager.class, true, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, Zombie.class, true, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, Witch.class, true, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, Vindicator.class, true, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, RaidergunnerEntity.class, true, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.class, true, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.class, true, false));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, BloatflyEntity.class, true, false));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, ProtectronEntity.class, true, false));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, GlowingoneEntity.class, true, false));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, MachinegunTurretEntity.class, true, false));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.class, true, false));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, true, false));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, false));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, false));
		this.goalSelector.addGoal(27, new BreakDoorGoal(this, e -> true));
		this.goalSelector.addGoal(28, new MoveBackToVillageGoal(this, 0.6, false));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(FalloutWastelandsModItems.SEPTAMMO.get()));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:supermutanthurt"));
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason,
			@Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ChromeraiderOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		BasesupermutantOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0.2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
