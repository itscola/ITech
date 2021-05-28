package top.whitecola.itech.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import top.whitecola.annotations.ItsACommand;
import top.whitecola.commandhandler.ICommand;
import top.whitecola.itech.items.ItemHandle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ItsACommand(CommandNmae = "giveitem",premission = "itech.giveitem")
public class GiveItem implements ICommand {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length<3)
            return false;
        ItemStack item;

        try {
            if((item = args.length==4?ItemHandle.getItemByName(args[1]).getItem(Integer.parseInt(args[3])):ItemHandle.getItemByName(args[1]).getItem()) == null)
                return false;
        }catch (IllegalArgumentException e){
            return false;
        }

        Player p = Bukkit.getPlayer(args[2]);

        if(p==null||!p.isOnline()) {
            commandSender.sendMessage("���" + args[2] + "������!");
            return true;
        }

        p.getInventory().addItem(item);
        p.sendMessage("�ѽ�"+args[1]+"��������ı���.");
        return true;
    }

    @Override
    public List<String> getArgs() {
        return Arrays.asList("[ItechItem]","[OnlinePlayer]","[amount]");
    }

    @Override
    public List<String> handleArg(CommandSender sender, String handleArg) {
        switch (handleArg){
            case "[ItechItem]":
                return ItemHandle.items.stream().map(i->i.getSimpleName()).collect(Collectors.toList());
            case "[OnlinePlayer]":
                return Bukkit.getOnlinePlayers().stream().map(i->i.getName()).collect(Collectors.toList());
        }

        return Arrays.asList(handleArg);
    }

    @Override
    public String getUsage() {
        return "/itech give <itechItem> <Player> [amount]";
    }

    @Override
    public String getUsageDescripition() {
        return "�����itech����Ʒ.";
    }
}
