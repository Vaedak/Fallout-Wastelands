package net.mcreator.fallout_wastelands.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.fallout_wastelands.FalloutWastelandsModVariables;
import net.mcreator.fallout_wastelands.FalloutWastelandsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FalloutWastelandsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		FalloutWastelandsMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		FalloutWastelandsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.Radioacitvity = original.Radioacitvity;
			clone.Radioactivity1 = original.Radioactivity1;
			clone.Radiation2 = original.Radiation2;
			clone.Fuel = original.Fuel;
			clone.InPowerArmor = original.InPowerArmor;
			clone.Power = original.Power;
			clone.CanUseWeapon = original.CanUseWeapon;
			clone.paulo_quest_in_progress = original.paulo_quest_in_progress;
			clone.paulo_quest_done = original.paulo_quest_done;
			if (!event.isWasDeath()) {
				clone.radioactivity_gauge = original.radioactivity_gauge;
				clone.RADUI0 = original.RADUI0;
				clone.RADUI2 = original.RADUI2;
				clone.RADUI1 = original.RADUI1;
				clone.RADUI3 = original.RADUI3;
				clone.RADUI4 = original.RADUI4;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "fallout_wastelands_worldvars";
		public double are10cardsdropped = 0;
		public boolean tencardsaredropped = false;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			are10cardsdropped = nbt.getDouble("are10cardsdropped");
			tencardsaredropped = nbt.getBoolean("tencardsaredropped");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("are10cardsdropped", are10cardsdropped);
			nbt.putBoolean("tencardsaredropped", tencardsaredropped);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "fallout_wastelands_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("fallout_wastelands", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Radioacitvity = 0;
		public boolean Radioactivity1 = false;
		public String Radiation2 = "";
		public double Fuel = 0;
		public double radioactivity_gauge = 0;
		public boolean RADUI0 = false;
		public boolean RADUI2 = false;
		public boolean RADUI1 = false;
		public boolean RADUI3 = false;
		public boolean InPowerArmor = false;
		public double Power = 0;
		public boolean CanUseWeapon = false;
		public boolean RADUI4 = false;
		public boolean paulo_quest_in_progress = false;
		public boolean paulo_quest_done = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Radioacitvity", Radioacitvity);
			nbt.putBoolean("Radioactivity1", Radioactivity1);
			nbt.putString("Radiation2", Radiation2);
			nbt.putDouble("Fuel", Fuel);
			nbt.putDouble("radioactivity_gauge", radioactivity_gauge);
			nbt.putBoolean("RADUI0", RADUI0);
			nbt.putBoolean("RADUI2", RADUI2);
			nbt.putBoolean("RADUI1", RADUI1);
			nbt.putBoolean("RADUI3", RADUI3);
			nbt.putBoolean("InPowerArmor", InPowerArmor);
			nbt.putDouble("Power", Power);
			nbt.putBoolean("CanUseWeapon", CanUseWeapon);
			nbt.putBoolean("RADUI4", RADUI4);
			nbt.putBoolean("paulo_quest_in_progress", paulo_quest_in_progress);
			nbt.putBoolean("paulo_quest_done", paulo_quest_done);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Radioacitvity = nbt.getDouble("Radioacitvity");
			Radioactivity1 = nbt.getBoolean("Radioactivity1");
			Radiation2 = nbt.getString("Radiation2");
			Fuel = nbt.getDouble("Fuel");
			radioactivity_gauge = nbt.getDouble("radioactivity_gauge");
			RADUI0 = nbt.getBoolean("RADUI0");
			RADUI2 = nbt.getBoolean("RADUI2");
			RADUI1 = nbt.getBoolean("RADUI1");
			RADUI3 = nbt.getBoolean("RADUI3");
			InPowerArmor = nbt.getBoolean("InPowerArmor");
			Power = nbt.getDouble("Power");
			CanUseWeapon = nbt.getBoolean("CanUseWeapon");
			RADUI4 = nbt.getBoolean("RADUI4");
			paulo_quest_in_progress = nbt.getBoolean("paulo_quest_in_progress");
			paulo_quest_done = nbt.getBoolean("paulo_quest_done");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.Radioacitvity = message.data.Radioacitvity;
					variables.Radioactivity1 = message.data.Radioactivity1;
					variables.Radiation2 = message.data.Radiation2;
					variables.Fuel = message.data.Fuel;
					variables.radioactivity_gauge = message.data.radioactivity_gauge;
					variables.RADUI0 = message.data.RADUI0;
					variables.RADUI2 = message.data.RADUI2;
					variables.RADUI1 = message.data.RADUI1;
					variables.RADUI3 = message.data.RADUI3;
					variables.InPowerArmor = message.data.InPowerArmor;
					variables.Power = message.data.Power;
					variables.CanUseWeapon = message.data.CanUseWeapon;
					variables.RADUI4 = message.data.RADUI4;
					variables.paulo_quest_in_progress = message.data.paulo_quest_in_progress;
					variables.paulo_quest_done = message.data.paulo_quest_done;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
