
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
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
public class GreysuitItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:greysuit_helmet")
	public static final Item helmet = null;
	@ObjectHolder("fallout_wastelands:greysuit_chestplate")
	public static final Item body = null;
	@ObjectHolder("fallout_wastelands:greysuit_leggings")
	public static final Item legs = null;
	@ObjectHolder("fallout_wastelands:greysuit_boots")
	public static final Item boots = null;

	public GreysuitItem(FalloutWastelandsModElements instance) {
		super(instance, 1461);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 2;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{0, 1, 1, 0}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 15;
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
				return "greysuit";
			}

			@Override
			public float getToughness() {
				return 0f;
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
						armorModel.bipedBody = new Modelsuit().body;
						armorModel.bipedLeftArm = new Modelsuit().armleft;
						armorModel.bipedRightArm = new Modelsuit().armright;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/greysuittop.png";
					}
				}.setRegistryName("greysuit_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelsuit().legleft;
						armorModel.bipedRightLeg = new Modelsuit().legright;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/greypants.png";
					}
				}.setRegistryName("greysuit_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modelsuit().legleft;
						armorModel.bipedRightLeg = new Modelsuit().legright;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/greypants.png";
					}
				}.setRegistryName("greysuit_boots"));
	}

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelsuit extends EntityModel<Entity> {
		private final ModelRenderer suit;
		private final ModelRenderer legright;
		private final ModelRenderer legleft;
		private final ModelRenderer body;
		private final ModelRenderer armright;
		private final ModelRenderer armleft;

		public Modelsuit() {
			textureWidth = 64;
			textureHeight = 32;
			suit = new ModelRenderer(this);
			suit.setRotationPoint(0.0F, 24.0F, 0.0F);
			legright = new ModelRenderer(this);
			legright.setRotationPoint(-2.0F, -12.0F, 0.0F);
			suit.addChild(legright);
			legright.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, false);
			legleft = new ModelRenderer(this);
			legleft.setRotationPoint(2.0F, -12.0F, 0.0F);
			suit.addChild(legleft);
			legleft.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -18.0F, 0.0F);
			suit.addChild(body);
			body.setTextureOffset(16, 0).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 13.0F, 4.0F, 0.12F, false);
			armright = new ModelRenderer(this);
			armright.setRotationPoint(-4.0F, -22.0F, 0.0F);
			suit.addChild(armright);
			armright.setTextureOffset(40, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.11F, false);
			armleft = new ModelRenderer(this);
			armleft.setRotationPoint(4.0F, -22.0F, 0.0F);
			suit.addChild(armleft);
			armleft.setTextureOffset(40, 0).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.11F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			suit.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.legright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.armleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.legleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
