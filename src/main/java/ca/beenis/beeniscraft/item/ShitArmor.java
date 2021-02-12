package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;

public class ShitArmor {

    // The Variables should be added below the Tools

    public static final RegistryObject<Item> SHIT_HELMET =
            Registration.ITEMS.register("shit_helmet",
                    () -> new ArmorItem(ModArmorMaterial.SHIT, EquipmentSlotType.HEAD,
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static final RegistryObject<Item> SHIT_CHESTPLATE =
            Registration.ITEMS.register("shit_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.SHIT, EquipmentSlotType.CHEST,
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static final RegistryObject<Item> SHIT_LEGGINGS =
            Registration.ITEMS.register("shit_leggings",
                    () -> new ArmorItem(ModArmorMaterial.SHIT, EquipmentSlotType.LEGS,
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static final RegistryObject<Item> SHIT_BOOTS =
            Registration.ITEMS.register("shit_boots",
                    () -> new ArmorItem(ModArmorMaterial.SHIT, EquipmentSlotType.FEET,
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() {
    }

    // The enum should be added at the bottom of the ModItems Class
    public enum ModArmorMaterial implements IArmorMaterial {
        SHIT(50, new int[]{3, 6, 4, 3}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks(new ItemStack(ShitIngot.SHIT_INGOT.get())),
                beeniscraft.MOD_ID + ":shit_ingot", 0, 0.1f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent,
                         Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return this.durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }
}