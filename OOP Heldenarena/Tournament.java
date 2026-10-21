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

        return null;
    }
}