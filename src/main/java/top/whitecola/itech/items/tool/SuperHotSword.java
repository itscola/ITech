package top.whitecola.itech.items.tool;

import de.slikey.effectlib.effect.CubeEffect;
import de.slikey.effectlib.effect.SmokeEffect;
import org.bukkit.Material;
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

public class SuperHotSword implements IItechItem {
    HiItem hitem;

    public SuperHotSword(){
        hitem = new HiItem(new ItemStack(Material.IRON_SWORD));
        hitem.setDisplayName("��c��l����֮��")
                .setLores(Arrays.asList("��6��������Ϊ̿��.","��6���渽ħ.","��6�и��ʽ������ճ�̿."))
                .setCustomModelData(20210528)
                .addEnchat(Enchantment.FIRE_ASPECT,1,true)
                .setAttackDamage(8);
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



        if(((LivingEntity)(e.getEntity())).getHealth()>4)
            return;





        int randomNumber = new Random().nextInt(10);
        if(randomNumber>=3 && randomNumber <=9){

            p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT,2,2);

            CubeEffect cubeEffect = new CubeEffect(ITech.instance.effectManager);
            cubeEffect.setLocation(e.getDamager().getLocation());
            cubeEffect.enableRotation = true;
            cubeEffect.iterations = 20;
            cubeEffect.start();
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.COAL));
        }

    }
}
