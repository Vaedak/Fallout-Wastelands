
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fallout_wastelands.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class FalloutWastelandsModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == FalloutWastelandsModItems.FUELJERRICAN.get())
			event.setBurnTime(16000);
		else if (itemstack.getItem() == FalloutWastelandsModItems.FERTILIZER.get())
			event.setBurnTime(1000);
	}
}
