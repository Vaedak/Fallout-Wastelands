
package net.mcreator.fallout_wastelands.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.fallout_wastelands.procedures.EnclaveX01paLeggingsTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.EnclaveX01paHelmetTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.EnclaveX01paBootsTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.EnclaveX01paBodyTickEventProcedure;
import net.mcreator.fallout_wastelands.itemgroup.WastelanderscombattabItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import java.util.Map;
import java.util.HashMap;

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
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{8, 12, 12, 8}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnclaveplatingItem.block));
			}

			@OnlyIn(Dist.CLIENT)
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
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							EnclaveX01paHelmetTickEventProcedure.executeProcedure($_dependencies);
						}
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
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							EnclaveX01paBodyTickEventProcedure.executeProcedure($_dependencies);
						}
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
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							EnclaveX01paLeggingsTickEventProcedure.executeProcedure($_dependencies);
						}
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
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							EnclaveX01paBootsTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("enclave_x_01pa_boots"));
	}
	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelxoone extends EntityModel<Entity> {
		private final ModelRenderer powerarmor;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightarm;
		private final ModelRenderer rightshoulder;
		private final ModelRenderer leftarm;
		private final ModelRenderer leftshoulder;
		private final ModelRenderer body;
		private final ModelRenderer torso;
		private final ModelRenderer plate;
		private final ModelRenderer back;
		private final ModelRenderer head;
		private final ModelRenderer pipe;
		private final ModelRenderer nose;
		public Modelxoone() {
			textureWidth = 128;
			textureHeight = 32;
			powerarmor = new ModelRenderer(this);
			powerarmor.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			powerarmor.addChild(rightleg);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
			powerarmor.addChild(leftleg);
			leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			powerarmor.addChild(rightarm);
			rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);
			rightshoulder = new ModelRenderer(this);
			rightshoulder.setRotationPoint(1.5F, -4.0F, 0.0F);
			rightarm.addChild(rightshoulder);
			setRotationAngle(rightshoulder, 0.0F, 0.0F, -0.2618F);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
			powerarmor.addChild(leftarm);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);
			leftshoulder = new ModelRenderer(this);
			leftshoulder.setRotationPoint(-1.5F, -4.0F, 0.0F);
			leftarm.addChild(leftshoulder);
			setRotationAngle(leftshoulder, 0.0F, 0.0F, 0.2618F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -24.0F, 0.0F);
			powerarmor.addChild(body);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.4F, false);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 3.0F, -2.0F);
			body.addChild(torso);
			setRotationAngle(torso, 0.3491F, 0.0F, 0.0F);
			torso.setTextureOffset(16, 16).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.4F, false);
			plate = new ModelRenderer(this);
			plate.setRotationPoint(0.0F, 0.0F, 1.0F);
			body.addChild(plate);
			setRotationAngle(plate, 0.3491F, 0.0F, 0.0F);
			plate.setTextureOffset(56, 19).addBox(-8.0F, -2.6041F, -6.1278F, 16.0F, 3.0F, 10.0F, 0.4F, false);
			back = new ModelRenderer(this);
			back.setRotationPoint(0.0F, 0.0F, 4.0F);
			body.addChild(back);
			setRotationAngle(back, -0.384F, 0.0F, 0.0F);
			back.setTextureOffset(78, 16).addBox(-8.0F, -1.173F, -2.6391F, 16.0F, 4.0F, 3.0F, 0.4F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			powerarmor.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);
			head.setTextureOffset(83, 17).addBox(-5.0F, -4.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.4F, false);
			pipe = new ModelRenderer(this);
			pipe.setRotationPoint(-4.5F, -8.0F, 0.5F);
			head.addChild(pipe);
			setRotationAngle(pipe, 0.0F, 0.0F, 0.6981F);
			pipe.setTextureOffset(108, 23).addBox(0.0F, -1.0F, -3.5F, 1.0F, 2.0F, 7.0F, 0.4F, false);
			nose = new ModelRenderer(this);
			nose.setRotationPoint(-2.0F, 0.0F, 0.0F);
			head.addChild(nose);
			setRotationAngle(nose, 0.0F, 0.0F, 0.7854F);
			nose.setTextureOffset(13, 16).addBox(-1.1F, -4.0F, -5.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			powerarmor.render(matrixStack, buffer, packedLight, packedOverlay);
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
