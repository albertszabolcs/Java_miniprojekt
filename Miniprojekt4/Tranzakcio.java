import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

interface Bankszamla {
    void betesz(double osszeg);
    void kivesz(double osszeg) throws NincsElegPenzException;
    double getEgyenleg();
}
class NincsElegPenzException extends Exception {
    public NincsElegPenzException(String uzenet) {
        super(uzenet);
    }
}

enum TranzakcioTipus {
    DEPOSIT,
    WITHDRAW
}
public class Tranzakcio {
    private LocalDateTime idopont;
    private TranzakcioTipus tranzTipus;
    private double osszeg;

    public Tranzakcio(LocalDateTime idopont, TranzakcioTipus tranzTipus, double osszeg) {
        this.idopont = idopont;
        this.tranzTipus = tranzTipus;
        this.osszeg = osszeg;
    }

    public LocalDateTime getIdopont() {
        return idopont;
    }

    public TranzakcioTipus getTranzTipus() {
        return tranzTipus;
    }

    public double getOsszeg() {
        return osszeg;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formazottIdopont = idopont.format(formatter);
        return "Tranzakció időpontja: " + formazottIdopont + ", Tranzakcio tipusa: " + tranzTipus + ", Összeg: " + osszeg;
    }

}
class Bankszamlak implements Bankszamla {

    private double egyenleg;

    public Bankszamlak(double kezdoEgyenleg) {
        this.egyenleg= kezdoEgyenleg;
    }
    @Override
    public void betesz(double osszeg) {
        this.egyenleg += osszeg;
        System.out.println(osszeg + "Ft befizetve.Az uj egyenleg: " + this.egyenleg + "Ft");
    }
        @Override
    public void kivesz(double osszeg) throws NincsElegPenzException {
        if (this.egyenleg >= osszeg) {
            this.egyenleg -= osszeg;
            System.out.println(osszeg + "Ft kivéve.Az uj egyenleg: " + this.egyenleg + "Ft");
        } else {
            throw new NincsElegPenzException("Nincs elég pénz a számlán");
        }
    }

    @Override
    public double getEgyenleg() {
        return this.egyenleg;
    }
}
class RegularisSzamla implements Bankszamla {
    private double egyenleg;
    private String tulajdonosNeve;
    private String szamlaszam;
    private int szamlakSzama= 0;
    private ArrayList<Tranzakcio> tranzakciok;
    private static final double alap_kamat = 0.02;

    public RegularisSzamla(double egyenleg, String tulajdonosNeve, String szamlaszam) {
        this.egyenleg = egyenleg;
        this.tulajdonosNeve = tulajdonosNeve;
        this.szamlaszam = szamlaszam;
        this.tranzakciok = new ArrayList<>();
        szamlakSzama++;
    }

    private void ujSzamlaSzam() {
        szamlakSzama++;
    }
    public void tranzakcióHozzáadása(Tranzakcio tranzakcio) {
        tranzakciok.add(tranzakcio);
    }
    public void kivesz (double osszeg) throws NincsElegPenzException {
        if (osszeg < 0) {
            throw new IllegalArgumentException("Az összeg nem lehet negativ");
        }
        if (osszeg > egyenleg) {
            throw new NincsElegPenzException("Nincs elég pénz a kivételhez");
        }
        egyenleg-= osszeg;
        tranzakcióHozzáadása(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.WITHDRAW, osszeg));
    }
    public void betesz (double osszeg){
        egyenleg += osszeg;
        tranzakcióHozzáadása(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.DEPOSIT, osszeg));
    }
    public void kamatszamitas() {
        double kamatOsszeg = egyenleg * (alap_kamat/100);
        egyenleg +=kamatOsszeg;
        System.out.println("Kamatszamitas.Uj egyenleg " + egyenleg);

    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Számla száma:").append(szamlaszam).append("\n");
        sb.append("Tulajdonos neve: ").append(tulajdonosNeve).append("\n");
        sb.append("Egyenleg: \n").append(egyenleg).append("\n");
        sb.append("Tranzakciok: \n");

        for (Tranzakcio tranzakcio: tranzakciok){
            sb.append(tranzakcio).append("\n");
        }
        return sb.toString();
    }


    @Override
    public double getEgyenleg() {
        return this.egyenleg;
    }
}
class FolyoSzamla implements Bankszamla {
    private double egyenleg;
    private int tranzakciokSzama;
    private static final double alap_hitelkeret = 1000;
    private static final double alap_kamat = 0.05;
    private static final int ingyenes_tranzakciokszama = 10;
    private static final int tranzakcioAra = 100;

    public FolyoSzamla(int tranzakciokSzama) {
        this.tranzakciokSzama = tranzakciokSzama;
        this.egyenleg = 0;
    }

    public void levonKoltseg(double osszeg) throws NincsElegPenzException {
        int levonandoOsszeg = tranzakcioAra * Math.max(0, tranzakciokSzama - ingyenes_tranzakciokszama);
        if (egyenleg >= levonandoOsszeg) {
            egyenleg -= levonandoOsszeg;
            tranzakciokSzama++;
        } else {
            throw new NincsElegPenzException("Nincs elegendő pénz a levonáshoz");
        }
        tranzakciokSzama = 0;
    }
    @Override
    public void betesz(double osszeg) {
        tranzakciokSzama++;
        this.egyenleg += osszeg;
    }
    @Override
    public void kivesz(double osszeg) throws NincsElegPenzException {
        tranzakciokSzama++;
        this.egyenleg -= osszeg;
    }
    @Override
    public double getEgyenleg() {
        return this.egyenleg;
    }
    public void kamatszamitas() {
        double kamatOsszeg = egyenleg * (alap_kamat/ 100);
        egyenleg += kamatOsszeg;
        System.out.println("Kamatszamitas tortent.Uj egyenleg" + egyenleg);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FolyoSzamla)) {
            return false;
        }

        FolyoSzamla f = (FolyoSzamla) obj;
        return tranzakciokSzama == f.tranzakciokSzama;
    }
}
class TakarekSzamla {
    private String tulajdonosNeve;
    private String szamlaszam;
    private double egyenleg;
    private double kamatRata;

    public TakarekSzamla(String tulajdonosNeve, String szamlaszam, double egyenleg, double kamatRata) {
        this.tulajdonosNeve = tulajdonosNeve;
        this.szamlaszam = szamlaszam;
        this.egyenleg = egyenleg;
        this.kamatRata = kamatRata;
    }

    public double getEgyenleg() {
        return egyenleg;
    }

    public void setEgyenleg(double egyenleg) {
        this.egyenleg = egyenleg;
    }

    public double getKamatRata() {
        return kamatRata;
    }

    public void setKamatRata(double kamatRata) {
        this.kamatRata = kamatRata;
    }

    public void hozzaadKamat() {
        double kamatOsszeg = egyenleg * (kamatRata / 100);
        egyenleg += kamatOsszeg;
    }
    public void kamatszamitas() {
        hozzaadKamat();
        System.out.println("Kamatszamitas tortent.Az uj egyenleg " + egyenleg);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TakarekSzamla)) {
            return false;
        }
        TakarekSzamla a = (TakarekSzamla) obj;
        return Objects.equals(tulajdonosNeve, a.tulajdonosNeve) &&
                Objects.equals(szamlaszam, a.szamlaszam) &&
                kamatRata == a.kamatRata;
    }
}










