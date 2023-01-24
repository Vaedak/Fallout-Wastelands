
package net.mcreator.fallout_wastelands.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.fallout_wastelands.world.inventory.PaulotradeMenu;
import net.mcreator.fallout_wastelands.procedures.Paulotradeslot67Procedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradeslot4Procedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradeslot2capsProcedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradecapsslot67Procedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradecapsslot2Procedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradecapsslot0Procedure;
import net.mcreator.fallout_wastelands.procedures.Paulotradeantiradslot1Procedure;
import net.mcreator.fallout_wastelands.procedures.Palotradecapsslot4Procedure;
import net.mcreator.fallout_wastelands.procedures.Ifcapsareremoved1Procedure;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PaulotradeSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public PaulotradeSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public PaulotradeSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(PaulotradeSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(PaulotradeSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PaulotradeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slotID == 0 && changeType == 0) {

			Paulotradecapsslot0Procedure.execute(entity);
		}
		if (slotID == 0 && changeType == 1) {

			Ifcapsareremoved1Procedure.execute(entity);
		}
		if (slotID == 1 && changeType == 1) {

			Paulotradeantiradslot1Procedure.execute(world, x, y, z, entity);
		}
		if (slotID == 1 && changeType == 2) {
			int amount = meta;

			Paulotradeantiradslot1Procedure.execute(world, x, y, z, entity);
		}
		if (slotID == 2 && changeType == 0) {

			Paulotradecapsslot2Procedure.execute(entity);
		}
		if (slotID == 3 && changeType == 1) {

			Paulotradeslot2capsProcedure.execute(world, x, y, z, entity);
		}
		if (slotID == 3 && changeType == 2) {
			int amount = meta;

			Paulotradeslot2capsProcedure.execute(world, x, y, z, entity);
		}
		if (slotID == 4 && changeType == 0) {

			Palotradecapsslot4Procedure.execute(entity);
		}
		if (slotID == 5 && changeType == 1) {

			Paulotradeslot4Procedure.execute(world, x, y, z, entity);
		}
		if (slotID == 5 && changeType == 2) {
			int amount = meta;

			Paulotradeslot4Procedure.execute(world, x, y, z, entity);
		}
		if (slotID == 6 && changeType == 0) {

			Paulotradecapsslot67Procedure.execute(entity);
		}
		if (slotID == 8 && changeType == 1) {

			Paulotradeslot67Procedure.execute(world, x, y, z, entity);
		}
		if (slotID == 8 && changeType == 2) {
			int amount = meta;

			Paulotradeslot67Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		FalloutWastelandsMod.addNetworkMessage(PaulotradeSlotMessage.class, PaulotradeSlotMessage::buffer, PaulotradeSlotMessage::new,
				PaulotradeSlotMessage::handler);
	}
}
