import java.util.Random;

public class Arena_v3 {
    public static void main(String[] args) {
        Held held1 = new Held("MaxMaximus", 150, 150, 20, 10, 0);
        Held held2 = new Held("Geistergertrude", 80, 80, 25, 5, 1);
        Random random = new Random(42);

        //Fight fight = new Fight(held1, held2, random);
        try {
            Fight fight = new Fight(held1, held2, random);
            fight.start();
        } catch (SameHeroException e) {
            System.out.println(e.getMessage());
        }
        //Held winner = fight.start();
    }
}



