
package net.mcreator.fallout_wastelands.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.fallout_wastelands.item.FueljerricanItem;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

@FalloutWastelandsModElements.ModElement.Tag
public class FueljerricanfuelFuel extends FalloutWastelandsModElements.ModElement {
	public FueljerricanfuelFuel(FalloutWastelandsModElements instance) {
		super(instance, 383);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(FueljerricanItem.block, (int) (1)).getItem())
			event.setBurnTime(16000);
	}
}
