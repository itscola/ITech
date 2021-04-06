package top.whitecola.itech;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import top.whitecola.HiPlugin;
import top.whitecola.commandhandler.HiCommand;
import top.whitecola.itech.commands.GiveItem;
import top.whitecola.itech.items.ItemHandle;
import top.whitecola.itech.listener.BlockListener;
import top.whitecola.itech.listener.EntityListener;
import top.whitecola.itech.listener.PlayerListener;

import java.util.List;

public class ITech extends JavaPlugin {
    public static ITech instance = null;
    {
        instance = this;
    }
    public ItemHandle itemHandle = new ItemHandle();
    public HiCommand commands = new HiCommand(instance,"itech");


    @Override
    public void onEnable() {
        HiPlugin.instance.registerPlugin(instance);
        System.out.println("ITech“—∆Ù∂Ø.");
        registerListener();
        registerCommands();
    }

    public void registerListener(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(),this);
        Bukkit.getPluginManager().registerEvents(new EntityListener(),this);
    }

    public void registerCommands(){
        commands.addCommand(new GiveItem());
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
