public class Film {
    private String cim;
    private double ar;
    private int[] velemenyek = new int[20];
    private int velemenyIndex = 0;

    public Film(String cim, double ar, int[] velemenyek) {
        this.cim = cim;
        this.ar = ar;
        this.velemenyek = velemenyek;
        if (velemenyek.length > 20) {
            System.out.print("a vélemények tömb mérete nem lehet nagyobb mint 20");
        }
        for (int i = 0; i < velemenyek.length; i++) {
            this.velemenyek[i] = velemenyek[i];
            velemenyIndex++;
        }
    }

    public String getCim() {
        return cim;
    }

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }

    public int[] getVelemenyek() {
        return velemenyek;
    }

    public void Velemenyezes(int velemeny) {
        if (velemenyIndex < 20) {
            velemenyek[velemenyIndex++] = velemeny;
        } else {
            System.out.print("Nem lehet több vélemény hozzáadni");
        }
    }

    @Override
    public String toString() {
        return "Film cime: " + this.cim + ",Film ara: " + this.ar;
    }

    public double Atlag() {
        double sum = 0;
        for (int i = 0; i < velemenyIndex; i++) {
            sum += velemenyek[i];
        }
        return sum / velemenyIndex;
    }
}
