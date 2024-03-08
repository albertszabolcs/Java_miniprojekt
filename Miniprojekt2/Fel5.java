import java.util.Arrays;

public class Fel5 {
    public static void main(String[] args) {
        int[] tomb = new int[]{1, 2, 3, 4, 5};
        System.out.println("Eredeti tömb: " + Arrays.toString(tomb));
        if (tomb.length >= 2) {
            int temp = tomb[0];
            tomb[0] = tomb[tomb.length - 1];
            tomb[tomb.length - 1] = temp;
        } else {
            System.out.println("a tömbben nincs elég elem a cseréhez");
        }

        System.out.println("Modositott tömb: " + Arrays.toString(tomb));
    }
}

