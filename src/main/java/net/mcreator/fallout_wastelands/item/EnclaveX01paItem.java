
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

<<<<<<< HEAD
import net.mcreator.fallout_wastelands.procedures.PowerArmorLeggingsTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorHelmetTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorChestTickProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorBootsTickProcedure;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModTabs;
import net.mcreator.fallout_wastelands.init.FalloutWastelandsModItems;
=======
import net.mcreator.fallout_wastelands.procedures.PowerArmorLeggingsUniversalProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorHelmetUniversalProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorChestUniversalProcedure;
import net.mcreator.fallout_wastelands.procedures.PowerArmorBootsUniversalProcedure;
import net.mcreator.fallout_wastelands.itemgroup.WastelanderscombattabItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands

<<<<<<< HEAD
public abstract class EnclaveX01paItem extends ArmorItem {
	public EnclaveX01paItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
=======
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@FalloutWastelandsModElements.ModElement.Tag
public class EnclaveX01paItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:enclave_x_01pa_helmet")
	public static final Item helmet = null;
	@ObjectHolder("fallout_wastelands:enclave_x_01pa_chestplate")
	public static final Item body = null;
	@ObjectHolder("fallout_wastelands:enclave_x_01pa_leggings")
	public static final Item legs = null;
	@ObjectHolder("fallout_wastelands:enclave_x_01pa_boots")
	public static final Item boots = null;

	public EnclaveX01paItem(FalloutWastelandsModElements instance) {
		super(instance, 517);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
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
<<<<<<< HEAD
		}, slot, properties);
=======
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedHead = new Modelxoone().head;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/x01b__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						super.onArmorTick(itemstack, world, entity);
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						PowerArmorHelmetUniversalProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				}.setRegistryName("enclave_x_01pa_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new Modelxoone().body;
						armorModel.bipedLeftArm = new Modelxoone().leftarm;
						armorModel.bipedRightArm = new Modelxoone().rightarm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/x01b__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						PowerArmorChestUniversalProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				}.setRegistryName("enclave_x_01pa_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelxoone().leftleg;
						armorModel.bipedRightLeg = new Modelxoone().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/x01b__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						PowerArmorLeggingsUniversalProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				}.setRegistryName("enclave_x_01pa_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelxoone().leftleg;
						armorModel.bipedRightLeg = new Modelxoone().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/x01b__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();

						PowerArmorBootsUniversalProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				}.setRegistryName("enclave_x_01pa_boots"));
>>>>>>> branch 'master' of https://github.com/Vaedak/Fallout-Wastelands
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
