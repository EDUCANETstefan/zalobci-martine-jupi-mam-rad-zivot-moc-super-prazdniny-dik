package Zalobci;

public class Zalobce {

    final int rok;
    final String nazev;
    final double castka;



    public Zalobce(int rok, String nazev, double castka) {
        this.rok = rok;
        this.nazev = nazev;
        this.castka = castka;
    }

    public double getCastka() {
        return castka;
    }

    public String getNazev() {
        return nazev;
    }
}
