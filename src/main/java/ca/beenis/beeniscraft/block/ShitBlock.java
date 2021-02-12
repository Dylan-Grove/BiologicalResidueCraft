package ca.beenis.beeniscraft.block;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;

import java.util.function.Supplier;

public class ShitBlock extends Block {

        public ShitBlock(Properties properties) {
            super(properties);
        }

    /* ON LEFT CLICK */
    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player)
    {
        if(worldIn.isRemote)
        {
            LogManager.getLogger().info("Hello you left clicked on me, Sir");
        }
        super.onBlockClicked(state, worldIn, pos, player);
    }


    public static final RegistryObject<Block> SHIT_BLOCK = register("shit_block",
            () -> new ShitBlock(AbstractBlock.Properties.create(Material.SPONGE)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.HONEY)));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));
        return toReturn;
    }

}


