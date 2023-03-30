package Servicii;

import Entitati.Adresa;
import Entitati.Carte;
import java.util.List;

public interface InterfataCarte {
    public List<Carte> getCarti();
    public Carte getCarteById(int idx) throws Exception;
    public void adaugaCarte(Carte carte) throws Exception;
    public void updateCarte(int idx, Carte carte) throws Exception;
    public void stergeCarte(int idx) throws Exception;
}
