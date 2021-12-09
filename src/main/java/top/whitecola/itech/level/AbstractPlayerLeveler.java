package top.whitecola.itech.level;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import top.whitecola.itech.ITech;
import top.whitecola.itech.level.struct.LevelPlayer;
import top.whitecola.itech.utils.PluginUtils;

import java.util.UUID;

public abstract class AbstractPlayerLeveler implements ILevelChanger,ILevelGetter {
    private LevelPlayer.Player lPlayer;
    private OfflinePlayer offlinePlayer;

    public AbstractPlayerLeveler(LevelPlayer.Player lPlayer){
        this.lPlayer = lPlayer;
        initLevelPlayer();
    }

    public void updateLevel() {
//        int level = (int) (lPlayer.exp / 1000);
//        if(level>lPlayer.level){
//            lPlayer.level = level;
//            lPlayer.exp = 0;
//            playerUpdateMessage();
//            return;
//        }
        if(lPlayer.exp>=1000){
            int toUpLevel = (int) (lPlayer.exp / 1000);
            double remainingExperience = lPlayer.exp - (toUpLevel*1000);
            this.lPlayer.level += toUpLevel;
            this.lPlayer.exp = remainingExperience;
            playerUpdateMessage();
            ITech.instance.levelPlayers.saveConfig();
            return;
        }
    }

    protected void playerUpdateMessage(){
        Player player = ((Player) offlinePlayer);
        if(!player.isOnline())
            return;

        // a server-side bug
        Player bugPlayer = Bukkit.getPlayer(player.getUniqueId());

        if(bugPlayer==null||!bugPlayer.isOnline())
            return;

        bugPlayer.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,2,2);
        PluginUtils.sendPluginMessageToPlayer(bugPlayer,"§e你的生存等级提升至"+lPlayer.level+"级！");
//        PluginUtils.sendPluginMessageToPlayer(bugPlayer,"§e输入 /itech level 查看等级奖励。");
//        bugPlayer.spigot().sendMessage(new ComponentBuilder("(或点击此处查看)").event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/itech level")).create());
        bugPlayer.setPlayerListName("[§e"+lPlayer.level+"§r] "+bugPlayer.getPlayer().getName());
    }

    public void initLevelPlayer(){
        this.offlinePlayer = getOfflinePlayer();
//        this.lPlayer = loadLevelPlayer();
        updateLevel();
    }

//    private LevelPlayer.Player loadLevelPlayer(){
//        for(LevelPlayer.Player lplayer : ITech.instance.levelPlayers.getConfig().players){
//            if(lplayer.uuid.equals(player.getUniqueId().toString())){
//                return lplayer;
//            }
//        }
//        LevelPlayer.Player lp = new LevelPlayer.Player(this.player.getUniqueId().toString(),0,0,false);
//        ITech.instance.levelPlayers.getConfig().players.add(lp);
//        return lp;
//    }

    private OfflinePlayer getOfflinePlayer(){
        OfflinePlayer offlinePlayer = lPlayer.toOfflinePlayer();
        if(offlinePlayer!=null&&offlinePlayer.isOnline())
            return offlinePlayer;
        return null;
    }


    public LevelPlayer.Player getlPlayer() {
        return lPlayer;
    }

    @Override
    public int getCurrentLevel() {
        return getlPlayer().level;
    }

    @Override
    public double GainEXPNeededToUpgrade(int level) {
        double exp =  level*1000;
        double currentEXP = getlPlayer().exp;

        return exp - currentEXP;

    }

    @Override
    public double getNextLevelNeededEXP() {
        int currentLevel = getlPlayer().level;
        return GainEXPNeededToUpgrade(currentLevel+1);
    }

}
