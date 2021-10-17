
package net.mcreator.fallout_wastelands.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.fallout_wastelands.item.FueljerricanItem;

@Mod.EventBusSubscriber
public class FueljerricanfuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == FueljerricanItem.block)
			event.setBurnTime(16000);
	}
}
