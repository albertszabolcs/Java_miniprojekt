import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Fel3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adjon meg egy karakterláncot");
        String karakterlanc = scanner.nextLine();
        StringBuilder eredmeny = new StringBuilder();
        Set<Character> karakterHalmaz = new LinkedHashSet();

        for(int i = 0; i < karakterlanc.length(); ++i) {
            char karakter = karakterlanc.charAt(i);
            if (!karakterHalmaz.contains(karakter)) {
                karakterHalmaz.add(karakter);
                eredmeny.append(karakter);
            }
        }

        System.out.println("Eredmeny: " + eredmeny.toString());
        scanner.close();
    }
}

