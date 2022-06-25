
package net.mcreator.fallout_wastelands.item;

@FalloutWastelandsModElements.ModElement.Tag
public class HazmatItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:hazmat_helmet")
	public static final Item helmet = null;

	@ObjectHolder("fallout_wastelands:hazmat_chestplate")
	public static final Item body = null;

	@ObjectHolder("fallout_wastelands:hazmat_leggings")
	public static final Item legs = null;

	@ObjectHolder("fallout_wastelands:hazmat_boots")
	public static final Item boots = null;

	public HazmatItem(FalloutWastelandsModElements instance) {
		super(instance, 1395);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 6;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 2, 3, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "hazmat";
			}

			@Override
			public float getToughness() {
				return 0.1f;
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
						return "fallout_wastelands:textures/models/armor/hazmat___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("hazmat_helmet"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/hazmat___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						HazmatBodyTickEventProcedure.executeProcedure(Collections.emptyMap());
					}
				}.setRegistryName("hazmat_chestplate"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/hazmat___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("hazmat_leggings"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/hazmat___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("hazmat_boots"));
	}

}
