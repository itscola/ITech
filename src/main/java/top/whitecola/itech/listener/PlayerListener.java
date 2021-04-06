package top.whitecola.itech.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import top.whitecola.itech.event.ItechItemEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerRightClickEntity(PlayerInteractAtEntityEvent e){
        if(e.isCancelled())
            return;
        if(e.getHand().equals(EquipmentSlot.HAND)) {
                ItechItemEvent.onPlayerRightClickEntity(e);
        }

    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerRightClick(PlayerInteractEvent e){
        ItechItemEvent.onPlayerRightClick(e);
    }

}
