package servicii;

import entitati.Biblioteca;
import persistenta.BibliotecaRepo;

import java.util.*;

public class ServiciuBiblioteca implements InterfataBiblioteca {
    private BibliotecaRepo bibliotecaRepo = BibliotecaRepo.getInit();

    public List<Biblioteca> getBiblioteci() {
        return bibliotecaRepo.findAll();
    }

    public Biblioteca getBibliotecaById(int idx) throws Exception {
        Optional<Biblioteca> biblioteca = bibliotecaRepo.findById(idx);
        return biblioteca.orElseThrow(() -> new Exception("Biblioteca cu acest id nu exista!"));
    }

    public Biblioteca adaugaBiblioteca(Biblioteca biblioteca) throws Exception {
        if (bibliotecaRepo.findById(biblioteca.getId()).isPresent())
            throw new Exception("Biblioteca cu acest id exista deja!");
        else
            return bibliotecaRepo.save(biblioteca);
    }


    public void updateBiblioteca(int idx, Biblioteca biblioteca) throws Exception {
        bibliotecaRepo.findById(idx).
                orElseThrow(() -> new Exception("Biblioteca cu acest id nu exista!"));
        if (bibliotecaRepo.findById(biblioteca.getId()).isPresent())
            throw new Exception("Exista deja o biblioteca cu acest id!");

        bibliotecaRepo.update(idx, biblioteca);
    }

    public void stergeBiblioteca(int idx) throws Exception {
        bibliotecaRepo.findById(idx).
                orElseThrow(() -> new Exception("Biblioteca cu acest id nu exista!"));

        bibliotecaRepo.delete(idx);
    }
}
