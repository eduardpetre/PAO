package Laborator2;

import java.util.Arrays;

public class ex5 {
    public static void main(String[] args){
        int[][] arrayOfArrays = new int[3][3];
        arrayOfArrays[0][0] = 0;
        arrayOfArrays[1][0] = 10;
        arrayOfArrays[1][1] = 11;
        arrayOfArrays[2][0] = 20;
        arrayOfArrays[2][1] = 21;
        arrayOfArrays[2][2] = 22;

        System.out.println(Arrays.toString(arrayOfArrays));
        System.out.println(Arrays.deepToString(arrayOfArrays));

        int[][] a1 = new int[2][];
        a1[0] = new int[2];
        a1[0][0] = 0;
        a1[0][0] = 1;
        a1[1] = new int[5];
        a1[1][0] = 10;
        a1[1][4] = 14;

        System.out.println(Arrays.deepToString(a1));
    }
}
