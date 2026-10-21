public class Held {

     private String name;
     private int maxhp;
     private int currenthp;
     private int attack;
     private int armor;
     private int ap;

    public Held(String name, int hp, int atack, int armor, int ap) {
        this.name = name;
        this.maxhp = hp;
        this.currenthp = hp;
        this.attack = atack;
        this.armor = armor;
        this.ap = ap;
    }


public void anzeigen() {
    System.out.println(this.getClass() + "| name: " + name + " | Leben: " + currenthp + " | Angriff: " + attack + " | Rüstung: " + armor + " | Armor Pen |" + ap
    );

    }
    public String getName() {
        return name;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getCurrenthp() {
        return currenthp;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public boolean isAlive() {
        return currenthp > 0;
    }

    public void takeDamage(int damage) {
        currenthp = Math.max(0, currenthp - Math.max(0, damage));
    }

    public void reset() {
        currenthp = maxhp;
    }


    public int getAP() {
        return ap;
    }

    public int calculateCriticalDamage(int criticalDamage ) {
        return criticalDamage;
    }

    public int modifyIncomingDamage(int damage, Held attacker) {
        return damage;
    }

    public void heal(int amount) {
        currenthp = Math.min(maxhp, currenthp + amount);
    }

    @Override
    public boolean equals(Object obj) {


        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Held)) {
            return false;
        }

        Held other = (Held) obj;

        return this.name.equals(other.name)
                && this.attack == other.attack;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, attack);
    }



}

