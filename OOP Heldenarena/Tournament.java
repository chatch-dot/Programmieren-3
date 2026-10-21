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

            ArrayList<Held> winners = new ArrayList<>();

            for (int i = 0; i < round.size(); i += 2) {

                Held held1 = round.get(i);
                Held held2 = round.get(i + 1);

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