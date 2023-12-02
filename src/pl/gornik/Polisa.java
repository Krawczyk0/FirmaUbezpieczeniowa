package pl.gornik;
import java.io.*;


class Polisa implements Serializable {
    private String typ;
    private double skladka;

    public Polisa(String typ, double skladka) {
        this.typ = typ;
        this.skladka = skladka;
    }

    public String getTyp() {
        return typ;
    }

    public double getSkladka() {
        return skladka;
    }
}
