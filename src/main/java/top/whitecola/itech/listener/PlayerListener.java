package top.whitecola.itech.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.ITech;
import top.whitecola.itech.event.ItechItemEvent;
import top.whitecola.itech.items.items.AntiGravityStone;
import top.whitecola.itech.items.tool.PigSoulPickaxe;
import top.whitecola.itech.items.tool.SlimeBow;
import top.whitecola.itech.level.PlayerLevelManager;
import top.whitecola.itech.level.struct.RewardPlayer;

public class PlayerListener implements Listener {



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


    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent e){
        for(RewardPlayer.Player rewardPlayer : ITech.instance.rewardPlayerHiConfig.getConfig().rewardPlayers){
            if(rewardPlayer.uuid.equals(e.getPlayer().getUniqueId().toString())){
                return;
            }
        }

        ITech.instance.rewardPlayerHiConfig.getConfig().rewardPlayers.add(new RewardPlayer.Player(e.getPlayer().getName(),e.getPlayer().getUniqueId().toString()));
        ITech.instance.rewardPlayerHiConfig.saveConfig();
        e.getPlayer().getInventory().addItem(new PigSoulPickaxe().getItem(1));
        e.getPlayer().getInventory().addItem(new SlimeBow().getItem(1));
        e.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK,1));
        e.getPlayer().sendMessage("§a 你已领取内测参与奖励。");
    }
}
