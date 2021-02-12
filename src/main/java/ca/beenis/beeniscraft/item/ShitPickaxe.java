package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;


public class ShitPickaxe extends Item{

    public ShitPickaxe(Properties properties) {
        super(properties);
    }

    public  static final RegistryObject<Item> SHIT_pickaxe =
            Registration.ITEMS.register("shit_pickaxe",
                    () -> new PickaxeItem(ModItemTier.SHIT, 1, 0,
                            new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.SHOVEL, 2)
                            .group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() { }

    public enum ModItemTier implements IItemTier {
        SHIT(2, 150, 2.5f, 1f, 15,
                Ingredient.fromStacks(new ItemStack(ShitIngot.SHIT_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }

}


