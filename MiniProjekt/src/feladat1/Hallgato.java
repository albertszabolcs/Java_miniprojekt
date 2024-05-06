package feladat1;

import java.util.*;

public class Hallgato {
    private String nev;
    private final int Id;
    private static int kovetkezoId = 0;
    private final String vezeteknev;
    private final String keresztnev;
    private List<Jegy> jegyek;
    private Map<String, Double> tantargyak;

    public Hallgato(String vezeteknev, String keresztnev) {
        this.Id = ++kovetkezoId;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.jegyek = new ArrayList<>();
        this.tantargyak = new HashMap<>();
    }

    public int getId() {
        return Id;
    }

    public String getNev() {
        return nev;
    }

    public double atlagJegy() {
        if (jegyek.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Jegy jegy : jegyek) {
            sum += jegy.getJegy();
        }
        return (double) sum / jegyek.size();
    }


    public void ujJegy( Jegy jegy) {
        if (Id == this.Id) {
            jegyek.add(jegy);
            System.out.println("Uj jegy hozzaadva a hallgatohoz");
        } else {
            System.out.println("Hiba hallgato azonosito");
        }
    }

    public void tantargyHozzaadas(String tantargy, double atlag) {
        tantargyak.put(tantargy,atlag);
    }
    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void ujBejegyzes(Jegy ujJegy) {
        jegyek.add(ujJegy);
    }

    public double tantargyAtlag(String tantargyNeve) {
        int osszeg = 0;
        int szamol = 0;

        for (Jegy jegy : jegyek) {
            if (jegy.getTantargyNeve().equals(tantargyNeve)) {
                osszeg += jegy.getJegy();
                szamol++;
            }
        }
        if (szamol == 0) {
            return 0;
        }
        return (double) osszeg / szamol;
    }

    public List<String> getTantargyak() {
        Set<String> tantargyakHalmaz = new HashSet<>();

        for (Jegy jegy : jegyek) {
            tantargyakHalmaz.add(jegy.getTantargyNeve());
        }
        return new ArrayList<>(tantargyakHalmaz);
    }
    public void listazas() {
        System.out.println( vezeteknev + " " + keresztnev);
        List<String> tantargyak =new ArrayList<>(Arrays.asList("Matek","Roman","Magyar"));


        for (String tantargy : tantargyak) {
            double atlag = tantargyAtlag(tantargy);
            System.out.printf("%s: %.1f\n",tantargy, atlag);
        }
    }
}






