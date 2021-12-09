package top.whitecola.itech.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.whitecola.annotations.ItsACommand;
import top.whitecola.commandhandler.ICommand;
import top.whitecola.itech.level.PlayerLevelManager;

import java.util.List;

@ItsACommand(CommandNmae = "uplevel",premission = "itech.uplevel")
public class UpLevel implements ICommand {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player))
            return false;

        Player player = (Player) commandSender;
        PlayerLevelManager.getPlayerLevelManager().getPlayerLeveler(player).addEXP(1000);
        return true;
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
        return "/uplevel";
    }

    @Override
    public String getUsageDescripition() {
        return "等级提升测试";
    }
}
