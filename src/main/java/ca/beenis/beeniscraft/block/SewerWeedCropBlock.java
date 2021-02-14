package ca.beenis.beeniscraft.block;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import java.util.function.Supplier;

public class SewerWeedCropBlock extends Block {

    public SewerWeedCropBlock(Properties properties) {
        super(properties);
    }

    public static final RegistryObject<Block> SEWERWEED_CROP =
            Registration.BLOCKS.register("sewerweed_crop",
                    () -> new SewerWeedCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));
        return toReturn;
    }

}


