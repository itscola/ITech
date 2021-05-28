package top.whitecola.itech.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import top.whitecola.itech.event.ItechItemEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void EntityDamageEvent(EntityDamageEvent e){
//        if(e.getEntity().getType()== EntityType.SLIME){
//            if(e.getEntity().getPassenger().getType()==EntityType.PLAYER){
//                e.setCancelled(true);
//            }
//        }

    }



    @EventHandler(priority = EventPriority.MONITOR)
    public void EntityDamageByEntity(EntityDamageByEntityEvent e){
        if(e.isCancelled())
            return;
        ItechItemEvent.onEntityDamageByEntity(e);
    }


    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityShootBow(EntityShootBowEvent e){
        if(e.isCancelled())
            return;
        ItechItemEvent.onEntityShootBowEvent(e);
    }
}
