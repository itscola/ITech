package top.whitecola.itech.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import top.whitecola.itech.event.ItechItemEvent;
import top.whitecola.itech.utils.ItemUtils;

public class BlockListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void BlockBreakListener(BlockBreakEvent e){
        if(e.isCancelled())
            return;
        ItechItemEvent.onItchItemDestroyBlock(e);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void BlockPlaceListener(BlockPlaceEvent e){
        if(e.isCancelled())
            return;
        ItechItemEvent.onBlockPlace(e);
    }
}
