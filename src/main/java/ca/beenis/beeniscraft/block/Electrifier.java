package ca.beenis.beeniscraft.block;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Electrifier extends Block
{
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(15, 0, 15, 16, 14, 16),
            Block.makeCuboidShape(0, 10, 0, 16, 14, 16),
            Block.makeCuboidShape(4, 14, 8, 12, 15, 13),
            Block.makeCuboidShape(4, 14, 1, 15, 15, 5),
            Block.makeCuboidShape(1, 14, 1, 3, 15, 4),
            Block.makeCuboidShape(2, 18, 9, 14, 24, 10),
            Block.makeCuboidShape(0, 0, 15, 1, 14, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 14, 1),
            Block.makeCuboidShape(7, 15, 10, 9, 21, 11),
            Block.makeCuboidShape(15, 0, 0, 16, 14, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(15, 0, 0, 16, 14, 1),
            Block.makeCuboidShape(0, 10, 0, 16, 14, 16),
            Block.makeCuboidShape(8, 14, 4, 13, 15, 12),
            Block.makeCuboidShape(1, 14, 1, 5, 15, 12),
            Block.makeCuboidShape(1, 14, 13, 4, 15, 15),
            Block.makeCuboidShape(9, 18, 2, 10, 24, 14),
            Block.makeCuboidShape(15, 0, 15, 16, 14, 16),
            Block.makeCuboidShape(0, 0, 15, 1, 14, 16),
            Block.makeCuboidShape(10, 15, 7, 11, 21, 9),
            Block.makeCuboidShape(0, 0, 0, 1, 14, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 1, 14, 1),
            Block.makeCuboidShape(0, 10, 0, 16, 14, 16),
            Block.makeCuboidShape(4, 14, 3, 12, 15, 8),
            Block.makeCuboidShape(1, 14, 11, 12, 15, 15),
            Block.makeCuboidShape(13, 14, 12, 15, 15, 15),
            Block.makeCuboidShape(2, 18, 6, 14, 24, 7),
            Block.makeCuboidShape(15, 0, 0, 16, 14, 1),
            Block.makeCuboidShape(15, 0, 15, 16, 14, 16),
            Block.makeCuboidShape(7, 15, 5, 9, 21, 6),
            Block.makeCuboidShape(0, 0, 15, 1, 14, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 15, 1, 14, 16),
            Block.makeCuboidShape(0, 10, 0, 16, 14, 16),
            Block.makeCuboidShape(3, 14, 4, 8, 15, 12),
            Block.makeCuboidShape(11, 14, 4, 15, 15, 15),
            Block.makeCuboidShape(12, 14, 1, 15, 15, 3),
            Block.makeCuboidShape(6, 18, 2, 7, 24, 14),
            Block.makeCuboidShape(0, 0, 0, 1, 14, 1),
            Block.makeCuboidShape(15, 0, 0, 16, 14, 1),
            Block.makeCuboidShape(5, 15, 7, 6, 21, 9),
            Block.makeCuboidShape(15, 0, 15, 16, 14, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public Electrifier(Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation((state.get(FACING))));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    public static final RegistryObject<Block> ELECTRIFIER = register("electrifier",
            () -> new Electrifier(AbstractBlock.Properties.create(Material.IRON)
                    .harvestTool(ToolType.PICKAXE)));

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));
        return toReturn;
    }

    public static void register() { }
}
