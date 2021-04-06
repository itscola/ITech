package top.whitecola.itech.entity;


import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.EntityType;

public class CustomEntityTest extends EntityArmorStand implements IEntity {
    static {
//        MinecraftKey minecraftKey = new MinecraftKey("CustomEntityTest");
//        // 实体注册
//        EntityTypes.a(new EntityTypes<>(minecraftKey)) // 将此key添加至EntityTypes的列表里
//        EntityTypes.a(54, minecraftKey, CustomEntityTest.class); // 对其注册
//        EntityType.
    }


    public CustomEntityTest(Location location){
        super(((CraftWorld) location.getWorld()).getHandle(),1,1,1);
        this.setCustomNameVisible(true);
        this.setPosition(location.getX(), location.getY(), location.getZ());
    }

    public CustomEntityTest(EntityTypes<? extends EntityArmorStand> entitytypes, World world) {
        super(entitytypes, world);
    }

    public CustomEntityTest(World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);
    }

    @Override
    public void movementTick() {
        super.movementTick();
    }

    @Override
    public void move(EnumMoveType enummovetype, Vec3D vec3d) {
        super.move(enummovetype, vec3d);
    }
}
