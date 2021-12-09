package top.whitecola.itech.level;

import top.whitecola.itech.ITech;
import top.whitecola.itech.level.struct.LevelPlayer;

public class OfflinePlayerLeveler extends AbstractPlayerLeveler {

    public OfflinePlayerLeveler(LevelPlayer.Player lPlayer) {
        super(lPlayer);
    }

    @Override
    public void setLevel(int level) {
        super.getlPlayer().level = level;
        saveData();
    }

    @Override
    public void upLevel() {
        super.getlPlayer().level += 1;
        saveData();
    }

    @Override
    public void downLevel() {
        super.getlPlayer().level -= 1;
        saveData();
    }

    @Override
    public void resetLevel() {
        super.getlPlayer().level = 0;
        saveData();
    }

    @Override
    public double addEXP(double exp) {
        super.getlPlayer().exp += exp;
        updateLevel();
        saveData();
        return super.getlPlayer().exp;
    }

    @Override
    public double removeEXP(double exp) {
        return addEXP(-exp);
    }

    public void saveData(){
        ITech.instance.levelPlayers.saveConfig();
    }
}
