public class Healer extends Held {

    public Healer(String name, int hp, int attack, int armor, int ap) {
        super(name, hp, attack, armor, ap);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);

        if (isAlive()) {
            heal(5);
            System.out.println(getName() + " heals 5 HP!");
        }
    }
}
