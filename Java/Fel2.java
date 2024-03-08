import java.util.Scanner;

public class Fel2 {
    public static void main(String[] args) {
        String helyesJelszo = "titkos";
        int probalkozasok = 3;

        while (probalkozasok > 0) {
            if (jelszoEllenorzes(helyesJelszo)) {
                System.out.println("Sikeres belépés!");
                break;
            } else {
                probalkozasok--;
                if (probalkozasok > 0) {
                    System.out.println("Hibás jelszó. Még " + probalkozasok + " próbálkozás lehetősége van.");
                } else {
                    System.out.println("Háromszori hibás próbálkozás után leáll a program.");
                }
            }
        }
    }

    public static boolean jelszoEllenorzes(String helyesJelszo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg a jelszót: ");
        String bekertJelszo = scanner.nextLine();
        return bekertJelszo.equals(helyesJelszo);
    }
}

