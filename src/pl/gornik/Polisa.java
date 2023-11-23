package pl.gornik;

public class Polisa {
    private String typ;
    private double skladka;

    public Polisa(String typ, double skladka) {
        this.typ = typ;
        this.skladka=skladka;
    }

    public String getTyp() {
        return typ;
    }
    public double getSkladka() {
        return skladka;
    }
}
