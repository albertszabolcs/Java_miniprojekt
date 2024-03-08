public class Fel6 {
        public static void main(String[] args) {
            int[] tomb1 = {1, 2, 3, 4, 5};
            int[] tomb2 = {1, 2, 3, 4, 5};
            int[] tomb3 = {1, 2, 3, 4, 6};

            System.out.println("tomb1 és tomb2 egyenlő: " + egyenlo(tomb1, tomb2));
            System.out.println("tomb1 és tomb3 egyenlő: " + egyenlo(tomb1, tomb3));
        }

        public static boolean egyenlo(int[] tomb1, int[] tomb2) {
            if (tomb1.length != tomb2.length) {
                return false;
            }
            for (int i = 0; i < tomb1.length; i++) {
                if (tomb1[i] != tomb2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

