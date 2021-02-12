package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;



public class ShitIngot extends Item {

    public ShitIngot(Properties properties) {
        super(properties);
    }

    public  static final RegistryObject<Item> SHIT_INGOT =
            Registration.ITEMS.register("shit_ingot",
                    () -> new ShitIngot(new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() { }

}


