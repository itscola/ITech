package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.bridges.HiPlayer;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;

public class SlimeSaddle implements IItechItem {
    HiItem hitem;

    public SlimeSaddle(){
        hitem = new HiItem(new ItemStack(Material.SADDLE));
        hitem.setDisplayName("§a§l史莱姆鞍")
                .setLores(Arrays.asList("§a皮革布料很好.","§a软软的.","§a右键玩家或史莱姆可骑乘."))
                .setCustomModelData(20212022)
                .addEnchat(Enchantment.DIG_SPEED,1,true);
    }

    @Override
    public ItemStack getItem(int amount) {
        return hitem.setAmount(amount).getItem();
    }

    @Override
    public ItemStack getItem() {
        return hitem.getItem();
    }


    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public ItemMaterial getType() {
        return ItemMaterial.TOOL;
    }

    @Override
    public void onRightClickEntity(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked().getType()==EntityType.SLIME){
            HiPlayer hiPlayer = new HiPlayer(e.getPlayer());
            try {
                hiPlayer.rideEntity(e.getRightClicked());
                e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SLIME_JUMP,2,2);
            } catch (Throwable throwable) {}
            return;
        }

        if(e.getRightClicked().getType()==EntityType.PLAYER){
            HiPlayer hiPlayer = new HiPlayer(e.getPlayer());
            try {
                hiPlayer.ridePlayer((Player) e.getRightClicked());
                e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SLIME_JUMP,2,2);
            } catch (Throwable throwable) {}
            return;
        }

        e.getPlayer().sendMessage("只能骑玩家或史莱姆. ");
        return;



    }
}
