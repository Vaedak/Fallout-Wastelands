
package net.mcreator.fallout_wastelands.item;

@FalloutWastelandsModElements.ModElement.Tag
public class EnclavehazmatItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:enclavehazmat_helmet")
	public static final Item helmet = null;

	@ObjectHolder("fallout_wastelands:enclavehazmat_chestplate")
	public static final Item body = null;

	@ObjectHolder("fallout_wastelands:enclavehazmat_leggings")
	public static final Item legs = null;

	@ObjectHolder("fallout_wastelands:enclavehazmat_boots")
	public static final Item boots = null;

	public EnclavehazmatItem(FalloutWastelandsModElements instance) {
		super(instance, 1433);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 7;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 3, 4, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.place"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnclaveplatingItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "enclavehazmat";
			}

			@Override
			public float getToughness() {
				return 0.3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/enclave_hazmat__b_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("enclavehazmat_helmet"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/enclave_hazmat__b_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						EnclavehazmatBodyTickEventProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				}.setRegistryName("enclavehazmat_chestplate"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/enclave_hazmat__b_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("enclavehazmat_leggings"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/enclave_hazmat__b_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("enclavehazmat_boots"));
	}

}
