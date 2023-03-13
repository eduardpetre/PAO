package Laborator1;

public class Exemplul2 {
    public static void main(String[] args){
        Exemplul1.main(null);

        Exemplul1 obiect1 = new Exemplul1();
        obiect1.setNrLab(1);
        obiect1.main(null);
//        Exemplul1.setNrLab(1111);

        System.out.println(obiect1.getNrLab()); // 1
        System.out.println(obiect1.nrLab); // 1

        Exemplul1 obiect2 = new Exemplul1();
        obiect2.setNrLab(2);
        System.out.println(obiect2.nrLab); // 2

        Exemplul1 obiect3 = new Exemplul1();
        System.out.println(obiect3.nrLab); // 0
    }
}
