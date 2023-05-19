package servicii;

import persistenta.AngajatRepo;
import entitati.Angajat;

import java.util.*;

public class ServiciuAngajat implements InterfataAngajat {

    private AngajatRepo angajatRepo = AngajatRepo.getInit();

    public Set<Angajat> getAngajati() {
        return angajatRepo.findAllSet();
    }

    public Angajat getAngajatById(int idx) throws Exception {
        Optional<Angajat> angajat = angajatRepo.findById(idx);
        return angajat.orElseThrow(() -> new Exception("Angajatul cu acest id nu exista!"));
    }

    public Angajat adaugaAngajat(Angajat angajat) throws Exception {
        if (angajatRepo.findById(angajat.getId()).isPresent())
            throw new Exception("Angajatul cu acest id exista deja!");
        else
            return angajatRepo.save(angajat);
    }

    public void updateAngajat(int idx, Angajat angajat) throws Exception {
        angajatRepo.findById(idx).
                orElseThrow(() -> new Exception("Angajatul cu acest id nu exista!"));
        if (angajatRepo.findById(angajat.getId()).isPresent())
            throw new Exception("Exista deja un angajat cu acest id!");

        angajatRepo.update(idx, angajat);
    }

    public void stergeAngajat(int idx) throws Exception {
        angajatRepo.findById(idx).
                orElseThrow(() -> new Exception("Angajatul cu acest id nu exista!"));

        angajatRepo.delete(idx);
    }
}
