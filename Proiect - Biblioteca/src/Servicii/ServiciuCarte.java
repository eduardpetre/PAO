package Servicii;

import Entitati.Carte;
import java.util.*;

public class ServiciuCarte implements InterfataCarte {
    private List<Carte> carti = new ArrayList<>();
    private static ServiciuCarte init;

    public ServiciuCarte() {
    }

    public static ServiciuCarte getInit(){
        if(init == null)
            init = new ServiciuCarte();
        return init;
    }

    public List<Carte> getCarti() {
        List<Carte> carti_aux = new ArrayList<>();
        carti_aux.addAll(this.carti);
        return carti_aux;
    }

    public Carte getCarteById(int idx) throws Exception {
        Carte carte = new Carte();
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                return this.carti.get(i);
            }
        }
        throw new Exception("Cartea cu acest id nu exista");
    }
    public void adaugaCarte(Carte carte) throws Exception {
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == carte.getId()){
                throw new Exception("Cartea cu acest id exista deja!");
            }
        }

        this.carti.add(carte);
    }
    public void updateCarte(int idx, Carte carte) throws Exception {
        boolean updated = false;
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                this.carti.remove(i);
                this.carti.add(i, carte);
                updated = true;
            } else if (this.carti.get(i).getId() == carte.getId()) {
                throw new Exception("Exista deja o carte cu acest id!");
            }
        }
        if (!updated)
            throw new Exception("Cartea cu acest id nu exista!");
    }

    public void stergeCarte(int idx) throws Exception {
        boolean deleted = false;
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                this.carti.remove(i);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Adresa cu acest id nu exista!");
    }
}
