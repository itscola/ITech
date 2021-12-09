package top.whitecola.itech.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.whitecola.annotations.ItsACommand;
import top.whitecola.commandhandler.ICommand;
import top.whitecola.itech.ITech;

import java.util.List;

public class Level implements ICommand {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        return false;
    }

    @Override
    public List<String> getArgs() {
        return ICommand.super.getArgs();
    }

    @Override
    public List<String> handleArg(CommandSender sender, String handleArg) {
        return ICommand.super.handleArg(sender, handleArg);
    }

    @Override
    public String getUsage() {
        return ICommand.super.getUsage();
    }

    @Override
    public String getUsageDescripition() {
        return ICommand.super.getUsageDescripition();
    }
}
