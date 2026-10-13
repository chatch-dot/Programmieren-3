import java.util.ArrayList;
import java.util.Scanner;

public class Arenatest2 {

    public static void main(String[] args) {

        ArrayList<String> HeldenListe = new ArrayList<>();
        HeldenListe.add("MaxMaximus");
        HeldenListe.add("FlinkerFrederick");
        HeldenListe.add("GeisterGertrude");
        HeldenListe.add("UnbesiegbarerUwe");

        ArrayList<Integer> Leben = new ArrayList<>();
        Leben.add(150);
        Leben.add(80);
        Leben.add(100);
        Leben.add(200);

        ArrayList<Integer> Angriff = new ArrayList<>();
        Angriff.add(20);
        Angriff.add(25);
        Angriff.add(45);
        Angriff.add(33);

        Scanner eingabecharanzeige = new Scanner(System.in);

        System.out.println("Choose your characters!");

        System.out.println("Character 1:");
        int werte = eingabecharanzeige.nextInt();

        System.out.println("Character 2:");
        int werte2 = eingabecharanzeige.nextInt();

        int untersterwert = 1;
        int obersterwert = HeldenListe.size();

        boolean inrange =
                (werte >= untersterwert && werte <= obersterwert)
                        &&
                        (werte2 >= untersterwert && werte2 <= obersterwert);

        if (inrange) {

            String str = HeldenListe.get(werte - 1);
            int LP = Leben.get(werte - 1);
            int AP = Angriff.get(werte - 1);

            System.out.println("Character: " + str);
            System.out.println("Leben: " + LP);
            System.out.println("Angriff: " + AP);

            System.out.println();

            String str2 = HeldenListe.get(werte2 - 1);
            int LP2 = Leben.get(werte2 - 1);
            int AP2 = Angriff.get(werte2 - 1);

            System.out.println("Character: " + str2);
            System.out.println("Leben: " + LP2);
            System.out.println("Angriff: " + AP2);

        } else {

            System.out.println(
                    "Die ausgewählte Zahl gehört zu keinem Character."
            );
        }

        eingabecharanzeige.close();
    }
}
