package servicii;

import entitati.Angajat;

import java.util.Set;

public interface InterfataAngajat {
    public Set<Angajat> getAngajati();

    public Angajat getAngajatById(int idx) throws Exception;

    public Angajat adaugaAngajat(Angajat angajat) throws Exception;

    public void updateAngajat(int idx, Angajat angajat) throws Exception;

    public void stergeAngajat(int idx) throws Exception;
}