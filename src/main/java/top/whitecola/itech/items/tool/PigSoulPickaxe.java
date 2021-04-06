package top.whitecola.itech.items.tool;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;
import java.util.Arrays;

public class PigSoulPickaxe implements IItechItem {
    HiItem hitem;

    public PigSoulPickaxe(){
        hitem = new HiItem(new ItemStack(Material.IRON_PICKAXE));
        hitem.setDisplayName("§f§l猪灵镐")
                .setLores(Arrays.asList("§4很坚固.","§4有些烫手.","§6挖矿物直接变锭."))
                .setCustomModelData(20212021)
                .addEnchat(Enchantment.DIG_SPEED,2,false);
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
    public void onBreakBlockEvent(BlockBreakEvent e) {
        if(e.getBlock().getType()!=Material.COAL_ORE && e.getBlock().getType()!=Material.IRON_ORE && e.getBlock().getType()!=Material.GOLD_ORE)
            return;

        Player p = e.getPlayer();
        p.playSound(e.getPlayer().getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER,2,2);
        Location spawnblockLocation = new Location(e.getBlock().getWorld(), e.getBlock().getLocation().getX(),e.getBlock().getLocation().getY()+1, e.getBlock().getLocation().getZ());
        p.getWorld().spawnParticle(Particle.FLAME,spawnblockLocation,2);
        e.setDropItems(false);


        if(e.getBlock().getType()==Material.COAL_ORE)
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(),new ItemStack(Material.COAL));

        if(e.getBlock().getType()==Material.IRON_ORE)
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(),new ItemStack(Material.IRON_INGOT));

        if(e.getBlock().getType()==Material.GOLD_ORE)
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(),new ItemStack(Material.GOLD_INGOT));

    }
}
