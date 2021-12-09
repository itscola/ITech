package top.whitecola.itech.level;

import top.whitecola.itech.level.struct.LevelPlayer;

public class PlayerLeveler extends AbstractPlayerLeveler{


    public PlayerLeveler(LevelPlayer.Player lPlayer){
        super(lPlayer);
    }


    @Override
    public void setLevel(int level) {
        super.getlPlayer().level = level;
    }

    @Override
    public void upLevel() {
        super.getlPlayer().level += 1;

        playerUpdateMessage();
    }

    @Override
    public void downLevel() {
        super.getlPlayer().level -= 1;
    }

    @Override
    public void resetLevel() {
        super.getlPlayer().level = 0;
    }

    @Override
    public double addEXP(double exp) {
        super.getlPlayer().exp += exp;
        updateLevel();
        return super.getlPlayer().exp;
    }

    @Override
    public double removeEXP(double exp) {
        return addEXP(-exp);
    }


}
