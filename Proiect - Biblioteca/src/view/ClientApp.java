package view;

import Entitati.*;
import Servicii.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClientApp {
    private final Scanner scanner = new Scanner(System.in);

    private final ServiciuAdresa serviciuAdresa = new ServiciuAdresa().getInit();
    private final ServiciuAngajat serviciuAngajat = new ServiciuAngajat().getInit();
    private final ServiciuBiblioteca serviciuBiblioteca = new ServiciuBiblioteca().getInit();
    private final ServiciuCarte serviciuCarte = new ServiciuCarte().getInit();
    private final ServiciuCititor serviciuCititor = new ServiciuCititor().getInit();
    private final ServiciuImprumut serviciuImprumut = new ServiciuImprumut().getInit();

    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp();
        while (true) {
            clientApp.showMenu();
        }
    }

    private ClientApp(){}

    private static ClientApp init;
    public static ClientApp getInit(){
        if(init == null){
            init = new ClientApp();
        }
        return init;
    }

    public void showMenu(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("What do you want to do?");
        System.out.println("1. Manager");
        System.out.println("2. Cititor");
        System.out.println("0. exit");

        int option = readOption(2);
        switch (option) {
            case 1: {
                meniuManager();
                break;
            }
            case 2: {
                meniuCititor();
                break;
            }
            case 0: {
                scanner.close();
                System.exit(0);
            }
        }
    }

    private void meniuManager() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Welcome to Library Management Platform");
        System.out.println("What do you want to do?");
        System.out.println("1. Meniu adrese");
        System.out.println("2. Meniu biblioteci");
        System.out.println("3. Meniu carti");
        System.out.println("4. Meniu angajati");
        System.out.println("0. inapoi");

        int option = readOption(4);
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
                meniuAngajat();
                break;
            }
            case 0: {
                showMenu();
                break;
            }
        }
    }

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
                    meniuManager();
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
        String tara = readString(scanner.nextLine());
        System.out.println("Oras: ");
        String oras = readString(scanner.nextLine());
        System.out.println("Strada: ");
        String strada = readString(scanner.nextLine());
        System.out.println("Numar: ");
        String nr = readString(scanner.nextLine());
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
                    meniuManager();
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
        String nume = readString(scanner.nextLine());
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
                    meniuManager();
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
        System.out.println("Sterge cartea cu id-ul: ");
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
        String titlu = readString(scanner.nextLine());
        System.out.println("Autor: ");
        String autor = readString(scanner.nextLine());
        System.out.println("Editura: ");
        String editura = readString(scanner.nextLine());
        return new Carte(id, titlu, autor, editura);
    }

    private void meniuAngajat(){
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Meniu angajat");
            System.out.println("De ce ai nevoie?");
            System.out.println("1. Adauga un angajat");
            System.out.println("2. Arata toti angajatii");
            System.out.println("3. Cauta un angajat dupa id");
            System.out.println("4. Actualizeaza datele despre un angajat");
            System.out.println("5. Sterge un angajat");
            System.out.println("0. Inapoi");

            int option = readOption(5);
            switch (option) {
                case 1: {
                    adaugaAngajat();
                    break;
                }
                case 2: {
                    afiseazaAngajatii();
                    break;
                }
                case 3: {
                    cautaAngajatDupaId();
                    break;
                }
                case 4: {
                    actualizeazaAngajat();
                    break;
                }
                case 5: {
                    stergeAngajat();
                    break;
                }
                case 0: {
                    meniuManager();
                    break;
                }
            }
        }

    }

    private void adaugaAngajat(){
        System.out.println("Adauga angajat");
        Angajat angajat = citesteAngajat();
        try {
            serviciuAngajat.adaugaAngajat(angajat);
            System.out.println("Un nou angajat a fost inregistrat: " + angajat);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void afiseazaAngajatii(){
        System.out.println("Afiseaza toti angajatii inregistrati: ");
        Set<Angajat> angajati = serviciuAngajat.getAngajati();
        if(angajati.isEmpty())
            System.out.println("Nu exista angajati inregistrati!");
        else
            angajati.forEach(System.out::println);
    }

    private void cautaAngajatDupaId(){
        System.out.println("Cauti angajatul cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            Angajat angajat = serviciuAngajat.getAngajatById(id);
            System.out.println("Angajatul a fost gasit: " + angajat);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void actualizeazaAngajat(){
        System.out.println("Actualizeaza angajatul cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Citeste noul angajat: ");
        Angajat angajat = citesteAngajat();
        try {
            serviciuAngajat.updateAngajat(id, angajat);
            System.out.println("Angajatul a fost actualizat cu succes!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void stergeAngajat(){
        System.out.println("Sterge angajatul cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            serviciuAngajat.stergeAngajat(id);
            System.out.println("Angajatul a fost sters cu succes");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Angajat citesteAngajat(){
        System.out.println("Id: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Nume: ");
        String nume = readString(scanner.nextLine());
        System.out.println("Email: ");
        String email = readString(scanner.nextLine());
        System.out.println("Telefon: ");
        String telefon = readString(scanner.nextLine());
        System.out.println("Data angajarii: ");
        String dataAngajarii = readString(scanner.nextLine());
        System.out.println("Pozitie: ");
        String pozitie = readString(scanner.nextLine());
        return new Angajat(id, nume, email, telefon, dataAngajarii, pozitie);
    }

    private void afiseazaCititorii(){
        System.out.println("Afiseaza toti cititorii inregistrati: ");
        Set<Cititor> cititori = serviciuCititor.getCititori();
        if(cititori.isEmpty())
            System.out.println("Nu exista cititori inregistrati!");
        else
            cititori.forEach(System.out::println);
    }

    private void adaugaCititor(){
        System.out.println("Adauga cititor");
        Cititor cititor = citesteCititor();
        try {
            serviciuCititor.adaugaCititor(cititor);
            System.out.println("Un nou cititor a fost inregistrat: " + cititor);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Cititor citesteCititor(){
        System.out.println("Id: ");
        int id = readOption(Integer.MAX_VALUE);
        System.out.println("Nume: ");
        String nume = readString(scanner.nextLine());
        System.out.println("Email: ");
        String email = readString(scanner.nextLine());
        System.out.println("Telefon: ");
        String telefon = readString(scanner.nextLine());
        System.out.println("Elev: ");
        System.out.println("1. Da");
        System.out.println("2. Nu");
        int opt = readOption(2);
        if (opt == 1)
            return new Cititor(id, nume, email, telefon, true);
        else if (opt == 2)
            return new Cititor(id, nume, email, telefon, false);
        meniuCititor();
        return null;
    }

    private void meniuCititor() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Welcome to Library Platform");
        System.out.println("1. Arata toate cartile disponibile.");
        System.out.println("2. Imprumuta o carte.");
        System.out.println("3. Returneaza o carte.");
        System.out.println("0. inapoi");

        int option = readOption(3);
        switch (option) {
            case 1: {
                afiseazaCartile();
                meniuCititor();
                break;
            }
            case 2: {
                adaugaImprumut();
                meniuCititor();
                break;
            }
            case 3: {
                stergeImprumut();
                meniuCititor();
                break;
            }
            case 0: {
                showMenu();
                break;
            }
        }
    }

    private void adaugaImprumut(){
        System.out.println("Imprumuta o carte: ");
        try {
            Imprumut imprumut = citesteImprumut();
            serviciuImprumut.adaugaImprumut(imprumut);
            serviciuCarte.stergeCarte(imprumut.getCarte().getId());
            System.out.println("Cartea a fost imprumutata cu succes: " + imprumut);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    private void stergeImprumut(){
        System.out.println("Returneaza imprumutul cu id-ul: ");
        int id = readOption(Integer.MAX_VALUE);
        try {
            serviciuCarte.adaugaCarte(serviciuImprumut.getImprumutById(id).getCarte());
            serviciuImprumut.stergeImprumut(id);
            System.out.println("Cartea a fost returnata cu succes");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private Imprumut citesteImprumut() throws Exception {
        System.out.println("Cititor");
        System.out.println("Alege contul tau: ");

        Cititor cititor = null;
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Ai deja un cont");
            System.out.println("2. Inregistreaza un cont nou");
            System.out.println("0. Iesire");

            int optionCont = readOption(2);
            if (optionCont == 0) {
                break;
            }
            if (optionCont == 1) {
                afiseazaCititorii();
                System.out.println("Id-ul contului dorit: ");
                int idCont = readOption(Integer.MAX_VALUE);
                try {
                    cititor = serviciuCititor.getCititorById(idCont);
                    break;
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (optionCont == 2) {
                adaugaCititor();
            }
        }

        System.out.println("Carte");
        System.out.println("Alege cartea dorita: ");

        Carte carte = null;
        while(true) {
            afiseazaCartile();
            System.out.println("Id-ul cartii dorite/ 0 pentru iesire: ");
            int idCarte = readOption(Integer.MAX_VALUE);
            if (idCarte == 0) {
                break;
            }
            try {
                carte = serviciuCarte.getCarteById(idCarte);
                break;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        if (carte == null || cititor == null)
            throw new Exception("Ceva nu a mers bine!");
        return new Imprumut(carte, cititor);
    }

    private String readString(String s){
        while (s.trim().isEmpty()) {
            System.out.print("Incercati din nou! Input-ul nu poate fi gol: ");
            s = scanner.nextLine();
        }
        return s;
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
        String line = scanner.nextLine();
        if (line.matches("^\\d+$")) {
            return Integer.parseInt(line);
        } else {
            throw new Exception("Numar invalid!");
        }
    }
}