package top.whitecola.itech.utils;


import org.bukkit.inventory.ItemStack;

public class ItemUtils {

    public static boolean isItchItem(ItemStack item){
        if(item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData()>=20212021)
            return true;
        return false;
    }

    public static boolean hasItemCustomModelData(ItemStack item){
        if(item.hasItemMeta() && item.getItemMeta().hasCustomModelData())
            return true;
        return false;
    }


}
