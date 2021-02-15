package ca.beenis.beeniscraft.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld();

}
