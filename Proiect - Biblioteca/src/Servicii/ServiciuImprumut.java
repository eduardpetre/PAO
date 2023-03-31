package Servicii;

import Entitati.Adresa;
import Entitati.Imprumut;
import java.util.*;
public class ServiciuImprumut implements InterfataImprumut {
    private List<Imprumut> imprumuturi = new ArrayList<>();
    private static ServiciuImprumut init;

    public ServiciuImprumut() {
    }

    public static ServiciuImprumut getInit(){
        if(init == null)
            init = new ServiciuImprumut();
        return init;
    }
    public List<Imprumut> getImprumuturi() {
        List<Imprumut> imprumuturi_aux = new ArrayList<>();
        imprumuturi_aux.addAll(this.imprumuturi);
        return imprumuturi_aux;
    }
    public Imprumut getImprumutById(int idx) throws Exception {
        for(int i = 0; i < this.imprumuturi.size(); ++i){
            if(this.imprumuturi.get(i).getId() == idx){
                return this.imprumuturi.get(i);
            }
        }
        throw new Exception("Imprumutul cu acest id nu exista");
    }
    public void adaugaImprumut(Imprumut imprumut){
        this.imprumuturi.add(imprumut);
    }

    public void stergeImprumut(int idx) throws Exception {
        boolean deleted = false;
        for(int i = 0; i < this.imprumuturi.size(); ++i){
            if(this.imprumuturi.get(i).getId() == idx){
                this.imprumuturi.remove(i);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Imprumutul cu acest id nu exista!");
    }
}
