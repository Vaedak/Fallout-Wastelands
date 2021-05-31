
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
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
public class FemalevaultjumpsuitItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:femalevaultjumpsuit_helmet")
	public static final Item helmet = null;
	@ObjectHolder("fallout_wastelands:femalevaultjumpsuit_chestplate")
	public static final Item body = null;
	@ObjectHolder("fallout_wastelands:femalevaultjumpsuit_leggings")
	public static final Item legs = null;
	@ObjectHolder("fallout_wastelands:femalevaultjumpsuit_boots")
	public static final Item boots = null;
	public FemalevaultjumpsuitItem(FalloutWastelandsModElements instance) {
		super(instance, 145);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 10;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 2, 2, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.hit"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "femalevaultjumpsuit";
			}

			@Override
			public float getToughness() {
				return 5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new Modelvaultjumpsuitfemale().body;
						armorModel.bipedLeftArm = new Modelvaultjumpsuitfemale().leftarm;
						armorModel.bipedRightArm = new Modelvaultjumpsuitfemale().rightarm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/femalejumpsuitb__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("femalevaultjumpsuit_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelvaultjumpsuitfemale().leftleg;
						armorModel.bipedRightLeg = new Modelvaultjumpsuitfemale().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/femalejumpsuitb__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("femalevaultjumpsuit_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelvaultjumpsuitfemale().leftleg;
						armorModel.bipedRightLeg = new Modelvaultjumpsuitfemale().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/femalejumpsuitb__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}
				}.setRegistryName("femalevaultjumpsuit_boots"));
	}
	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelvaultjumpsuitfemale extends EntityModel<Entity> {
		private final ModelRenderer jumpsuit;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer body;
		private final ModelRenderer breast;
		public Modelvaultjumpsuitfemale() {
			textureWidth = 64;
			textureHeight = 32;
			jumpsuit = new ModelRenderer(this);
			jumpsuit.setRotationPoint(0.0F, 24.0F, 0.0F);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
			jumpsuit.addChild(leftleg);
			leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.26F, true);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			jumpsuit.addChild(rightleg);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.26F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			jumpsuit.addChild(rightarm);
			rightarm.setTextureOffset(40, 16).addBox(-2.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.26F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
			jumpsuit.addChild(leftarm);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.26F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -24.0F, 0.0F);
			jumpsuit.addChild(body);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.26F, false);
			breast = new ModelRenderer(this);
			breast.setRotationPoint(0.0F, 1.0F, -0.5F);
			body.addChild(breast);
			setRotationAngle(breast, -0.4363F, 0.0F, 0.0F);
			breast.setTextureOffset(18, 10).addBox(-4.0F, 0.65F, -1.49F, 8.0F, 4.0F, 2.0F, 0.26F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			jumpsuit.render(matrixStack, buffer, packedLight, packedOverlay);
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
