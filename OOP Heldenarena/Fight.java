import java.util.Random;

public class Fight {

    private Held held1;
    private Held held2;
    private boolean held1Turn;
    private Random random;

    public Fight(Held held1, Held held2, Random random) {
        if (held1 == held2 /*gleiche speicheradr*/ || held1.equals(held2)  /*inhalt*/) {
            throw new  SameHeroException("Select two different heroes.");
        }

        this.held1 = held1;
        this.held2 = held2;
        this.random = random;
        this.held1Turn = true;
    }

    public Held start() {

        held1.reset();
        held2.reset();
        held1Turn = true;

        System.out.println();
        System.out.println("=== " + held1.getName() + " versus " + held2.getName() + " ===");
        System.out.println();

        while (held1.isAlive() && held2.isAlive()) {

            Held attacker;
            Held defender;

            if (held1Turn) {
                attacker = held1;
                defender = held2;
            } else {
                attacker = held2;
                defender = held1;
            }

            performAttack(attacker, defender);

            held1Turn = !held1Turn;
        }

        Held winner = determineWinner();

        System.out.println("Winner: " + winner.getName());

        held1.reset();
        held2.reset();

        System.out.println("Both heroes have full health again.");

        return winner;
    }

    private int calculateDamage(Held attacker, Held defender) {

        int criticalDamage = random.nextInt(5);
        criticalDamage = attacker.calculateCriticalDamage(criticalDamage);
        int attackDamage = attacker.getAttack() + criticalDamage;
        int effectiveArmor = Math.max(0, defender.getArmor() - attacker.getAP());

        return Math.max(0, attackDamage - effectiveArmor);
      //  return Math.max(0, attackDamage - defender.getArmor());
    }

    private void performAttack(Held attacker, Held defender) {

        int damage = calculateDamage(attacker, defender);

        damage = Math.min(damage, defender.getCurrenthp());

        defender.takeDamage(damage);

        System.out.println (attacker.getName() + " hits " + defender.getName() + " for " + damage + " damage.");
        System.out.println (defender.getName() + " has " + defender.getCurrenthp() + " health and " + defender.getArmor() + " armor remaining.");
        System.out.println ();
    }

    private Held determineWinner() {

        if (held1.isAlive()) {
            return held1;
        } else {
            return held2;
        }
    }
}

