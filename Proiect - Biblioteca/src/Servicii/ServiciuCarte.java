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

    public Carte getCarteById(int idx){
        Carte carte = new Carte();
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                carte = this.carti.get(i);
            }
        }
        return carte;
    }
    public void adaugaCarte(Carte carte){
        this.carti.add(carte);
    }
    public void updateCarte(int idx, Carte carte){
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                this.carti.remove(i);
                this.carti.add(i, carte);
                break;
            }
        }
    }

    public void stergeCarte(int idx){
        for(int i = 0; i < this.carti.size(); ++i){
            if(this.carti.get(i).getId() == idx){
                this.carti.remove(i);
                break;
            }
        }
    }
}
