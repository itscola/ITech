package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;

public class SlimeSaddle implements IItechItem {
    HiItem hitem;

    public SlimeSaddle(){
        hitem = new HiItem(new ItemStack(Material.SADDLE));
        hitem.setDisplayName("��b��lѩ��֮��")
                .setLores(Arrays.asList("��bƤ�ﲼ�Ϻܺ�.","��b�����.","��b�Ҽ� ���/ʷ��ķ/ţ/ �����."))
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
            e.getRightClicked().addPassenger(e.getPlayer());
        }

        if(e.getRightClicked().getType()==EntityType.PLAYER){
            e.getRightClicked().addPassenger(e.getPlayer());
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SLIME_JUMP,2,2);
            return;
        }

        if(e.getRightClicked().getType()==EntityType.COW){
            e.getRightClicked().addPassenger(e.getPlayer());
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_SLIME_JUMP,2,2);
            return;
        }


        e.getPlayer().sendMessage("ֻ������һ�ʷ��ķ. ");
        return;



    }
}
