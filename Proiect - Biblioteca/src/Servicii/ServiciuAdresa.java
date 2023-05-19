package servicii;

import persistenta.AdresaRepo;
import entitati.Adresa;

import java.util.*;

public class ServiciuAdresa implements InterfataAdresa {

    private AdresaRepo adresaRepo = AdresaRepo.getInit();

    public List<Adresa> getAdrese() {
        return adresaRepo.findAll();
    }

    public Adresa getAdresaById(int idx) throws Exception {
        Optional<Adresa> adresa = adresaRepo.findById(idx);
        return adresa.orElseThrow(() -> new Exception("Adresa cu acest id nu exista!"));
    }

    public Adresa adaugaAdresa(Adresa adresa) throws Exception {
        if (adresaRepo.findById(adresa.getId()).isPresent())
            throw new Exception("Adresa cu acest id exista deja!");
        else
            return adresaRepo.save(adresa);
    }

    public void updateAdresa(int idx, Adresa adresa) throws Exception {
        adresaRepo.findById(idx).
                orElseThrow(() -> new Exception("Adresa cu acest id nu exista!"));
        if (adresaRepo.findById(adresa.getId()).isPresent())
            throw new Exception("Exista deja o adresa cu acest id!");

        adresaRepo.update(idx, adresa);
    }

    public void stergeAdresa(int idx) throws Exception {
        adresaRepo.findById(idx).
                orElseThrow(() -> new Exception("Adresa cu acest id nu exista!"));

        adresaRepo.delete(idx);
    }
}
