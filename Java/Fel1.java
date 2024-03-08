import java.util.Scanner;

public class Fel1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adjon meg egy számot 1 és 10 között: ");
        int szam = scanner.nextInt();

        if (szam < 1 || szam > 10) {
            System.out.println("Hibás bemenet. Kérem adjon meg egy számot 1 és 10 között.");
            return;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(szam + " x " + i + " = " + (szam * i));
        }
    }
}


