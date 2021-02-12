package ca.beenis.beeniscraft.events;

import ca.beenis.beeniscraft.item.ShitIngot;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.inventory.FurnaceScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.system.CallbackI;

import java.util.Collection;

public class ModEvents {

    @SubscribeEvent
    public void onShitSlapVillager(PlayerInteractEvent.EntityInteract event) {

        if (event.getPlayer().getHeldItemMainhand().getItem() == ShitIngot.SHIT_INGOT.get()) {

            if (event.getTarget().isAlive()) {

                LivingEntity target = (LivingEntity) event.getTarget();

                if (target instanceof VillagerEntity) {

                    PlayerEntity player = event.getPlayer();

                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.NAUSEA, 600));


                }
            }
        }
    }

    @SubscribeEvent
    public void onShitSlapVillagerDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof VillagerEntity) {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if (entity.isPotionActive(Effects.NAUSEA)) {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ShitIngot.SHIT_INGOT.get())));

                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ShitIngot.SHIT_INGOT.get())));
            }
        }
    }


    @SubscribeEvent
    public void onPickupBurningShitIngot(EntityItemPickupEvent event) {

        PlayerEntity player = event.getPlayer();
        World world = player.getEntityWorld();

        if (event.getItem().getItem().getItem() == (ShitIngot.SHIT_INGOT.get())) {

            if (event.getItem().getEntity().isBurning()) {

                String msg = TextFormatting.RED + ("you have angered the gods of shit by burning the sacred materials");
                player.sendMessage(new StringTextComponent(msg), player.getUniqueID());

                world.createExplosion(player.getEntity(), (player.getPosX()), (player.getPosY()), (player.getPosZ()), 4.5F, (Explosion.Mode.DESTROY));
            }
        }

    }
}