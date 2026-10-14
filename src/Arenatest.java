import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arenatest {

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
                            leben2 -= schaden;
                            verbleibendesLeben = leben2;
                        } else {
                            leben1 -= schaden;
                            verbleibendesLeben = leben1;
                        }
                        if (kritschaden > 0){System.out.println(
                                "Kritischer Treffer von " + " " + HeldenListe.get(angreifer) + "!" + kritschaden
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
                    /* Experimentel
                    if (menüAuswahl == 3) {

                        System.out.println("\n=== Turnier ===");

                        int kampfNummer = 1;
                        int sieger1 = -1;
                        int sieger2 = -1;
                        int gesamtsieger = -1;

                        while (kampfNummer <= 3) {

                            int held1;
                            int held2;

                            // Select the participants for the current match.
                            if (kampfNummer == 1) {
                                System.out.println("\n=== Halbfinale 1 ===");
                                held1 = 0;
                                held2 = 1;

                            } else if (kampfNummer == 2) {
                                System.out.println("\n=== Halbfinale 2 ===");
                                held1 = 2;
                                held2 = 3;

                            } else {
                                System.out.println("\n=== Finale ===");
                                held1 = sieger1;
                                held2 = sieger2;
                            }

                            // Reset health and abilities for each match.
                            int leben1 = Leben.get(held1);
                            int leben2 = Leben.get(held2);
                            int AngriffeaufFred = 0;

                            boolean held1AmZug = true;

                            System.out.println(
                                    HeldenListe.get(held1) + " gegen "
                                            + HeldenListe.get(held2)
                            );

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

                                // Exactly one random call per attack.
                                int kritschaden = random.nextInt(5);

                                // Warrior ability: double the random bonus.
                                if (angreifer == 0) {
                                    kritschaden *= 2;
                                }

                                int angriffsschaden = Angriff.get(angreifer) + kritschaden;
                                int rüstung = Rüstung.get(verteidiger);

                                // Ghost ability: ignore armor.
                                if (angreifer == 2) {
                                    rüstung = 0;
                                }

                                int schaden = Math.max(0, angriffsschaden - rüstung);
                                boolean ausgewichen = false;

                                // Rogue ability: dodge every third incoming attack.
                                if (verteidiger == 1) {
                                    AngriffeaufFred++;

                                    if (AngriffeaufFred % 3 == 0) {
                                        schaden = 0;
                                        ausgewichen = true;
                                    }
                                }

                                int verbleibendesLeben;

                                if (held1AmZug) {
                                    leben2 -= schaden;
                                    verbleibendesLeben = leben2;
                                } else {
                                    leben1 -= schaden;
                                    verbleibendesLeben = leben1;
                                }

                                if (ausgewichen) {
                                    System.out.println(
                                            HeldenListe.get(verteidiger)
                                                    + " weicht dem Angriff aus!"
                                    );
                                } else {
                                    if (kritschaden > 0) {
                                        System.out.println(
                                                "Kritischer Treffer von "
                                                        + HeldenListe.get(angreifer)
                                                        + "! Bonus: " + kritschaden
                                        );
                                    }

                                    System.out.println(
                                            HeldenListe.get(angreifer) + " trifft "
                                                    + HeldenListe.get(verteidiger)
                                                    + " für " + schaden + " Schaden."
                                    );
                                }

                                System.out.println(
                                        HeldenListe.get(verteidiger)
                                                + " hat noch " + verbleibendesLeben
                                                + " Lebenspunkte."
                                );

                                held1AmZug = !held1AmZug;
                            }

                            int sieger;

                            if (leben1 > 0) {
                                sieger = held1;
                            } else {
                                sieger = held2;
                            }

                            System.out.println("Sieger: " + HeldenListe.get(sieger));

                            // Store the winner for the final or tournament result.
                            if (kampfNummer == 1) {
                                sieger1 = sieger;
                            } else if (kampfNummer == 2) {
                                sieger2 = sieger;
                            } else {
                                gesamtsieger = sieger;
                            }

                            kampfNummer++;
                        }

                        System.out.println(
                                "\nGesamtsieger des Turniers: "
                                        + HeldenListe.get(gesamtsieger)
                        );
                    }

                     */
                } else {}
            } else {
                System.out.println("Ungültige Auswahl. Bitte 0, 1 oder 2 wählen.");
            }
        }

        scanner.close();
    }
}






