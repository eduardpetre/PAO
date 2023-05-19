package servicii;

import entitati.Carte;
import persistenta.CarteRepo;

import java.util.*;

public class ServiciuCarte implements InterfataCarte {
    private CarteRepo carteRepo = CarteRepo.getInit();

    public List<Carte> getCarti() {
        return carteRepo.findAll();
    }

    public Carte getCarteById(int idx) throws Exception {
        Optional<Carte> carte = carteRepo.findById(idx);
        return carte.orElseThrow(() -> new Exception("Cartea cu acest id nu exista!"));
    }

    public Carte adaugaCarte(Carte carte) throws Exception {
        if (carteRepo.findById(carte.getId()).isPresent())
            throw new Exception("Cartea cu acest id exista deja!");
        else
            return carteRepo.save(carte);
    }

    public void updateCarte(int idx, Carte carte) throws Exception {
        carteRepo.findById(idx).
                orElseThrow(() -> new Exception("Cartea cu acest id nu exista!"));
        if (carteRepo.findById(carte.getId()).isPresent())
            throw new Exception("Exista deja o carte cu acest id!");

        carteRepo.update(idx, carte);
    }

    public void stergeCarte(int idx) throws Exception {
        carteRepo.findById(idx).
                orElseThrow(() -> new Exception("Angajatul cu acest id nu exista!"));

        carteRepo.delete(idx);
    }
}
