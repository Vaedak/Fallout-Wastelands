
package net.mcreator.fallout_wastelands.item;

@FalloutWastelandsModElements.ModElement.Tag
public class TaloncombatarmorItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:taloncombatarmor_helmet")
	public static final Item helmet = null;

	@ObjectHolder("fallout_wastelands:taloncombatarmor_chestplate")
	public static final Item body = null;

	@ObjectHolder("fallout_wastelands:taloncombatarmor_leggings")
	public static final Item legs = null;

	@ObjectHolder("fallout_wastelands:taloncombatarmor_boots")
	public static final Item boots = null;

	public TaloncombatarmorItem(FalloutWastelandsModElements instance) {
		super(instance, 1432);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 5, 5, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.metal.hit"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SheetmetalplatingItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "taloncombatarmor";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		};

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/talonarmor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("taloncombatarmor_helmet"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/talonarmor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("taloncombatarmor_chestplate"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/talonarmor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("taloncombatarmor_leggings"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/talonarmor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

				}.setRegistryName("taloncombatarmor_boots"));
	}

}
