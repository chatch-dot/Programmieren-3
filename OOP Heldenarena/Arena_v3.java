import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena_v3 {

    public static void main(String[] args) {

        ArrayList<Held> heroes = new ArrayList<>();

        heroes.add(new Warrior("MaxMaximus",150,30,15,1 ));
        heroes.add(new Held("Geistergertrude",80,20,0,1));
        heroes.add(new Rogue("FlinkerFrederick", 100, 25, 5, 1));
        heroes.add(new Tank("Gustav", 100, 25, 10, 1));
        heroes.add(new Healer("Uwe",100,20,10,1));
        Held heldA = new Held("TestHeld", 100, 20, 5, 1);
        Held heldB = new Held("TestHeld", 200, 20, 10, 5);

        System.out.println("Same object: " + heldA.equals(heldA));
        System.out.println("Same by definition: " + heldA.equals(heldB));
        System.out.println("Held vs String: " + heldA.equals("TestHeld"));
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(42);


        boolean running = true;

        while (running) {

            System.out.println("  __             _            _            _                               ");
            System.out.println(" / _| __ _ _ __ | |_ __ _ ___(_) ___      / \\   _ __ ___  __ _ _ __   __ _ ");
            System.out.println("| |_ / _` | '_ \\| __/ _` / __| |/ _ \\    / _ \\ | '__/ _ \\/ _` | '_ \\ / _` |");
            System.out.println("|  _| (_| | | | | || (_| \\\\__ \\ |  __/   / ___ \\| | |  __/ (_| | | | | (_| |");
            System.out.println("|_|  \\__,_|_| |_|\\__\\__,_|___/_|\\ ___  /_/   \\_\\_|  \\___|\\__,_|_| |_|\\__,_|");
            // https://www.asciiart.eu/text-to-ascii-art
            System.out.println();

            System.out.println("======= Arena ======");
            System.out.println("1: Display heroes");
            System.out.println("2: Start fight");
            System.out.println("3: Tournament");
            System.out.println("0: Exit");
            System.out.print("Selection: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.next();
                continue;
            }

            int selection = scanner.nextInt();

            if (selection == 0) {
                running = false;
                System.out.println("Program ended.");

            } else if (selection == 1) {
                displayHeroes(heroes);

            } else if (selection == 2) {
                displayHeroes(heroes);

                Held held1 = selectHero(scanner, heroes, "First hero: ");

                Fight fight = null;

                // Repeat the second selection until the fight is valid.
                while (fight == null) {

                    Held held2 = selectHero(scanner, heroes, "Second hero: ");

                    try {
                        fight = new Fight(held1, held2, random);
                    } catch (SameHeroException e) {
                        System.out.println(e.getMessage());
                    }
                }

                fight.start();

            } else if (selection == 3) {
                System.out.println("Are you ready to rumble?");
                System.out.println("Tournament is not implemented yet.");

            } else {
                System.out.println("Invalid selection. Please select 0, 1, 2 or 3.");
            }
        }

        scanner.close();
    }

    private static void displayHeroes(ArrayList<Held> heroes) {

        System.out.println();
        System.out.println("=== Heroes ===");

        int index = 0;

        while (index < heroes.size()) {
            System.out.print((index + 1) + ": ");
            heroes.get(index).anzeigen();
            index++;
        }

        System.out.println();
    }

    private static Held selectHero(Scanner scanner, ArrayList<Held> heroes, String prompt) {

        while (true) {

            System.out.print(prompt);

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.next();
                continue;
            }

            int selection = scanner.nextInt();

            if (selection >= 1 && selection <= heroes.size()) {
                return heroes.get(selection - 1);
            }

            System.out.println("Invalid number. Please select 1 to " + heroes.size() + ".");
        }
    }
}


