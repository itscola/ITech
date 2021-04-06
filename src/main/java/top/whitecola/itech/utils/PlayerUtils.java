package top.whitecola.itech.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerUtils {
    public static void removeOneItemInHand(Player p){
        ItemStack oneItem = new ItemStack(p.getInventory().getItemInMainHand());
        oneItem.setAmount(1);
        p.getInventory().remove(oneItem);
        p.updateInventory();
    }
}
