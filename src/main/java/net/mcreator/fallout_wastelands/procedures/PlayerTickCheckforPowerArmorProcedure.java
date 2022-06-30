package net.mcreator.fallout_wastelands.procedures;

import net.minecraftforge.eventbus.api.Event;

public class PlayerTickCheckforPowerArmorProcedure {

	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FalloutWastelandsMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerTickCheckforPowerArmor!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == EnclaveX01paItem.helmet
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
						.getItem() == T45powerarmorItem.helmet) == true) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == EnclaveX01paItem.body
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
							.getItem() == T45powerarmorItem.body) == true) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
						.getItem() == EnclaveX01paItem.legs
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
								.getItem() == T45powerarmorItem.legs) == true) {
					if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
							.getItem() == EnclaveX01paItem.boots
							|| ((entity instanceof LivingEntity)
									? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
									: ItemStack.EMPTY).getItem() == T45powerarmorItem.boots) == true) {
						{
							boolean _setval = (true);
							entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InPowerArmor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							boolean _setval = (false);
							entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.InPowerArmor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1, (false), (false)));
					}
				} else {
					{
						boolean _setval = (false);
						entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.InPowerArmor = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1, (false), (false)));
				}
			} else {
				{
					boolean _setval = (false);
					entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InPowerArmor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1, (false), (false)));
			}
		} else {
			{
				boolean _setval = (false);
				entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InPowerArmor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1, (false), (false)));
		}
		if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FalloutWastelandsModVariables.PlayerVariables())).InPowerArmor == true) {
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Power > 0) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
			}
			if ((entity.getCapability(FalloutWastelandsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new FalloutWastelandsModVariables.PlayerVariables())).Power == 0) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 1, (false), (false)));
			}
		}
	}

}
