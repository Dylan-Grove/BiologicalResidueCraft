package ca.beenis.beeniscraft.setup;

import net.minecraft.world.World;

public class ServerProxy implements IProxy{
    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Cannot run on Server!");
    }
}
