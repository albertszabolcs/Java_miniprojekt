import java.util.Scanner;

public class Fel4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adjon meg egy karakterláncot: ");
        String karakterlanc = scanner.nextLine();
        StringBuilder tomoritettKarakterlanc = new StringBuilder();
        int szamlalo = 1;

        for(int i = 0; i < karakterlanc.length() - 1; ++i) {
            if (karakterlanc.charAt(i) == karakterlanc.charAt(i + 1)) {
                ++szamlalo;
            } else {
                tomoritettKarakterlanc.append(karakterlanc.charAt(i));
                tomoritettKarakterlanc.append(szamlalo);
                szamlalo = 1;
            }
        }

        tomoritettKarakterlanc.append(karakterlanc.charAt(karakterlanc.length() - 1));
        tomoritettKarakterlanc.append(szamlalo);
        System.out.println("Tömörített karakterlánc: " + tomoritettKarakterlanc.toString());
        scanner.close();
    }
}


