package ca.beenis.beeniscraft.block;

import ca.beenis.beeniscraft.block.ShitBlock;
import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class NonBlockBlocks {

    public static final RegistryObject<Block> SHIT_STAIRS =
            register("shit_stairs", () -> new StairsBlock( () -> ShitBlock.SHIT_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.SPONGE)));

    public static final RegistryObject<Block> SHIT_FENCE =
            register("shit_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.SPONGE)));

    public static final RegistryObject<Block> SHIT_FENCE_GATE =
            register("shit_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.SPONGE)));

    public static final RegistryObject<Block> SHIT_BUTTON =
            register("shit_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.SPONGE)));

    public static final RegistryObject<Block> SHIT_PRESSURE_PLATE =
            register("shit_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.SPONGE)));



    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));
        return toReturn;
    }

    public static void register() { }


}
