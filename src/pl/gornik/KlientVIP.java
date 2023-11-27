package pl.gornik;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class KlientVIP extends Klient {
    private double rabat;

    public KlientVIP(String imie, String nazwisko, double rabat) {
        super(imie, nazwisko);
        this.rabat = rabat;
    }

    public KlientVIP(String imie, String nazwisko, List<Polisa> polisy, double rabat) {
        super(imie, nazwisko, polisy);
        this.rabat = rabat;
    }

    public double getRabat() {
        return rabat;
    }

    @Override
    public double obliczSkladkeSumaryczna() {
        double sumaSkladek = super.obliczSkladkeSumaryczna();
        return sumaSkladek - (sumaSkladek * rabat);
    }
}
