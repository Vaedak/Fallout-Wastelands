
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

import java.util.List;

public class FriendlybrainbotEntity extends TamableAnimal implements RangedAttackMob {
	public FriendlybrainbotEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FalloutWastelandsModEntities.FRIENDLYBRAINBOT.get(), world);
	}

	public FriendlybrainbotEntity(EntityType<FriendlybrainbotEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 0.3, (float) 10, (float) 2, false));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.4));
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.class, true, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, MirelurkEntity.class, true, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, GhoulEntity.class, true, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ArmyrobobrainEntity.class, true, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, EnderDragon.class, true, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Zombie.class, true, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Witch.class, true, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, Vindicator.class, true, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.class, true, false));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, BasesupermutantEntity.class, true, false));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.class, true, false));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Blaze.class, true, false));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, CaveSpider.class, true, false));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, Drowned.class, true, false));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, ChromeraiderEntity.class, true, false));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, LargeFireball.class, true, false));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Giant.class, true, false));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, Guardian.class, true, false));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, Illusioner.class, true, false));
		this.targetSelector.addGoal(29, new NearestAttackableTargetGoal(this, Pillager.class, true, false));
		this.targetSelector.addGoal(30, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, true, false));
		this.targetSelector.addGoal(31, new NearestAttackableTargetGoal(this, Shulker.class, true, false));
		this.targetSelector.addGoal(32, new NearestAttackableTargetGoal(this, Skeleton.class, true, false));
		this.targetSelector.addGoal(33, new NearestAttackableTargetGoal(this, Spider.class, true, false));
		this.targetSelector.addGoal(34, new NearestAttackableTargetGoal(this, Slime.class, true, false));
		this.targetSelector.addGoal(35, new NearestAttackableTargetGoal(this, Vex.class, true, false));
		this.targetSelector.addGoal(36, new NearestAttackableTargetGoal(this, Vindicator.class, true, false));
		this.targetSelector.addGoal(37, new NearestAttackableTargetGoal(this, Witch.class, true, false));
		this.targetSelector.addGoal(38, new NearestAttackableTargetGoal(this, WitherBoss.class, true, false));
		this.targetSelector.addGoal(39, new NearestAttackableTargetGoal(this, WitherSkeleton.class, true, false));
		this.targetSelector.addGoal(40, new NearestAttackableTargetGoal(this, WitherSkull.class, true, false));
		this.targetSelector.addGoal(41, new NearestAttackableTargetGoal(this, Zombie.class, true, false));
		this.targetSelector.addGoal(42, new NearestAttackableTargetGoal(this, Phantom.class, true, false));
		this.targetSelector.addGoal(43, new NearestAttackableTargetGoal(this, Ravager.class, true, false));
		this.targetSelector.addGoal(44, new NearestAttackableTargetGoal(this, Monster.class, true, false));
		this.targetSelector.addGoal(45, new NearestAttackableTargetGoal(this, ZombieVillager.class, true, false));
		this.targetSelector.addGoal(46, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.class, true, false));
		this.targetSelector.addGoal(47, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.class, true, false));
		this.targetSelector.addGoal(48, new NearestAttackableTargetGoal(this, BrotherhoodPaladinEntity.class, true, false));
		this.targetSelector.addGoal(49, new NearestAttackableTargetGoal(this, TaloncompagnysoldierEntity.class, true, false));
		this.targetSelector.addGoal(50, new NearestAttackableTargetGoal(this, TaloncompagnylieutenantEntity.class, true, false));
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

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:robobrainliving"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:robobraintracks")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.dragon_fireball.explode"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level.isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
					? InteractionResult.sidedSuccess(this.level.isClientSide())
					: InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level.isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level.isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level.broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level.broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level.isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		return retval;
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		FrbcannonEntity.shoot(this, target);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		FriendlybrainbotEntity retval = FalloutWastelandsModEntities.FRIENDLYBRAINBOT.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(FalloutWastelandsModItems.MILITARYGRADEACCESSBADGE.get()).contains(stack.getItem());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 50);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100);
		return builder;
	}
}
