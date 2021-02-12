package ca.beenis.beeniscraft.item;

import ca.beenis.beeniscraft.beeniscraft;
import ca.beenis.beeniscraft.util.KeyboardHelper;
import ca.beenis.beeniscraft.util.Registration;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;

public class CanOfShit extends Item {

    public CanOfShit(Properties properties) {

        super(new Properties().group(beeniscraft.BEENISCRAFT_TAB)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(1.5f)
                        .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 3), 1)
                        .build()));
    }

    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag){

        if(KeyboardHelper.isHoldingShift()){

            tooltip.add(new StringTextComponent("Villagers will eat this but they can never digest it."));
        }
        else{
            tooltip.add(new StringTextComponent("Hold"+"\u00A7e" + " SHIFT " + "\u00A77" + "for more information!" ));
        }

        super.addInformation(stack, world, tooltip, flag);
    }


    public  static final RegistryObject<Item> CAN_OF_SHIT =
            Registration.ITEMS.register("can_of_shit",
                    () -> new CanOfShit(new Item.Properties().group(beeniscraft.BEENISCRAFT_TAB)));

    public static void register() { }
}
