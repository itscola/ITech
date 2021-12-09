package top.whitecola.itech.items.tool;

import de.slikey.effectlib.effect.CircleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.ITech;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;

import java.util.Arrays;
import java.util.Random;

public class SeaAXE implements IItechItem {
    HiItem hitem;

    public SeaAXE(){
        hitem = new HiItem(new ItemStack(Material.DIAMOND_AXE));
        hitem.setDisplayName("§b§o海之咆哮")
                .setLores(Arrays.asList("§3来自海洋深处的神秘力量.","§3§o攻击生物有概率激起泡沫。","§3此时额外增加3点伤害。"))
                .setCustomModelData(20210529)
                .addEnchat(Enchantment.LOOT_BONUS_MOBS,3,true)
                .setAttackDamage(9);
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


        Player p = (Player) e.getDamager();

        int randomNumber = new Random().nextInt(10);
        if(randomNumber>=3 && randomNumber <=7){

            e.setDamage(e.getDamage()+3);
            p.playSound(p.getLocation(), Sound.ENTITY_DROWNED_HURT_WATER,2,2);



            CircleEffect circleEffect = new CircleEffect(ITech.instance.effectManager);
            circleEffect.radius = 0.7f;
            circleEffect.particle = Particle.WATER_SPLASH;
            circleEffect.iterations = 16;
            circleEffect.particleCount = 10;
            Location loc = e.getEntity().getLocation();
            circleEffect.setLocation(new Location(e.getEntity().getWorld(),loc.getX(),loc.getY()+0.8,loc.getZ()));
            circleEffect.start();


        }

    }
}
