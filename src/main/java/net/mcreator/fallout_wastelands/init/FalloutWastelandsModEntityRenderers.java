
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.fallout_wastelands.client.renderer.TaloncompagnysoldierRenderer;
import net.mcreator.fallout_wastelands.client.renderer.TaloncompagnylieutenantRenderer;
import net.mcreator.fallout_wastelands.client.renderer.RangedsupermutantRenderer;
import net.mcreator.fallout_wastelands.client.renderer.RaidergunnerRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ProtectronRenderer;
import net.mcreator.fallout_wastelands.client.renderer.PowerArmorFrameRenderer;
import net.mcreator.fallout_wastelands.client.renderer.PaulothetraderRenderer;
import net.mcreator.fallout_wastelands.client.renderer.OverseerRenderer;
import net.mcreator.fallout_wastelands.client.renderer.NightkinRenderer;
import net.mcreator.fallout_wastelands.client.renderer.MirelurkRenderer;
import net.mcreator.fallout_wastelands.client.renderer.Malewastelander4Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Malewastelander3Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Malewastelander2Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Malewastelander1Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Malevaultdweller2Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Malevaultdweller1Renderer;
import net.mcreator.fallout_wastelands.client.renderer.MachinegunTurretRenderer;
import net.mcreator.fallout_wastelands.client.renderer.HighwaymanRenderer;
import net.mcreator.fallout_wastelands.client.renderer.GlowingoneRenderer;
import net.mcreator.fallout_wastelands.client.renderer.GhoulRenderer;
import net.mcreator.fallout_wastelands.client.renderer.GeckoRenderer;
import net.mcreator.fallout_wastelands.client.renderer.FriendlybrainbotRenderer;
import net.mcreator.fallout_wastelands.client.renderer.Femalevaultdweller2Renderer;
import net.mcreator.fallout_wastelands.client.renderer.Femalevaultdweller1Renderer;
import net.mcreator.fallout_wastelands.client.renderer.EnclavepowerarmorsoldierRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ENCLAVEofficierRenderer;
import net.mcreator.fallout_wastelands.client.renderer.DeathclawRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ClosecombatsupermutantRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ChromeraiderRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ChromedraiderfemaleRenderer;
import net.mcreator.fallout_wastelands.client.renderer.CaravanguardRenderer;
import net.mcreator.fallout_wastelands.client.renderer.BrotherhoodPaladinRenderer;
import net.mcreator.fallout_wastelands.client.renderer.BrokenFrameRenderer;
import net.mcreator.fallout_wastelands.client.renderer.BrahminRenderer;
import net.mcreator.fallout_wastelands.client.renderer.BloatflyRenderer;
import net.mcreator.fallout_wastelands.client.renderer.BasesupermutantRenderer;
import net.mcreator.fallout_wastelands.client.renderer.ArmyrobobrainRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FalloutWastelandsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FalloutWastelandsModEntities.CHROMERAIDER.get(), ChromeraiderRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.CHROMEDRAIDERFEMALE.get(), ChromedraiderfemaleRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.THEMACHINEGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.LASERRIFFLE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MOBMACHINEGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.AK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MIRELURK.get(), MirelurkRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.GHOUL.get(), GhoulRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.ARMYROBOBRAIN.get(), ArmyrobobrainRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.ROBOBRAINRIVETCANON.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.CLOSECOMBATSUPERMUTANT.get(), ClosecombatsupermutantRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BASESUPERMUTANT.get(), BasesupermutantRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.RANGEDSUPERMUTANT.get(), RangedsupermutantRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.FRIENDLYBRAINBOT.get(), FriendlybrainbotRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.FRBCANNON.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BLOATFLYSHOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BLOATFLY.get(), BloatflyRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.NAILGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.RAIDERGUNNER.get(), RaidergunnerRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.HIGHWAYMAN.get(), HighwaymanRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.TENMM.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.PLASMARIFLE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.ENCLAVEPOWERARMORSOLDIER.get(), EnclavepowerarmorsoldierRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.ENCLAV_EOFFICIER.get(), ENCLAVEofficierRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEVAULTDWELLER_1.get(), Malevaultdweller1Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEVAULTDWELLER_2.get(), Malevaultdweller2Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.FEMALEVAULTDWELLER_1.get(), Femalevaultdweller1Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.FEMALEVAULTDWELLER_2.get(), Femalevaultdweller2Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEWASTELANDER_1.get(), Malewastelander1Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEWASTELANDER_2.get(), Malewastelander2Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEWASTELANDER_3.get(), Malewastelander3Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MALEWASTELANDER_4.get(), Malewastelander4Renderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.OVERSEER.get(), OverseerRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MMPISTOLNINE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MMPISTOLNINEAIM.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.MACHINEGUN_TURRET.get(), MachinegunTurretRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.TURRET_FAKE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.REAL_TURRET_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.POWER_ARMOR_FRAME.get(), PowerArmorFrameRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BROKEN_FRAME.get(), BrokenFrameRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.GECKO.get(), GeckoRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.GLOWINGONE.get(), GlowingoneRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.DEATHCLAW.get(), DeathclawRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.PROTECTRON.get(), ProtectronRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.NIGHTKIN.get(), NightkinRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.ENEMYLASERWEAPON.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.CARAVANGUARD.get(), CaravanguardRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.PAULOTHETRADER.get(), PaulothetraderRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BROTHERHOOD_PALADIN.get(), BrotherhoodPaladinRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.TALONCOMPAGNYSOLDIER.get(), TaloncompagnysoldierRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.TALONCOMPAGNYLIEUTENANT.get(), TaloncompagnylieutenantRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.BRAHMIN.get(), BrahminRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.SPEAR.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FalloutWastelandsModEntities.TRIBAL_SPEAR.get(), ThrownItemRenderer::new);
	}
}
