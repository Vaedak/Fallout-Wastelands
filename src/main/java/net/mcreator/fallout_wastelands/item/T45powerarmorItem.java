
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
import net.minecraft.block.Blocks;

import net.mcreator.fallout_wastelands.procedures.T45powerarmorLeggingsTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.T45powerarmorHelmetTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.T45powerarmorBootsTickEventProcedure;
import net.mcreator.fallout_wastelands.procedures.T45powerarmorBodyTickEventProcedure;
import net.mcreator.fallout_wastelands.itemgroup.WastelanderscombattabItemGroup;
import net.mcreator.fallout_wastelands.FalloutWastelandsModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@FalloutWastelandsModElements.ModElement.Tag
public class T45powerarmorItem extends FalloutWastelandsModElements.ModElement {
	@ObjectHolder("fallout_wastelands:t_45powerarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("fallout_wastelands:t_45powerarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("fallout_wastelands:t_45powerarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("fallout_wastelands:t_45powerarmor_boots")
	public static final Item boots = null;
	public T45powerarmorItem(FalloutWastelandsModElements instance) {
		super(instance, 160);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 40;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 6, 6, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.hit"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "t_45powerarmor";
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
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedHead = new Modeltfourtyfive().head;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/pa45__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
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
							T45powerarmorHelmetTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("t_45powerarmor_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new Modeltfourtyfive().body;
						armorModel.bipedLeftArm = new Modeltfourtyfive().leftarm;
						armorModel.bipedRightArm = new Modeltfourtyfive().rightarm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/pa45__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							T45powerarmorBodyTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("t_45powerarmor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modeltfourtyfive().leftleg;
						armorModel.bipedRightLeg = new Modeltfourtyfive().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/pa45__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							T45powerarmorLeggingsTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("t_45powerarmor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(WastelanderscombattabItemGroup.tab)) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new Modeltfourtyfive().leftleg;
						armorModel.bipedRightLeg = new Modeltfourtyfive().rightleg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "fallout_wastelands:textures/models/armor/pa45__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}

					@Override
					public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
						double x = entity.getPosX();
						double y = entity.getPosY();
						double z = entity.getPosZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							T45powerarmorBootsTickEventProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("t_45powerarmor_boots"));
	}
	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeltfourtyfive extends EntityModel<Entity> {
		private final ModelRenderer powerarmor;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightarm;
		private final ModelRenderer rightshoulder;
		private final ModelRenderer leftarm;
		private final ModelRenderer leftshoulder;
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer tube;
		private final ModelRenderer lamptow;
		public Modeltfourtyfive() {
			textureWidth = 128;
			textureHeight = 32;
			powerarmor = new ModelRenderer(this);
			powerarmor.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
			powerarmor.addChild(rightleg);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);
			rightleg.setTextureOffset(120, 19).addBox(-1.5F, 4.0F, -3.0F, 3.0F, 3.0F, 1.0F, 0.4F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
			powerarmor.addChild(leftleg);
			leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);
			leftleg.setTextureOffset(120, 19).addBox(-1.5F, 4.0F, -3.0F, 3.0F, 3.0F, 1.0F, 0.4F, true);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			powerarmor.addChild(rightarm);
			rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, false);
			rightshoulder = new ModelRenderer(this);
			rightshoulder.setRotationPoint(1.5F, -4.0F, 0.0F);
			rightarm.addChild(rightshoulder);
			setRotationAngle(rightshoulder, 0.0F, 0.0F, -0.2618F);
			rightshoulder.setTextureOffset(57, 24).addBox(-7.5F, 0.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.4F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, -22.0F, 0.0F);
			powerarmor.addChild(leftarm);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.4F, true);
			leftshoulder = new ModelRenderer(this);
			leftshoulder.setRotationPoint(-1.5F, -4.0F, 0.0F);
			leftarm.addChild(leftshoulder);
			setRotationAngle(leftshoulder, 0.0F, 0.0F, 0.2618F);
			leftshoulder.setTextureOffset(57, 24).addBox(0.5F, 0.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.4F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -24.0F, 0.0F);
			powerarmor.addChild(body);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.4F, false);
			body.setTextureOffset(89, 17).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.4F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			powerarmor.addChild(head);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4F, false);
			head.setTextureOffset(123, 24).addBox(2.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.4F, false);
			tube = new ModelRenderer(this);
			tube.setRotationPoint(0.0F, -2.5F, 0.5F);
			head.addChild(tube);
			setRotationAngle(tube, 0.1745F, 0.0F, 0.0F);
			tube.setTextureOffset(58, 15).addBox(-5.0F, -0.5F, -4.0F, 10.0F, 1.0F, 7.0F, 0.4F, false);
			lamptow = new ModelRenderer(this);
			lamptow.setRotationPoint(-5.6F, -7.0F, -0.5F);
			head.addChild(lamptow);
			setRotationAngle(lamptow, 0.0F, 0.0F, -0.7854F);
			lamptow.setTextureOffset(76, 24).addBox(-1.0F, -0.5F, -3.5F, 1.0F, 2.0F, 4.0F, 0.4F, false);
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
