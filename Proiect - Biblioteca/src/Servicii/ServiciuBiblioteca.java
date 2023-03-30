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

    public Biblioteca getBibliotecaById(int idx){
        Biblioteca biblioteca = new Biblioteca();
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                biblioteca = this.biblioteci.get(i);
            }
        }
        return biblioteca;
    }
    public void adaugaBiblioteca(Biblioteca biblioteca){
        this.biblioteci.add(biblioteca);
    }
    public void updateBiblioteca(int idx, Biblioteca biblioteca){
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                this.biblioteci.remove(i);
                this.biblioteci.add(i, biblioteca);
                break;
            }
        }
    }

    public void stergeBiblioteca(int idx){
        for(int i = 0; i < this.biblioteci.size(); ++i){
            if(this.biblioteci.get(i).getId() == idx){
                this.biblioteci.remove(i);
                break;
            }
        }
    }
}
