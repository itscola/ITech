package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;
import java.util.Random;

public class PokeBall implements IItechItem {
    private static final String TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19";

    HiItem hitem;

    public PokeBall(){
        hitem = new HiItem(new ItemStack(Material.IRON_SWORD));
        hitem.setDisplayName("§l精灵球")
                .setLores(Arrays.asList("§l可以将动物装进精灵球.","§l对动物右键使用."))
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
    public void onRightClick(PlayerInteractEvent e) {

    }
}


