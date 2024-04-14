import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Teszter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Film> filmek = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            System.out.println("Kérlek add meg a film adatait");
            System.out.print("Cím: ");
            String cim = scanner.nextLine();
            System.out.print("Ár: ");
            double ar = Double.parseDouble(scanner.nextLine());

            Film film = new Film(cim, ar, new int[0]);
            filmek.add(film);
        }


        for (int i = 0; i < 6; i++) {
            System.out.println("Kérlek add meg a horrorfilm adatait");
            System.out.print("Cím: ");
            String cim = scanner.nextLine();
            System.out.print("Ár: ");
            double ar = Double.parseDouble(scanner.nextLine());
            System.out.print("Korhatár: ");
            int korhatar = Integer.parseInt(scanner.nextLine());

            HorrorFilm horrorFilm = new HorrorFilm(cim, ar, new int[0], korhatar);
            filmek.add(horrorFilm);
        }


        Collections.sort(filmek, Comparator.comparing(Film::getAr));


        System.out.println("Filmek rendezve ár szerint:");
        for (Film film : filmek) {
            System.out.println(film);
        }
    }
}