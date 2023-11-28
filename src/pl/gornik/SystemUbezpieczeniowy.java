package pl.gornik;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SystemUbezpieczeniowy {
    public static void main(String[] args) {
        Klient.powitanie();
        List<Klient> listaKlientow = new ArrayList<>();
        initializeKlient(listaKlientow);

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
                            scanner.nextLine(); // Konsumuj znak nowej linii
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
                    scanner.nextLine(); // Konsumuj znak nowej linii
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

    public static void initializeKlient(List<Klient> listaKlientow) {
        listaKlientow.add(new Klient("Jan", "Kowalski"));
        listaKlientow.add(new Klient("Zbyszek","Nowak"));
        listaKlientow.add(new Klient("Paweł","Stolarski"));
        listaKlientow.add(new KlientVIP("Izydor","Komorowski",5));
        listaKlientow.add(new KlientVIP("Henryk","Belek",3));
        listaKlientow.add(new KlientVIP("Jacek","Baran",2.5));
    }
}
