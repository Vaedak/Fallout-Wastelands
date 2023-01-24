
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.fallout_wastelands.procedures.RaidercarddropProcedure;
import net.mcreator.fallout_wastelands.procedures.ChromeraiderOnInitialEntitySpawnProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

import javax.annotation.Nullable;

public class RaidergunnerEntity extends Monster implements RangedAttackMob {
	public RaidergunnerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.RAIDERGUNNER.get(), world);
	}

	public RaidergunnerEntity(EntityType<RaidergunnerEntity> type, Level world) {
		super(type, world);
		xpReward = 6;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FalloutWastelandsModItems.THEMACHINEGUN.get()));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.3));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, BloatflyEntity.class, true, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, MirelurkEntity.class, true, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, GhoulEntity.class, true, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, true, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Villager.class, true, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, Zombie.class, true, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, Witch.class, true, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.class, true, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.class, true, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, FriendlybrainbotEntity.class, true, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.class, true, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.class, true, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, BasesupermutantEntity.class, true, false));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, DeathclawEntity.class, true, false));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, GeckoEntity.class, true, false));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, GlowingoneEntity.class, true, false));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, OverseerEntity.class, true, false));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, NightkinEntity.class, true, false));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, Malevaultdweller1Entity.class, true, false));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Malevaultdweller2Entity.class, true, false));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Malewastelander3Entity.class, true, false));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Malewastelander4Entity.class, true, false));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Femalevaultdweller1Entity.class, true, false));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, Femalevaultdweller2Entity.class, true, false));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, ProtectronEntity.class, true, false));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, OverseerEntity.class, true, false));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, false));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, false));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, true, false));
		this.goalSelector.addGoal(35, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(36, new MoveBackToVillageGoal(this, 0.6, false));
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

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(FalloutWastelandsModItems.CANNEDPORKSHOP.get()));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vindicator.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vindicator.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		RaidercarddropProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
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
		MobmachinegunEntity.shoot(this, target);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
