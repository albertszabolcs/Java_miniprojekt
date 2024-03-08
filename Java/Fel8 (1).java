import java.util.Scanner;
public class Fel8 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int véletlenSzám = (int) (Math.random() * 100) + 1;
            int tipp;
            int próbálkozások = 0;

            System.out.println("Gondoltam egy számra 1 és 100 között. Próbáld meg kitalálni!");

            do {
                System.out.print("Tippelj egy számot: ");
                tipp = scanner.nextInt();
                próbálkozások++;

                if (tipp < véletlenSzám) {
                    System.out.println("Kevés, a szám nagyobb.");
                } else if (tipp > véletlenSzám) {
                    System.out.println("Sok, a szám kisebb.");
                } else {
                    System.out.println("Eltaláltad! A szám: " + véletlenSzám + ". " + próbálkozások + " lépés után.");
                }
            } while (tipp != véletlenSzám);

            scanner.close();
        }
    }
