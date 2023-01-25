
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.fallout_wastelands.entity.TurretFakeProjectileEntity;
import net.mcreator.fallout_wastelands.entity.TribalSpearEntity;
import net.mcreator.fallout_wastelands.entity.ThemachinegunEntity;
import net.mcreator.fallout_wastelands.entity.TenmmEntity;
import net.mcreator.fallout_wastelands.entity.TaloncompagnysoldierEntity;
import net.mcreator.fallout_wastelands.entity.TaloncompagnylieutenantEntity;
import net.mcreator.fallout_wastelands.entity.SpearEntity;
import net.mcreator.fallout_wastelands.entity.RobobrainrivetcanonEntity;
import net.mcreator.fallout_wastelands.entity.RealTurretProjectileEntity;
import net.mcreator.fallout_wastelands.entity.RangedsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.RaidergunnerEntity;
import net.mcreator.fallout_wastelands.entity.ProtectronEntity;
import net.mcreator.fallout_wastelands.entity.PowerArmorFrameEntity;
import net.mcreator.fallout_wastelands.entity.PlasmarifleEntity;
import net.mcreator.fallout_wastelands.entity.PaulothetraderEntity;
import net.mcreator.fallout_wastelands.entity.OverseerEntity;
import net.mcreator.fallout_wastelands.entity.NightkinEntity;
import net.mcreator.fallout_wastelands.entity.NailgunEntity;
import net.mcreator.fallout_wastelands.entity.MobmachinegunEntity;
import net.mcreator.fallout_wastelands.entity.MmpistolnineaimEntity;
import net.mcreator.fallout_wastelands.entity.MmpistolnineEntity;
import net.mcreator.fallout_wastelands.entity.MirelurkEntity;
import net.mcreator.fallout_wastelands.entity.Malewastelander4Entity;
import net.mcreator.fallout_wastelands.entity.Malewastelander3Entity;
import net.mcreator.fallout_wastelands.entity.Malewastelander2Entity;
import net.mcreator.fallout_wastelands.entity.Malewastelander1Entity;
import net.mcreator.fallout_wastelands.entity.Malevaultdweller2Entity;
import net.mcreator.fallout_wastelands.entity.Malevaultdweller1Entity;
import net.mcreator.fallout_wastelands.entity.MachinegunTurretEntity;
import net.mcreator.fallout_wastelands.entity.LaserriffleEntity;
import net.mcreator.fallout_wastelands.entity.HighwaymanEntity;
import net.mcreator.fallout_wastelands.entity.GlowingoneEntity;
import net.mcreator.fallout_wastelands.entity.GhoulEntity;
import net.mcreator.fallout_wastelands.entity.GeckoEntity;
import net.mcreator.fallout_wastelands.entity.FriendlybrainbotEntity;
import net.mcreator.fallout_wastelands.entity.FrbcannonEntity;
import net.mcreator.fallout_wastelands.entity.Femalevaultdweller2Entity;
import net.mcreator.fallout_wastelands.entity.Femalevaultdweller1Entity;
import net.mcreator.fallout_wastelands.entity.EnemylaserweaponEntity;
import net.mcreator.fallout_wastelands.entity.EnclavepowerarmorsoldierEntity;
import net.mcreator.fallout_wastelands.entity.ENCLAVEofficierEntity;
import net.mcreator.fallout_wastelands.entity.DeathclawEntity;
import net.mcreator.fallout_wastelands.entity.ClosecombatsupermutantEntity;
import net.mcreator.fallout_wastelands.entity.ChromeraiderEntity;
import net.mcreator.fallout_wastelands.entity.ChromedraiderfemaleEntity;
import net.mcreator.fallout_wastelands.entity.CaravanguardEntity;
import net.mcreator.fallout_wastelands.entity.BrotherhoodPaladinEntity;
import net.mcreator.fallout_wastelands.entity.BrokenFrameEntity;
import net.mcreator.fallout_wastelands.entity.BrahminEntity;
import net.mcreator.fallout_wastelands.entity.BloatflyshotEntity;
import net.mcreator.fallout_wastelands.entity.BloatflyEntity;
import net.mcreator.fallout_wastelands.entity.BasesupermutantEntity;
import net.mcreator.fallout_wastelands.entity.ArmyrobobrainEntity;
import net.mcreator.fallout_wastelands.entity.AkEntity;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FalloutWastelandsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FalloutWastelandsMod.MODID);
	public static final RegistryObject<EntityType<ChromeraiderEntity>> CHROMERAIDER = register("chromeraider",
			EntityType.Builder.<ChromeraiderEntity>of(ChromeraiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(ChromeraiderEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ChromedraiderfemaleEntity>> CHROMEDRAIDERFEMALE = register("chromedraiderfemale",
			EntityType.Builder.<ChromedraiderfemaleEntity>of(ChromedraiderfemaleEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3)
					.setCustomClientFactory(ChromedraiderfemaleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ThemachinegunEntity>> THEMACHINEGUN = register("projectile_themachinegun",
			EntityType.Builder.<ThemachinegunEntity>of(ThemachinegunEntity::new, MobCategory.MISC).setCustomClientFactory(ThemachinegunEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LaserriffleEntity>> LASERRIFFLE = register("projectile_laserriffle",
			EntityType.Builder.<LaserriffleEntity>of(LaserriffleEntity::new, MobCategory.MISC).setCustomClientFactory(LaserriffleEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MobmachinegunEntity>> MOBMACHINEGUN = register("projectile_mobmachinegun",
			EntityType.Builder.<MobmachinegunEntity>of(MobmachinegunEntity::new, MobCategory.MISC).setCustomClientFactory(MobmachinegunEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AkEntity>> AK = register("projectile_ak",
			EntityType.Builder.<AkEntity>of(AkEntity::new, MobCategory.MISC).setCustomClientFactory(AkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MirelurkEntity>> MIRELURK = register("mirelurk",
			EntityType.Builder.<MirelurkEntity>of(MirelurkEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MirelurkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GhoulEntity>> GHOUL = register("ghoul",
			EntityType.Builder.<GhoulEntity>of(GhoulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GhoulEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArmyrobobrainEntity>> ARMYROBOBRAIN = register("armyrobobrain",
			EntityType.Builder.<ArmyrobobrainEntity>of(ArmyrobobrainEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(ArmyrobobrainEntity::new).fireImmune().sized(3f, 3f));
	public static final RegistryObject<EntityType<RobobrainrivetcanonEntity>> ROBOBRAINRIVETCANON = register("projectile_robobrainrivetcanon",
			EntityType.Builder.<RobobrainrivetcanonEntity>of(RobobrainrivetcanonEntity::new, MobCategory.MISC)
					.setCustomClientFactory(RobobrainrivetcanonEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ClosecombatsupermutantEntity>> CLOSECOMBATSUPERMUTANT = register("closecombatsupermutant",
			EntityType.Builder.<ClosecombatsupermutantEntity>of(ClosecombatsupermutantEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(200).setUpdateInterval(3)
					.setCustomClientFactory(ClosecombatsupermutantEntity::new)

					.sized(0.7999999999999999f, 2.8000000000000003f));
	public static final RegistryObject<EntityType<BasesupermutantEntity>> BASESUPERMUTANT = register("basesupermutant",
			EntityType.Builder.<BasesupermutantEntity>of(BasesupermutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(264).setUpdateInterval(3).setCustomClientFactory(BasesupermutantEntity::new)

					.sized(0.8f, 2.8000000000000003f));
	public static final RegistryObject<EntityType<RangedsupermutantEntity>> RANGEDSUPERMUTANT = register("rangedsupermutant",
			EntityType.Builder.<RangedsupermutantEntity>of(RangedsupermutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(264).setUpdateInterval(3).setCustomClientFactory(RangedsupermutantEntity::new)

					.sized(0.7999999999999999f, 2.8000000000000003f));
	public static final RegistryObject<EntityType<FriendlybrainbotEntity>> FRIENDLYBRAINBOT = register("friendlybrainbot",
			EntityType.Builder.<FriendlybrainbotEntity>of(FriendlybrainbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(164).setUpdateInterval(3).setCustomClientFactory(FriendlybrainbotEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<FrbcannonEntity>> FRBCANNON = register("projectile_frbcannon",
			EntityType.Builder.<FrbcannonEntity>of(FrbcannonEntity::new, MobCategory.MISC).setCustomClientFactory(FrbcannonEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloatflyshotEntity>> BLOATFLYSHOT = register("projectile_bloatflyshot",
			EntityType.Builder.<BloatflyshotEntity>of(BloatflyshotEntity::new, MobCategory.MISC).setCustomClientFactory(BloatflyshotEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloatflyEntity>> BLOATFLY = register("bloatfly",
			EntityType.Builder.<BloatflyEntity>of(BloatflyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(30)
					.setUpdateInterval(3).setCustomClientFactory(BloatflyEntity::new)

					.sized(0.5f, 0.8f));
	public static final RegistryObject<EntityType<NailgunEntity>> NAILGUN = register("projectile_nailgun",
			EntityType.Builder.<NailgunEntity>of(NailgunEntity::new, MobCategory.MISC).setCustomClientFactory(NailgunEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RaidergunnerEntity>> RAIDERGUNNER = register("raidergunner",
			EntityType.Builder.<RaidergunnerEntity>of(RaidergunnerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(RaidergunnerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HighwaymanEntity>> HIGHWAYMAN = register("highwayman",
			EntityType.Builder.<HighwaymanEntity>of(HighwaymanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(HighwaymanEntity::new)

					.sized(3.9999999999999996f, 3f));
	public static final RegistryObject<EntityType<TenmmEntity>> TENMM = register("projectile_tenmm",
			EntityType.Builder.<TenmmEntity>of(TenmmEntity::new, MobCategory.MISC).setCustomClientFactory(TenmmEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PlasmarifleEntity>> PLASMARIFLE = register("projectile_plasmarifle",
			EntityType.Builder.<PlasmarifleEntity>of(PlasmarifleEntity::new, MobCategory.MISC).setCustomClientFactory(PlasmarifleEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EnclavepowerarmorsoldierEntity>> ENCLAVEPOWERARMORSOLDIER = register("enclavepowerarmorsoldier",
			EntityType.Builder.<EnclavepowerarmorsoldierEntity>of(EnclavepowerarmorsoldierEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(EnclavepowerarmorsoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ENCLAVEofficierEntity>> ENCLAV_EOFFICIER = register("enclav_eofficier",
			EntityType.Builder.<ENCLAVEofficierEntity>of(ENCLAVEofficierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ENCLAVEofficierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malevaultdweller1Entity>> MALEVAULTDWELLER_1 = register("malevaultdweller_1",
			EntityType.Builder.<Malevaultdweller1Entity>of(Malevaultdweller1Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malevaultdweller1Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malevaultdweller2Entity>> MALEVAULTDWELLER_2 = register("malevaultdweller_2",
			EntityType.Builder.<Malevaultdweller2Entity>of(Malevaultdweller2Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malevaultdweller2Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Femalevaultdweller1Entity>> FEMALEVAULTDWELLER_1 = register("femalevaultdweller_1",
			EntityType.Builder.<Femalevaultdweller1Entity>of(Femalevaultdweller1Entity::new, MobCategory.CREATURE)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(Femalevaultdweller1Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Femalevaultdweller2Entity>> FEMALEVAULTDWELLER_2 = register("femalevaultdweller_2",
			EntityType.Builder.<Femalevaultdweller2Entity>of(Femalevaultdweller2Entity::new, MobCategory.CREATURE)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(Femalevaultdweller2Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malewastelander1Entity>> MALEWASTELANDER_1 = register("malewastelander_1",
			EntityType.Builder.<Malewastelander1Entity>of(Malewastelander1Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malewastelander1Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malewastelander2Entity>> MALEWASTELANDER_2 = register("malewastelander_2",
			EntityType.Builder.<Malewastelander2Entity>of(Malewastelander2Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malewastelander2Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malewastelander3Entity>> MALEWASTELANDER_3 = register("malewastelander_3",
			EntityType.Builder.<Malewastelander3Entity>of(Malewastelander3Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malewastelander3Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Malewastelander4Entity>> MALEWASTELANDER_4 = register("malewastelander_4",
			EntityType.Builder.<Malewastelander4Entity>of(Malewastelander4Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Malewastelander4Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OverseerEntity>> OVERSEER = register("overseer",
			EntityType.Builder.<OverseerEntity>of(OverseerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OverseerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MmpistolnineEntity>> MMPISTOLNINE = register("projectile_mmpistolnine",
			EntityType.Builder.<MmpistolnineEntity>of(MmpistolnineEntity::new, MobCategory.MISC).setCustomClientFactory(MmpistolnineEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MmpistolnineaimEntity>> MMPISTOLNINEAIM = register("projectile_mmpistolnineaim",
			EntityType.Builder.<MmpistolnineaimEntity>of(MmpistolnineaimEntity::new, MobCategory.MISC)
					.setCustomClientFactory(MmpistolnineaimEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MachinegunTurretEntity>> MACHINEGUN_TURRET = register("machinegun_turret",
			EntityType.Builder.<MachinegunTurretEntity>of(MachinegunTurretEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MachinegunTurretEntity::new).fireImmune().sized(0.5f, 0.7f));
	public static final RegistryObject<EntityType<TurretFakeProjectileEntity>> TURRET_FAKE_PROJECTILE = register("projectile_turret_fake_projectile",
			EntityType.Builder.<TurretFakeProjectileEntity>of(TurretFakeProjectileEntity::new, MobCategory.MISC)
					.setCustomClientFactory(TurretFakeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RealTurretProjectileEntity>> REAL_TURRET_PROJECTILE = register("projectile_real_turret_projectile",
			EntityType.Builder.<RealTurretProjectileEntity>of(RealTurretProjectileEntity::new, MobCategory.MISC)
					.setCustomClientFactory(RealTurretProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PowerArmorFrameEntity>> POWER_ARMOR_FRAME = register("power_armor_frame",
			EntityType.Builder.<PowerArmorFrameEntity>of(PowerArmorFrameEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PowerArmorFrameEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BrokenFrameEntity>> BROKEN_FRAME = register("broken_frame",
			EntityType.Builder.<BrokenFrameEntity>of(BrokenFrameEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrokenFrameEntity::new).fireImmune().sized(0.7f, 0.4f));
	public static final RegistryObject<EntityType<GeckoEntity>> GECKO = register("gecko",
			EntityType.Builder.<GeckoEntity>of(GeckoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(80)
					.setUpdateInterval(3).setCustomClientFactory(GeckoEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GlowingoneEntity>> GLOWINGONE = register("glowingone",
			EntityType.Builder.<GlowingoneEntity>of(GlowingoneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GlowingoneEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DeathclawEntity>> DEATHCLAW = register("deathclaw",
			EntityType.Builder.<DeathclawEntity>of(DeathclawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(DeathclawEntity::new)

					.sized(2f, 3f));
	public static final RegistryObject<EntityType<ProtectronEntity>> PROTECTRON = register("protectron",
			EntityType.Builder.<ProtectronEntity>of(ProtectronEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ProtectronEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NightkinEntity>> NIGHTKIN = register("nightkin",
			EntityType.Builder.<NightkinEntity>of(NightkinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(200).setUpdateInterval(3).setCustomClientFactory(NightkinEntity::new)

					.sized(1f, 2.8000000000000003f));
	public static final RegistryObject<EntityType<EnemylaserweaponEntity>> ENEMYLASERWEAPON = register("projectile_enemylaserweapon",
			EntityType.Builder.<EnemylaserweaponEntity>of(EnemylaserweaponEntity::new, MobCategory.MISC)
					.setCustomClientFactory(EnemylaserweaponEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CaravanguardEntity>> CARAVANGUARD = register("caravanguard",
			EntityType.Builder.<CaravanguardEntity>of(CaravanguardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CaravanguardEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PaulothetraderEntity>> PAULOTHETRADER = register("paulothetrader",
			EntityType.Builder.<PaulothetraderEntity>of(PaulothetraderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PaulothetraderEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BrotherhoodPaladinEntity>> BROTHERHOOD_PALADIN = register("brotherhood_paladin",
			EntityType.Builder.<BrotherhoodPaladinEntity>of(BrotherhoodPaladinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrotherhoodPaladinEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TaloncompagnysoldierEntity>> TALONCOMPAGNYSOLDIER = register("taloncompagnysoldier",
			EntityType.Builder.<TaloncompagnysoldierEntity>of(TaloncompagnysoldierEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TaloncompagnysoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TaloncompagnylieutenantEntity>> TALONCOMPAGNYLIEUTENANT = register("taloncompagnylieutenant",
			EntityType.Builder.<TaloncompagnylieutenantEntity>of(TaloncompagnylieutenantEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TaloncompagnylieutenantEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BrahminEntity>> BRAHMIN = register("brahmin",
			EntityType.Builder.<BrahminEntity>of(BrahminEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(BrahminEntity::new)

					.sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<SpearEntity>> SPEAR = register("projectile_spear",
			EntityType.Builder.<SpearEntity>of(SpearEntity::new, MobCategory.MISC).setCustomClientFactory(SpearEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TribalSpearEntity>> TRIBAL_SPEAR = register("projectile_tribal_spear",
			EntityType.Builder.<TribalSpearEntity>of(TribalSpearEntity::new, MobCategory.MISC).setCustomClientFactory(TribalSpearEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ChromeraiderEntity.init();
			ChromedraiderfemaleEntity.init();
			MirelurkEntity.init();
			GhoulEntity.init();
			ArmyrobobrainEntity.init();
			ClosecombatsupermutantEntity.init();
			BasesupermutantEntity.init();
			RangedsupermutantEntity.init();
			FriendlybrainbotEntity.init();
			BloatflyEntity.init();
			RaidergunnerEntity.init();
			HighwaymanEntity.init();
			EnclavepowerarmorsoldierEntity.init();
			ENCLAVEofficierEntity.init();
			Malevaultdweller1Entity.init();
			Malevaultdweller2Entity.init();
			Femalevaultdweller1Entity.init();
			Femalevaultdweller2Entity.init();
			Malewastelander1Entity.init();
			Malewastelander2Entity.init();
			Malewastelander3Entity.init();
			Malewastelander4Entity.init();
			OverseerEntity.init();
			MachinegunTurretEntity.init();
			PowerArmorFrameEntity.init();
			BrokenFrameEntity.init();
			GeckoEntity.init();
			GlowingoneEntity.init();
			DeathclawEntity.init();
			ProtectronEntity.init();
			NightkinEntity.init();
			CaravanguardEntity.init();
			PaulothetraderEntity.init();
			BrotherhoodPaladinEntity.init();
			TaloncompagnysoldierEntity.init();
			TaloncompagnylieutenantEntity.init();
			BrahminEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CHROMERAIDER.get(), ChromeraiderEntity.createAttributes().build());
		event.put(CHROMEDRAIDERFEMALE.get(), ChromedraiderfemaleEntity.createAttributes().build());
		event.put(MIRELURK.get(), MirelurkEntity.createAttributes().build());
		event.put(GHOUL.get(), GhoulEntity.createAttributes().build());
		event.put(ARMYROBOBRAIN.get(), ArmyrobobrainEntity.createAttributes().build());
		event.put(CLOSECOMBATSUPERMUTANT.get(), ClosecombatsupermutantEntity.createAttributes().build());
		event.put(BASESUPERMUTANT.get(), BasesupermutantEntity.createAttributes().build());
		event.put(RANGEDSUPERMUTANT.get(), RangedsupermutantEntity.createAttributes().build());
		event.put(FRIENDLYBRAINBOT.get(), FriendlybrainbotEntity.createAttributes().build());
		event.put(BLOATFLY.get(), BloatflyEntity.createAttributes().build());
		event.put(RAIDERGUNNER.get(), RaidergunnerEntity.createAttributes().build());
		event.put(HIGHWAYMAN.get(), HighwaymanEntity.createAttributes().build());
		event.put(ENCLAVEPOWERARMORSOLDIER.get(), EnclavepowerarmorsoldierEntity.createAttributes().build());
		event.put(ENCLAV_EOFFICIER.get(), ENCLAVEofficierEntity.createAttributes().build());
		event.put(MALEVAULTDWELLER_1.get(), Malevaultdweller1Entity.createAttributes().build());
		event.put(MALEVAULTDWELLER_2.get(), Malevaultdweller2Entity.createAttributes().build());
		event.put(FEMALEVAULTDWELLER_1.get(), Femalevaultdweller1Entity.createAttributes().build());
		event.put(FEMALEVAULTDWELLER_2.get(), Femalevaultdweller2Entity.createAttributes().build());
		event.put(MALEWASTELANDER_1.get(), Malewastelander1Entity.createAttributes().build());
		event.put(MALEWASTELANDER_2.get(), Malewastelander2Entity.createAttributes().build());
		event.put(MALEWASTELANDER_3.get(), Malewastelander3Entity.createAttributes().build());
		event.put(MALEWASTELANDER_4.get(), Malewastelander4Entity.createAttributes().build());
		event.put(OVERSEER.get(), OverseerEntity.createAttributes().build());
		event.put(MACHINEGUN_TURRET.get(), MachinegunTurretEntity.createAttributes().build());
		event.put(POWER_ARMOR_FRAME.get(), PowerArmorFrameEntity.createAttributes().build());
		event.put(BROKEN_FRAME.get(), BrokenFrameEntity.createAttributes().build());
		event.put(GECKO.get(), GeckoEntity.createAttributes().build());
		event.put(GLOWINGONE.get(), GlowingoneEntity.createAttributes().build());
		event.put(DEATHCLAW.get(), DeathclawEntity.createAttributes().build());
		event.put(PROTECTRON.get(), ProtectronEntity.createAttributes().build());
		event.put(NIGHTKIN.get(), NightkinEntity.createAttributes().build());
		event.put(CARAVANGUARD.get(), CaravanguardEntity.createAttributes().build());
		event.put(PAULOTHETRADER.get(), PaulothetraderEntity.createAttributes().build());
		event.put(BROTHERHOOD_PALADIN.get(), BrotherhoodPaladinEntity.createAttributes().build());
		event.put(TALONCOMPAGNYSOLDIER.get(), TaloncompagnysoldierEntity.createAttributes().build());
		event.put(TALONCOMPAGNYLIEUTENANT.get(), TaloncompagnylieutenantEntity.createAttributes().build());
		event.put(BRAHMIN.get(), BrahminEntity.createAttributes().build());
	}
}
