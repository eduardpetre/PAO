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
    public Adresa getAdresaById(int idx) throws Exception {
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                return this.adrese.get(i);
            }
        }
        throw new Exception("Adresa cu acest id nu exista");
    }
    public void adaugaAdresa(Adresa adresa) throws Exception {
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == adresa.getId()){
                throw new Exception("Adresa cu acest id exista deja!");
            }
        }

        this.adrese.add(adresa);
    }
    public void updateAdresa(int idx, Adresa adresa) throws Exception {
        boolean updated = false;
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                this.adrese.remove(i);
                this.adrese.add(i, adresa);
                updated = true;
            } else if (this.adrese.get(i).getId() == adresa.getId()) {
                throw new Exception("Exista deja o adresa cu acest id!");
            }
        }
        if (!updated)
            throw new Exception("Adresa cu acest id nu exista!");
    }

    public void stergeAdresa(int idx) throws Exception {
        boolean deleted = false;
        for(int i = 0; i < this.adrese.size(); ++i){
            if(this.adrese.get(i).getId() == idx){
                this.adrese.remove(i);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Adresa cu acest id nu exista!");
    }
}
