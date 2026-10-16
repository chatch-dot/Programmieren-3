import java.util.Random;
public class Held {

    String name;
     private int maxhp;
     private int currenthp;
     private int attack;
     private int armor;
     private int ap;

    public Held(String name, int maxhp, int currenthp, int atack, int armor, int ap) {
        this.name = name;
        this.maxhp = maxhp;
        this.currenthp = currenthp;
        this.attack = atack;
        this.armor = armor;
        this.ap = ap;
    }


public void anzeigen() {
    System.out.println(" | name: " + name + " | Leben: " + currenthp + " | Angriff: " + attack + " | Rüstung: " + armor + " | Armor Pen" + ap
    );}
    public String getName() {
        return name;
    }

    public int getCurrenthp() {
        return currenthp;
    }

    public int getAtack() {
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
    /*
    public boolean equals(Held obj) {
        if (obj.name.equals(this.name)) {
            return false;
        }
        if (obj.atack == this.atack) {
            return false;
        }

        return true;
    */
    public boolean equals(Held obj) {
        if (obj == null) {
            return false;
        }

        return this.name.equals(obj.name)
                && this.attack == obj.attack;
    }


}

