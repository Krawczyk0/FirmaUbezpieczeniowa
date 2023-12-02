package pl.gornik;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SystemUbezpieczeniowy {
    public static void main(String[] args) {
        Klient.powitanie();
        List<Klient> listaKlientow = ListaKlientow();

        int wybor;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj nowego klienta");
            System.out.println("2. Dodaj polisę dla klienta");
            System.out.println("3. Usuń polisę klienta");
            System.out.println("4. Wyświetl polisy klienta");
            System.out.println("5. Wyświetl wszystkich klientów");
            System.out.println("6. Wyświetl dane klienta");
            System.out.println("7. Zapisz dane klienta do pliku");
            System.out.println("8. Wczytaj dane klienta z pliku");
            System.out.println("9. Zakończ");

            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    Klient nowyKlient = Klient.wczytajKlienta();
                    listaKlientow.add(nowyKlient);
                    System.out.println("Dodano nowego klienta.");
                    break;
                case 2:
                    if (!listaKlientow.isEmpty()) {
                        System.out.print("Podaj indeks klienta: ");
                        int indeksKlienta = scanner.nextInt();
                        if (indeksKlienta >= 0 && indeksKlienta < listaKlientow.size()) {
                            Klient klient = listaKlientow.get(indeksKlienta);
                            Polisa nowaPolisa = Klient.wczytajNowaPolise();
                            klient.dodajPolise(nowaPolisa.getTyp(), nowaPolisa.getSkladka());
                            System.out.println("Dodano polisę dla klienta.");
                        } else {
                            System.out.println("Nieprawidłowy indeks klienta.");
                        }
                    } else {
                        System.out.println("Brak klientów. Dodaj nowego klienta.");
                    }
                    break;
                case 3:
                    if (!listaKlientow.isEmpty()) {
                        System.out.print("Podaj indeks klienta: ");
                        int indeksKlienta = scanner.nextInt();
                        if (indeksKlienta >= 0 && indeksKlienta < listaKlientow.size()) {
                            Klient klient = listaKlientow.get(indeksKlienta);
                            scanner.nextLine();
                            System.out.print("Podaj typ polisy do usunięcia: ");
                            String typPolisy = scanner.nextLine();
                            klient.usunPolise(typPolisy);
                        } else {
                            System.out.println("Nieprawidłowy indeks klienta.");
                        }
                    } else {
                        System.out.println("Brak klientów.");
                    }
                    break;
                case 4:
                    if (!listaKlientow.isEmpty()) {
                        System.out.print("Podaj indeks klienta: ");
                        int indeksKlienta = scanner.nextInt();
                        if (indeksKlienta >= 0 && indeksKlienta < listaKlientow.size()) {
                            Klient klient = listaKlientow.get(indeksKlienta);
                            klient.wyswietlPolisy();
                        } else {
                            System.out.println("Nieprawidłowy indeks klienta.");
                        }
                    } else {
                        System.out.println("Brak klientów.");
                    }
                    break;
                case 5:
                    if (!listaKlientow.isEmpty()) {
                        Klient.wyswietlWszystkichKlientow(listaKlientow);
                    } else {
                        System.out.println("Brak klientów.");
                    }
                    break;
                case 6:
                    if (!listaKlientow.isEmpty()) {
                        System.out.print("Podaj indeks klienta: ");
                        int indeksKlienta = scanner.nextInt();
                        if (indeksKlienta >= 0 && indeksKlienta < listaKlientow.size()) {
                            Klient klient = listaKlientow.get(indeksKlienta);
                            System.out.println("Dane klienta:");
                            System.out.println("Imię: " + klient.imie);
                            System.out.println("Nazwisko: " + klient.nazwisko);
                            System.out.println("Suma składek: " + klient.obliczSkladkeSumaryczna());
                        } else {
                            System.out.println("Nieprawidłowy indeks klienta.");
                        }
                    } else {
                        System.out.println("Brak klientów.");
                    }
                    break;
                case 7:
                    if (!listaKlientow.isEmpty()) {
                        System.out.print("Podaj indeks klienta: ");
                        int indeksKlienta = scanner.nextInt();
                        if (indeksKlienta >= 0 && indeksKlienta < listaKlientow.size()) {
                            Klient klient = listaKlientow.get(indeksKlienta);
                            klient.zapiszDoPliku("klient_" + indeksKlienta + ".dat");
                        } else {
                            System.out.println("Nieprawidłowy indeks klienta.");
                        }
                    } else {
                        System.out.println("Brak klientów.");
                    }
                    break;
                case 8:
                    System.out.print("Podaj nazwę pliku z danymi klienta: ");
                    scanner.nextLine();
                    String nazwaPliku = scanner.nextLine();
                    Klient klientZPliku = Klient.wczytajZPliku(nazwaPliku);
                    if (klientZPliku != null) {
                        listaKlientow.add(klientZPliku);
                        System.out.println("Dodano klienta z pliku.");
                    }
                    break;
                case 9:
                    Klient.zakonczenie();
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }
        } while (wybor != 9);
    }
    private static List<Klient> ListaKlientow() {
        List<Klient> lista = new ArrayList<>();

        Klient klient1 = new Klient("Jan", "Kowalski");
        klient1.dodajPolise("Auto", 1200.0);
        klient1.dodajPolise("Mieszkanie", 1800.0);

        Klient klient2 = new Klient("Anna", "Nowak");
        klient2.dodajPolise("Zdrowie", 800.0);
        klient2.dodajPolise("Życie", 1500.0);

        Klient klient3 = new KlientVIP("Marek", "Kwiatkowski", 0.1);
        klient3.dodajPolise("Dom", 2500.0);
        klient3.dodajPolise("Odpowiedzialność cywilna", 1200.0);

        Klient klient4 = new Klient("Katarzyna", "Wójcik");
        klient4.dodajPolise("Auto", 1300.0);
        klient4.dodajPolise("Mieszkanie", 2000.0);

        Klient klient5 = new Klient("Piotr", "Lis");
        klient5.dodajPolise("Zdrowie", 900.0);
        klient5.dodajPolise("Życie", 1700.0);

        Klient klient6 = new KlientVIP("Agnieszka", "Nowicka", 0.15);
        klient6.dodajPolise("Dom", 2800.0);
        klient6.dodajPolise("Odpowiedzialność cywilna", 1300.0);

        Klient klient7 = new Klient("Michał", "Kowalczyk");
        klient7.dodajPolise("Auto", 1400.0);
        klient7.dodajPolise("Mieszkanie", 2200.0);

        Klient klient8 = new Klient("Monika", "Szymańska");
        klient8.dodajPolise("Zdrowie", 950.0);
        klient8.dodajPolise("Życie", 1800.0);

        Klient klient9 = new KlientVIP("Grzegorz", "Kowalski", 0.2);
        klient9.dodajPolise("Dom", 3000.0);
        klient9.dodajPolise("Odpowiedzialność cywilna", 1400.0);

        lista.add(klient1);
        lista.add(klient2);
        lista.add(klient3);
        lista.add(klient4);
        lista.add(klient5);
        lista.add(klient6);
        lista.add(klient7);
        lista.add(klient8);
        lista.add(klient9);

        return lista;
    }
    private static Klient dodajNowegoKlienta() {
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
}
