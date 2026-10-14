public class Held {

    String name;
    int hp;
    int atack;
    int armor;
    int ap;

    public Held(String name, int hp, int atack, int armor, int ap) {
        this.name = name;
        this.hp = hp;
        this.atack = atack;
        this.armor = armor;
        this.ap = ap;
    }
}

public void anzeigen() {
    System.out.println(" | name: " + name + " | Leben: " + hp + " | Angriff: " + atack + " | Rüstung: " + armor + " | Armor Pen" + ap
    );
}
}