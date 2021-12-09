package top.whitecola.itech.level.struct;

import java.util.Vector;

public class RewardPlayer {
    public Vector<Player> rewardPlayers = new Vector<>();

    public static class Player {
        public String name;
        public String uuid;

        public Player(String name,String uuid) {
            this.name = name;
            this.uuid = uuid;
        }

    }

}
