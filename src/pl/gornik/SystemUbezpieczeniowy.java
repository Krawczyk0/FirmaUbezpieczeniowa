package pl.gornik;
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
                case 6:
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
                case 7:
                    System.out.print("Podaj nazwę pliku z danymi klienta: ");
                    scanner.nextLine(); 
                    String nazwaPliku = scanner.nextLine();
                    Klient klientZPliku = Klient.wczytajZPliku(nazwaPliku);
                    if (klientZPliku != null) {
                        listaKlientow.add(klientZPliku);
                        System.out.println("Dodano klienta z pliku.");
                    }
                    break;
                case 8:
                    Klient.zakonczenie();
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }
        } while (wybor != 8);
    }
}
