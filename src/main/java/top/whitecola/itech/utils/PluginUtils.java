package top.whitecola.itech.utils;

import org.bukkit.entity.Player;

public class PluginUtils {
    public static void sendPluginMessageToPlayer(Player player,String msg){
        player.sendMessage(""+msg);
    }
}
