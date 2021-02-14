package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.block.SewerWeedCropBlock;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;



public class SewerWeedCropSeeds extends Item {

    public SewerWeedCropSeeds(Properties properties) {
        super(properties);
    }

    public static final RegistryObject<Item> SEWERWEED_SEED =
            Registration.ITEMS.register("sewerweed_seed",
                    () -> new BlockItem(SewerWeedCropBlock.SEWERWEED_CROP.get(),
                            new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() { }

}


