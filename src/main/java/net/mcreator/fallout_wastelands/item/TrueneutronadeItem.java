
package net.mcreator.fallout_wastelands.item;

import net.minecraft.entity.ai.attributes.Attributes;

@FalloutWastelandsModElements.ModElement.Tag
public class TrueneutronadeItem extends FalloutWastelandsModElements.ModElement {

	@ObjectHolder("fallout_wastelands:trueneutronade")
	public static final Item block = null;

	public TrueneutronadeItem(FalloutWastelandsModElements instance) {
		super(instance, 1635);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(WastelandersitemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.5f).setAlwaysEdible().build()));
			setRegistryName("trueneutronade");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 20;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Now with 220 % more Neutrons !"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			NeutronadeFoodEatenProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			return retval;
		}

	}

}
