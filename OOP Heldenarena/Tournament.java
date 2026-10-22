import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tournament extends HeroCompetition {

    private ArrayList<Held> participants;
    private Random random;

    public Tournament(ArrayList<Held> participants, Random random) {
        this.participants = participants;
        this.random = random;
    }

    @Override
    public Held start() {

        ArrayList<Held> round = new ArrayList<>(participants);

        while (round.size() > 1) {

            Collections.shuffle(round, random);

            System.out.println("Heroes still in tournament:");

            for (Held held : round) {
                System.out.println("- " + held.getName());
            }

            ArrayList<Held> winners = new ArrayList<>();

            for (int i = 0; i < round.size(); i += 2) {

                Held held1 = round.get(i);

                if (i + 1 >= round.size()) {
                    System.out.println(held1.getName() + " gets a bye!");
                    winners.add(held1);
                    continue;
                }

                Held held2 = round.get(i + 1);
                System.out.println();
                System.out.println("Tournament pairing:");
                System.out.println("Held 1: " + held1.getName());
                System.out.println("Held 2: " + held2.getName());
                System.out.println("Same reference: " + (held1 == held2));
                System.out.println("equals(): " + held1.equals(held2));
                Fight fight = new Fight(held1, held2, random);

                winners.add(fight.start());
            }

            round = winners;
        }

        System.out.println(
                "Tournament Winner: " + round.get(0).getName()
        );

        return round.get(0);
    }
}