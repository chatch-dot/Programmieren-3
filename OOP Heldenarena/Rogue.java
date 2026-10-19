public class Rogue extends Held {

    private int receivedAttacks = 0;

    public Rogue(String name, int currenthp, int attack, int armor, int ap) {
        super(name, currenthp, attack, armor, ap);
    }

    @Override
    public void takeDamage(int damage) {
        receivedAttacks++;

        if (receivedAttacks % 3 == 0) {
            System.out.println(getName() + " dodges!");
        } else {
            super.takeDamage(damage);
        }
    }

    @Override
    public void reset() {
        super.reset();
        receivedAttacks = 0;
    }

}
