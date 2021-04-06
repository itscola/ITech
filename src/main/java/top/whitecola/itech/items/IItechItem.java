package top.whitecola.itech.items;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.itech.Type.ItemMaterial;

public interface IItechItem {
    default void iItechItem() {

    }


    default ItemStack getItem(int amount){
        return null;
    }

    default ItemStack getItem(){
        return null;
    }

    default String getSimpleName(){
        return "";
    }

    default ItemMaterial getType(){
        return ItemMaterial.ITEM;
    }

    default void onBreakBlockEvent(BlockBreakEvent e){

    }

    default void onRightClickEntity(PlayerInteractAtEntityEvent e){

    }

    default void onRightClick(PlayerInteractEvent e){

    }

    default void onBlockPlace(BlockPlaceEvent e){

    }

    default void onEntityDamageByEntity(EntityDamageByEntityEvent e){

    }

    default void onEntityShootBow(EntityShootBowEvent e){

    }
}
