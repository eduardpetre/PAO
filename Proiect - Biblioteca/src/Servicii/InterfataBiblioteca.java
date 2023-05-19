package servicii;

import entitati.Biblioteca;

import java.util.List;

public interface InterfataBiblioteca {
    public List<Biblioteca> getBiblioteci();

    public Biblioteca getBibliotecaById(int idx) throws Exception;

    public Biblioteca adaugaBiblioteca(Biblioteca biblioteca) throws Exception;

    public void updateBiblioteca(int idx, Biblioteca biblioteca) throws Exception;

    public void stergeBiblioteca(int idx) throws Exception;
}
