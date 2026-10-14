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
        Angriff.add(33);
        Angriff.add(2);

        ArrayList<Integer> Rüstung = new ArrayList<>();
        Rüstung.add(10);
        Rüstung.add(5);
        Rüstung.add(0);
        Rüstung.add(19);

        ArrayList<String> Klasse = new ArrayList<>();
        Klasse.add("Krieger - hat zu viel Glück bei seinen Angriffen");
        Klasse.add("Schurck - weicht jeder 3. atacke aus");
        Klasse.add("Geist - reicht durch deine Rüstung");
        Klasse.add("Tank - hat eine Haut aus Stahl ()");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(42);

        boolean läuft = true;

        while (läuft) {

            System.out.println("=== Arena ===");
            System.out.println("drücke 1 Helden anzeigen");
            System.out.println("drücke 2 Kampf starten");
            System.out.println("drücke 3 Tunier");
            System.out.println("drücke 0 Ende");
            System.out.print("Auswahl: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Bitte eine ganze Zahl eingeben.");
                scanner.next();
                continue;
            }

            int menüAuswahl = scanner.nextInt();

            if (menüAuswahl == 0) {
                läuft = false;
                System.out.println("Programm beendet.");

            } else if (menüAuswahl == 1 || menüAuswahl == 2 || menüAuswahl == 3) {

                // zeigt alle Helden an.

                if (menüAuswahl == 1) {
                    int index = 0;
                    System.out.println("=== Helden ===");
                    while (index < HeldenListe.size()) {
                        System.out.println((index + 1) + ": " + HeldenListe.get(index) + " | Klasse " + Klasse.get(index) + " | Leben: " + Leben.get(index) + " | Angriff: " + Angriff.get(index) + " | Rüstung " + Rüstung.get(index));

                        index++;
                    }
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

                        if (!scanner.hasNextInt()) {
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

                    // tomporeres Leben und Rüstung.
                    int leben1 = Leben.get(held1);
                    int leben2 = Leben.get(held2);
                    boolean held1AmZug = true;

                    System.out.println(" ");
                    System.out.println("=== " + HeldenListe.get(held1) + " gegen " + HeldenListe.get(held2) + " ===");
                    System.out.println("///////////////////////////////////////////////");
                    System.out.println(" ");

                    int AngriffeaufFred = 0;
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

                        int kritschaden = random.nextInt(5);
                        // der random krit schaden

                        int angriffsschaden = Angriff.get(angreifer) + kritschaden;
                        int rüstung = Rüstung.get(verteidiger);

                        // Fähigkeit vom Geist
                        if (angreifer == 2) {
                            rüstung = 0;
                        }

                        //Fähigkeit vom Krieger
                        if (angreifer == 0){
                            angriffsschaden = Angriff.get(angreifer) + kritschaden * 2;
                        }

                        int schaden = Math.max(0, angriffsschaden - rüstung);

                        //Fähigkeit vom Schurcken
                        if (verteidiger == 1){
                        AngriffeaufFred++;
                            if (AngriffeaufFred % 3 == 0) {
                                schaden = 0;

                                System.out.println(HeldenListe.get(verteidiger) + " weicht dem Angriff aus!");
                            }
                        }

                        int verbleibendesLeben;


                        if (held1AmZug) {
                            schaden = Math.min(schaden, leben2);
                            leben2 -= schaden;
                            verbleibendesLeben = leben2;
                        } else {
                            schaden = Math.min(schaden, leben1);
                            leben1 -= schaden;
                            verbleibendesLeben = leben1;
                        }
                        if (kritschaden > 0){System.out.println(
                                "Kritischer Treffer von " + " " + HeldenListe.get(angreifer) +  " " + "!" + kritschaden
                        );
                        }
                        System.out.println(HeldenListe.get(angreifer) + " trifft " + HeldenListe.get(verteidiger) + " für " + schaden + "schaden" + "."  + HeldenListe.get(verteidiger) + " hat noch " + "| " + rüstung + "  Rüstung " + "und" + " " + verbleibendesLeben + " Lebenspunkte.");
                        System.out.println(" ");
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
                if (menüAuswahl == 3) {
                    System.out.println("Are you ready to rumble!!!?");
                } else {}
            } else {
                System.out.println("Ungültige Auswahl. Bitte 0, 1 oder 2 wählen.");
            }
        }

        scanner.close();
    }
}






