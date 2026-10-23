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
        //heroes.add(new Rogue("Bert",100,20,10,1));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random(42);


        boolean running = true;

        while (running) {

            System.out.println("  __             _            _            _                               ");
            System.out.println(" / _| __ _ _ __ | |_ __ _ ___(_) ___      / \\   _ __ ___  __ _ _ __   __ _ ");
            System.out.println("| |_ / _` | '_ \\| __/ _` / __| |/ _ \\    / _ \\ | '__/ _ \\/ _` | '_ \\ / _` |");
            System.out.println("|  _| (_| | | | | || (_| \\__ \\ |  __/   / ___ \\| | |  __/ (_| | | | | (_| |");
            System.out.println("|_|  \\__,_|_| |_|\\__\\__,_|___/_|\\ ___  /_/   \\_\\_|  \\___|\\__,_|_| |_|\\__,_|");
            // https://www.asciiart.eu/text-to-ascii-art
            System.out.println();
            System.out.println("                            .-'|\")");
            System.out.println("                            |-'\\|");
            System.out.println("                                |   _.-'`.");
            System.out.println("                               _|-\"'_.-'|.`.");
            System.out.println("                              |:^.-'_.-'`.;.`.");
            System.out.println("                              | `.'.   ,-'_.-'|");
            System.out.println("                              |   + '-'.-'   J");
            System.out.println("           __.            .d88|    `.-'      |");
            System.out.println("      _.--'_..`.    .d88888888|     |       J'b.");
            System.out.println("   +:\" ,--'_.|`.`.d88888888888|-.   |    _-.|888b.");
            System.out.println("   | \\ \\-'_.--'_.-+888888888+'  _>F F +:'   `88888bo.");
            System.out.println("    L \\ +'_.--'   |88888+\"'  _.' J J J  `.    +8888888b.");
            System.out.println("    |  `+'        |8+\"'  _.-'    | | |    +    `+8888888._-'.");
            System.out.println("  .d8L  L         J  _.-'        | | |     `.    `+888+^'.-|.`.");
            System.out.println(" d888|  |         J-'            F F F       `.  _.-\"_.-'_.+.`.`.");
            System.out.println("d88888L  L     _.  L            J J J          `|. +'_.-'    `_+ `;");
            System.out.println("888888J  |  +-'  \\ L         _.-+.|.+.          F `.`.     .-'_.-\"J");
            System.out.println("8888888|  L L\\    \\|     _.-'     '   `.       J    `.`.,-'.-\"    |");
            System.out.println("8888888PL | | \\    `._.-'               `.     |      `..-\"      J.b");
            System.out.println("8888888 |  L L `.    \\     _.-+.          `.   L+`.     |        F88b");
            System.out.println("8888888  L | |   \\   _..--'_.-|.`.          >-'    `., J        |8888b");
            System.out.println("8888888  |  L L   +:\" _.--'_.-'.`.`.    _.-'     .-' | |       JY88888b");
            System.out.println("8888888   L | |   J \\ \\_.-'     `.`.`.-'     _.-'   J J        F Y88888b");
            System.out.println("Y888888    \\ L L   L \\ `.      _.-'_.-+  _.-'       | |       |   Y88888b");
            System.out.println("`888888b    \\| |   |  `. \\ _.-'_.-'   |-'          J J       J     Y88888b");
            System.out.println(" Y888888     +'\\   J    \\ '_.-'       F    ,-T\"\\   | |    .-'      )888888");
            System.out.println("  Y88888b.      \\   L    +'          J    /  | J  J J  .-'        .d888888");
            System.out.println("   Y888888b      \\  |    |           |    F  '.|.-'+|-'         .d88888888");
            System.out.println("    Y888888b      \\ J    |           F   J    -.              .od88888888P");
            System.out.println("     Y888888b      \\ L   |          J    | .' ` \\d8888888888888888888888P");
            System.out.println("      Y888888b      \\|   |          |  .-'`.  `\\ `.88888888888888888888P");
            System.out.println("       Y888888b.     J   |          F-'     \\\\ ` \\ \\88888888888888888P'");
            System.out.println("        Y8888888b     L  |         J       d8`.`\\  \\`.8888888888888P'");
            System.out.println("         Y8888888b    |  |        .+      d8888\\  ` .'  `Y888888P'");
            System.out.println("         `88888888b   J  |     .-'     .od888888\\.-'");
            System.out.println("          Y88888888b   \\ |  .-'     d888888888P'");
            System.out.println("          `888888888b   \\|-'       d888888888P");
            System.out.println("           `Y88888888b            d8888888P'");
            System.out.println("             Y88888888bo.      .od88888888   hs");
            System.out.println("             `8888888888888888888888888888");
            System.out.println("              Y88888888888888888888888888P");
            System.out.println("               `Y8888888888888888888888P'");
            System.out.println("                 `Y8888888888888P'");
            System.out.println("                      `Y88888P'");
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
                try {
                    Tournament tournament = new Tournament(heroes, random);

                    tournament.start();
                } catch (SameHeroException e) {
                    System.out.println(e.getMessage());

                }
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


