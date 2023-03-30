package Servicii;

import Entitati.Cititor;
import java.util.*;

public class ServiciuCititor implements InterfataCititor{
    private List<Cititor> cititori = new ArrayList<>();
    private static ServiciuCititor init;

    public ServiciuCititor() {
    }

    public static ServiciuCititor getInit(){
        if(init == null)
            init = new ServiciuCititor();
        return init;
    }

    public List<Cititor> getCititori() {
        List<Cititor> cititori_aux = new ArrayList<>();
        cititori_aux.addAll(this.cititori);
        return cititori_aux;
    }

    public Cititor getCititorById(int idx){
        Cititor angajat = new Cititor();
        for(int i = 0; i < this.cititori.size(); ++i){
            if(this.cititori.get(i).getId() == idx){
                angajat = this.cititori.get(i);
            }
        }
        return angajat;
    }
    public void adaugaCititor(Cititor cititor){
        this.cititori.add(cititor);
    }
    public void updateCititor(int idx, Cititor cititor){
        for(int i = 0; i < this.cititori.size(); ++i){
            if(this.cititori.get(i).getId() == idx){
                this.cititori.remove(i);
                this.cititori.add(i, cititor);
                break;
            }
        }
    }

    public void stergeCititor(int idx){
        for(int i = 0; i < this.cititori.size(); ++i){
            if(this.cititori.get(i).getId() == idx){
                this.cititori.remove(i);
                break;
            }
        }
    }
}
