import java.util.Arrays;


public class Fel8 {
    public static void main(String[] args) {
        int [] tomb = {5, 2, 9, 1, 3};

        Arrays.sort(tomb);

        System.out.println("a növekvő sorrendbe rendezett tömb:");
        for (int num : tomb) {
            System.out.print(num + " ");

        }
    }
}
