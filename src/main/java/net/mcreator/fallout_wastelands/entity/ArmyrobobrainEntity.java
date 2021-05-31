
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
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
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.fallout_wastelands.item.RobobrainrivetcanonItem;
import net.mcreator.fallout_wastelands.entity.renderer.ArmyrobobrainRenderer;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class ArmyrobobrainEntity extends FalloutWastelandsModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(3f, 3f)).build("armyrobobrain").setRegistryName("armyrobobrain");
	public ArmyrobobrainEntity(FalloutWastelandsModElements instance) {
		super(instance, 214);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ArmyrobobrainRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -12958699, -12433606, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("armyrobobrain_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 100);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 30);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 6);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 100);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 9;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.2));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ChromeraiderEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ChromedraiderfemaleEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, MirelurkEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, GhoulEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, ElderGuardianEntity.class, true, true));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, GhastEntity.class, true, true));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, IronGolemEntity.class, true, true));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, HorseEntity.class, true, true));
			this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, GuardianEntity.class, true, true));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, LlamaEntity.class, true, true));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, VillagerEntity.class, true, true));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, RavagerEntity.class, true, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, PhantomEntity.class, true, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, PillagerEntity.class, true, true));
			this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, SpiderEntity.class, true, true));
			this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, WitherEntity.class, true, true));
			this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, ClosecombatsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, BasesupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, RangedsupermutantEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, BloatflyEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, EnclavepowerarmorsoldierEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, ENCLAVEofficierEntity.CustomEntity.class, true, true));
			this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, RaidergunnerEntity.CustomEntity.class, true, true));
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

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Blocks.IRON_BLOCK, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:rblfix"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:rbwfix")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.fall"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			RobobrainrivetcanonItem.shoot(this, target);
		}
	}
}
