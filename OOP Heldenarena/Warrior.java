public class Warrior extends Held {

    public Warrior(String name,int currenthp, int attack, int armor, int ap) {
        super(name, currenthp, attack, armor, ap);
    }

    @Override
    public int calculateCriticalDamage(int criticalDamage) {
        return criticalDamage * 2;
    }
}