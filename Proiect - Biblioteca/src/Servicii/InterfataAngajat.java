package Servicii;

import Entitati.Angajat;
import java.util.List;

public interface InterfataAngajat {
    public List<Angajat> getAngajati();
    public Angajat getAngajatById(int idx);
    public void adaugaAngajat(Angajat angajat);
    public void updateAngajat(int idx, Angajat angajat);
    public void stergeAngajat(int idx);
}