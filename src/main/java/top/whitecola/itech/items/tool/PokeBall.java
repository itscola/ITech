package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;
import top.whitecola.itech.utils.SkullUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class PokeBall implements IItechItem {
    private static final String TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19";

    HiItem hitem;

    public PokeBall() {
        try {
            hitem = new HiItem(new ItemStack(SkullUtils.getSkullItemFromBase64(UUID.nameUUIDFromBytes(TEXTURE.getBytes(StandardCharsets.UTF_8)),TEXTURE).orElse(new ItemStack(Material.PLAYER_HEAD))));
        } catch (Throwable throwable) {
            hitem = new HiItem(new ItemStack(Material.PLAYER_HEAD));
        }

        hitem.setDisplayName("§l精灵球")
                .setLores(Arrays.asList("§f§l将动物装进精灵球.", "§f§l对羊/牛/猪 左键使用."))
                .setCustomModelData(202105282);
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
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player))
            return;

        Player p = ((Player)e.getDamager());

        if (!(e.getEntity() instanceof LivingEntity))
            return;



        EntityType entityType = e.getEntityType();

        int randomNumber = new Random().nextInt(10);
        if(!(randomNumber>=3 && randomNumber <=7)){
            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
            p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BREAK,2,2);
            e.setCancelled(true);
            return;
        }



        if(entityType == EntityType.COW) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.COW_SPAWN_EGG));
        }else if(entityType == EntityType.SHEEP) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SHEEP_SPAWN_EGG));
        }else if(entityType == EntityType.PIG) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.PIG_SPAWN_EGG));
        }else{
            return;
        }

        e.getEntity().remove();
        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
        p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER,2,2);
        e.setCancelled(true);

    }


}


