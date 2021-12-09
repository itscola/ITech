package top.whitecola.itech.level;

public interface ILevelGetter {
    int getCurrentLevel();
    double GainEXPNeededToUpgrade(int level);
    double getNextLevelNeededEXP();
}
