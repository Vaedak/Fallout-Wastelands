
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.fallout_wastelands.procedures.PowerArmorLeggingsTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorHelmetTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorChestTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorBootsTickProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;

public abstract class EnclaveX01paItem extends ArmorItem {
	public EnclaveX01paItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{8, 12, 12, 8}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(FalloutWastelandsModItems.ENCLAVEPLATING.get()));
			}

			@Override
			public String getName() {
				return "enclave_x_01pa";
			}

			@Override
			public float getToughness() {
				return 4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends EnclaveX01paItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSCOMBATTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "fallout_wastelands:textures/models/armor/x01b__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PowerArmorHelmetTickProcedure.execute(

			);
		}
	}

	public static class Chestplate extends EnclaveX01paItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSCOMBATTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "fallout_wastelands:textures/models/armor/x01b__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PowerArmorChestTickProcedure.execute(

			);
		}
	}

	public static class Leggings extends EnclaveX01paItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSCOMBATTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "fallout_wastelands:textures/models/armor/x01b__layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PowerArmorLeggingsTickProcedure.execute(

			);
		}
	}

	public static class Boots extends EnclaveX01paItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(FalloutWastelandsModTabs.TAB_WASTELANDERSCOMBATTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "fallout_wastelands:textures/models/armor/x01b__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			PowerArmorBootsTickProcedure.execute(

			);
		}
	}
}
