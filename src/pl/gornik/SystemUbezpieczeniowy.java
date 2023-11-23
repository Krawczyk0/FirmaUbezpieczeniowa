package pl.gornik;

import java.util.Scanner;

public class SystemUbezpieczeniowy {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String imie;
        String nazwisko;
        String typ;
        double wartosc;

        Klient.powitanie();

        Klient klient1=new Klient("Jan", "Kowalski");
        klient1.dodajPolise("Mieszkanie",  750);
        klient1.wyswietlPolisy();
        double sumaSkladekKlienta1=klient1.obliczSkladke();
        System.out.println("Suma składek klienta "  + klient1 + ":" + sumaSkladekKlienta1);
        scanner.nextLine();

        KlientVIP klient2=new KlientVIP("Anna", "Nowak",  0.2);
        klient2.dodajPolise("Samochod", 500);
        klient2.wyswietlPolisy();
        double sumaSkladekKlienta2=klient2.obliczSkladke();
        System.out.println("Suma skladek klienta " + klient2 + ":" + sumaSkladekKlienta2);
        scanner.nextLine();


        Klient klient3= new Klient("Zbyszek", "Jakiś");
        klient3.dodajPolise("Życiowa", 400);
        klient3.wyswietlPolisy();
        double sumaSkladekKlienta3= klient3.obliczSkladke();
        System.out.println("Suma skladek klienta " + klient3 + ":" + sumaSkladekKlienta3);
        scanner.nextLine();


        klient3.usunPolise("Życiowa");
        scanner.nextLine();


        System.out.println("Podaj imie");
        imie=scanner.nextLine();
        System.out.println("Podaj nazwisko");
        nazwisko=scanner.nextLine();
        System.out.println("Podaj rodzaj polisy");
        typ=scanner.nextLine();
        System.out.println("Podaj wartosc polisy");
        wartosc=scanner.nextDouble();
        System.out.printf("Twoja suma skladek wynosi");


        Klient.zakonczenie();
    }
}
