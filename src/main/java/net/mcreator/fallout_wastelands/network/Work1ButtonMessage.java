
package net.mcreator.fallout_wastelands.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.world.inventory.Work1Menu;
import net.mcreator.fallout_wastelands.procedures.Work1nextProcedure;
import net.mcreator.fallout_wastelands.procedures.Work1C1Procedure;
import net.mcreator.fallout_wastelands.procedures.OpentradeProcedure;
import net.mcreator.fallout_wastelands.procedures.ClosingtradeProcedure;
import net.mcreator.fallout_wastelands.procedures.CardsworthProcedure;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Work1ButtonMessage {
	private final int buttonID, x, y, z;

	public Work1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Work1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Work1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Work1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = Work1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpentradeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Work1C1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CardsworthProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ClosingtradeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Work1nextProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		FalloutWastelandsMod.addNetworkMessage(Work1ButtonMessage.class, Work1ButtonMessage::buffer, Work1ButtonMessage::new,
				Work1ButtonMessage::handler);
	}
}
