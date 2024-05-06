package feladat1;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Naplo {
    private String vezeteknev;
    private int ID;
    private List<String> hallgatokNevei;
    private List<Jegy> hallgatokJegyei;
    private Map<String, Double> tantargyak;
    private String nev;
    private List<Hallgato> hallgatok;

    public Naplo(String filenev) {
        this.hallgatok = new ArrayList<>();
        this.hallgatokNevei = new ArrayList<>();
        this.tantargyak = new HashMap<>();
        try {
            File theFile = new File("./src/hallgatok.csv");
            Scanner scan = new Scanner(theFile);

            while (scan.hasNextLine()) {
                String sor = scan.nextLine();
                hallgatokNevei.add(sor);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Hiba történt a fájl beolvasása során: " + e.getMessage());
        }
    }

    public List<String> getHallgatokNevei() {
        return hallgatokNevei;
    }

    public void listazNevek() {
        System.out.println("Hallgatok listaja:");
        for (int i = 0; i < hallgatokNevei.size(); i++) {
            String nev = hallgatokNevei.get(i);
            String formazottNev = NevetAlakit(i + 1, nev);
            System.out.println(formazottNev);
        }
    }
    public void listazHallgatoiAdatok () {
        System.out.println("Hallgatók és tantárgy átlagok:");
        for (Hallgato hallgato : hallgatok) {
            System.out.println(hallgato.getNev() + ":");
            Set<String> tantargyNevek = tantargyak.keySet();

            for (String tantargy : tantargyNevek) {
                double atlag = tantargyak.get(tantargy);
                System.out.printf("\t%s: %.1f\n", tantargy, atlag);

            }
        }
    }

    private String NevetAlakit(int id, String nev) {
        String[] resz = nev.split(",");
        if (resz.length >= 2) {
            String vezeteknev = resz[0];
            String keresztnev = resz[1];
            return String.format("%d. %s", id, vezeteknev, keresztnev);
        } else {
            return String.format("%d. %s", id, nev);
        }
    }
}




















