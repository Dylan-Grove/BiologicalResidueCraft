package ca.beenis.beeniscraft.util;


import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;


@Mod.EventBusSubscriber
public class Config {

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue SHIT_INGOT_EXPLOSION;

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        shitIngotExplosionEnabled(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void shitIngotExplosionEnabled(ForgeConfigSpec.Builder SERVER_BUILDER,
                                                  ForgeConfigSpec.Builder CLIENT_BUILDER){

        SHIT_INGOT_EXPLOSION = CLIENT_BUILDER.comment("Whether or the shit ingot will explode if you light it on fire.")
                .define("shit_ingot_explosion",true);

    }

    public static void loadConfigFile(ForgeConfigSpec config, String path)
    {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();

        file.load();
        config.setConfig(file);
    }
}


