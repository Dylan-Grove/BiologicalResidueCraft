//test

package ca.beenis.beeniscraft;

import ca.beenis.beeniscraft.block.*;
import ca.beenis.beeniscraft.events.ModEvents;
import ca.beenis.beeniscraft.item.*;
import ca.beenis.beeniscraft.setup.ClientProxy;
import ca.beenis.beeniscraft.setup.IProxy;
import ca.beenis.beeniscraft.setup.ServerProxy;
import ca.beenis.beeniscraft.util.Config;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
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

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public beeniscraft() {

        proxy = DistExecutor.safeRunForDist(() ->ClientProxy::new, () -> ServerProxy::new);


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        registerConfigs();

        proxy.init();

        loadConfigs();

    }

    private void registerConfigs(){

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs(){

        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("beeniscraft-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("beeniscraft-server.toml").toString());
    }

    private void registerModAdditions(){

        //inits the registration of our additions
        Registration.init();

        //register items and blocks added
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
        RawSewage.register();
        RawSewageBucket.register();
        Electrifier.register();

        //register mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
