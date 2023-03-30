package Servicii;

import Entitati.Biblioteca;
import java.util.*;

public class ServiciuBiblioteca implements InterfataBiblioteca{
    private List<Biblioteca> biblioteci = new ArrayList<>();
    private static ServiciuBiblioteca init;

    public ServiciuBiblioteca() {
    }

    public static ServiciuBiblioteca getInit(){
        if(init == null)
            init = new ServiciuBiblioteca();
        return init;
    }

    public List<Biblioteca> getBiblioteci() {
        List<Biblioteca> biblioteci_aux = new ArrayList<>();
        biblioteci_aux.addAll(this.biblioteci);
        return biblioteci_aux;
    }

    public Biblioteca getBibliotecaById(int idx) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                return this.biblioteci.get(i);
            }
        }
        throw new Exception("Biblioteca cu acest id nu exista");
    }
    public void adaugaBiblioteca(Biblioteca biblioteca) throws Exception {
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == biblioteca.getId()){
                throw new Exception("Biblioteca cu acest id exista deja!");
            }
        }
        this.biblioteci.add(biblioteca);
    }
    public void updateBiblioteca(int idx, Biblioteca biblioteca) throws Exception {
        boolean updated = false;
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                this.biblioteci.remove(i);
                this.biblioteci.add(i, biblioteca);
                updated = true;
            } else if (this.biblioteci.get(i).getId() == biblioteca.getId()) {
                throw new Exception("Exista deja o biblioteca cu acest id!");
            }
        }
        if (!updated)
            throw new Exception("Biblioteca cu acest id nu exista!");
    }

    public void stergeBiblioteca(int idx) throws Exception {
        boolean deleted = false;
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                this.biblioteci.remove(i);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new Exception("Adresa cu acest id nu exista!");
    }
}
