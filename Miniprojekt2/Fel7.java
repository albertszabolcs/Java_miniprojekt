import java.util.Arrays;

public class Fel7 {
    public static void main(String[] args) {
        int[] tomb = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 1, 2, 1};
        System.out.println("többször előfordulo elemek");
        megoldas(tomb);
    }

    public static void megoldas(int[] tomb) {
        Arrays.sort(tomb);
        int jelenlegi = tomb[0];
        int elofordulasok = 1;

        for(int i = 1; i < tomb.length; ++i) {
            if (tomb[i] == jelenlegi) {
                ++elofordulasok;
            } else {
                if (elofordulasok > 1) {
                    System.out.println(jelenlegi);
                }

                jelenlegi = tomb[i];
                elofordulasok = 1;
            }
        }

        if (elofordulasok > 1) {
            System.out.println(jelenlegi);
        }

    }
}

