import java.util.Random;
public class Held {

    String name;
     private int maxhp;
     private int currenthp;
     private int atack;
     private int armor;
     private int ap;

    public Held(String name, int maxhp, int currenthp, int atack, int armor, int ap) {
        this.name = name;
        this.maxhp = maxhp;
        this.currenthp = currenthp;
        this.atack = atack;
        this.armor = armor;
        this.ap = ap;
    }


public void anzeigen() {
    System.out.println(" | name: " + name + " | Leben: " + currenthp + " | Angriff: " + atack + " | Rüstung: " + armor + " | Armor Pen" + ap
    );}
    public String getName() {
        return name;
    }

    public int getCurrenthp() {
        return currenthp;
    }

    public int getAtack() {
        return atack;
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
}

