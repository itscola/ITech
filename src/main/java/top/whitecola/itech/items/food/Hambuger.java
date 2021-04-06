package top.whitecola.itech.items.food;


import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import top.whitecola.bridges.HiItemNBT;
import top.whitecola.bridges.HiItemSerialization;
import top.whitecola.bridges.HiReflect;
import top.whitecola.builder.HiItem;
import top.whitecola.itech.Type.ItemMaterial;
import top.whitecola.itech.items.IItechItem;
import top.whitecola.itech.utils.SkullUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

public class Hambuger implements IItechItem {
    HiItem hitem;
    private static final String TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWMwYmM5NTE4Mzc5NzZhODZlOTEwZGMzM2JkYWMzYzcyZjQ4YzAwMmEzNTNhODNmZWMyMzcwZWMyMDI1M2ZhMSJ9fX0=";


    public Hambuger() throws Throwable{
        hitem = new HiItem(SkullUtils.getSkullItemFromBase64(UUID.nameUUIDFromBytes(TEXTURE.getBytes(StandardCharsets.UTF_8)),TEXTURE).orElse(new ItemStack(Material.PLAYER_HEAD)));
        hitem.setDisplayName("鸡肉汉堡")
                .setLores(Arrays.asList("闻上去很香.","恢复12(6个鸡腿)饱食度."));
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
        return ItemMaterial.FOOD;
    }
}
