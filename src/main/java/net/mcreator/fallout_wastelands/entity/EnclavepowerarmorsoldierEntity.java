
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.fallout_wastelands.procedures.ChromeraiderOnInitialEntitySpawnProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

import javax.annotation.Nullable;

public class EnclavepowerarmorsoldierEntity extends Monster implements RangedAttackMob {
	public EnclavepowerarmorsoldierEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.ENCLAVEPOWERARMORSOLDIER.get(), world);
	}

	public EnclavepowerarmorsoldierEntity(EntityType<EnclavepowerarmorsoldierEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FalloutWastelandsModItems.PLASMARIFLE.get()));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FalloutWastelandsModItems.ENCLAVE_X_01PA_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(FalloutWastelandsModItems.ENCLAVE_X_01PA_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(FalloutWastelandsModItems.ENCLAVE_X_01PA_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(FalloutWastelandsModItems.ENCLAVE_X_01PA_BOOTS.get()));
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
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.class, true, true));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, BloatflyEntity.class, true, true));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, RaidergunnerEntity.class, true, true));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, HighwaymanEntity.class, true, true));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Bat.class, true, true));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Ghast.class, true, true));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, IronGolem.class, true, true));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Pillager.class, true, true));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Spider.class, true, true));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Villager.class, true, true));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, WitherBoss.class, true, true));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Wolf.class, true, true));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Zombie.class, true, true));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Ravager.class, true, true));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, Phantom.class, true, true));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true, true));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Witch.class, true, true));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, SnowGolem.class, true, true));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, Slime.class, true, true));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, Skeleton.class, true, true));
		this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, EnderDragon.class, true, true));
		this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, true, true));
		this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, Player.class, true, true));
		this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, Creeper.class, true, true));
		this.targetSelector.addGoal(39, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, true, true));
		this.targetSelector.addGoal(40, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, true));
		this.targetSelector.addGoal(41, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, true));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.ILLAGER;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(FalloutWastelandsModItems.ENCLAVEPLATING.get()));
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason,
			@Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ChromeraiderOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		PlasmarifleEntity.shoot(this, target);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 40);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
