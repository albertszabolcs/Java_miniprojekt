import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestTranzakcio {
    public static void main(String[] args) {
        Bankszamla bankszamla = new Bankszamlak(1000);
        try {
            bankszamla.betesz(800);
            bankszamla.kivesz(300);
            System.out.println("Egyenleg: " + bankszamla.getEgyenleg());
        } catch (NincsElegPenzException e) {
            System.out.print(e.getMessage());
        }

        RegularisSzamla regularisSzamla = new RegularisSzamla(2000, "Albert Ferenc", "78941315");
        try {
            regularisSzamla.betesz(1000);
            regularisSzamla.kivesz(500);
            System.out.println(regularisSzamla.toString());
        } catch (NincsElegPenzException e) {
            System.out.println(e.getMessage());
        }
        FolyoSzamla folyoSzamla = new FolyoSzamla(5);
        try {
            folyoSzamla.betesz(300);
            folyoSzamla.kivesz(100);
            folyoSzamla.levonKoltseg(50);
            System.out.println("Egyenleg: " + folyoSzamla.getEgyenleg());
        } catch (NincsElegPenzException e) {
            System.out.println(e.getMessage());
        }
        TakarekSzamla takarekSzamla = new TakarekSzamla("Albert Istvan", "647841", 4000, 2.9);
        takarekSzamla.hozzaadKamat();
        System.out.println("Egyenleg kamattal: " + takarekSzamla.getEgyenleg());

        Bankszamla bankszamla1 = new Bankszamlak(1000);
        FolyoSzamla folyoszamla1 = new FolyoSzamla(5);

        System.out.println("Bankszamla és FolyoSzamla egyenlőségének ellenőrzése: ");
        System.out.println("bankszamla1.equals(folyoSzamla1): " + bankszamla1.equals(folyoszamla1));

        RegularisSzamla regularisSzamla1 = new RegularisSzamla(2000, "Albert Ferenc", "784191");
        System.out.println("regularis es folyoszamla egyenlőségének ellenőrzése: ");
        System.out.println("regularisSzamla1.equals(folyoszamla1)): " + regularisSzamla.equals(folyoszamla1));

        ArrayList<Tranzakcio> tranzakciok = new ArrayList<>();
        tranzakciok.add(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.DEPOSIT, 500));
        tranzakciok.add(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.WITHDRAW, 300));
        tranzakciok.add(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.DEPOSIT, 200));
        tranzakciok.add(new Tranzakcio(LocalDateTime.now(), TranzakcioTipus.WITHDRAW, 800));

        System.out.println("A szemely DEPOSIT tipusu tranzakcioi");
        for (Tranzakcio tranzakcio : tranzakciok) {
            if (tranzakcio.getTranzTipus() == TranzakcioTipus.DEPOSIT) {
                System.out.println(tranzakcio);
            }
        }
        kamatszamitas();
    }

    public static void kamatszamitas() {
        TakarekSzamla takarekSzamla = new TakarekSzamla("Albert Istvan", "687895", 5000, 2.6);
        takarekSzamla.hozzaadKamat();
        System.out.println("Egyenleg kamattal: " + takarekSzamla.getEgyenleg());
    }
}






