package servicii;

import entitati.Adresa;

import java.util.List;

public interface InterfataAdresa {
    public List<Adresa> getAdrese();

    public Adresa getAdresaById(int idx) throws Exception;

    public Adresa adaugaAdresa(Adresa adresa) throws Exception;

    public void updateAdresa(int idx, Adresa adresa) throws Exception;

    public void stergeAdresa(int idx) throws Exception;
}
