
package net.mcreator.fallout_wastelands.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.fallout_wastelands.procedures.PlasmarifleWhileBulletFlyingTickProcedure;
import net.mcreator.fallout_wastelands.procedures.LaserriffleProjectileHitsBlockProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PlasmarifleEntity extends AbstractArrow implements ItemSupplier {
	public PlasmarifleEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(FalloutWastelandsModEntities.PLASMARIFLE.get(), world);
	}

	public PlasmarifleEntity(EntityType<? extends PlasmarifleEntity> type, Level world) {
		super(type, world);
	}

	public PlasmarifleEntity(EntityType<? extends PlasmarifleEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public PlasmarifleEntity(EntityType<? extends PlasmarifleEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(FalloutWastelandsModItems.PLASMAS.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		LaserriffleProjectileHitsBlockProcedure.execute(this.level, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(),
				blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		PlasmarifleWhileBulletFlyingTickProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static PlasmarifleEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		PlasmarifleEntity entityarrow = new PlasmarifleEntity(FalloutWastelandsModEntities.PLASMARIFLE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:plasmarifle")), SoundSource.PLAYERS, 1,
				1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static PlasmarifleEntity shoot(LivingEntity entity, LivingEntity target) {
		PlasmarifleEntity entityarrow = new PlasmarifleEntity(FalloutWastelandsModEntities.PLASMARIFLE.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 4f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(1.7999999999999998);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("fallout_wastelands:plasmarifle")), SoundSource.PLAYERS, 1,
				1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
