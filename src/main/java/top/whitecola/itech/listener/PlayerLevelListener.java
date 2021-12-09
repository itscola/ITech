package top.whitecola.itech.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import top.whitecola.itech.level.PlayerLevelManager;

public class PlayerLevelListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerPlaceBlock(BlockPlaceEvent e){
        PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).addEXP(5);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent e){
        PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).addEXP(500);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDropItem(PlayerDropItemEvent e){
        PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).addEXP(1);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerFish(PlayerFishEvent e){
        if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH){
            PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).addEXP(12);
            return;
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if(!e.getMessage().startsWith("/")){
            PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).addEXP(20);
        }


        e.setFormat("["+"¡ìe"+PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(e.getPlayer()).getlPlayer().level+"¡ìr]["+e.getPlayer().getWorld().getName()+"] ¡ìr"+e.getPlayer().getName()+"¡ìr: "+(e.getMessage().replace("&","¡ì")));

    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        PlayerLevelManager.getPlayerLevelManager().onPlayerJoinQuest(e);
    }

    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent e){
        PlayerLevelManager.getPlayerLevelManager().onPlayerQuitQuest(e);
    }



}
