import java.util.Scanner;
public class Fel2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.print("Kérem adjon meg egy szót");
        String szo= scanner.nextLine();

        String ujSzo= szo.replace('a','*');

        System.out.println("Az eredeti szo" + szo);
        System.out.println("A cssere eredménye" + ujSzo);

        scanner.close();

    }
}
