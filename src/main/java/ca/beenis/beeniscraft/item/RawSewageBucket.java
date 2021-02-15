package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.block.RawSewage;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;



public class RawSewageBucket  {

    public static final RegistryObject<Item> RAWSEWAGE_BUCKET =
            Registration.ITEMS.register("rawsewage_bucket",
                    () -> new BucketItem(RawSewage.RAWSEWAGE_FLUID::get,
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB).maxStackSize(1)));

    public static void register() { }

}


