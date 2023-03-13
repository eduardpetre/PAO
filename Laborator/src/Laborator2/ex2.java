package Laborator2;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){
        /*
        Cititi de la tastatura 2 valori: numele si varsta
        Afisati numele
        Daca varsta este impara afisati toate nr impare mai mici sau egale cu varsta
        Daca varsta este para afisati toate nr pare mai mici sau egale cu vaw3rsta
        */

        Scanner scanner = new Scanner (System.in);
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Numele introdus este: " + nume);

        System.out.println("Introduceti varsta: ");
        int varsta = scanner.nextInt();

        int i = 0;
        if(varsta % 2 != 0)
            i = 1;
        while(i<= varsta){
            System.out.println(i);
            i += 2;
        }

        scanner.close();
    }
}
