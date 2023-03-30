package Servicii;

import Entitati.Adresa;
import Entitati.Carte;
import java.util.List;

public interface InterfataCarte {
    public List<Carte> getCarti();
    public Carte getCarteById(int idx);
    public void adaugaCarte(Carte carte);
    public void updateCarte(int idx, Carte carte);
    public void stergeCarte(int idx);
}
