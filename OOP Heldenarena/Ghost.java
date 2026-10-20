
public class Ghost extends Held {

    public Ghost(String name,int currenthp, int attack, int armor, int ap) {
        super(name, currenthp, attack, armor, ap);
    }

    @Override
    public int modifyIncomingDamage(int damage, Held attacker) {
        return attacker.getAP();
    }

}




