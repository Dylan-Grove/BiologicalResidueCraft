package ca.beenis.beeniscraft.setup;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.block.SewerWeedCropBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = beeniscraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ClientProxy implements IProxy{
    @Override
    public void init() {
        RenderTypeLookup.setRenderLayer(SewerWeedCropBlock.SEWERWEED_CROP.get(), RenderType.getCutout());
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
