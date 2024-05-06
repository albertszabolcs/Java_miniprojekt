package feladat1;

import java.util.ArrayList;

public final class Jegy {
    private final String tantargyNeve;
    private final int jegy;
    private String hallgatokJegyei;

    public Jegy(String tantargyNeve, int jegy) {
        this.tantargyNeve = tantargyNeve;
        this.jegy = jegy;
    }


    public String getTantargyNeve() {
        return tantargyNeve;
    }

    public int getJegy() {
        return jegy;
    }
    @Override
    public String toString() {
        return "Jegy{" +
                "tantargyNeve='" + tantargyNeve + '\'' +
                ", jegy=" + jegy +
                '}';
    }
}


