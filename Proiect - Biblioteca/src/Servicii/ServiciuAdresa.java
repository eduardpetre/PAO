package Servicii;

import Entitati.Adresa;

import java.util.*;

public class ServiciuAdresa implements InterfataAdresa {
    private List<Adresa> adrese = new ArrayList<>();
    private static ServiciuAdresa init;

    public ServiciuAdresa() {
    }

    public static ServiciuAdresa getInit(){
        if(init == null)
            init = new ServiciuAdresa();
        return init;
    }
    public List<Adresa> getAdrese() {
        List<Adresa> adrese_aux = new ArrayList<>();
        adrese_aux.addAll(this.adrese);
        return adrese_aux;
    }
    public Adresa getAdresaById(int idx){
        Adresa adresa = new Adresa();
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                adresa = this.adrese.get(i);
            }
        }
        return adresa;
    }
    public void adaugaAdresa(Adresa adresa){
        this.adrese.add(adresa);
    }
    public void updateAdresa(int idx, Adresa adresa){
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                this.adrese.remove(i);
                this.adrese.add(i, adresa);
                break;
            }
        }
    }

    public void stergeAdresa(int idx){
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                this.adrese.remove(i);
                break;
            }
        }
    }
}
