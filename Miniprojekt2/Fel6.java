public class Fel6 {
    public static void main(String[] args) {
        int[] tomb = new int[]{5, 3, 9, 2, 8, 1};
        int legkisebb = tomb[0];
        int legnagyobb = tomb[0];

        for(int i = 1; 1 < tomb.length; ++i) {
            if (tomb[i] < legkisebb) {
                legkisebb = tomb[i];
            }

            if (tomb[i] > legnagyobb) {
                legnagyobb = tomb[i];
            }
        }

    }
}


