
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.fallout_wastelands.itemgroup.WastelanderscombattabItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@FalloutWastelandsModElements.ModElement.Tag
public class EnclaveofficierarmorItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:enclaveofficierarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("fallout_wastelands:enclaveofficierarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("fallout_wastelands:enclaveofficierarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("fallout_wastelands:enclaveofficierarmor_boots")
	public static final Item boots = null;
	public EnclaveofficierarmorItem(FalloutWastelandsModElements instance) {
		super(instance, 542);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 3, 4, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.snow.step"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.STRING));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "enclaveofficierarmor";
			}

			@Override
			public float getToughness() {
				return 1.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedHead = new Modelenclaveofficeruniform().head;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/2enclaveofficeruniform__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("enclaveofficierarmor_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new Modelenclaveofficeruniform().torso;
						armorModel.bipedLeftArm = new Modelenclaveofficeruniform().leftarm;
						armorModel.bipedRightArm = new Modelenclaveofficeruniform().rightarm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/2enclaveofficeruniform__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("enclaveofficierarmor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelenclaveofficeruniform().leftleg;
						armorModel.bipedRightLeg = new Modelenclaveofficeruniform().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/2enclaveofficeruniform__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("enclaveofficierarmor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelenclaveofficeruniform().leftleg;
						armorModel.bipedRightLeg = new Modelenclaveofficeruniform().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/2enclaveofficeruniform__layer_"
								+ (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("enclaveofficierarmor_boots"));
	}
	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelenclaveofficeruniform extends EntityModel<Entity> {
		private final ModelRenderer enclaveofficer;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer torso;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer head;
		private final ModelRenderer visor;
		private final ModelRenderer visor_r1;
		public Modelenclaveofficeruniform() {
			textureWidth = 128;
			textureHeight = 32;
			enclaveofficer = new ModelRenderer(this);
			enclaveofficer.setRotationPoint(0.0F, 24.0F, 0.0F);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
			enclaveofficer.addChild(leftleg);
			leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			enclaveofficer.addChild(rightleg);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, -24.0F, 0.0F);
			enclaveofficer.addChild(torso);
			torso.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.2F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			enclaveofficer.addChild(rightarm);
			rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
			enclaveofficer.addChild(leftarm);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.2F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			enclaveofficer.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.3F, false);
			visor = new ModelRenderer(this);
			visor.setRotationPoint(0.0F, -4.5F, -4.0F);
			head.addChild(visor);
			setRotationAngle(visor, 0.3054F, 0.0F, 0.0F);
			visor_r1 = new ModelRenderer(this);
			visor_r1.setRotationPoint(-3.0F, 0.5F, 0.0F);
			visor.addChild(visor_r1);
			setRotationAngle(visor_r1, 0.1745F, 0.0F, 0.0F);
			visor_r1.setTextureOffset(92, 17).addBox(-1.0F, -1.0F, -1.6F, 8.0F, 1.0F, 2.0F, 0.2F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			enclaveofficer.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
