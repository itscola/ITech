package top.whitecola.itech;

import de.slikey.effectlib.EffectManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import top.whitecola.HiPlugin;
import top.whitecola.commandhandler.HiCommand;
import top.whitecola.confighandler.HiConfig;
import top.whitecola.itech.commands.GiveItem;
import top.whitecola.itech.commands.Test;
import top.whitecola.itech.commands.UpLevel;
import top.whitecola.itech.feature.FishingFeature;
import top.whitecola.itech.items.ItemHandle;
import top.whitecola.itech.level.PlayerLevelManager;
import top.whitecola.itech.level.struct.LevelPlayer;
import top.whitecola.itech.level.struct.RewardPlayer;
import top.whitecola.itech.listener.*;

import java.nio.charset.Charset;
import java.util.List;

public class ITech extends JavaPlugin {
    public static ITech instance = null;
    {
        instance = this;
    }
    public ItemHandle itemHandle = new ItemHandle();

    public HiCommand commands = new HiCommand(instance,"itech");
    public EffectManager effectManager;
    public HiConfig<LevelPlayer> levelPlayers = new HiConfig<>(this.getDataFolder() + "/levelPlayer.json",LevelPlayer.class, Charset.forName("utf8"),instance);
    private PlayerLevelManager playerLevelManager;
    public FishingFeature fishingFeature = new FishingFeature();

    public HiConfig<RewardPlayer> rewardPlayerHiConfig = new HiConfig<>(this.getDataFolder() + "/rewardPlayer.json",RewardPlayer.class, Charset.forName("utf8"),instance);


    @Override
    public void onEnable() {
        HiPlugin.instance.registerPlugin(instance);
        System.out.println("ITech“—∆Ù∂Ø.");
        effectManager = new EffectManager(this);
        playerLevelManager = PlayerLevelManager.getPlayerLevelManager();
        registerListener();
        registerCommands();
        registerPlayerToLevelManager();

    }

    @Override
    public void onDisable() {
        this.levelPlayers.saveConfig();
    }

    public void registerPlayerToLevelManager(){
        for(Player player : Bukkit.getOnlinePlayers()){

            if(!PlayerLevelManager.getPlayerLevelManager().isInOnlineList(player)) {
                PlayerLevelManager.getPlayerLevelManager().addPlayerToOnlineList(player);

            }

        }
    }

    public void registerListener(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(),this);
        Bukkit.getPluginManager().registerEvents(new EntityListener(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerLevelListener(),this);
        Bukkit.getPluginManager().registerEvents(new FishingListener(),this);
    }

    public void registerCommands(){
        commands.addCommand(new GiveItem());
        commands.addCommand(new UpLevel());
        commands.addCommand(new Test());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("itech")){
            return commands.onCommand(sender,command,label,args);
        }
        return super.onCommand(sender, command, label, args);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("itech")){
            return commands.onTabComplete(sender,command,alias,args);
        }
        return super.onTabComplete(sender, command, alias, args);
    }
}
