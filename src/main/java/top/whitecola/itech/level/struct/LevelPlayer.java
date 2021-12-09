package top.whitecola.itech.level.struct;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.Objects;
import java.util.UUID;
import java.util.Vector;

public class LevelPlayer {
    public Vector<Player> players = new Vector<>();

    public static class Player {
        public String uuid;
        public int level;
        public double exp;

        public Player(String uuid,int level,double exp){
            this.uuid = uuid;
            this.level = level;
            this.exp = exp;
        }

        public OfflinePlayer toOfflinePlayer(){
            return Bukkit.getOfflinePlayer(UUID.fromString(uuid));
        }




        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return level == player.level && Double.compare(player.exp, exp) == 0  && Objects.equals(uuid, player.uuid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uuid, level, exp);
        }
    }


}
