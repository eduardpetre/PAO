package view;

import Entitati.*;
import Servicii.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
    private Scanner scanner = new Scanner(System.in);

    private final ServiciuAdresa serviciuAdresa = new ServiciuAdresa().getInit();
    private final ServiciuAngajat serviciuAngajat = new ServiciuAngajat();
    private final ServiciuBiblioteca serviciuBiblioteca = new ServiciuBiblioteca().getInit();
    private final ServiciuCarte serviciuCarte = new ServiciuCarte().getInit();
    private final ServiciuCititor serviciuCititor = new ServiciuCititor();

    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp();
        while (true) {
            clientApp.showMenu();
        }
    }

    private void showMenu() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Welcome to Library Management Platform");
        System.out.println("What do you want to do?");
        System.out.println("1. Meniu adrese");
        System.out.println("2. Meniu biblioteci");
        System.out.println("3. Meniu carti");
        System.out.println("4. Meniu utilizatori");
        System.out.println("0. exit");

        int option = readOption(5);
        switch (option) {
            case 1: {
                meniuAdresa();
                break;
            }
            case 2: {
                meniuBiblioteca();
                break;
            }
            case 3: {
                meniuCarte();
                break;
            }
            case 4: {
//                meniuUtilizatori();
                break;
            }
            case 0: {
                scanner.close();
                System.exit(0);
            }
        }
    }

