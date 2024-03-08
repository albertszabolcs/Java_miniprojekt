import java.util.Scanner;
public class Fel7 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Kérlek válassz egy opciót:");
            System.out.println("1 - Pohár nélküli kávé (alap ár)");
            System.out.println("2 - Dupla cukorral (20 Ft plusz)");
            System.out.println("3 - Habos kávé (50 Ft plusz)");

            int valasztas = scanner.nextInt();

            int ar;
            String megrendeltKave = "";

            switch (valasztas) {
                case 1:
                    ar = 100; // Alapár
                    megrendeltKave = "Pohár nélküli kávé";
                    break;
                case 2:
                    ar = 120; // Alapár + 20 Ft dupla cukorral
                    megrendeltKave = "Dupla cukorral";
                    break;
                case 3:
                    ar = 150; // Alapár + 50 Ft habbal
                    megrendeltKave = "Habos kávé";
                    break;
                default:
                    System.out.println("Érvénytelen választás. Kérem próbálja újra.");
                    return;
            }

            System.out.println("Megrendelt kávé: " + megrendeltKave);
            System.out.println("Ár: " + ar + " Ft");

            System.out.print("Kérlek add meg a fizetendő összeget: ");
            int fizetettOsszeg = scanner.nextInt();

            if (fizetettOsszeg >= ar) {
                int visszajaro = fizetettOsszeg - ar;
                System.out.println("Köszönjük a vásárlást! Visszajáró: " + visszajaro + " Ft");
            } else {
                System.out.println("Nem megfelelő összeg. A kávé " + (ar - fizetettOsszeg) + " Ft-tal drágább.");
            }
        }
    }

