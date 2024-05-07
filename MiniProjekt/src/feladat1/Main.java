package feladat1;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hallgato hallgato = new Hallgato( "Nagy", "Elemer");
        hallgato.ujBejegyzes(new Jegy("Matek", 10));
        hallgato.ujBejegyzes(new Jegy("Matek", 8));
        hallgato.ujBejegyzes(new Jegy("Roman", 7));
        hallgato.ujBejegyzes(new Jegy("Roman", 8));
        hallgato.ujBejegyzes(new Jegy("Magyar", 9));
        hallgato.listazas();
        hallgato.tantargyHozzaadas("Matek",5);
        ArrayList<String> tantargyak = new ArrayList<>(Arrays.asList("Matek", "Roman", "Magyar"));
        ArrayList<String> hallgatokNevei = new ArrayList<>();
        Map<Integer, Hallgato> hallgatok = new HashMap<>();
        try {
            File File = new File("./src/jegyek.txt");
            Scanner scanner = new Scanner(File);

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                hallgatokNevei.add(sor);
            }
            scanner.close();
            for (String sor : hallgatokNevei) {
                System.out.println(sor);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Hiba történt a fájl beolvasása során: " + e.getMessage());
        }
        Naplo naplo = new Naplo("hallgatok.csv");
        naplo.listazNevek();
        naplo.listazHallgatoiAdatok();

    }
}



