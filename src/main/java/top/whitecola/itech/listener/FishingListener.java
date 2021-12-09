package top.whitecola.itech.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import top.whitecola.itech.ITech;

public class FishingListener implements Listener {

    @EventHandler
    public void onPlayerFishing(PlayerFishEvent e){
        if(e.getState()!= PlayerFishEvent.State.CAUGHT_FISH)
            return;

        ITech.instance.fishingFeature.onFeature(e);


    }
}
