package Servicii;

import Entitati.Adresa;
import java.util.List;

public interface InterfataAdresa {
    public List<Adresa> getAdrese();
    public Adresa getAdresaById(int idx) throws Exception;
    public void adaugaAdresa(Adresa adresa) throws Exception;
    public void updateAdresa(int idx, Adresa adresa) throws Exception;
    public void stergeAdresa(int idx) throws Exception;
}