//    private void execute(int option) {
//
//    }

    private void meniuAdresa() {
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Meniu adrese");
            System.out.println("De ce ai nevoie?");
            System.out.println("1. Adauga o adresa");
            System.out.println("2. Arata toate adresele");
            System.out.println("3. Cauta o adresa dupa id");
            System.out.println("4. Actualizeaza datele despre o adresa");
            System.out.println("5. Sterge o adresa");
            System.out.println("0. Inapoi");

            int option = readOption(5);
            switch (option) {
                case 1: {
                    adaugaAdresa();
                    break;
                }
                case 2: {
                    afiseazaAdresele();
                    break;
                }
                case 3: {
                    cautaAdresaDupaId();
                    break;
                }
                case 4: {
                    actualizeazaAdresa();
                    break;
                }
                case 5: {
                    stergeAdresa();
                    break;
                }
                case 0: {
                    showMenu();
                    break;
                }
            }
        }

    }

    private void adaugaAdresa(){
        System.out.println("Adauga adresa");
        Adresa adresa = citesteAdresa();
        try {
            serviciuAdresa.adaugaAdresa(adresa);
            System.out.println("O noua adresa a fost inregistrata: " + adresa);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void afiseazaAdresele(){
        System.out.println("Afiseaza toate adresele inregistrate: ");
        List<Adresa> adrese = serviciuAdresa.getAdrese();
        if(adrese.isEmpty())
            System.out.println("Nu exista adrese inregistrate!");
        else
            adrese.forEach(System.out::println);
    }

    private void cautaAdresaDupaId(){
        System.out.println("Cauti adresa cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            Adresa adresa = serviciuAdresa.getAdresaById(id);
            System.out.println("Adresa a fost gastia: " + adresa);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void actualizeazaAdresa(){
        System.out.println("Actualizeaza adresa cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Citeste noua adresa: ");
        Adresa adresa = citesteAdresa();
        try {
            serviciuAdresa.updateAdresa(id, adresa);
            System.out.println("Adresa a fost actualizata cu succes!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void stergeAdresa(){
        System.out.println("Sterge adresa cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            serviciuAdresa.stergeAdresa(id);
            System.out.println("Adresa a fost stearsa cu succes");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Adresa citesteAdresa(){
        System.out.println("Id: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Tara: ");
        String tara = scanner.nextLine();
        System.out.println("Oras: ");
        String oras = scanner.nextLine();
        System.out.println("Strada: ");
        String strada = scanner.nextLine();
        System.out.println("Numar: ");
        String nr = scanner.nextLine();
        return new Adresa(id, tara, oras, strada, nr);
    }

    private void meniuBiblioteca() {
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Meniu Biblioteca");
            System.out.println("De ce ai nevoie?");
            System.out.println("1. Adauga o biblioteca");
            System.out.println("2. Arata toate bibliotecile");
            System.out.println("3. Cauta o biblioteca dupa id");
            System.out.println("4. Actualizeaza datele despre o biblioteca");
            System.out.println("5. Sterge o biblioteca");
            System.out.println("0. Inapoi");

            int option = readOption(5);
            switch (option) {
                case 1: {
                    adaugaBiblioteca();
                    break;
                }
                case 2: {
                    afiseazaBibliotecile();
                    break;
                }
                case 3: {
                    cautaBibliotecaDupaId();
                    break;
                }
                case 4: {
                    actualizeazaBiblioteca();
                    break;
                }
                case 5: {
                    stergeBiblioteca();
                    break;
                }
                case 0: {
                    showMenu();
                    break;
                }
            }
        }
    }

    private void adaugaBiblioteca(){
        System.out.println("Adauga biblioteca");
        Biblioteca biblioteca = citesteBiblioteca();
        try {
            serviciuBiblioteca.adaugaBiblioteca(biblioteca);
            System.out.println("O noua biblioteca a fost inregistrata: " + biblioteca);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void afiseazaBibliotecile(){
        System.out.println("Afiseaza toate bibliotecile inregistrate: ");
        List<Biblioteca> biblioteci = serviciuBiblioteca.getBiblioteci();
        if(biblioteci.isEmpty())
            System.out.println("Nu exista biblioteci inregistrate!");
        else
            biblioteci.forEach(System.out::println);
    }

    private void cautaBibliotecaDupaId(){
        System.out.println("Cauti biblioteca cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            Biblioteca biblioteca = serviciuBiblioteca.getBibliotecaById(id);
            System.out.println("Biblioteca a fost gastia: " + biblioteca);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void actualizeazaBiblioteca(){
        System.out.println("Actualizeaza biblioteca cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Citeste noua biblioteca: ");
        Biblioteca biblioteca = citesteBiblioteca();
        try {
            serviciuBiblioteca.updateBiblioteca(id, biblioteca);
            System.out.println("Biblioteca a fost actualizata cu succes!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void stergeBiblioteca(){
        System.out.println("Sterge biblioteca cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            serviciuBiblioteca.stergeBiblioteca(id);
            System.out.println("Biblioteca a fost stearsa cu succes");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Biblioteca citesteBiblioteca() {
        System.out.println("Id: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Adresa: ");

        Adresa adresa = null;
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Alege o adresa deja inregistrata");
            System.out.println("2. Inregistreaza o adresa noua");
            System.out.println("0. Iesire");

            int optionAdresa = readOption(2);
            if (optionAdresa == 1) {
                afiseazaAdresele();
                System.out.println("Id-ul adresei dorite: ");
                int idAdresa = readOption(Integer.MAX_VALUE);
                try {
                    adresa = serviciuAdresa.getAdresaById(idAdresa);
                    break;
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (optionAdresa == 2) {
                adaugaAdresa();
            }
        }

        System.out.println("Carti: ");
        System.out.println("ATENTIE! Trebuie inregistrate manual");
        System.out.println("Numar carti: ");
        int nr = readOption(Integer.MAX_VALUE);
        List<Carte> carti = new ArrayList<>();
        while (nr > 0) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Alege o carte deja inregistrata");
            System.out.println("2. Inregistreaza o carte noua");
            System.out.println("0. Iesire");

            int optionCarti = readOption(2);
            if (optionCarti == 1) {
                afiseazaCartile();
                System.out.println("Id-ul cartii dorite: ");
                int idCarte = readOption(Integer.MAX_VALUE);
                try {
                    carti.add(serviciuCarte.getCarteById(idCarte));
                    nr--;
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (optionCarti == 2) {
                adaugaCarte();
            }
        }

        return new Biblioteca(id, nume, adresa, carti);
    }

    private void meniuCarte() {
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Meniu carte");
            System.out.println("De ce ai nevoie?");
            System.out.println("1. Adauga o carte");
            System.out.println("2. Arata toate cartile");
            System.out.println("3. Cauta o carte dupa id");
            System.out.println("4. Actualizeaza datele despre o carte");
            System.out.println("5. Sterge o carte");
            System.out.println("0. Inapoi");

            int option = readOption(5);
            switch (option) {
                case 1: {
                    adaugaCarte();
                    break;
                }
                case 2: {
                    afiseazaCartile();
                    break;
                }
                case 3: {
                    cautaCarteDupaId();
                    break;
                }
                case 4: {
                    actualizeazaCarte();
                    break;
                }
                case 5: {
                    stergeCarte();
                    break;
                }
                case 0: {
                    showMenu();
                    break;
                }
            }
        }

    }

    private void adaugaCarte(){
        System.out.println("Adauga carte");
        Carte carte = citesteCarte();
        try {
            serviciuCarte.adaugaCarte(carte);
            System.out.println("O noua carte a fost inregistrata: " + carte);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void afiseazaCartile(){
        System.out.println("Afiseaza toate cartile inregistrate: ");
        List<Carte> carti = serviciuCarte.getCarti();
        if(carti.isEmpty())
            System.out.println("Nu exista carti inregistrate!");
        else
            carti.forEach(System.out::println);
    }

    private void cautaCarteDupaId(){
        System.out.println("Cauti cartea cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            Carte carte = serviciuCarte.getCarteById(id);
            System.out.println("Cartea a fost gastia: " + carte);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void actualizeazaCarte(){
        System.out.println("Actualizeaza cartea cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Citeste noua carte: ");
        Carte carte = citesteCarte();
        try {
            serviciuCarte.updateCarte(id, carte);
            System.out.println("Cartea a fost actualizata cu succes!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void stergeCarte(){
        System.out.println("Sterge adresa cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            serviciuCarte.stergeCarte(id);
            System.out.println("Cartea a fost stearsa cu succes");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Carte citesteCarte(){
        System.out.println("Id: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Titlu: ");
        String titlu = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("Editura: ");
        String editura = scanner.nextLine();
        return new Carte(id, titlu, autor, editura);
    }

    private int readOption(int x) {
        int option = -1;
        do {
            try {
                option = readInt();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            if (option > x)
                System.out.println("Nu exista aceasta optiune!");
        } while (option < 0 || option > x);
        return option;
    }

    private int readInt() throws Exception {
        String line = scanner.next();
        if (line.matches("^\\d+$")) {
            return Integer.parseInt(line);
        } else {
            throw new Exception("Numar invalid!");
        }
    }
}