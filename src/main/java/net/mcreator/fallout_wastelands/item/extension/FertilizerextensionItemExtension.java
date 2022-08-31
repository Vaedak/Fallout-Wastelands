
package net.mcreator.fallout_wastelands.item.extension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.block.ComposterBlock;

import net.mcreator.fallout_wastelands.item.FertilizerItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FertilizerextensionItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ComposterBlock.CHANCES.put(FertilizerItem.block, 1f);
	}

	@Mod.EventBusSubscriber
	public static class Fuel {
		@SubscribeEvent
		public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
			ItemStack itemstack = event.getItemStack();
			if (itemstack.getItem() == FertilizerItem.block)

				event.setBurnTime(1000);
		}
	}
}
