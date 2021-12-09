package top.whitecola.itech.items;

import org.bukkit.inventory.ItemStack;
import top.whitecola.bridges.HiItemSerialization;
import top.whitecola.itech.items.food.Hambuger;
import top.whitecola.itech.items.items.AntiGravityStone;
import top.whitecola.itech.items.tool.*;

import java.util.Vector;

public class ItemHandle {
    public static Vector<IItechItem> items = new Vector<>();

    public ItemHandle(){
        try {
            registerItem();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static IItechItem getItemByName(String name){
        for(IItechItem itechItem : items){
            if(itechItem.getSimpleName().equalsIgnoreCase(name)){
                return itechItem;
            }
        }
        return null;
    }

    public void registerItem() throws Throwable{
        items.add(new PigSoulPickaxe());
        items.add(new Hambuger());
        items.add(new SlimeSaddle());
        items.add(new AntiGravityStone());
        items.add(new SlimeBow());
        items.add(new SuperHotSword());
        items.add(new PokeBall());
        items.add(new SeaAXE());
    }

    public static boolean wasItIgnoreDur(ItemStack item, IItechItem itechItem){
        try {

            System.out.println(HiItemSerialization.getItemNBTTagString(item));
            System.out.println(HiItemSerialization.getItemNBTTagString(itechItem.getItem()));

        }catch (Throwable e){
            e.printStackTrace();
        }

       return false;
    }

    public static boolean wasIt(ItemStack item, IItechItem itechItem){
        if(item.equals(itechItem.getItem())){
            return true;
        }
        return false;
    }

    public static ItemStack getItemAsCopy(ItemStack item){
        return getItemAsCopy(item,1);
    }

    public static ItemStack getItemAsCopy(ItemStack item,int amount){
        for(IItechItem itechItem : items){
            if(wasIt(item,itechItem)){
                return itechItem.getItem(amount);
            }
        }
        return item;
    }


}
