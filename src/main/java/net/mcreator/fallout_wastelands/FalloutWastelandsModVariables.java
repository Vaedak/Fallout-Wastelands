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
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
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
			nbt.putBoolean("RADUIToggle", instance.RADUIToggle);
			nbt.putBoolean("PaHudToggle", instance.PaHudToggle);
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
			instance.RADUIToggle = nbt.getBoolean("RADUIToggle");
			instance.PaHudToggle = nbt.getBoolean("PaHudToggle");
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
		public boolean RADUIToggle = false;
		public boolean PaHudToggle = false;

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
		if (!event.isWasDeath()) {
			clone.radioactivity_gauge = original.radioactivity_gauge;
			clone.RADUI0 = original.RADUI0;
			clone.RADUI2 = original.RADUI2;
			clone.RADUI1 = original.RADUI1;
			clone.RADUI3 = original.RADUI3;
			clone.RADUIToggle = original.RADUIToggle;
			clone.PaHudToggle = original.PaHudToggle;
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
					variables.RADUIToggle = message.data.RADUIToggle;
					variables.PaHudToggle = message.data.PaHudToggle;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
