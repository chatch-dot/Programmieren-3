public class Tank extends Held {

    public Tank(String name, int hp, int attack, int armor, int ap) {
        super(name, hp, attack, armor, ap);
    }

    @Override
    public void takeDamage(int damage) {

        damage = Math.min(damage, 20);

        super.takeDamage(damage);
    }
}