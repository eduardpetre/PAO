package Servicii;

import Entitati.Adresa;
import java.util.List;

public interface InterfataAdresa {
    public List<Adresa> getAdrese();
    public Adresa getAdresaById(int idx);
    public void adaugaAdresa(Adresa adresa);
    public void updateAdresa(int idx, Adresa adresa);
    public void stergeAdresa(int idx);
}
