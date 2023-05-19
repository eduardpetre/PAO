package servicii;

import entitati.Imprumut;

import java.util.List;

public interface InterfataImprumut {
    public List<Imprumut> getImprumuturi();

    public Imprumut getImprumutById(int idx) throws Exception;

    public void adaugaImprumut(Imprumut imprumut);

    public void stergeImprumut(int idx) throws Exception;
}
