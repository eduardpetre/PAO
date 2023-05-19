package servicii;

import entitati.Imprumut;
import persistenta.ImprumutRepo;

import java.util.*;

public class ServiciuImprumut implements InterfataImprumut {
    private ImprumutRepo imprumutRepo = ImprumutRepo.getInit();

    public List<Imprumut> getImprumuturi() {
        return imprumutRepo.findAll();
    }

    public Imprumut getImprumutById(int idx) throws Exception {
        Optional<Imprumut> imprumut = imprumutRepo.findById(idx);
        return imprumut.orElseThrow(() -> new Exception("Imprumutul cu acest id nu exista!"));
    }

    public void adaugaImprumut(Imprumut imprumut) {
        imprumutRepo.save(imprumut);
    }

    public void stergeImprumut(int idx) throws Exception {
        imprumutRepo.findById(idx).
                orElseThrow(() -> new Exception("Imprumutul cu acest id nu exista!"));

        imprumutRepo.delete(idx);
    }
}
