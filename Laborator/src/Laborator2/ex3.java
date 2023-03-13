package Laborator2;

import java.util.Arrays;

public class ex3 {
    public static void main (String[] args){
        int[] ar1; // recommended
        int ar2 [], i3, ar3[][], i4[];

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[6];
        int[] array3 = new int[]{1, 2, 3, 4, 5};
        int[] array4 = array2;

        System.out.println(array1); // referinta

        System.out.println("Comparatie referinte: " + (array1 == array3));
        System.out.println("Comparatie continut: " + Arrays.compare(array1, array3));
        System.out.println("Comparatie obiecte: " + Arrays.equals(array1, array3));

        for (int i = 0; i < array1.length; i++)
            System.out.println(array1[i]);

        for (int i = 0; i < array4.length; i++)
            System.out.println(array4[i]);
    }
}
