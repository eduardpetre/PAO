package Servicii;

import Entitati.Angajat;
import Entitati.Cititor;
import java.util.*;

public class ServiciuCititor implements InterfataCititor{
    private Set<Cititor> cititori = new HashSet<Cititor>();;
    private static ServiciuCititor init;

    public ServiciuCititor() {
    }

    public static ServiciuCititor getInit(){
        if(init == null)
            init = new ServiciuCititor();
        return init;
    }

    public Set<Cititor> getCititori() {
        Set<Cititor> cititori_aux = new HashSet<Cititor>();
        cititori_aux.addAll(this.cititori);
        return cititori_aux;
    }

    public Cititor getCititorById(int idx) throws Exception {
        for(Cititor c: cititori){
            if(c.getId() == idx){
                return c;
            }
        }
        throw new Exception("Cititorul cu acest id nu exista!");
    }
    public void adaugaCititor(Cititor cititor) throws Exception {
        for(Cititor c: cititori){
            if(c.getId() == cititor.getId()){
                throw new Exception("Angajatul cu acest id exista deja!");
            }
        }
        this.cititori.add(cititor);
    }
    public void updateCititor(int idx, Cititor cititor) throws Exception {
        boolean updated = false;
        for(Cititor c: cititori){
            if(c.getId() == idx){
                this.cititori.remove(c);
                this.cititori.add(cititor);
                updated = true;
            } else if (c.getId() == cititor.getId()) {
                throw new Exception("Exista deja un cititor cu acest id!");
            }
        }
        if (!updated)
            throw new Exception("Cititorul cu acest id nu exista!");
    }

    public void stergeCititor(int idx) throws Exception {
        boolean deleted = false;
        for(Cititor c: cititori){
            if(c.getId() == idx){
                this.cititori.remove(c);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Cititorul cu acest id nu exista!");
    }
}
