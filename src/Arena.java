import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    public static void main(String[] args) {

        ArrayList<String> HeldenListe = new ArrayList<>();
        HeldenListe.add("MaxMaximus");
        HeldenListe.add("FlinkerFrederick");
        HeldenListe.add("GeisterGertrude");
        HeldenListe.add("UNbesiegbarerUwe");

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

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(42);

        boolean läuft = true;

        while (läuft) {

            System.out.println("=== Arena ===");
            System.out.println("drücke 1 Helden anzeigen");
            System.out.println("drücke 2 Kampf starten");
            System.out.println("drücke 0 Ende");
            System.out.print("Auswahl: ");

            if (scanner.hasNextInt()) {
                //    System.out.println("Bitte eine ganze Zahl eingeben.");
                scanner.next();
                continue;
            }

            int menüAuswahl = scanner.nextInt();

            if (menüAuswahl == 0) {
                läuft = false;
                System.out.println("Programm beendet.");

            } else if (menüAuswahl == 1 || menüAuswahl == 2) {

                // zeigt alle Helden an.
                System.out.println("=== Helden ===");

                int index = 0;

                while (index < HeldenListe.size()) {
                    System.out.println((index + 1) + ": " + HeldenListe.get(index) + " | Leben: " + Leben.get(index) + " | Angriff: " + Angriff.get(index));

                    index++;
                }

                if (menüAuswahl == 2) {

                    // den ersten Held wählen.
                    int held1 = -1;

                    while (held1 == -1) {
                        System.out.print("Erster Held: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Bitte eine ganze Zahl eingeben.");
                            scanner.next();
                            continue;
                        }

                        int auswahl = scanner.nextInt();

                        if (auswahl >= 1 && auswahl <= HeldenListe.size()) {
                            held1 = auswahl - 1;
                        } else {
                            System.out.println("Ungültige Nummer. Bitte erneut wählen.");
                        }
                    }

                    // einen anderen zweiten Held wählen.
                    int held2 = -1;

                    while (held2 == -1) {
                        System.out.print("Zweiter Held: ");

                        if (scanner.hasNextInt()) {
                            System.out.println("Bitte eine ganze Zahl eingeben.");
                            scanner.next();
                            continue;
                        }

                        int auswahl = scanner.nextInt();

                        if (auswahl < 1 || auswahl > HeldenListe.size()) {
                            System.out.println("Ungültige Nummer. Bitte erneut wählen.");

                        } else if (auswahl -1 == held1) {
                            System.out.println("Dieser Held wurde bereits gewählt. " + "Bitte einen anderen wählen.");

                        } else {
                            held2 = auswahl - 1;
                        }
                    }

                    // tomporeres Leben.
                    int leben1 = Leben.get(held1);
                    int leben2 = Leben.get(held2);

                    boolean held1AmZug = true;

                    System.out.println("=== " + HeldenListe.get(held1) + " gegen " + HeldenListe.get(held2) + " ===");

                    while (leben1 > 0 && leben2 > 0) {

                        int angreifer;
                        int verteidiger;

                        if (held1AmZug) {
                            angreifer = held1;
                            verteidiger = held2;
                        } else {
                            angreifer = held2;
                            verteidiger = held1;
                        }

                        // der random krit schaden
                        int schaden = Angriff.get(angreifer) + random.nextInt(5);

                        int verbleibendesLeben;

                        if (held1AmZug) {
                            leben2 -= schaden;
                            verbleibendesLeben = leben2;
                        } else {
                            leben1 -= schaden;
                            verbleibendesLeben = leben1;
                        }

                        System.out.println(HeldenListe.get(angreifer) + " trifft " + HeldenListe.get(verteidiger) + " für " + schaden + "schaden" + "."  + HeldenListe.get(verteidiger) + " hat noch " + verbleibendesLeben + " Lebenspunkte.");

                        // Alternate turns.
                        held1AmZug = !held1AmZug;
                    }

                    if (leben1 > 0) {
                        System.out.println("Sieger: " + HeldenListe.get(held1));
                    } else {
                        System.out.println("Sieger: " + HeldenListe.get(held2));
                    }

                    System.out.println("Beide Helden haben wieder volle Lebenspunkte.");
                }

            } else {
                System.out.println("Ungültige Auswahl. Bitte 0, 1 oder 2 wählen.");
            }
        }

        scanner.close();
    }
}





