public  class HorrorFilm extends Film implements IKorhataros {
    @java.lang.Override
    public int buntetes(int ertek) {
        return 0;
    }

    private int korh;

    public HorrorFilm(String cim, double ar, int[] velemenyek, int korh) {
        super(cim, ar, velemenyek);
        this.korh = korh;
    }

    public int getKorh() {
        return korh;
    }

    public void setKorh(int korh) {
        this.korh = korh;
    }

    @Override
    public int korhatar() {
        return korh;
    }

    @Override
    public String toString() {
        return "Film cime: " + getCim() + ", Film ara: " + getAr() + ", Korhatar: " + korh;
    }

    public double Buntetes(int kor) {
        int kulonbseg = kor - korh;
        if (kulonbseg < 0) {
            return Math.abs(kulonbseg) * getAr();
        } else {
            return 0;
        }
    }
}

