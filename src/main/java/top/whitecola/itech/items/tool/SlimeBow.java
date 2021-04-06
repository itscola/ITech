package top.whitecola.itech.items.tool;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;

public class SlimeBow implements IItechItem {
    HiItem hitem;

    public SlimeBow(){
        hitem = new HiItem(new ItemStack(Material.BOW));
        hitem.setDisplayName("§2§l史莱姆弓")
                .setLores(Arrays.asList("§a上面..","§a黏黏的...","§2射到生物后,生物获得3秒跳跃提升效果.","§2射出时 玩家像史莱姆跳跃"))
                .setCustomModelData(20212024)
                .addEnchat(Enchantment.ARROW_KNOCKBACK,1,false);
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
        if(!(e.getDamager() instanceof Projectile && e.getEntity() instanceof LivingEntity ))
            return;

        Projectile pj = (Projectile)e.getDamager();
        if(!(pj.getShooter() instanceof Player))
            return;


        if(e.getDamager().isDead())
            return;
        ((LivingEntity)e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,70,2));

        Player p = ((Player)pj.getShooter());
        getSlimeEffectOnPlayer(p);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP,2,2);

    }

    @Override
    public void onEntityShootBow(EntityShootBowEvent e) {
        Player p = ((Player)e.getEntity());
        getSlimeEffectOnPlayer(p);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SLIME_SQUISH,2,2);

    }

    public void getSlimeEffectOnPlayer(Player p){
        if(p.isOnGround()) {
            p.setVelocity(new Vector(0.0, 1, 0.0));
        }
        p.getWorld().spawnParticle(Particle.SLIME,p.getLocation(),10);
    }

}
