package top.whitecola.itech.level;


import de.slikey.effectlib.effect.CircleEffect;
import de.slikey.effectlib.effect.TextEffect;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.ITech;
import top.whitecola.itech.items.tool.PokeBall;
import top.whitecola.itech.items.tool.SlimeSaddle;
import top.whitecola.itech.level.struct.LevelPlayer;
import top.whitecola.itech.utils.PluginUtils;

import java.util.Arrays;
import java.util.Vector;

public class PlayerLevelManager {
    private static PlayerLevelManager playerLevelManager = new PlayerLevelManager();
    private Vector<AbstractPlayerLeveler> onlinePlayerLevelerVector = new Vector<>();

    private PlayerLevelManager(){}

    public static PlayerLevelManager getPlayerLevelManager() {
        return playerLevelManager;
    }

    @Deprecated
    public AbstractPlayerLeveler getPlayerLevelerByName(String name){
        return getPlayerLeveler(Bukkit.getOfflinePlayer(name).getUniqueId().toString());
    }

    public AbstractPlayerLeveler getPlayerLeveler(Player player){
        return getPlayerLeveler(player.getUniqueId().toString());
    }

    public AbstractPlayerLeveler getPlayerLeveler(String uuid){
        for(AbstractPlayerLeveler playerLeveler : onlinePlayerLevelerVector){
            if(playerLeveler.getlPlayer().uuid.equalsIgnoreCase(uuid)){
                return playerLeveler;
            }
        }

        for(LevelPlayer.Player lPlayer : ITech.instance.levelPlayers.getConfig().players){
            if(uuid.equals(lPlayer.uuid)){
                return new OfflinePlayerLeveler(lPlayer);
            }
        }

        return null;
    }

    public synchronized void onPlayerJoinQuest(PlayerJoinEvent e){
        e.getPlayer().sendMessage("欢迎来到 Revoll MC 服务器");
        e.getPlayer().sendMessage("玩得开心~");
        e.getPlayer().sendMessage("内测路上，有你真好。");
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP,2,2);


        addPlayerToOnlineList(e.getPlayer());
        e.getPlayer().setPlayerListName("[§e"+getPlayerLeveler(e.getPlayer()).getlPlayer().level+"§r] "+e.getPlayer().getName());

    }

    public synchronized void onPlayerQuitQuest(PlayerQuitEvent e){
        AbstractPlayerLeveler playerLeveler = getPlayerLeveler(e.getPlayer().getUniqueId().toString());
        if(playerLeveler==null || playerLeveler instanceof OfflinePlayerLeveler)
            return;

        this.onlinePlayerLevelerVector.remove(playerLeveler);
        ITech.instance.levelPlayers.saveConfig();
    }

    public void addPlayerToOnlineList(Player player){
        if(player==null|| !player.isOnline())
            return;


        if(!addToOnlineFirst(player)) {
            ITech.instance.levelPlayers.getConfig().players.add(new LevelPlayer.Player(player.getUniqueId().toString(), 0, 0));
            newPlayerReward(player);
        }
        addToOnlineFirst(player);
    }

    private boolean addToOnlineFirst(Player player){
        for(LevelPlayer.Player lPlayer : ITech.instance.levelPlayers.getConfig().players){
            if(!lPlayer.uuid.equals(player.getUniqueId().toString()))
                continue;

            this.onlinePlayerLevelerVector.add(new PlayerLeveler(lPlayer));
            return true;

        }
        return false;
    }



    public boolean isInOnlineList(Player player){
        if(player==null|| !player.isOnline())
            return false;
        if(this.onlinePlayerLevelerVector.contains(getPlayerLeveler(player)))
            return true;
        return false;

    }


    public void newPlayerReward(Player player){
        player.getInventory().addItem(new PokeBall().getItem(5));
        player.getInventory().addItem(new HiItem(new ItemStack(Material.BREAD,32)).setDisplayName("§e新人面包").setLores(Arrays.asList("§f欢迎新人~")).getItem());
        player.getInventory().addItem(new HiItem(new ItemStack(Material.SPYGLASS)).getItem());
        CircleEffect circleEffect = new CircleEffect(ITech.instance.effectManager);
        circleEffect.setLocation(new Location(player.getWorld(),player.getLocation().getBlockX(),player.getLocation().getBlockY()+2,player.getLocation().getBlockZ()));
        circleEffect.delay = 2;
        circleEffect.iterations = 80;
        circleEffect.particle = Particle.HEART;
        circleEffect.start();

        player.sendRawMessage("不错的选择。");
    }

}
