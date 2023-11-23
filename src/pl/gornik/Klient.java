package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private List<Polisa> polisy;


    public Klient(String imie, String nazwisko) {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.polisy=new ArrayList<>();
    }

    public Klient(String imie, String nazwisko, List<Polisa> polisy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.polisy = polisy;
    }
    public void dodajPolise(String typ, double skladka) {
        Polisa nowaPolisa=new Polisa(typ, skladka);
        polisy.add(nowaPolisa);
        System.out.println("Dodano polise dla klienta: " + imie + " " + nazwisko);
    }
    public void usunPolise(String typ) {
        polisy.removeIf(polisa -> polisa.getTyp().equals(typ));
        System.out.println("Usunieto polise dla klienta: " + imie + " " + nazwisko);
    }
    public void wyswietlPolisy() {
        System.out.println("Polisy klienta " + imie + " " + nazwisko + ":");
        for (Polisa polisa : polisy) {
            System.out.println("Typ: " + polisa.getTyp() + ",Skladka: " + polisa.getSkladka());
        }
    }

    public double obliczSkladke() {
        double sumaSkladek=0;
        for(Polisa polisa: polisy) {
            sumaSkladek +=polisa.getSkladka();
        }
        return sumaSkladek;
    }
    public static void powitanie() {
        System.out.println("Witaj w naszej firmie ubezpieczeniowej");
    }
    public static void zakonczenie() {
        System.out.println("Dziękujemy za skorzystanie z naszych usług");
    }
}
