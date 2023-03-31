package Servicii;

import Entitati.Angajat;
import java.util.*;

public class ServiciuAngajat implements InterfataAngajat{
    private Set<Angajat> angajati = new HashSet<Angajat>();;
    private static ServiciuAngajat init;

    public ServiciuAngajat() {
    }

    public static ServiciuAngajat getInit(){
        if(init == null)
            init = new ServiciuAngajat();
        return init;
    }

    public Set<Angajat> getAngajati() {
        Set<Angajat> angajati_aux = new HashSet<Angajat>();;
        angajati_aux.addAll(this.angajati);
        return angajati_aux;
    }

    public Angajat getAngajatById(int idx) throws Exception {
        for(Angajat a: angajati){
            if(a.getId() == idx){
                return a;
            }
        }
        throw new Exception("Angajatul cu acest id nu exista!");
    }
    public void adaugaAngajat(Angajat angajat) throws Exception {
        for(Angajat a: angajati){
            if(a.getId() == angajat.getId()){
                throw new Exception("Angajatul cu acest id exista deja!");
            }
        }
        this.angajati.add(angajat);
    }
    public void updateAngajat(int idx, Angajat angajat) throws Exception {
        boolean updated = false;
        for(Angajat a: angajati){
            if(a.getId() == idx){
                this.angajati.remove(a);
                this.angajati.add(angajat);
                updated = true;
            } else if (a.getId() == angajat.getId()) {
                throw new Exception("Exista deja un angajat cu acest id!");
            }
        }
        if (!updated)
            throw new Exception("Angajatul cu acest id nu exista!");
    }

    public void stergeAngajat(int idx) throws Exception {
        boolean deleted = false;
        for(Angajat a: angajati){
            if(a.getId() == idx){
                this.angajati.remove(a);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Angajatul cu acest id nu exista!");
    }
}
