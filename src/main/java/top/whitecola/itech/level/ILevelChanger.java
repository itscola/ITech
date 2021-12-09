package top.whitecola.itech.level;

public interface ILevelChanger {
    void setLevel(int level);
    void upLevel();
    void downLevel();
    void resetLevel();
    double addEXP(double exp);
    double removeEXP(double exp);
}
