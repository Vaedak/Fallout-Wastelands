package net.mcreator.fallout_wastelands;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class FalloutWastelandsModVariables {
	public FalloutWastelandsModVariables(FalloutWastelandsModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "fallout_wastelands_worldvars";
		public double are10cardsdropped = 0;
		public boolean tencardsaredropped = false;

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			are10cardsdropped = nbt.getDouble("are10cardsdropped");
			tencardsaredropped = nbt.getBoolean("tencardsaredropped");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("are10cardsdropped", are10cardsdropped);
			nbt.putBoolean("tencardsaredropped", tencardsaredropped);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "fallout_wastelands_mapvars";

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("fallout_wastelands", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("Radioacitvity", instance.Radioacitvity);
			nbt.putBoolean("Radioactivity1", instance.Radioactivity1);
			nbt.putString("Radiation2", instance.Radiation2);
			nbt.putDouble("Fuel", instance.Fuel);
			nbt.putDouble("radioactivity_gauge", instance.radioactivity_gauge);
			nbt.putBoolean("RADUI0", instance.RADUI0);
			nbt.putBoolean("RADUI2", instance.RADUI2);
			nbt.putBoolean("RADUI1", instance.RADUI1);
			nbt.putBoolean("RADUI3", instance.RADUI3);
			nbt.putBoolean("InPowerArmor", instance.InPowerArmor);
			nbt.putDouble("Power", instance.Power);
			nbt.putBoolean("CanUseWeapon", instance.CanUseWeapon);
			nbt.putBoolean("RADUI4", instance.RADUI4);
			nbt.putBoolean("paulo_quest_in_progress", instance.paulo_quest_in_progress);
			nbt.putBoolean("paulo_quest_done", instance.paulo_quest_done);
			nbt.putBoolean("DisplayRadUI", instance.DisplayRadUI);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Radioacitvity = nbt.getDouble("Radioacitvity");
			instance.Radioactivity1 = nbt.getBoolean("Radioactivity1");
			instance.Radiation2 = nbt.getString("Radiation2");
			instance.Fuel = nbt.getDouble("Fuel");
			instance.radioactivity_gauge = nbt.getDouble("radioactivity_gauge");
			instance.RADUI0 = nbt.getBoolean("RADUI0");
			instance.RADUI2 = nbt.getBoolean("RADUI2");
			instance.RADUI1 = nbt.getBoolean("RADUI1");
			instance.RADUI3 = nbt.getBoolean("RADUI3");
			instance.InPowerArmor = nbt.getBoolean("InPowerArmor");
			instance.Power = nbt.getDouble("Power");
			instance.CanUseWeapon = nbt.getBoolean("CanUseWeapon");
			instance.RADUI4 = nbt.getBoolean("RADUI4");
			instance.paulo_quest_in_progress = nbt.getBoolean("paulo_quest_in_progress");
			instance.paulo_quest_done = nbt.getBoolean("paulo_quest_done");
			instance.DisplayRadUI = nbt.getBoolean("DisplayRadUI");
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
		public boolean DisplayRadUI = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				FalloutWastelandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
			clone.DisplayRadUI = original.DisplayRadUI;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
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
					variables.DisplayRadUI = message.data.DisplayRadUI;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
