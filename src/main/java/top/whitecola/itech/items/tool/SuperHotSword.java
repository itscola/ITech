package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;
import java.util.Random;

public class SuperHotSword implements IItechItem {
    HiItem hitem;

    public SuperHotSword(){
        hitem = new HiItem(new ItemStack(Material.IRON_SWORD));
        hitem.setDisplayName("¡ìc¡ìl³ãÈÈÖ®½£")
                .setLores(Arrays.asList("¡ì6½«µĞÈËÉÕÎªÌ¿»Ò.","¡ì6»ğÑæ¸½Ä§.","¡ì6ÓĞ¸ÅÂÊ½«µĞÈËÉÕ³ÉÌ¿."))
                .setCustomModelData(20210528)
                .addEnchat(Enchantment.FIRE_ASPECT,1,true);
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
        if(!(e.getDamager() instanceof Player))
            return;

        if(!(e.getEntity() instanceof LivingEntity))
            return;

        if(((LivingEntity)(e.getEntity())).getHealth()>4)
            return;

            int randomNumber = new Random().nextInt(10);
            System.out.println(randomNumber);
            if(randomNumber>=3 && randomNumber <=8){
                Player p = (Player) e.getDamager();

                p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT,2,2);
                p.getWorld().spawnParticle(Particle.FLAME,e.getEntity().getLocation(),5);

                e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.COAL));
            }

    }
}
