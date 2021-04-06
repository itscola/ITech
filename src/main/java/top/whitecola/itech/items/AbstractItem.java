package top.whitecola.itech.items;

import org.bukkit.inventory.ItemStack;

public abstract class AbstractItem {
    ItemStack itemstack;

    public AbstractItem(ItemStack itemStack){
        this.itemstack =  itemStack;
    }

//    public boolean equals(ItemStack itemStack){
//        if(){
//
//        }
//        return false;
//    }
}
