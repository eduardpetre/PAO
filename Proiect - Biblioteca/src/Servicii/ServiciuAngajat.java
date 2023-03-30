package Servicii;

import Entitati.Angajat;
import java.util.*;

public class ServiciuAngajat implements InterfataAngajat{
    private List<Angajat> angajati = new ArrayList<>();
    private static ServiciuAngajat init;

    public ServiciuAngajat() {
    }

    public static ServiciuAngajat getInit(){
        if(init == null)
            init = new ServiciuAngajat();
        return init;
    }

    public List<Angajat> getAngajati() {
        List<Angajat> angajati_aux = new ArrayList<>();
        angajati_aux.addAll(this.angajati);
        return angajati_aux;
    }

    public Angajat getAngajatById(int idx){
        Angajat angajat = new Angajat();
        for(int i = 0; i < this.angajati.size(); ++i){
            if(this.angajati.get(i).getId() == idx){
                angajat = this.angajati.get(i);
            }
        }
        return angajat;
    }
    public void adaugaAngajat(Angajat angajat){
        this.angajati.add(angajat);
    }
    public void updateAngajat(int idx, Angajat angajat){
        for(int i = 0; i < this.angajati.size(); ++i){
            if(this.angajati.get(i).getId() == idx){
                this.angajati.remove(i);
                this.angajati.add(i, angajat);
                break;
            }
        }
    }

    public void stergeAngajat(int idx){
        for(int i = 0; i < this.angajati.size(); ++i){
            if(this.angajati.get(i).getId() == idx){
                this.angajati.remove(i);
                break;
            }
        }
    }
}
