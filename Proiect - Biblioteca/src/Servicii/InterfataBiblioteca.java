package Servicii;

import Entitati.Biblioteca;
import java.util.List;

public interface InterfataBiblioteca {
    public List<Biblioteca> getBiblioteci();
    public Biblioteca getBibliotecaById(int idx);
    public void adaugaBiblioteca(Biblioteca biblioteca);
    public void updateBiblioteca(int idx, Biblioteca biblioteca);
    public void stergeBiblioteca(int idx);
}
