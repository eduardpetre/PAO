package Laborator1;
//clasele din pachete merg refolosite

//private, public, protected
//default-package (nu specifica ce e; acesibil doar din acelasi pachet)

public class Exemplul1 {
//campuri & metode

    protected int nrLab;
    public int getNrLab(){
        return nrLab;
    }

    public void setNrLab(int nrLab){
        this.nrLab = nrLab;
    }
    public static void main(String[] args){
    }
}