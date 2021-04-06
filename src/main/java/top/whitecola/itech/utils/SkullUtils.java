package top.whitecola.itech.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Optional;
import java.util.UUID;

public class SkullUtils {
    public static Optional<ItemStack> getSkullItemFromBase64(UUID uuid, String texture) throws Throwable{
        ItemStack itemStack = null;
        try {
            itemStack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
            new FakePlayerProfile(uuid, texture).get(meta);
            itemStack.setItemMeta(meta);
        }catch (Throwable e){
            throw e;
        }

        return Optional.of(itemStack);
    }

    public static void handleDrop(){

    }
}
