import java.util.Scanner;
import java.util.ArrayList;

public class Arena {
    public static void main(String[] args) {
        /*
        String Held1 = "MaxMaximus";
        String Held2 = "FlinkerFrederick";
        String Held3 = "GeisterGertrude";
        String Held4 = "UnbesiegbarerUwe";
 */


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
        System.out.println("chose your Character!!!");

        Scanner Scanner = new Scanner(System.in);
        System.out.println("Characer1");
        int werte = Scanner.nextInt();

        String str = HeldenListe.get(werte -1);
        System.out.println("Character" + str);
        int LP = Leben.get(werte -1);
        System.out.println("Character" + LP);
        int AP = Angriff.get(werte -1);
        System.out.println("Character" + AP);


        System.out.println("Characer2");
        int werte2 = Scanner.nextInt();

        String str2 = HeldenListe.get(werte2 -1);
        System.out.println("Character" + str2);
        int LP2 = Leben.get(werte2 -1);
        System.out.println("Character" + LP2);
        int AP2 = Angriff.get(werte2 -1);
        System.out.println("Character" + AP2);


    }
}




