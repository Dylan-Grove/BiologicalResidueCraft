//test

package ca.beenis.beeniscraft;

import ca.beenis.beeniscraft.block.*;
import ca.beenis.beeniscraft.events.ModEvents;
import ca.beenis.beeniscraft.item.*;
import ca.beenis.beeniscraft.util.Config;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(beeniscraft.MOD_ID)
public class beeniscraft
{
    public  static final String MOD_ID = "beeniscraft";

    public static  final ItemGroup BEENISCRAFT_TAB = new ItemGroup("beeniscraft") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ShitIngot.SHIT_INGOT.get());
        }
    };

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public beeniscraft() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        Registration.register();
        ShitBlock.register();
        ShitOre.register();
        ShitWire.register();
        ShitIngot.register();
        ShitPickaxe.register();
        CanOfShit.register();
        ShitArmor.register();
        NonBlockBlocks.register();
        SewerWeedCropSeeds.register();
        SewerWeedCropBlock.register();


        MinecraftForge.EVENT_BUS.register(new ModEvents());

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("beeniscraft-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("beeniscraft-server.toml").toString());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    // comment!
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(SewerWeedCropBlock.SEWERWEED_CROP.get(), RenderType.getCutout());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
