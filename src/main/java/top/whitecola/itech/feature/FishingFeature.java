package top.whitecola.itech.feature;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.items.items.AntiGravityStone;
import top.whitecola.itech.items.tool.*;

import java.util.Random;
import java.util.Vector;

public class FishingFeature extends Feature{
    Random random = new Random();
    private Vector<ItemStack> randomItems = new Vector<>();

    public FishingFeature(){
        randomItems.add(new PokeBall().getItem(3));
        randomItems.add(new PokeBall().getItem(5));
        randomItems.add(new AntiGravityStone().getItem(5));
        randomItems.add(new HiItem(new ItemStack(Material.IRON_LEGGINGS,1)).setDurability((short) 14).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.FISHING_ROD,1)).setDurability((short) 200).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.ROTTEN_FLESH,17)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.COAL,24)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.ROTTEN_FLESH,2)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.AXOLOTL_BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.SEAGRASS,3)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.SEA_PICKLE,1)).getItem());
        randomItems.add(new SlimeSaddle().getItem(1));
        randomItems.add(new HiItem(new ItemStack(Material.MILK_BUCKET,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.OAK_BOAT,1)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.APPLE,3)).getItem());
        randomItems.add(new HiItem(new ItemStack(Material.BLUE_ICE,4)).getItem());
        randomItems.add(new SuperHotSword().getItem(1));
        randomItems.add(new SeaAXE().getItem(1));
    }

    @Override
    public boolean onFeature(Object obj) {
        if(!(obj instanceof PlayerFishEvent))
            return false;

        PlayerFishEvent e = (PlayerFishEvent) obj;
        int randomNumber = random.nextInt(20);

        if(!(randomNumber>=1 && randomNumber <=3))
            return true;

        rewardItem(e.getPlayer());

        return true;
    }

    public void rewardItem(Player player){
        Inventory inv = Bukkit.createInventory(null, 18,"奖励箱");
        ItemStack item = randomItems.get(random.nextInt(randomItems.size()));
        inv.addItem(low(item,player));
        player.openInventory(inv);
        player.playSound(player.getLocation(), Sound.ITEM_CROSSBOW_HIT,2,2);
        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN,2,2);
        player.sendMessage("§a视乎钓上什么物品！");
    }


    public ItemStack low(ItemStack item,Player player){
        if(item.getItemMeta().hasCustomModelData()){
            if (item.getItemMeta().getCustomModelData() == 20210528){ //super hot sword
                if(random.nextInt(10)<=6) {
                    return item;
                }
            }

            if (item.getItemMeta().getCustomModelData() == 20210529){ //super hot sword
                if(random.nextInt(12)<=1 && !player.getWorld().isClearWeather()) {
                    return item;
                }
            }
        }
        int ran = random.nextInt(randomItems.size());
        return randomItems.get(ran>=2?ran-2:ran);
    }

    @Override
    public void onUpdate(Object e) {


        super.onUpdate(e);
    }

    @Override
    public void disable() {
        super.disable();
    }
}
