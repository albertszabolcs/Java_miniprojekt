public class Fel5 {
        public static void main(String[] args) {
            String szoveg = "HelloWorld"; //

            if (csakBetuketTartalmaz(szoveg)) {
                System.out.println("A(z) \"" + szoveg + "\" szöveg csak alfabetikus karaktereket tartalmaz.");
            } else {
                System.out.println("A(z) \"" + szoveg + "\" szöveg nem csak alfabetikus karaktereket tartalmaz.");
            }
        }

        public static boolean csakBetuketTartalmaz(String szoveg) {
            for (int i = 0; i < szoveg.length(); i++) {
                char karakter = szoveg.charAt(i);
                if (!Character.isLetter(karakter)) {
                    return false;
                }
            }
            return true;
        }
    }

