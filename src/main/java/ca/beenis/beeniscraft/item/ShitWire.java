package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;



public class ShitWire extends Item {

    public ShitWire(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 600;
    }

    public  static final RegistryObject<Item> SHIT_WIRE =
            Registration.ITEMS.register("shit_wire",
                    () -> new ShitWire(new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() { }

}


