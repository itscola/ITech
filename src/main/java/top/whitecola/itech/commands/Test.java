package top.whitecola.itech.commands;

import de.slikey.effectlib.effect.CircleEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.whitecola.annotations.ItsACommand;
import top.whitecola.commandhandler.ICommand;
import top.whitecola.itech.ITech;

import java.util.List;

@ItsACommand(CommandNmae = "test",premission = "itech.test")
public class Test implements ICommand{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            CircleEffect circleEffect = new CircleEffect(ITech.instance.effectManager);
            circleEffect.radius = 1.2f;
            circleEffect.particle = Particle.SPELL_WITCH;
            circleEffect.iterations = 80;
            circleEffect.particleCount = 10;
            circleEffect.setLocation(new Location(p.getLocation().getWorld(),p.getLocation().getX(),p.getLocation().getY()+1,p.getLocation().getZ()));
            circleEffect.start();
            p.playSound(p.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT,2,2);

        }
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
        return ICommand.super.getUsage();
    }

    @Override
    public String getUsageDescripition() {
        return ICommand.super.getUsageDescripition();
    }
}
