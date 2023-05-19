package servicii;

import entitati.Cititor;
import persistenta.CititorRepo;

import java.util.*;

public class ServiciuCititor implements InterfataCititor {
    private CititorRepo cititorRepo = CititorRepo.getInit();

    public Set<Cititor> getCititori() {
        return cititorRepo.findAllSet();
    }

    public Cititor getCititorById(int idx) throws Exception {
        Optional<Cititor> cititor = cititorRepo.findById(idx);
        return cititor.orElseThrow(() -> new Exception("Cititorul cu acest id nu exista!"));
    }

    public Cititor adaugaCititor(Cititor cititor) throws Exception {
        if (cititorRepo.findById(cititor.getId()).isPresent())
            throw new Exception("Angajatul cu acest id exista deja!");
        else
            return cititorRepo.save(cititor);
    }

    public void updateCititor(int idx, Cititor cititor) throws Exception {
        cititorRepo.findById(idx).
                orElseThrow(() -> new Exception("Cititorul cu acest id nu exista!"));
        if (cititorRepo.findById(cititor.getId()).isPresent())
            throw new Exception("Exista deja un cititor cu acest id!");

        cititorRepo.update(idx, cititor);
    }

    public void stergeCititor(int idx) throws Exception {
        cititorRepo.findById(idx).
                orElseThrow(() -> new Exception("Cititorul cu acest id nu exista!"));

        cititorRepo.delete(idx);
    }
}
