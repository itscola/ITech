package top.whitecola.itech.items.items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;
import top.whitecola.itech.utils.PlayerUtils;
import top.whitecola.itech.utils.SkullUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

public class AntiGravityStone implements IItechItem {
    private static final String TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY4MDkzYTJmMWE3MGQxOGZhNzhjMDIwN2UzZmExM2JiYTBjYjUyNjg1MTM3N2Y1N2I2MGM3MWViZTQ1NGJlZiJ9fX0=";

    HiItem hitem;

    public AntiGravityStone(){
        try {
            hitem = new HiItem(new ItemStack(SkullUtils.getSkullItemFromBase64(UUID.nameUUIDFromBytes(TEXTURE.getBytes(StandardCharsets.UTF_8)),TEXTURE).orElse(new ItemStack(Material.PLAYER_HEAD))));
        } catch (Throwable throwable) {
            hitem = new HiItem(new ItemStack(Material.PLAYER_HEAD));
        }
        hitem.setDisplayName("§2§l反重力石")
                .setLores(Arrays.asList("§2嗡鸣声不断.","§2在发光.","§f拿在主位置,右键获得3秒漂浮效果."))
                .setCustomModelData(20212023)
        ;
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
        return ItemMaterial.ITEM;
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {
        e.setCancelled(true);
        if(e.getAction()==Action.LEFT_CLICK_AIR || e.getAction()==Action.LEFT_CLICK_BLOCK){
            return;
        }

        if(e.getPlayer().hasPotionEffect(PotionEffectType.LEVITATION)){
            e.getPlayer().sendMessage("拥有漂浮效果时,无法使用该物品");
            return;
        }

        if(e.getPlayer().getInventory().getItemInMainHand().equals(e.getItem())){
            e.getPlayer().getInventory().setItemInMainHand(new HiItem(e.getItem()).setAmount(e.getItem().getAmount()-1).getItem());
        }else{
            e.getPlayer().getInventory().setItemInOffHand(new HiItem(e.getItem()).setAmount(e.getItem().getAmount()-1).getItem());
        }

        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,2,2);
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,70,2));
    }

    @Override
    public void onBlockPlace(BlockPlaceEvent e) {
    }
}
