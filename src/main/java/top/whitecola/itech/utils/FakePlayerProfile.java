package top.whitecola.itech.utils;

import com.mojang.authlib.GameProfile;

import java.lang.reflect.Method;
import java.util.UUID;
import com.mojang.authlib.properties.Property;
import org.bukkit.inventory.meta.SkullMeta;

public class FakePlayerProfile extends GameProfile {

    public FakePlayerProfile(UUID id, String texture) {
        super(id, "ITech_Head");
        getProperties().put("textures",new Property("textures", texture));
    }

    public void get(SkullMeta meta) throws Throwable{
        set(meta);
        meta.setOwningPlayer(meta.getOwningPlayer());
        set(meta);
    }

    private void set(SkullMeta meta) throws Throwable{
        Class<?> clazz = meta.getClass();
        Method method = clazz.getDeclaredMethod("setProfile",GameProfile.class);
        method.setAccessible(true);
        method.invoke(meta,this);
    }
}
