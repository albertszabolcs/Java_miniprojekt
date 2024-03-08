import java.util.Scanner;

public class Fel3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Adja meg az első számot:");
            double szam1 = scanner.nextDouble();

            System.out.println("Adja meg a második számot:");
            double szam2 = scanner.nextDouble();

            System.out.println("Adja meg a művelet kódját:");
            System.out.println("1 - összeadás");
            System.out.println("2 - kivonás");
            System.out.println("3 - szorzás");
            System.out.println("4 - osztás");
            System.out.println("5 - Kilépés");

            int valasztas = scanner.nextInt();

            double eredmeny = 0;

            switch (valasztas) {
                case 1:
                    eredmeny = szam1 + szam2;
                    break;
                case 2:
                    eredmeny = szam1 - szam2;
                    break;
                case 3:
                    eredmeny = szam1 * szam2;
                    break;
                case 4:
                    if (szam2 != 0) {
                        eredmeny = szam1 / szam2;
                    } else {
                        System.out.println("Hiba: Nullával való osztás nem megengedett!");
                        continue; // Ismét menü megjelenítése
                    }
                    break;
                case 5:
                    System.out.println("Kilépés...");
                    return;
                default:
                    System.out.println("Érvénytelen választás. Kérem próbálja újra.");
                    continue; // Ismét menü megjelenítése
            }

            System.out.println("Eredmény: " + eredmeny);
        }
    }
}