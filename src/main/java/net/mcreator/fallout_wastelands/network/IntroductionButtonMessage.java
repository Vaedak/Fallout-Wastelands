
package net.mcreator.fallout_wastelands.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.world.inventory.IntroductionMenu;
import net.mcreator.fallout_wastelands.procedures.Town1Procedure;
import net.mcreator.fallout_wastelands.procedures.StartingmexicanProcedure;
import net.mcreator.fallout_wastelands.procedures.OpentradeProcedure;
import net.mcreator.fallout_wastelands.procedures.IntroductionC1Procedure;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IntroductionButtonMessage {
	private final int buttonID, x, y, z;

	public IntroductionButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public IntroductionButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(IntroductionButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(IntroductionButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = IntroductionMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpentradeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StartingmexicanProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			IntroductionC1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Town1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		FalloutWastelandsMod.addNetworkMessage(IntroductionButtonMessage.class, IntroductionButtonMessage::buffer, IntroductionButtonMessage::new,
				IntroductionButtonMessage::handler);
	}
}
