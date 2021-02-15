package ca.beenis.beeniscraft.block;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.item.RawSewageBucket;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class RawSewage {

    public static final ResourceLocation RAWSEWAGE_STILL_RL = new ResourceLocation(beeniscraft.MOD_ID,
            "block/rawsewage_still");

    public static final ResourceLocation RAWSEWAGE_FLOWING_RL = new ResourceLocation(beeniscraft.MOD_ID,
            "block/rawsewage_flowing");

    public static final ResourceLocation RAWSEWAGE_OVERLAY_RL = new ResourceLocation(beeniscraft.MOD_ID,
            "block/rawsewage_overlay");

    public static final RegistryObject<FlowingFluid> RAWSEWAGE_FLUID
            = Registration.FLUIDS.register("rawsewage_fluid",
            () -> new ForgeFlowingFluid.Source(RawSewage.RAWSEWAGE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> RAWSEWAGE_FLOWING
            = Registration.FLUIDS.register("rawsewage_flowing",
            () -> new ForgeFlowingFluid.Flowing(RawSewage.RAWSEWAGE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties RAWSEWAGE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> RAWSEWAGE_FLUID.get(), () -> RAWSEWAGE_FLOWING.get(), FluidAttributes.builder(RAWSEWAGE_STILL_RL, RAWSEWAGE_FLOWING_RL)
            .density(30).luminosity(2).rarity(Rarity.RARE).sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(RAWSEWAGE_OVERLAY_RL)
            .viscosity(5)).slopeFindDistance(3).levelDecreasePerBlock(3)
            .block(() -> RawSewage.RAWSEWAGE_BLOCK.get()).bucket(() -> RawSewageBucket.RAWSEWAGE_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> RAWSEWAGE_BLOCK = Registration.BLOCKS.register("rawsewage",
            () -> new FlowingFluidBlock(() -> RawSewage.RAWSEWAGE_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

    public static void register() {
    }

}