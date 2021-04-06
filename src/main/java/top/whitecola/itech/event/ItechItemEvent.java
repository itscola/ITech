package top.whitecola.itech.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import top.whitecola.itech.items.ItemHandle;
import top.whitecola.itech.utils.ItemUtils;

public class ItechItemEvent {

    public static void onItchItemDestroyBlock(BlockBreakEvent e){
        if(!ItemUtils.hasItemCustomModelData(e.getPlayer().getInventory().getItemInMainHand()))
            return;

        ItemHandle.items.forEach(i->{
            if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                return;

            if(i.getItem().getItemMeta().getCustomModelData()==e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                i.onBreakBlockEvent(e);
            }
        });
    }

    public static void onPlayerRightClickEntity(PlayerInteractAtEntityEvent e){
        if(!ItemUtils.hasItemCustomModelData(e.getPlayer().getInventory().getItemInMainHand()))
            return;

        ItemHandle.items.forEach(i->{
            if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                return;

            if(i.getItem().getItemMeta().getCustomModelData()==e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                i.onRightClickEntity(e);
            }
        });
    }

    public static void onPlayerRightClick(PlayerInteractEvent e){
        if(!ItemUtils.hasItemCustomModelData(e.getPlayer().getInventory().getItemInMainHand()))
            return;

        ItemHandle.items.forEach(i->{
            if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                return;

            if(i.getItem().getItemMeta().getCustomModelData()==e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                i.onRightClick(e);
            }
        });
    }

    public static void onBlockPlace(BlockPlaceEvent e){
        if(!ItemUtils.hasItemCustomModelData(e.getPlayer().getInventory().getItemInMainHand()))
            return;

        ItemHandle.items.forEach(i->{
            if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                return;

            if(i.getItem().getItemMeta().getCustomModelData()==e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                i.onBlockPlace(e);
            }
        });
    }

    public static void onEntityDamageByEntity(EntityDamageByEntityEvent e){
        boolean isBow = false;
        if ((e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity)) {

            if(!ItemUtils.hasItemCustomModelData( ((Player)e.getDamager()).getInventory().getItemInMainHand()))
                return;

        }else if(e.getDamager() instanceof Projectile && e.getEntity() instanceof LivingEntity ){
            Projectile pj = (Projectile)e.getDamager();
            if(pj.getShooter() instanceof Player){

                if(!ItemUtils.hasItemCustomModelData( ((Player)(pj.getShooter())).getInventory().getItemInMainHand()))
                    return;
                isBow = true;

            }
        }


        boolean finalIsBow = isBow;
        ItemHandle.items.forEach(i->{
            if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                return;
            if(finalIsBow){

                if(i.getItem().getItemMeta().getCustomModelData()==((Player)(((Projectile)e.getDamager()).getShooter())).getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                    i.onEntityDamageByEntity(e);
                }
                return;
            }
            if(i.getItem().getItemMeta().getCustomModelData()==((Player)e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                i.onEntityDamageByEntity(e);
            }
        });
    }

    public static void onEntityShootBowEvent(EntityShootBowEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            ItemHandle.items.forEach(i->{
                if(!ItemUtils.hasItemCustomModelData(i.getItem()))
                    return;

                if(i.getItem().getItemMeta().getCustomModelData()==p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData()){
                    i.onEntityShootBow(e);
                }
            });
        }
    }
}
