package pl.gornik;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Klient implements Serializable {
    public String imie;
    public String nazwisko;
    public List<Polisa> polisy;

    public Klient(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.polisy = new ArrayList<>();
    }

    public Klient(String imie, String nazwisko, List<Polisa> polisy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.polisy = polisy;
    }

    public void dodajPolise(String typ, double skladka) {
        Polisa nowaPolisa = new Polisa(typ, skladka);
        polisy.add(nowaPolisa);
        System.out.println("Dodano polisę dla klienta: " + imie + " " + nazwisko);
    }

    public void usunPolise(String typ) {
        polisy.removeIf(polisa -> polisa.getTyp().equals(typ));
        System.out.println("Usunięto polisę typu " + typ + " dla klienta: " + imie + " " + nazwisko);
    }

    public void wyswietlPolisy() {
        System.out.println("Polisy klienta " + imie + " " + nazwisko + ":");
        for (Polisa polisa : polisy) {
            System.out.println("Typ: " + polisa.getTyp() + ", Składka: " + polisa.getSkladka());
        }
    }

    public double obliczSkladkeSumaryczna() {
        double sumaSkladek = 0;
        for (Polisa polisa : polisy) {
            sumaSkladek += polisa.getSkladka();
        }
        return sumaSkladek;
    }

    public static void powitanie() {
        System.out.println("Witaj w systemie ubezpieczeniowym!");
    }

    public static void zakonczenie() {
        System.out.println("Dziękujemy za skorzystanie z naszych usług. Życzymy bezpiecznych dni!");
    }

    public static Klient wczytajKlienta() {
        Scanner scanner = new Scanner(System.in);
        String imie;
        String nazwisko;

        do {
            System.out.print("Podaj imię klienta (zaczynając od wielkiej litery): ");
            imie = scanner.nextLine().trim();
            if (imie.isEmpty() || !Character.isUpperCase(imie.charAt(0))) {
                System.out.println("Imię nie może być puste i musi zaczynać się od wielkiej litery. Podaj ponownie.");
            }
        } while (imie.isEmpty() || !Character.isUpperCase(imie.charAt(0)));

        do {
            System.out.print("Podaj nazwisko klienta (zaczynając od wielkiej litery): ");
            nazwisko = scanner.nextLine().trim();
            if (nazwisko.isEmpty() || !Character.isUpperCase(nazwisko.charAt(0))) {
                System.out.println("Nazwisko nie może być puste i musi zaczynać się od wielkiej litery. Podaj ponownie.");
            }
        } while (nazwisko.isEmpty() || !Character.isUpperCase(nazwisko.charAt(0)));

        return new Klient(imie, nazwisko);
    }

    public static Polisa wczytajNowaPolise() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj typ polisy: ");
        String typ = scanner.nextLine();
        System.out.print("Podaj składkę polisy: ");
        double skladka = scanner.nextDouble();
        return new Polisa(typ, skladka);
    }

    public void zapiszDoPliku(String nazwaPliku) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            outputStream.writeObject(this);
            System.out.println("Dane klienta zapisane do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }

    public static Klient wczytajZPliku(String nazwaPliku) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            Klient klient = (Klient) inputStream.readObject();
            System.out.println("Dane klienta wczytane z pliku: " + nazwaPliku);
            return klient;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd podczas odczytu z pliku: " + e.getMessage());
            return null;
        }
    }

    public static void wyswietlWszystkichKlientow(List<Klient> listaKlientow) {
        System.out.println("Lista wszystkich klientów:");
        for (int i = 0; i < listaKlientow.size(); i++) {
            Klient klient = listaKlientow.get(i);
            System.out.println(i + ". " + klient.imie + " " + klient.nazwisko);
        }
    }
}
